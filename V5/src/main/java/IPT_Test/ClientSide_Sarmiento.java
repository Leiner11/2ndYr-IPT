/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author myrrden
 */
package IPT_Test;

//import com.sun.management.OperatingSystemMXBean;
import java.awt.event.*;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;


public class ClientSide_Sarmiento extends javax.swing.JFrame {
        private static DecimalFormat FORMAT = new DecimalFormat("00");
    /**
     * Creates new form ClientSide
     */
    public ClientSide_Sarmiento() {
        initComponents();
    }
//    private Timer timer;
//    private JLabel label; 
    private Timer timer;
//    private int NCU;
    Socket socket;
    
        public void connectToServer() throws InterruptedException {
        String serverHostname = "localhost";
        int serverPort = 12;
        try {
            System.out.println("Connecting to " + serverHostname + " on port " + serverPort);
            centerText.setText("");
            centerText.setText("Connecting to " + serverHostname + " on port " + serverPort);
//            anotherText.setText("");
//            anotherText.setText("Connecting... Please click Connect to retry.");

            socket = new Socket(serverHostname, serverPort);
            //System.out.println("Connected to " + serverHostname + " on port " + serverPort);
            centerText.setText("");
            centerText.setText("Connected to " + serverHostname + " on port " + serverPort);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            upTime();
//            anotherText.setText("");
//            anotherText.setText("Client request successfully completed.");
            String message = "Client request successfully completed.";
//            NCU++;
//            String NCU_str = String.valueOf(NCU);
//            centerText.setText("");
//            centerText.setText(NCU_str);
            out.println(message);
            System.out.println(message);

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }
            //socket.close();
        } catch (IOException e) {
//            errorText.setText("");
//            errorText.setText("An error occurred while connecting to the server: " + e.getMessage()");
            System.err.println("An error occurred while connecting to the server: " + e.getMessage());
            System.err.println("Server closed");
        }
    }
        public void disconnectServer() {
         try {
             if (socket != null) {
                 socket.close();
                 centerText.setText("");
                 centerText.setText("Connection successfully closed.");
                 System.out.println("Client disconnected.");
             }
         } catch (IOException e) {
             System.err.println("Error while disconnecting client: " + e.getMessage());
         }
     }
        
        
//                //Uptime
//
//        public void upTime() throws InterruptedException{
//        long startTime = System.currentTimeMillis();
//        while (true) {
//            long elapsedTime = System.currentTimeMillis() - startTime;
//            long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
//            long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(hours);
//            long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);
//            
//            String elapsedTimeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
//            currentTime.setText("");
//            currentTime.setText(elapsedTimeString);
//
//            Thread.sleep(1000);
//        }
//        }
        
//            public void CPUpercentage() {
//                label = new JLabel();
//                timer = new Timer(1000, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//                    // What % load the overall system is at, from 0.0-1.0
//                    double systemLoad = osBean.getSystemCpuLoad() * 100.0;
//                        currentTime.setText("");
//                        currentTime.setText("System CPU Load: " + String.format("%.2f", systemLoad) + "%");
//                    }
//                });
//                timer.setInitialDelay(0);
//                timer.start();
//            }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backgroundPanel = new javax.swing.JPanel();
        whiteSpace = new javax.swing.JPanel();
        centerText = new javax.swing.JLabel();
        titleName = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        dateANDtime = new javax.swing.JPanel();
        iconPanel = new javax.swing.JPanel();
        cloudIcon = new javax.swing.JButton();
        buttonPanel = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        discButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(46, 65, 114));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(136, 113, 249));

        whiteSpace.setBackground(new java.awt.Color(199, 244, 90));
        whiteSpace.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        whiteSpace.setForeground(new java.awt.Color(255, 255, 255));

        centerText.setBackground(new java.awt.Color(255, 255, 255));
        centerText.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        centerText.setForeground(new java.awt.Color(255, 255, 255));
        centerText.setText("Center Text Message");

        javax.swing.GroupLayout whiteSpaceLayout = new javax.swing.GroupLayout(whiteSpace);
        whiteSpace.setLayout(whiteSpaceLayout);
        whiteSpaceLayout.setHorizontalGroup(
            whiteSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whiteSpaceLayout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(centerText)
                .addGap(190, 190, 190))
        );
        whiteSpaceLayout.setVerticalGroup(
            whiteSpaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whiteSpaceLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(centerText)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        titleName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titleName.setForeground(new java.awt.Color(255, 255, 255));
        titleName.setText("Group 12 Client Management Software");

        currentTime.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        currentTime.setForeground(new java.awt.Color(255, 255, 255));    
//      Current Date and Time
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate currentDate = LocalDate.now();
                LocalTime Time = LocalTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String formattedTime = Time.format(formatter);
                String formattedDate = currentDate.format(dateFormatter);
                currentTime.setText("Current date & time: " + formattedDate + " " + formattedTime);
            }
        });
        timer.setInitialDelay(0);
        timer.start();

        dateANDtime.setBackground(new java.awt.Color(199, 244, 90));

        javax.swing.GroupLayout dateANDtimeLayout = new javax.swing.GroupLayout(dateANDtime);
        dateANDtime.setLayout(dateANDtimeLayout);
        dateANDtimeLayout.setHorizontalGroup(
            dateANDtimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dateANDtimeLayout.setVerticalGroup(
            dateANDtimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        iconPanel.setBackground(new java.awt.Color(136, 113, 249));
        iconPanel.setToolTipText("");

        cloudIcon.setBackground(new java.awt.Color(136, 113, 249));
        //cloudIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CLOUD.png"))); // NOI18N
        cloudIcon.setBorder(null);
        cloudIcon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cloudIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cloudIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonPanel.setBackground(new java.awt.Color(136, 113, 249));

        connectButton.setBackground(new java.awt.Color(127, 57, 233));
        connectButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        centerText.setText("");
                        connectToServer();
                        //CPUpercentage();
                        return null;
                    }
                };
                worker.execute();
            }
            }
        );

        discButton.setBackground(new java.awt.Color(127, 57, 233));
        discButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        discButton.setText("Disconnect");
        discButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                        disconnectServer();
                        }});


        aboutButton.setBackground(new java.awt.Color(127, 57, 233));
        aboutButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        aboutButton.setText("About Us");

        helpButton.setBackground(new java.awt.Color(127, 57, 233));
        helpButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        helpButton.setText("Help");

        exitButton.setBackground(new java.awt.Color(127, 57, 233));
        exitButton.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(helpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(discButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(titleName)
                                .addGap(40, 40, 40))
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addComponent(currentTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateANDtime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(whiteSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(titleName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(whiteSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateANDtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(currentTime)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClientSide_Sarmiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientSide_Sarmiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientSide_Sarmiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientSide_Sarmiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientSide_Sarmiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel centerText;
    private javax.swing.JButton cloudIcon;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel currentTime;
    private javax.swing.JPanel dateANDtime;
    private javax.swing.JButton discButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titleName;
    private javax.swing.JPanel whiteSpace;
    // End of variables declaration//GEN-END:variables
}
