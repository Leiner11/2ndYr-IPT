
package IPT_Final2;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import com.sun.management.OperatingSystemMXBean;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;


/**
 *
 * @author User
 */
public class EstablishConnection extends javax.swing.JFrame {  
    /**
     * Creates new form EstablishConnection
     */
    private int serverport;
    private String IP_Address;
    Socket socket;
    private Timer timer_date;
    private int NCU; //Number of Connected Users
   
    
    public EstablishConnection() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(EstablishConnection.class.getResource("/Images/Server-Icon.png")));
        initComponents();
        CPUpercentage();
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
        
    public void startServer() throws InterruptedException {
        try (ServerSocket listener = new ServerSocket(serverport)) {
            Con4TextField.setText("");
            Con4TextField.setText("Using server socket: " + serverport);

            HistoryLogs HistoryLogs = new HistoryLogs();
            ManageNetwork ManageNetwork = new ManageNetwork();
            HistoryLogs.setVisible(true);
            ManageNetwork.setVisible(true);
            // Minimize the frame
            ManageNetwork.setExtendedState(ManageNetwork.ICONIFIED); //To minimize

            while (true) {
                socket = listener.accept();

                InetAddress clientAddress = socket.getInetAddress();
                IP_Address = clientAddress.getHostAddress();

                Con3TextField.setText("");
                Con3TextField.setText("IP Address & Host Name: " + clientAddress.getHostAddress() +
                    " (" + clientAddress.getHostName() + ")");

                Con1TextField.setText("");
                Con1TextField.setText("Port No.: " + socket.getPort());

                HistoryLogs.handleNewConnection(socket);
                ManageNetwork.handleNewConnection(socket);

                if (socket != null) { //not equals to null
                    NCU++; //to increment NCU variable
                }
                String NCU_str = String.valueOf(NCU);
                NumConTextField.setText(NCU_str); //convert from int to string
                
                new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            System.out.println(inputLine);
                            out.println(inputLine);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        // Send a message to the client when the socket is closed
                        PrintWriter out;
                        try {
                        	if(socket.isClosed()) {
                            out = new PrintWriter(socket.getOutputStream(), true);
                            out.println("Server connection closed.");
                        	}} catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close(); // Close the socket
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                
                // Check if the socket is closed
                while (!socket.isClosed()) { 
                    Thread.sleep(1000); // Wait for 1 second before checking again
                }
            }
        } catch (IOException e) {
            Con4TextField.setText("");
            Con4TextField.setText("Error is found");
            e.printStackTrace();
        }
    }

   
    public void disconnectServer() {
        if (socket != null) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Server disconnected.");
                socket.close();
                socket = null;
                Con4TextField.setText("");
                Con3TextField.setText("");
                Con2TextField.setText("");
                Con1TextField.setText("");
                Con4TextField.setText("Client disconnected.");
            } catch (IOException e) {
                Con4TextField.setText("");
                Con4TextField.setText("Error while disconnecting client: " + e.getMessage());
            }
        } else {
            Con4TextField.setText("");
            Con4TextField.setText("No client connection to disconnect.");
        }
    }
    
    public void disconnectServer_fromManageNetwork() {
        if (socket != null) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Server disconnected.");
                socket.close();
                socket = null;
                Con4TextField.setText("");
                Con3TextField.setText("");
                Con2TextField.setText("");
                Con1TextField.setText("");
                Con4TextField.setText("Client disconnected.");
            } catch (IOException e) {
                Con4TextField.setText("");
                Con4TextField.setText("Error while disconnecting client: " + e.getMessage());
            }
        } else {
            Con4TextField.setText("");
            Con4TextField.setText("No client connection to disconnect.");
        }
    }

    //upTime
    public void upTime() throws InterruptedException, IOException {
        boolean isConnected = true;
        long startTime = System.currentTimeMillis();
        while (isConnected) {
            // Check if the socket is still connected
            isConnected = !socket.isClosed() && socket.isConnected();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(hours);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);

            String elapsedTimeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            UptimeTextField1.setText(elapsedTimeString);

            Thread.sleep(1000);
        }
    }
    
    public void CPUpercentage() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
                    // What % load the overall system is at, from 0.0-1.0
                    @SuppressWarnings("deprecation")
					double systemLoad = osBean.getSystemCpuLoad() * 100.0;
                        CPUText.setText("");
                        CPUText.setText("CPU Performance: " + String.format("%.2f", systemLoad) + "%");
                    }
                });
                timer.setInitialDelay(0);
                timer.start();
            }    

    
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
        jLabel5 = new javax.swing.JLabel();
        TextResultPanel = new javax.swing.JPanel();
        Con1TextField = new javax.swing.JLabel();
        Con2TextField = new javax.swing.JLabel();
        Con3TextField = new javax.swing.JLabel();
        Con4TextField = new javax.swing.JLabel();
        TopInfo2Panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        StartServerButton = new javax.swing.JButton();
        Text1 = new javax.swing.JLabel();
        Text2 = new javax.swing.JLabel();
        Img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        StopServerButton = new javax.swing.JButton();
        Img2 = new javax.swing.JLabel();
        Text3 = new javax.swing.JLabel();
        Text4 = new javax.swing.JLabel();
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
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-home-64.png"))); // NOI18N
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
        EConnectionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-connect-48.png"))); // NOI18N
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
        SettingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-settings-48.png"))); // NOI18N
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
        AboutUsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-about-64.png"))); // NOI18N
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
        ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-close-48.png"))); // NOI18N
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

        LogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Duck1.png"))); // NOI18N

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EConnectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AboutUsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SettingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        
        CPUText = new JLabel("");
        CPUText.setFont(new Font("Century Gothic", Font.BOLD, 12));

        javax.swing.GroupLayout TextResultPanelLayout = new javax.swing.GroupLayout(TextResultPanel);
        TextResultPanelLayout.setHorizontalGroup(
        	TextResultPanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(TextResultPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(TextResultPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(Con4TextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
        				.addComponent(Con3TextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
        				.addComponent(Con2TextField, GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
        				.addGroup(TextResultPanelLayout.createSequentialGroup()
        					.addComponent(Con1TextField, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        					.addGap(127)
        					.addComponent(CPUText, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        TextResultPanelLayout.setVerticalGroup(
        	TextResultPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(TextResultPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(Con2TextField, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
        			.addComponent(Con4TextField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(Con3TextField, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(TextResultPanelLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(Con1TextField, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
        				.addComponent(CPUText, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addGap(98))
        );
        TextResultPanel.setLayout(TextResultPanelLayout);

        TopInfo2Panel.setBackground(new java.awt.Color(136, 113, 249));

        jPanel1.setBackground(new java.awt.Color(136, 113, 249));
        jPanel1.setLayout(null);

        StartServerButton.setBackground(new java.awt.Color(199, 255, 189));
        StartServerButton.setForeground(new java.awt.Color(0, 0, 0));
        StartServerButton.setText("Start Server");
        StartServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartServerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(StartServerButton);
        StartServerButton.setBounds(270, 80, 133, 45);

        Text1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Text1.setText("Don't know how to start?");
        jPanel1.add(Text1);
        Text1.setBounds(255, 25, 162, 20);

        Text2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Text2.setText("Just click this button!");
        jPanel1.add(Text2);
        Text2.setBounds(267, 43, 140, 19);

        Img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Establish.png"))); // NOI18N
        Img.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.add(Img);
        Img.setBounds(0, 0, 450, 146);

        jPanel2.setBackground(new java.awt.Color(136, 113, 249));
        jPanel2.setLayout(null);

        StopServerButton.setBackground(new java.awt.Color(255, 56, 79));
        StopServerButton.setForeground(new java.awt.Color(0, 0, 0));
        StopServerButton.setText("Close Server");
        StopServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopServerButtonActionPerformed(evt);
            }
        });
        jPanel2.add(StopServerButton);
        StopServerButton.setBounds(20, 80, 130, 45);

        Img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Establish2.png"))); // NOI18N
        Img2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.add(Img2);
        Img2.setBounds(0, 0, 460, 146);

        Text3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Text3.setText("Want to stop the server?");
        jPanel2.add(Text3);
        Text3.setBounds(20, 25, 170, 19);

        Text4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Text4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text4.setText("Just click this button!");
        jPanel2.add(Text4);
        Text4.setBounds(22, 44, 150, 19);

        javax.swing.GroupLayout TopInfo2PanelLayout = new javax.swing.GroupLayout(TopInfo2Panel);
        TopInfo2Panel.setLayout(TopInfo2PanelLayout);
        TopInfo2PanelLayout.setHorizontalGroup(
            TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopInfo2PanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TopInfo2PanelLayout.setVerticalGroup(
            TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopInfo2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopInfo2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
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
        BackgroundLayout.setHorizontalGroup(
        	BackgroundLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(BackgroundLayout.createSequentialGroup()
        			.addComponent(SidePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(BackgroundLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(TextResultPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(BackgroundLayout.createSequentialGroup()
        					.addComponent(Dashboard5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(Dashboard6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(Dashboard7, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        				.addComponent(TopInfo2Panel, GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE))
        			.addGap(13))
        );
        BackgroundLayout.setVerticalGroup(
        	BackgroundLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(BackgroundLayout.createSequentialGroup()
        			.addGroup(BackgroundLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(BackgroundLayout.createSequentialGroup()
        					.addComponent(TopInfo2Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(BackgroundLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(Dashboard5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Dashboard6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(Dashboard7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(TextResultPanel, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE))
        				.addComponent(SidePanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(0, 106, Short.MAX_VALUE))
        );
        Background.setLayout(BackgroundLayout);

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
                serverport = 12;
                createServer();
                StartServerButton.setEnabled(false);
                HomeButton.setEnabled(false);
//                StartServerButton.setEnabled(false);
//                StopServerButton.setEnabled(true);
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
//		StopServerButton.setEnabled(false);
//		StartServerButton.setEnabled(true);  
    	if(socket!=null) {
        StartServerButton.setEnabled(true);
    	}
    	disconnectServer();        // TODO add your handling code here:
    }//GEN-LAST:event_StopServerButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
    this.setVisible(false);
//    	System.exit(0);      // TODO add your handling code here:
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
    private javax.swing.JLabel Img;
    private javax.swing.JLabel Img2;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel NumConTextField;
    private javax.swing.JLabel NumberConnectedUserLabel;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton StartServerButton;
    private javax.swing.JButton StopServerButton;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text2;
    private javax.swing.JLabel Text3;
    private javax.swing.JLabel Text4;
    private javax.swing.JPanel TextResultPanel;
    private javax.swing.JPanel TopInfo2Panel;
    private javax.swing.JLabel UptimeLabel1;
    private javax.swing.JLabel UptimeTextField1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JLabel CPUText;
}
