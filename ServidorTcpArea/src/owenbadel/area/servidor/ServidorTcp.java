package owenbadel.area.servidor;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import owenbadel.area.vistas.VentanaPrincipal;

public class ServidorTcp extends Thread {
    private Boolean estado = false;
    public static Map<String, SubProcesoCliente> listaDeClientes;
    private Integer puerto = 9007;
    private ServerSocket servicio;
    private VentanaPrincipal ventana;

    public ServidorTcp(Integer puerto, VentanaPrincipal v) {
        if (puerto != null && puerto != 0) {
            this.puerto = puerto;
        }
        ventana = v;
        listaDeClientes = new HashMap<>();
    }

    @Override
    public void run() {
        iniciarServicio();
    }

    public void iniciarServicio() {
        try {
            servicio = new ServerSocket(puerto);
            estado = true;
            ventana.getBtnIniciar().setText("DETENER");
            ventana.getTxtEstado().setText("ONLINE");
            ventana.getTxtEstado().setForeground(new Color(39, 174, 96));
            ventana.getBtnIniciar().setForeground(new Color(192, 57, 43));
            
            String msg = log() + "[SERVIDOR] Servidor disponible y escuchando en el puerto " + puerto;
            System.out.println(msg);
            ventana.getCajaLog().append(msg + "\n");

            while (estado) {
                Socket cliente = servicio.accept();
                String ip = cliente.getInetAddress().getHostAddress();
                msg = log() + "[CONEXION] Cliente conectado desde: " + ip;
                System.out.println(msg);
                ventana.getCajaLog().append(msg + "\n");

                SubProcesoCliente atencion = new SubProcesoCliente(cliente, ventana);
                ServidorTcp.listaDeClientes.put(ip, atencion);
                atencion.start();
            }
        } catch (IOException ex) {
            if (estado) {
                String msg = log() + "[ERROR] Error al abrir o escuchar en el puerto " + puerto;
                System.out.println(msg);
                ventana.getCajaLog().append(msg + "\n");
                ventana.getBtnIniciar().setText("INICIAR");
                ventana.getTxtEstado().setText("OFF LINE");
                ventana.getTxtEstado().setForeground(new Color(192, 57, 43));
            }
        }
    }

    public void detenerServicio() {
        if (estado) {
            estado = false;
            ventana.getBtnIniciar().setText("INICIAR");
            ventana.getBtnIniciar().setForeground(new Color(39, 174, 96));
            ventana.getTxtEstado().setText("OFF LINE");
            ventana.getTxtEstado().setForeground(new Color(192, 57, 43));

            ServidorTcp.listaDeClientes.entrySet().stream().map(new Function<Map.Entry<String, SubProcesoCliente>, String>() {
                @Override
                public String apply(Map.Entry<String, SubProcesoCliente> elemento) {
                    String ip = elemento.getKey();
                    SubProcesoCliente cliente = elemento.getValue();
                    String msg = log() + "[DESCONEXION] Desconectando cliente " + ip;
                    System.out.println(msg);
                    ventana.getCajaLog().append(msg + "\n");
                    try {
                        cliente.getCliente().close();
                        cliente = null;
                        ServidorTcp.listaDeClientes.remove(elemento.getKey());
                    } catch (IOException ex) {
                        cliente = null;
                        ServidorTcp.listaDeClientes.remove(elemento.getKey());
                    }
                    return ip;
                }
            }).forEachOrdered(ip -> {
                String msg = log() + "[DESCONEXION] Cliente " + ip + " desconectado";
                System.out.println(msg);
                ventana.getCajaLog().append(msg + "\n");
            });

            try {
                if (servicio != null && !servicio.isClosed()) {
                    servicio.close();
                }
                String msg = log() + "[SERVIDOR] Servidor detenido por el usuario";
                System.out.println(msg);
                ventana.getCajaLog().append(msg + "\n");
            } catch (IOException ex) {
                String msg = log() + "[ERROR] No se puede cerrar el puerto " + puerto;
                System.out.println(msg);
                ventana.getCajaLog().append(msg + "\n");
            }
        }
    }

    public String log() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "[" + f.format(new Date()) + "] ";
    }
}
