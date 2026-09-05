package owenbadel.area.vistas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import owenbadel.area.servidor.ServidorTcp;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoIP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoPuerto = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaLog = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor TCP - Cálculo de Área");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 22)); 
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVIDOR ÁREA");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 12));

        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        jLabel2.setText("DIRECCION IP: ");

        campoIP.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        campoIP.setBorder(BorderFactory.createCompoundBorder(campoIP.getBorder(), BorderFactory.createEmptyBorder(2, 6, 2, 6)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        jLabel3.setText("PUERTO DE RED:");

        campoPuerto.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 13));
        campoPuerto.setText("9007");
        campoPuerto.setBorder(BorderFactory.createCompoundBorder(campoPuerto.getBorder(), BorderFactory.createEmptyBorder(2, 6, 2, 6)));

        btnIniciar.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 13)); 
        btnIniciar.setForeground(new java.awt.Color(46, 125, 50));
        btnIniciar.setText("INICIAR");
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
        txtEstado.setText("DETENIDO");

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
                        .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstado))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONEXION", jPanel1);

        cajaLog.setEditable(false);
        cajaLog.setBackground(new java.awt.Color(25, 28, 36));
        cajaLog.setForeground(new java.awt.Color(230, 235, 245));
        cajaLog.setCaretColor(java.awt.Color.WHITE);
        cajaLog.setFont(new java.awt.Font("Consolas", Font.PLAIN, 12));
        cajaLog.setMargin(new Insets(8, 8, 8, 8));
        cajaLog.setLineWrap(true);
        cajaLog.setWrapStyleWord(true);
        
        DefaultCaret caret = (DefaultCaret) cajaLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        jScrollPane1.setViewportView(cajaLog);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(200, 205, 215)));

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 12));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaLog.setText("");
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LOG DE CONEXIONES", jPanel2);

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

    ServidorTcp s;

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
        if (btnIniciar.getText().equalsIgnoreCase("INICIAR")) {
            try {
                int puerto = Integer.parseInt(campoPuerto.getText().trim());
                s = new ServidorTcp(puerto, this);
                s.start();
                btnIniciar.setText("DETENER");
                txtEstado.setText("ONLINE");
                txtEstado.setForeground(new Color(46, 125, 50));
                btnIniciar.setForeground(new Color(198, 40, 40));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un puerto numerico valido", "Puerto Invalido", JOptionPane.WARNING_MESSAGE);
            }
        } else if (btnIniciar.getText().equalsIgnoreCase("DETENER")) {
            s.detenerServicio();
            btnIniciar.setText("INICIAR");
            txtEstado.setText("OFF LINE");
            txtEstado.setForeground(new Color(198, 40, 40));
            btnIniciar.setForeground(new Color(46, 125, 50));
        }
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        String ip;
        try {
            campoIP.setEditable(false);
            ip = InetAddress.getLocalHost().getHostAddress();
            campoIP.setText(ip);
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(this, "Falla en la conexion de red");
        }
    }

    public JLabel getTxtEstado() {
        return txtEstado;
    }

    public JTextArea getCajaLog() {
        return cajaLog;
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
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTextArea cajaLog;
    private javax.swing.JTextField campoIP;
    private javax.swing.JTextField campoPuerto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel txtEstado;
}
