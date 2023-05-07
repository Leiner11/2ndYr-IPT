/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IPT_Final;

import com.sun.management.OperatingSystemMXBean;
import java.awt.event.*;
import java.lang.management.ManagementFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 *
 * @author User
 */
public class NetworkUI extends javax.swing.JFrame {

    /**
     * Creates new form NetworkUI
     */
    private Timer timer, timer_date;

    
    public NetworkUI() {
        initComponents();
        this.setResizable(false);
        CPUpercentage();
    }
     
    public void CPUpercentage() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
                    // What % load the overall system is at, from 0.0-1.0
                    double systemLoad = osBean.getSystemCpuLoad() * 100.0;
                        PercentNumTextField.setText("");
                        PercentNumTextField.setText(String.format("%.2f", systemLoad) + "%");
                    }
                });
                timer.setInitialDelay(0);
                timer.start();
            }
    
//Uptime
    public void upTime() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long hours = TimeUnit.MILLISECONDS.toHours(elapsedTime);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime) - TimeUnit.HOURS.toMinutes(hours);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime) - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);
            
            String elapsedTimeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            UptimeTextField.setText(elapsedTimeString);
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
        Sidepanel = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        EConnectionButton = new javax.swing.JButton();
        ManageButton = new javax.swing.JButton();
        HistoryLogsButton = new javax.swing.JButton();
        SettingsButton = new javax.swing.JButton();
        AboutUsButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        LogoLabel = new javax.swing.JLabel();
        Dashboard4 = new javax.swing.JPanel();
        UptimeLabel = new javax.swing.JLabel();
        UptimeTextField = new javax.swing.JLabel();
        Dashboard5 = new javax.swing.JPanel();
        DateLabel = new javax.swing.JLabel();
        DateTextField = new javax.swing.JLabel();
        Dashboard6 = new javax.swing.JPanel();
        NumberConnectedUserLabel = new javax.swing.JLabel();
        NumConTextField = new javax.swing.JLabel();
        TopInfoPanel = new javax.swing.JPanel();
        Image = new javax.swing.JLabel();
        TextPanel = new javax.swing.JLabel();
        TextPanel2 = new javax.swing.JLabel();
        UpdateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        FeedbackButton = new javax.swing.JButton();
        TextPanel3 = new javax.swing.JLabel();
        TextPanel4 = new javax.swing.JLabel();
        CPUPanel = new javax.swing.JPanel();
        CPUPerformance = new javax.swing.JLabel();
        ImageCircle = new javax.swing.JLabel();
        PercentNumTextField = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(136, 113, 249));

        Sidepanel.setBackground(new java.awt.Color(136, 113, 249));

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

        ManageButton.setBackground(new java.awt.Color(127, 57, 233));
        ManageButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        ManageButton.setText("Manage Networks");
        ManageButton.setBorder(null);
        ManageButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ManageButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ManageButton.setIconTextGap(14);
        ManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageButtonActionPerformed(evt);
            }
        });

        HistoryLogsButton.setBackground(new java.awt.Color(127, 57, 233));
        HistoryLogsButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        HistoryLogsButton.setText("History Logs");
        HistoryLogsButton.setBorder(null);
        HistoryLogsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HistoryLogsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        HistoryLogsButton.setIconTextGap(30);
        HistoryLogsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryLogsButtonActionPerformed(evt);
            }
        });

        SettingsButton.setBackground(new java.awt.Color(127, 57, 233));
        SettingsButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        SettingsButton.setText("Settings");
        SettingsButton.setBorder(null);
        SettingsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SettingsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        SettingsButton.setIconTextGap(60);

        AboutUsButton.setBackground(new java.awt.Color(127, 57, 233));
        AboutUsButton.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        AboutUsButton.setText("About Us");
        AboutUsButton.setBorder(null);
        AboutUsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AboutUsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        AboutUsButton.setIconTextGap(54);

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

        javax.swing.GroupLayout SidepanelLayout = new javax.swing.GroupLayout(Sidepanel);
        Sidepanel.setLayout(SidepanelLayout);
        SidepanelLayout.setHorizontalGroup(
            SidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EConnectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
            .addComponent(ManageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HistoryLogsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AboutUsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SettingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidepanelLayout.setVerticalGroup(
            SidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidepanelLayout.createSequentialGroup()
                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EConnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HistoryLogsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AboutUsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Dashboard4.setBackground(new java.awt.Color(199, 244, 90));
        Dashboard4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Dashboard4.setForeground(new java.awt.Color(255, 152, 100));

        UptimeLabel.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        UptimeLabel.setForeground(new java.awt.Color(0, 0, 0));
        UptimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UptimeLabel.setText("Uptime: ");

        UptimeTextField.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        UptimeTextField.setForeground(new java.awt.Color(0, 0, 0));
        UptimeTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Dashboard4Layout = new javax.swing.GroupLayout(Dashboard4);
        Dashboard4.setLayout(Dashboard4Layout);
        Dashboard4Layout.setHorizontalGroup(
            Dashboard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Dashboard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UptimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UptimeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        Dashboard4Layout.setVerticalGroup(
            Dashboard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(UptimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UptimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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
        DateTextField.setText("DateText");

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

        NumberConnectedUserLabel.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        NumberConnectedUserLabel.setForeground(new java.awt.Color(0, 0, 0));
        NumberConnectedUserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumberConnectedUserLabel.setText("Number of Connected Users:");

        NumConTextField.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        NumConTextField.setForeground(new java.awt.Color(0, 0, 0));
        NumConTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumConTextField.setText("NCU:");

        javax.swing.GroupLayout Dashboard6Layout = new javax.swing.GroupLayout(Dashboard6);
        Dashboard6.setLayout(Dashboard6Layout);
        Dashboard6Layout.setHorizontalGroup(
            Dashboard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(Dashboard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NumberConnectedUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addComponent(NumConTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Dashboard6Layout.setVerticalGroup(
            Dashboard6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dashboard6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(NumberConnectedUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumConTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        TopInfoPanel.setBackground(new java.awt.Color(136, 113, 249));
        TopInfoPanel.setLayout(null);

        Image.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        TopInfoPanel.add(Image);
        Image.setBounds(0, 0, 450, 205);

        TextPanel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TextPanel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextPanel.setText("Having problems with the old version?");
        TopInfoPanel.add(TextPanel);
        TextPanel.setBounds(160, 60, 260, 40);

        TextPanel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TextPanel2.setText("Get the lastest version now!");
        TopInfoPanel.add(TextPanel2);
        TextPanel2.setBounds(190, 83, 190, 40);

        UpdateButton.setBackground(new java.awt.Color(255, 191, 175));
        UpdateButton.setForeground(new java.awt.Color(0, 0, 0));
        UpdateButton.setText("Update");
        TopInfoPanel.add(UpdateButton);
        UpdateButton.setBounds(200, 120, 160, 30);

        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        TopInfoPanel.add(jLabel2);
        jLabel2.setBounds(460, 0, 462, 205);

        FeedbackButton.setBackground(new java.awt.Color(255, 191, 175));
        FeedbackButton.setForeground(new java.awt.Color(0, 0, 0));
        FeedbackButton.setText("Send Feedback");
        TopInfoPanel.add(FeedbackButton);
        FeedbackButton.setBounds(670, 120, 160, 30);

        TextPanel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TextPanel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextPanel3.setText("Enjoying our application?");
        TopInfoPanel.add(TextPanel3);
        TextPanel3.setBounds(630, 60, 256, 43);

        TextPanel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        TextPanel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TextPanel4.setText("Kindly send us a feedback!");
        TopInfoPanel.add(TextPanel4);
        TextPanel4.setBounds(660, 80, 197, 46);

        CPUPanel.setBackground(new java.awt.Color(199, 244, 90));

        CPUPerformance.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        CPUPerformance.setForeground(new java.awt.Color(0, 0, 0));
        CPUPerformance.setText("CPU PERFORMANCE");

        PercentNumTextField.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        PercentNumTextField.setForeground(new java.awt.Color(51, 51, 51));
        PercentNumTextField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout CPUPanelLayout = new javax.swing.GroupLayout(CPUPanel);
        CPUPanel.setLayout(CPUPanelLayout);
        CPUPanelLayout.setHorizontalGroup(
            CPUPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPUPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(CPUPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CPUPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImageCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(CPUPanelLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(PercentNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CPUPanelLayout.setVerticalGroup(
            CPUPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPUPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(CPUPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(CPUPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CPUPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(PercentNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ImageCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBackground(new java.awt.Color(199, 244, 90));
        jPanel1.setLayout(null);

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(Sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TopInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(Dashboard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Dashboard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Dashboard6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addComponent(CPUPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addComponent(TopInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Dashboard6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashboard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashboard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CPUPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void EConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EConnectionButtonActionPerformed
    this.setVisible(false);
    new EstablishConnection().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_EConnectionButtonActionPerformed

    private void ManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageButtonActionPerformed
    this.setVisible(false);
    new ManageNetwork().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ManageButtonActionPerformed

    private void HistoryLogsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryLogsButtonActionPerformed
    this.setVisible(false);
    new HistoryLogs().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_HistoryLogsButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_ExitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NetworkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NetworkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NetworkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NetworkUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NetworkUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutUsButton;
    private javax.swing.JPanel Background;
    private javax.swing.JPanel CPUPanel;
    private javax.swing.JLabel CPUPerformance;
    private javax.swing.JPanel Dashboard4;
    private javax.swing.JPanel Dashboard5;
    private javax.swing.JPanel Dashboard6;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DateTextField;
    private javax.swing.JButton EConnectionButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton FeedbackButton;
    private javax.swing.JButton HistoryLogsButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JLabel Image;
    private javax.swing.JLabel ImageCircle;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JButton ManageButton;
    private javax.swing.JLabel NumConTextField;
    private javax.swing.JLabel NumberConnectedUserLabel;
    private javax.swing.JLabel PercentNumTextField;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JPanel Sidepanel;
    private javax.swing.JLabel TextPanel;
    private javax.swing.JLabel TextPanel2;
    private javax.swing.JLabel TextPanel3;
    private javax.swing.JLabel TextPanel4;
    private javax.swing.JPanel TopInfoPanel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel UptimeLabel;
    private javax.swing.JLabel UptimeTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
