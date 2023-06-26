/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPT_Test;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import com.sun.management.OperatingSystemMXBean;

/**
 *
 * @author AR
 */
public class testCPU {
    
    public static void main(String[] args){
OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
            // What % CPU load this current JVM is taking, from 0.0-1.0
            System.out.println(osBean.getProcessCpuLoad());

            // What % load the overall system is at, from 0.0-1.0
            System.out.println(osBean.getSystemCpuLoad());
}}
