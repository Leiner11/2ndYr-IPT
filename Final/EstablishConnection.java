/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IPT_Final2;

import IPT_Final2.NetworkUI;
import IPT_Final2.HistoryLogs;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import IPT_Final2.ClientSide; // replace with the actual package and class name


/**
 *
 * @author User
 */
public class EstablishConnection extends javax.swing.JFrame {
//    public static boolean isSocketOpen(Socket socket) {
//        return socket != null && socket.isConnected() && !socket.isClosed();
//    }    private Socket socket;
    private boolean running = true;

    public EstablishConnection(Socket socket) {
        this.socket = socket;
    }

    public void stopChecking() {
        running = false;
    }

    public void run() {
        while (running) {
            try {
                if (socket.isClosed()) {
                    // Socket is closed, perform necessary actions
                }
                // Sleep for some time before checking again
                Thread.sleep(1000); // 1 second
            } catch (InterruptedException e) {
                // Handle the exception
            }
        }
    }
    /**
     * Creates new form EstablishConnection
     */
//    private NetworkUI NetworkUI;
    boolean isClicked;
    private int serverport;
    private int count=0;
    private String IP_Address;
    Socket socket;
    private Timer timer, timer_date;
    private int NCU=0;
    
    
    public EstablishConnection() {
        initComponents();
        this.setResizable(false);
    }
    
    public void createServer(){
        try (ServerSocket listener = new ServerSocket(serverport)) {
        Con2TextField.setText("");
        Con2TextField.setText("The server is running...");
        }
        catch(Exception e) {
        Con2TextField.setText("");
        Con2TextField.setText("Error is found");
            e.printStackTrace();
    }}
        
    public void startServer() {
         
    if (isClicked==true) {
            try (ServerSocket listener = new ServerSocket(serverport)) {
                Con4TextField.setText("");
                Con4TextField.setText("Using server socket: " + serverport);

                    socket = listener.accept();
                    
                    InetAddress clientAddress = socket.getInetAddress(); //GET IP ADDRESS
                    IP_Address = clientAddress.getHostAddress();
                    
                    Con3TextField.setText("");
                    Con3TextField.setText("IP Address & Host Name: " + clientAddress.getHostAddress() +
                        " ("+ clientAddress.getHostName() + ") ");
                    
                    Con1TextField.setText("");
                    Con1TextField.setText("Port No.: " + socket.getPort()); //GET PORT NO.

                    if(count<=5){
                        HistoryLogs HistoryLogs = new HistoryLogs(IP_Address,count,socket);
                        HistoryLogs.setVisible(true);
                    }
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    
                    NCU();
                                        
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                        out.println(inputLine);
                    }
                    } catch(Exception e) {
                    Con4TextField.setText("");
                    Con4TextField.setText("Error is found");
                            e.printStackTrace();
                            
                    }
                } else {
                    Con4TextField.setText("");
                    Con4TextField.setText("Create a server first and try again.");
    }}
    
    public void NCU() throws InterruptedException, IOException{
        if(socket != null){
            NCU++;
        }
        String NCU_str = String.valueOf(NCU);
        NumConTextField.setText("");
        NumConTextField.setText(NCU_str);
        upTime();
    }
   
    public void disconnectServer() {
         try {
                 socket.close();
                 Con4TextField.setText("");
                 Con3TextField.setText("");
                 Con1TextField.setText("");
                 Con4TextField.setText("Client disconnected.");
             
         } catch (IOException e) {
             Con4TextField.setText("");
             Con4TextField.setText("Error while disconnecting client: " + e.getMessage());
         }
     }
    
    //Uptime
    public void upTime() throws InterruptedException, IOException{
        long startTime = System.currentTimeMillis();
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(hours);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);
            
            String elapsedTimeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            UptimeTextField1.setText("");
            UptimeTextField1.setText(elapsedTimeString);

            Thread.sleep(1000);
        }}
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        EConnectionButton = new javax.swing.JButton();
        SettingsButton = new javax.swing.JButton();
        AboutUsButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        LogoLabel = new javax.swing.JLabel();
        TextResultPanel = new javax.swing.JPanel();
        Con1TextField = new javax.swing.JLabel();
        Con2TextField = new javax.swing.JLabel();
        Con3TextField = new javax.swing.JLabel();
        Con4TextField = new javax.swing.JLabel();
        TopInfo2Panel = new javax.swing.JPanel();
        StopServerButton = new javax.swing.JButton();
        StartServerButton = new javax.swing.JButton();
        Info1 = new javax.swing.JLabel();
        Info2 = new javax.swing.JLabel();
        Info3 = new javax.swing.JLabel();
        Info4 = new javax.swing.JLabel();
        Dashboard5 = new javax.swing.JPanel();
        DateLabel = new javax.swing.JLabel();
        DateTextField = new javax.swing.JLabel();
        Dashboard6 = new javax.swing.JPanel();
        UptimeLabel1 = new javax.swing.JLabel();
        UptimeTextField1 = new javax.swing.JLabel();
        Dashboard7 = new javax.swing.JPanel();
        NumberConnectedUserLabel = new javax.swing.JLabel();
        NumConTextField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(136, 113, 249));
        Background.setPreferredSize(new java.awt.Dimension(2404, 674));

        SidePanel.setBackground(new java.awt.Color(136, 113, 249));
        SidePanel.setPreferredSize(new java.awt.Dimension(247, 674));

        HomeButton.setBackground(new java.awt.Color(127, 57, 233));
        HomeButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        HomeButton.setText("Home");
        HomeButton.setBorder(null);
        HomeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HomeButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        HomeButton.setIconTextGap(60);
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        EConnectionButton.setBackground(new java.awt.Color(127, 57, 233));
        EConnectionButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        EConnectionButton.setText("Establish Connection");
        EConnectionButton.setBorder(null);
        EConnectionButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EConnectionButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        EConnectionButton.setIconTextGap(24);
        EConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EConnectionButtonActionPerformed(evt);
            }
        });

        SettingsButton.setBackground(new java.awt.Color(127, 57, 233));
        SettingsButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        SettingsButton.setText("Settings");
        SettingsButton.setBorder(null);
        SettingsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SettingsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        SettingsButton.setIconTextGap(60);
        SettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsButtonActionPerformed(evt);
            }
        });

        AboutUsButton.setBackground(new java.awt.Color(127, 57, 233));
        AboutUsButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        AboutUsButton.setText("About Us");
        AboutUsButton.setBorder(null);
        AboutUsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AboutUsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AboutUsButton.setIconTextGap(54);
        AboutUsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutUsButtonActionPerformed(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(127, 57, 233));
        ExitButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.setBorder(null);
        ExitButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExitButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ExitButton.setIconTextGap(73);
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EConnectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
            .addComponent(AboutUsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SettingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EConnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AboutUsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TextResultPanel.setBackground(new java.awt.Color(199, 244, 90));
        TextResultPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        Con1TextField.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Con1TextField.setForeground(new java.awt.Color(0, 0, 0));

        Con2TextField.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Con2TextField.setForeground(new java.awt.Color(0, 0, 0));
        Con2TextField.setText("Awaiting client connection....");

        Con3TextField.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Con3TextField.setForeground(new java.awt.Color(0, 0, 0));

        Con4TextField.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Con4TextField.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout TextResultPanelLayout = new javax.swing.GroupLayout(TextResultPanel);
        TextResultPanel.setLayout(TextResultPanelLayout);
        TextResultPanelLayout.setHorizontalGroup(
            TextResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TextResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Con4TextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Con3TextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Con2TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                    .addComponent(Con1TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextResultPanelLayout.setVerticalGroup(
            TextResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Con2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(Con4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Con3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Con1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        TopInfo2Panel.setBackground(new java.awt.Color(136, 113, 249));

        StopServerButton.setBackground(new java.awt.Color(255, 56, 79));
        StopServerButton.setForeground(new java.awt.Color(0, 0, 0));
        StopServerButton.setText("Disconnect Client");
        StopServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopServerButtonActionPerformed(evt);
            }
        });

        StartServerButton.setBackground(new java.awt.Color(199, 255, 189));
        StartServerButton.setForeground(new java.awt.Color(0, 0, 0));
        StartServerButton.setText("Start Server");
        StartServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartServerButtonActionPerformed(evt);
            }
        });

        Info1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Info1.setForeground(new java.awt.Color(0, 0, 0));
        Info1.setText("Don't know how to start a server?");

        Info2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Info2.setForeground(new java.awt.Color(0, 0, 0));
        Info2.setText("Just click this button!");

        Info3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Info3.setForeground(new java.awt.Color(0, 0, 0));
        Info3.setText("Want to stop the server connection?");

        Info4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Info4.setForeground(new java.awt.Color(0, 0, 0));
        Info4.setText("Just click this button!");

        javax.swing.GroupLayout TopInfo2PanelLayout = new javax.swing.GroupLayout(TopInfo2Panel);
        TopInfo2Panel.setLayout(TopInfo2PanelLayout);
        TopInfo2PanelLayout.setHorizontalGroup(
            TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                .addGroup(TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(Info1))
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(Info2))
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(StartServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(Info3))
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Info4))
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(StopServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(210, 210, 210))
        );
        TopInfo2PanelLayout.setVerticalGroup(
            TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                .addGroup(TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Info1)
                        .addGap(1, 1, 1)
                        .addComponent(Info2)
                        .addGap(21, 21, 21)
                        .addComponent(StartServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Info3))
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Info4))
                    .addGroup(TopInfo2PanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(StopServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        Dashboard5.setBackground(new java.awt.Color(199, 244, 90));
        Dashboard5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Dashboard5.setForeground(new java.awt.Color(255, 152, 100));

        DateLabel.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(0, 0, 0));
        DateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateLabel.setText("Date:");

        DateTextField.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        DateTextField.setForeground(new java.awt.Color(0, 0, 0));
        DateTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Dashboard5Layout = new javax.swing.GroupLayout(Dashboard5);
        Dashboard5.setLayout(Dashboard5Layout);
        Dashboard5Layout.setHorizontalGroup(
            Dashboard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Dashboard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        Dashboard5Layout.setVerticalGroup(
            Dashboard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        //      Current Date and Time
        timer_date = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate currentDate = LocalDate.now();
                LocalTime Time = LocalTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String formattedTime = Time.format(formatter);
                String formattedDate = currentDate.format(dateFormatter);
                DateTextField.setText(formattedDate + " " + formattedTime);
            }
        });
        timer_date.setInitialDelay(0);
        timer_date.start();

        Dashboard6.setBackground(new java.awt.Color(199, 244, 90));
        Dashboard6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Dashboard6.setForeground(new java.awt.Color(255, 152, 100));

        UptimeLabel1.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        UptimeLabel1.setForeground(new java.awt.Color(0, 0, 0));
        UptimeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UptimeLabel1.setText("Uptime: ");

        UptimeTextField1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        UptimeTextField1.setForeground(new java.awt.Color(0, 0, 0));
        UptimeTextField1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Dashboard6Layout = new javax.swing.GroupLayout(Dashboard6);
        Dashboard6.setLayout(Dashboard6Layout);
        Dashboard6Layout.setHorizontalGroup(
            Dashboard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Dashboard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UptimeLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UptimeTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        Dashboard6Layout.setVerticalGroup(
            Dashboard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(UptimeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UptimeTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        Dashboard7.setBackground(new java.awt.Color(199, 244, 90));
        Dashboard7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Dashboard7.setForeground(new java.awt.Color(255, 152, 100));

        NumberConnectedUserLabel.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        NumberConnectedUserLabel.setForeground(new java.awt.Color(0, 0, 0));
        NumberConnectedUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumberConnectedUserLabel.setText("Number of Connected Users:");

        NumConTextField.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        NumConTextField.setForeground(new java.awt.Color(0, 0, 0));
        NumConTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Dashboard7Layout = new javax.swing.GroupLayout(Dashboard7);
        Dashboard7.setLayout(Dashboard7Layout);
        Dashboard7Layout.setHorizontalGroup(
            Dashboard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(Dashboard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NumberConnectedUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(NumConTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Dashboard7Layout.setVerticalGroup(
            Dashboard7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(NumberConnectedUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumConTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(Dashboard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Dashboard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Dashboard7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(TopInfo2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextResultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(TopInfo2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dashboard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashboard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashboard7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextResultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
    this.setVisible(false);
    new NetworkUI().setVisible(true);
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void EConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EConnectionButtonActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_EConnectionButtonActionPerformed

    private void StartServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartServerButtonActionPerformed
                isClicked = true;
                serverport = 12;
                createServer();
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                protected Void doInBackground() throws Exception {
                    startServer();
                    return null;
                    }
                };
                worker.execute();// TODO add your handling code here:
    }//GEN-LAST:event_StartServerButtonActionPerformed

    private void StopServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopServerButtonActionPerformed
                disconnectServer();        // TODO add your handling code here:
    }//GEN-LAST:event_StopServerButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
    System.exit(0);      // TODO add your handling code here:
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void SettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsButtonActionPerformed
    this.setVisible(false);
    new Settings().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_SettingsButtonActionPerformed

    private void AboutUsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutUsButtonActionPerformed
    this.setVisible(false);
    new AboutUs().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_AboutUsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EstablishConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstablishConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstablishConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstablishConnection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EstablishConnection().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutUsButton;
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Con1TextField;
    private javax.swing.JLabel Con2TextField;
    private javax.swing.JLabel Con3TextField;
    private javax.swing.JLabel Con4TextField;
    private javax.swing.JPanel Dashboard5;
    private javax.swing.JPanel Dashboard6;
    private javax.swing.JPanel Dashboard7;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DateTextField;
    private javax.swing.JButton EConnectionButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JLabel Info1;
    private javax.swing.JLabel Info2;
    private javax.swing.JLabel Info3;
    private javax.swing.JLabel Info4;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel NumConTextField;
    private javax.swing.JLabel NumberConnectedUserLabel;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton StartServerButton;
    private javax.swing.JButton StopServerButton;
    private javax.swing.JPanel TextResultPanel;
    private javax.swing.JPanel TopInfo2Panel;
    private javax.swing.JLabel UptimeLabel1;
    private javax.swing.JLabel UptimeTextField1;
    // End of variables declaration//GEN-END:variables
}
