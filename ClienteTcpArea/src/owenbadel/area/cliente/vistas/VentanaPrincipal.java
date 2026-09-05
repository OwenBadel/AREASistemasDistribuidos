package owenbadel.area.cliente.vistas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    Socket servidor;
    DataOutputStream out;
    DataInputStream in;

    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoIPServidor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoPuertoServidor = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        campoLargo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoAncho = new javax.swing.JTextField();
        btnIniciar1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtResultado = new javax.swing.JLabel();
        txtMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente TCP - Cálculo de Área");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 22)); 
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTE ÁREA");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 12));

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        jLabel2.setText("DIRECCION IP: ");

        campoIPServidor.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        campoIPServidor.setText("localhost");
        campoIPServidor.setBorder(BorderFactory.createCompoundBorder(campoIPServidor.getBorder(), BorderFactory.createEmptyBorder(2, 6, 2, 6)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        jLabel3.setText("PUERTO DE RED:");

        campoPuertoServidor.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        campoPuertoServidor.setText("9007");
        campoPuertoServidor.setBorder(BorderFactory.createCompoundBorder(campoPuertoServidor.getBorder(), BorderFactory.createEmptyBorder(2, 6, 2, 6)));

        btnIniciar.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        btnIniciar.setForeground(new java.awt.Color(46, 125, 50));
        btnIniciar.setText("Conectar");
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIniciar.setFocusPainted(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        jLabel4.setText("ESTADO: ");

        txtEstado.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13));
        txtEstado.setForeground(new java.awt.Color(198, 40, 40));
        txtEstado.setText("Desconectado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPuertoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoPuertoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstado))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONEXION", jPanel1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        jLabel5.setText("LARGO (m):");

        campoLargo.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        campoLargo.setBorder(BorderFactory.createCompoundBorder(campoLargo.getBorder(), BorderFactory.createEmptyBorder(2, 6, 2, 6)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        jLabel6.setText("ANCHO (m):");

        campoAncho.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        campoAncho.setBorder(BorderFactory.createCompoundBorder(campoAncho.getBorder(), BorderFactory.createEmptyBorder(2, 6, 2, 6)));

        btnIniciar1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        btnIniciar1.setForeground(new java.awt.Color(46, 125, 50));
        btnIniciar1.setText("CALCULAR");
        btnIniciar1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIniciar1.setFocusPainted(false);
        btnIniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13));
        jLabel7.setText("ÁREA (m²): ");

        txtResultado.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); 
        txtResultado.setForeground(new java.awt.Color(46, 125, 50));
        txtResultado.setText("0.0");

        txtMensaje.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 12));
        txtMensaje.setForeground(new java.awt.Color(55, 65, 81));
        txtMensaje.setBorder(javax.swing.BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new java.awt.Color(200, 205, 215)), "Mensaje del Servidor"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnIniciar1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(campoLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(campoAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnIniciar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CALCULAR ÁREA", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        String ip = campoIPServidor.getText().trim();
        try {
            int puerto = Integer.parseInt(campoPuertoServidor.getText().trim());
            if (btnIniciar.getText().equalsIgnoreCase("Conectar")) {
                servidor = new Socket(ip, puerto);
                out = new DataOutputStream(servidor.getOutputStream());
                in = new DataInputStream(servidor.getInputStream());
                btnIniciar.setText("Desconectar");
                btnIniciar.setForeground(new Color(198, 40, 40));
                txtEstado.setText("Conectado");
                txtEstado.setForeground(new Color(46, 125, 50));
            } else if (btnIniciar.getText().equalsIgnoreCase("Desconectar")) {
                if (servidor != null && servidor.isConnected()) {
                    servidor.close();
                }
                btnIniciar.setText("Conectar");
                txtEstado.setText("Desconectado");
                btnIniciar.setForeground(new Color(46, 125, 50));
                txtEstado.setForeground(new Color(198, 40, 40));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un puerto numerico valido", "Puerto Invalido", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar con el servidor en " + ip, "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnIniciar1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (servidor == null || !servidor.isConnected() || servidor.isClosed()) {
            JOptionPane.showMessageDialog(this, "Cliente Offline. Primero conectese con el Servidor.", "Sin Conexion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String strLargo = campoLargo.getText().trim();
        String strAncho = campoAncho.getText().trim();

        if (strLargo.isEmpty() || strAncho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete ambos campos (Largo y Ancho) antes de continuar.", "Campos Requeridos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            float largo = Float.parseFloat(strLargo);
            float ancho = Float.parseFloat(strAncho);

            if (largo <= 0 || ancho <= 0) {
                JOptionPane.showMessageDialog(this, "El largo y el ancho deben ser valores numericos mayores a cero (0).", "Dimensiones Invalidas", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        out.writeFloat(largo);
                        out.writeFloat(ancho);
                        out.flush();

                        float area = in.readFloat();
                        String msj = in.readUTF();

                        txtResultado.setText(area + "");
                        txtMensaje.setText(msj);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(VentanaPrincipal.this, "Conexion interrumpida con el servidor: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            };
            hilo.start();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese numeros validos en Largo y Ancho.", "Datos Invalidos", JOptionPane.WARNING_MESSAGE);
        }
    }

    public JLabel getTxtEstado() {
        return txtEstado;
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            VentanaPrincipal v = new VentanaPrincipal();
            v.setLocationRelativeTo(null);
            v.setVisible(true);
        });
    }

    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnIniciar1;
    private javax.swing.JTextField campoAncho;
    private javax.swing.JTextField campoIPServidor;
    private javax.swing.JTextField campoLargo;
    private javax.swing.JTextField campoPuertoServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JLabel txtMensaje;
    private javax.swing.JLabel txtResultado;
}
