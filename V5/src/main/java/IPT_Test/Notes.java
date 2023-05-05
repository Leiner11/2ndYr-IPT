/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPT_Test;

import com.sun.management.OperatingSystemMXBean;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author AR
 */


public class Notes {
    
                public void CPUpercentage() {
                    
                label = new JLabel();
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
                    // What % load the overall system is at, from 0.0-1.0
                    double systemLoad = osBean.getSystemCpuLoad() * 100.0;
                        currentTime.setText("");
                        currentTime.setText("System CPU Load: " + String.format("%.2f", systemLoad) + "%");
                    }
                });
                timer.setInitialDelay(0);
                timer.start();
            }
}





