package owenbadel.area.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import owenbadel.area.modelo.CalculoArea;
import owenbadel.area.vistas.VentanaPrincipal;

public class SubProcesoCliente extends Thread {
    private Socket cliente;
    private String ip;
    private VentanaPrincipal ventana;

    public SubProcesoCliente(Socket cliente, VentanaPrincipal v) {
        this.cliente = cliente;
        ip = cliente.getInetAddress().getHostAddress();
        ventana = v;
    }

    @Override
    public void run() {
        try {
            CalculoArea.Area area = calcularArea();
            if (area != null) {
                enviarRespuesta(area);
            }
        } catch (EOFException | SocketException ex) {
            String msg = log() + "[DESCONEXION] El cliente " + ip + " cerro la conexion";
            System.out.println(msg);
            ventana.getCajaLog().append(msg + "\n");
            desconectar();
        } catch (Exception ex) {
            String msg = log() + "[ERROR: " + ip + "] " + ex.getMessage();
            System.out.println(msg);
            ventana.getCajaLog().append(msg + "\n");
            desconectar();
        }
    }

    public CalculoArea.Area calcularArea() throws Exception {
        DataInputStream input = null;
        try {
            input = new DataInputStream(cliente.getInputStream());
            
            float largo = input.readFloat();
            float ancho = input.readFloat();
            
            String msgDatos = log() + "[SOLICITUD: " + ip + "] Dimensiones recibidas -> Largo: " + largo + " m | Ancho: " + ancho + " m";
            System.out.println(msgDatos);
            ventana.getCajaLog().append(msgDatos + "\n");

            CalculoArea datosArea = new CalculoArea(largo, ancho);
            CalculoArea.Area resultadoArea = datosArea.getArea();

            String msgCalculo = log() + "[CALCULO: " + ip + "] Area resultante: " + resultadoArea.resultado + " m2";
            System.out.println(msgCalculo);
            ventana.getCajaLog().append(msgCalculo + "\n");

            return resultadoArea;
        } catch (EOFException | SocketException ex) {
            throw ex;
        } catch (IOException ex) {
            String msg = "[ERROR: " + ip + "] Falla al capturar datos: " + ex.getMessage();
            System.out.println(log() + msg);
            ventana.getCajaLog().append(log() + msg + "\n");
            throw new Exception(msg);
        }
    }

    public void enviarRespuesta(CalculoArea.Area area) {
        Thread hiloResponde = new Thread() {
            @Override
            public void run() {
                DataOutputStream output = null;
                try {
                    output = new DataOutputStream(cliente.getOutputStream());
                    output.writeFloat(area.resultado);
                    output.writeUTF(area.mensaje);
                    output.flush();

                    String msg = log() + "[RESPUESTA: " + ip + "] Resultado enviado -> " + area.mensaje;
                    System.out.println(msg);
                    ventana.getCajaLog().append(msg + "\n");

                    CalculoArea.Area proximaArea = calcularArea();
                    if (proximaArea != null) {
                        enviarRespuesta(proximaArea);
                    }
                } catch (EOFException | SocketException ex) {
                    String msg = log() + "[DESCONEXION] Cliente " + ip + " finalizo la sesion";
                    System.out.println(msg);
                    ventana.getCajaLog().append(msg + "\n");
                    desconectar();
                } catch (Exception ex) {
                    String msg = log() + "[ERROR: " + ip + "] " + ex.getMessage();
                    System.out.println(msg);
                    ventana.getCajaLog().append(msg + "\n");
                    desconectar();
                }
            }
        };
        hiloResponde.start();
    }

    private void desconectar() {
        try {
            if (cliente != null && !cliente.isClosed()) {
                cliente.close();
            }
        } catch (IOException ignored) {
        } finally {
            ServidorTcp.listaDeClientes.remove(ip);
        }
    }

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public String log() {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "[" + f.format(new Date()) + "] ";
    }
}
