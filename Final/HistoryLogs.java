/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IPT_Final2;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class HistoryLogs extends javax.swing.JFrame {
    private String IP_Address;
    private int count;      
    private String[] IP_Array;
    private int counter = 0;
    private Socket socket;
    /**
     * Creates new form HistoryLogs
     */
    
    public HistoryLogs(String IP_Address, int count, Socket socket) {
        initComponents();
        IP_Array = new String[5];
        this.IP_Address = IP_Address;
        this.count = count;
        this.socket = socket;
        
        if(count >= 6){
            count=0;
        }
        else{
            store(IP_Address);
        }
        
        this.setResizable(false);
    }
    public void Date(){
        LocalDate currentDate = LocalDate.now();
        LocalTime Time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = Time.format(formatter);
        String formattedDate = currentDate.format(dateFormatter);
        DateTextField1.setText(formattedDate + " " + formattedTime);}
    
    public void store(String IP_Address) {
        IP_Array[counter] = IP_Address; // add the received data to the array at the current index
        counter++; // increment the current index

        switch (counter){
            case 1:
            IpAddTextField1.setText("");
            IpAddTextField1.setText(IP_Address);
            Date();
            break;
            
            case 2:
            IpAddTextField2.setText("");
            IpAddTextField2.setText(IP_Address);    
            Date();
            break;
            
            case 3:
            IpAddTextField3.setText("");
            IpAddTextField3.setText(IP_Address);    
            Date();
            break;
            
            case 4:
            IpAddTextField4.setText("");
            IpAddTextField4.setText(IP_Address);  
            Date();
            break;
            
            case 5:
            IpAddTextField5.setText("");
            IpAddTextField5.setText(IP_Address);    
            Date();
            break;
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Sidepanel = new javax.swing.JPanel();
        ManageButton = new javax.swing.JButton();
        HistoryLogsButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        LogsPanel = new javax.swing.JPanel();
        Log1 = new javax.swing.JPanel();
        Text1 = new javax.swing.JLabel();
        IpAddTextField1 = new javax.swing.JLabel();
        Text6 = new javax.swing.JLabel();
        DateTextField1 = new javax.swing.JLabel();
        Log2 = new javax.swing.JPanel();
        Text2 = new javax.swing.JLabel();
        IpAddTextField2 = new javax.swing.JLabel();
        Text7 = new javax.swing.JLabel();
        DateTextField2 = new javax.swing.JLabel();
        Log3 = new javax.swing.JPanel();
        Text3 = new javax.swing.JLabel();
        IpAddTextField3 = new javax.swing.JLabel();
        Text8 = new javax.swing.JLabel();
        DateTextField3 = new javax.swing.JLabel();
        Log4 = new javax.swing.JPanel();
        Text4 = new javax.swing.JLabel();
        IpAddTextField4 = new javax.swing.JLabel();
        Text9 = new javax.swing.JLabel();
        DateTextField4 = new javax.swing.JLabel();
        Log5 = new javax.swing.JPanel();
        Text5 = new javax.swing.JLabel();
        IpAddTextField5 = new javax.swing.JLabel();
        Text10 = new javax.swing.JLabel();
        DateTextField5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(136, 113, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(1194, 678));

        Sidepanel.setBackground(new java.awt.Color(136, 113, 249));

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
            .addComponent(ManageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
            .addComponent(HistoryLogsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidepanelLayout.setVerticalGroup(
            SidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidepanelLayout.createSequentialGroup()
                .addGap(482, 482, 482)
                .addComponent(ManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HistoryLogsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LogsPanel.setBackground(new java.awt.Color(127, 57, 233));

        Log1.setBackground(new java.awt.Color(127, 211, 235));

        Text1.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text1.setForeground(new java.awt.Color(0, 0, 0));
        Text1.setText("  A user has connected to the server with an IP Address of");

        IpAddTextField1.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        IpAddTextField1.setForeground(new java.awt.Color(0, 0, 0));
        IpAddTextField1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        Text6.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text6.setForeground(new java.awt.Color(0, 0, 0));
        Text6.setText("at");

        DateTextField1.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        DateTextField1.setForeground(new java.awt.Color(0, 0, 0));
        DateTextField1.setText("(Date of connection)");

        javax.swing.GroupLayout Log1Layout = new javax.swing.GroupLayout(Log1);
        Log1.setLayout(Log1Layout);
        Log1Layout.setHorizontalGroup(
            Log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IpAddTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Log1Layout.setVerticalGroup(
            Log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Log1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(IpAddTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        if(count==1){
            IpAddTextField1.setText("");
            IpAddTextField1.setText(IP_Address);
        }

        Log2.setBackground(new java.awt.Color(127, 211, 235));

        Text2.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text2.setForeground(new java.awt.Color(0, 0, 0));
        Text2.setText("  A user has connected to the server with an IP Address of");

        IpAddTextField2.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        IpAddTextField2.setForeground(new java.awt.Color(0, 0, 0));

        Text7.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text7.setForeground(new java.awt.Color(0, 0, 0));
        Text7.setText("at");

        DateTextField2.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        DateTextField2.setForeground(new java.awt.Color(0, 0, 0));
        DateTextField2.setText("(Date of connection)");

        javax.swing.GroupLayout Log2Layout = new javax.swing.GroupLayout(Log2);
        Log2.setLayout(Log2Layout);
        Log2Layout.setHorizontalGroup(
            Log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IpAddTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Log2Layout.setVerticalGroup(
            Log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Log2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(Text7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IpAddTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Log3.setBackground(new java.awt.Color(127, 211, 235));

        Text3.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text3.setForeground(new java.awt.Color(0, 0, 0));
        Text3.setText("  A user has connected to the server with an IP Address of");

        IpAddTextField3.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        IpAddTextField3.setForeground(new java.awt.Color(0, 0, 0));

        Text8.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text8.setForeground(new java.awt.Color(0, 0, 0));
        Text8.setText("at");

        DateTextField3.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        DateTextField3.setForeground(new java.awt.Color(0, 0, 0));
        DateTextField3.setText("(Date of connection)");

        javax.swing.GroupLayout Log3Layout = new javax.swing.GroupLayout(Log3);
        Log3.setLayout(Log3Layout);
        Log3Layout.setHorizontalGroup(
            Log3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IpAddTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Log3Layout.setVerticalGroup(
            Log3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Log3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Log3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IpAddTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addContainerGap())
        );

        Log4.setBackground(new java.awt.Color(127, 211, 235));

        Text4.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text4.setForeground(new java.awt.Color(0, 0, 0));
        Text4.setText("  A user has connected to the server with an IP Address of");

        IpAddTextField4.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        IpAddTextField4.setForeground(new java.awt.Color(0, 0, 0));

        Text9.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text9.setForeground(new java.awt.Color(0, 0, 0));
        Text9.setText("at");

        DateTextField4.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        DateTextField4.setForeground(new java.awt.Color(0, 0, 0));
        DateTextField4.setText("(Date of connection)");

        javax.swing.GroupLayout Log4Layout = new javax.swing.GroupLayout(Log4);
        Log4.setLayout(Log4Layout);
        Log4Layout.setHorizontalGroup(
            Log4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IpAddTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Log4Layout.setVerticalGroup(
            Log4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Log4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Log4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IpAddTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text4, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(Text9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Log5.setBackground(new java.awt.Color(127, 211, 235));

        Text5.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text5.setForeground(new java.awt.Color(0, 0, 0));
        Text5.setText("  A user has connected to the server with an IP Address of");

        IpAddTextField5.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        IpAddTextField5.setForeground(new java.awt.Color(0, 0, 0));

        Text10.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        Text10.setForeground(new java.awt.Color(0, 0, 0));
        Text10.setText("at");

        DateTextField5.setFont(new java.awt.Font("Century Gothic", 1, 19)); // NOI18N
        DateTextField5.setForeground(new java.awt.Color(0, 0, 0));
        DateTextField5.setText("(Date of connection)");

        javax.swing.GroupLayout Log5Layout = new javax.swing.GroupLayout(Log5);
        Log5.setLayout(Log5Layout);
        Log5Layout.setHorizontalGroup(
            Log5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IpAddTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Text10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Log5Layout.setVerticalGroup(
            Log5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Log5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Log5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IpAddTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(Text5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout LogsPanelLayout = new javax.swing.GroupLayout(LogsPanel);
        LogsPanel.setLayout(LogsPanelLayout);
        LogsPanelLayout.setHorizontalGroup(
            LogsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LogsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Log1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Log2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Log3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Log4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Log5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LogsPanelLayout.setVerticalGroup(
            LogsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogsPanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(Log1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Log2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Log3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Log4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Log5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Sidepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Sidepanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(LogsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageButtonActionPerformed
    this.setVisible(false);
    new ManageNetwork(IP_Address,count,socket).setVisible(true);// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_ManageButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
    System.exit(0);      // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void HistoryLogsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryLogsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HistoryLogsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HistoryLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoryLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoryLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoryLogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HistoryLogs(IP_Address,count).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateTextField1;
    private javax.swing.JLabel DateTextField2;
    private javax.swing.JLabel DateTextField3;
    private javax.swing.JLabel DateTextField4;
    private javax.swing.JLabel DateTextField5;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton HistoryLogsButton;
    private javax.swing.JLabel IpAddTextField1;
    private javax.swing.JLabel IpAddTextField2;
    private javax.swing.JLabel IpAddTextField3;
    private javax.swing.JLabel IpAddTextField4;
    private javax.swing.JLabel IpAddTextField5;
    private javax.swing.JPanel Log1;
    private javax.swing.JPanel Log2;
    private javax.swing.JPanel Log3;
    private javax.swing.JPanel Log4;
    private javax.swing.JPanel Log5;
    private javax.swing.JPanel LogsPanel;
    private javax.swing.JButton ManageButton;
    private javax.swing.JPanel Sidepanel;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text10;
    private javax.swing.JLabel Text2;
    private javax.swing.JLabel Text3;
    private javax.swing.JLabel Text4;
    private javax.swing.JLabel Text5;
    private javax.swing.JLabel Text6;
    private javax.swing.JLabel Text7;
    private javax.swing.JLabel Text8;
    private javax.swing.JLabel Text9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
