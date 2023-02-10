/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esp32cp;

import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Ui extends javax.swing.JFrame {

    private Thread WIFI_CONNECT_THREAD;
    private Socket WIFI_SOCKET;
    private String WIFI_IP = "";
    private String WIFI_PORT = "";
    private BufferedWriter WIFI_BUFFERED_WRITER;
  

    /**
     * Creates new form Ui
     */
    public Ui() {
        initComponents();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WIFI_IP_TXF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        WIFI_CONNECT_BTN = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        WIFI_PORT_TXF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("esp32 switches");
        setResizable(false);

        WIFI_IP_TXF.setText("192.168.1.9");

        jLabel1.setText("IP Address :");

        WIFI_CONNECT_BTN.setText("Connect");
        WIFI_CONNECT_BTN.setPreferredSize(new java.awt.Dimension(73, 20));
        WIFI_CONNECT_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WIFI_CONNECT_BTNActionPerformed(evt);
            }
        });

        WIFI_PORT_TXF.setText("80");

        jLabel2.setText("...");

        jButton1.setText("Up");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        jButton2.setText("Down");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });

        jButton3.setText("Left");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });

        jButton4.setText("Right");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jButton4)
                                .addGap(26, 148, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(WIFI_IP_TXF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(WIFI_PORT_TXF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(WIFI_CONNECT_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 40, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(WIFI_IP_TXF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(WIFI_CONNECT_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(WIFI_PORT_TXF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        try {
            SendData("a");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
        try {
            SendData("e");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        try {
            SendData("b");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
        try {
            SendData("e");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
        try {
            SendData("d");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
        try {
            SendData("e");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
        try {
            SendData("c");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        // TODO add your handling code here:
        try {
            SendData("e");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton4MouseReleased

    private void WIFI_CONNECT_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WIFI_CONNECT_BTNActionPerformed
        if (WIFI_IP_TXF.getText().isEmpty() || WIFI_PORT_TXF.getText().isEmpty()) {
            return;
        }
        
       WIFI_CONNECT_BTN.setEnabled(false);
        WIFI_IP = WIFI_IP_TXF.getText();
        WIFI_PORT = WIFI_PORT_TXF.getText();

        try {
            Socket client;
            client = new Socket("localhost", 8888);
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            String str = WIFI_IP + "-" + WIFI_PORT;
            byte[] data = str.getBytes("UTF-8");
            dout.writeInt(data.length);
            dout.write(data);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
                          WIFI_IP_TXF.setEnabled(true);
               WIFI_PORT_TXF.setEnabled(true);
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
        }
//        WIFI_CONNECT_THREAD = new Thread(() -> {
//            if (WIFI_isConnected()) {
//                jLabel2.setText("closing connection ...");
//                WIFI_closeConnecition();
//                jLabel2.setText("connection closed");
//                WIFI_SOCKET = null;
//                WIFI_CONNECT_BTN.setText("Connect");
//                WIFI_CONNECT_BTN.setEnabled(true);

//                return;
//            }
//
//            WIFI_IP = WIFI_IP_TXF.getText();
//            WIFI_PORT = WIFI_PORT_TXF.getText();
//            try {
//                jLabel2.setText("connecting...");
//                WIFI_SOCKET = new Socket(WIFI_IP, Integer.valueOf(WIFI_PORT));
//                jLabel2.setText("connected to :" + WIFI_IP + "  " + 80);
//                WIFI_CONNECT_BTN.setText("Disconnect");
//                WIFI_CONNECT_BTN.setEnabled(true);
//                WIFI_IP_TXF.setEnabled(false);
//                WIFI_PORT_TXF.setEnabled(false);
//                jButton1.setEnabled(true);
//                jButton2.setEnabled(true);
//                jButton3.setEnabled(true);
//                jButton4.setEnabled(true);
//            } catch (UnknownHostException e1) {
//                jLabel2.setText("Error !");
//                WIFI_CONNECT_BTN.setEnabled(true);
//                WIFI_IP_TXF.setEnabled(true);
//                WIFI_PORT_TXF.setEnabled(true);
//                //                sw1.setEnabled(false);
//                //                sw2.setEnabled(false);
//                //                sw3.setEnabled(false);
//                //                sw4.setEnabled(false);
//            } catch (IOException e1) {
//                jLabel2.setText("Network is unreachable !");
//                WIFI_CONNECT_BTN.setEnabled(true);
//                WIFI_IP_TXF.setEnabled(true);
//                WIFI_PORT_TXF.setEnabled(true);
//                //                sw1.setEnabled(false);
//                //                sw2.setEnabled(false);
//                //                sw3.setEnabled(false);
//                //                sw4.setEnabled(false);
//            }
//        });
//        WIFI_CONNECT_THREAD.start();
    }//GEN-LAST:event_WIFI_CONNECT_BTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton WIFI_CONNECT_BTN;
    private javax.swing.JTextField WIFI_IP_TXF;
    private javax.swing.JTextField WIFI_PORT_TXF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
  private void WIFI_closeConnecition() {
        if (WIFI_SOCKET != null) {
            if (WIFI_SOCKET.isConnected()) {
                try {
                    WIFI_SOCKET.close();
                    WIFI_SOCKET = null;
//                    sw1.setEnabled(false);
//                    sw2.setEnabled(false);
//                    sw3.setEnabled(false);
//                    sw4.setEnabled(false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

    private boolean WIFI_isConnected() {
        if (WIFI_SOCKET != null) {
            if (WIFI_SOCKET.isConnected()) {
                return true;
            }
        }
        return false;
    }

    private void SendData(String x) throws Exception {
        if (x == null || x.isEmpty()) {
            return;
        }

        try {
              Socket client;
               client = new Socket("localhost", 8888);
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            String str = x;
            byte[] data = str.getBytes("UTF-8");
            dout.writeInt(data.length);
            dout.write(data);
            
//            WIFI_BUFFERED_WRITER = new BufferedWriter(new OutputStreamWriter(WIFI_SOCKET.getOutputStream()));
//            WIFI_BUFFERED_WRITER.write(x + "\n");
//            WIFI_BUFFERED_WRITER.flush();
            jLabel2.setText("sent :" + x);
//            System.out.println("esp32cp.Ui.SendData()");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
