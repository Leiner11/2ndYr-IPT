/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IPT_Test;

/**
 *
 * @author AR
 */

import java.io.*;
import java.net.*;

public class Client_Test {
    
    public static void main(String[] args) throws IOException {

        String serverHostname = "localhost";
        int serverPort = 12;

        System.out.println("Connecting to " + serverHostname + " on port " + serverPort);

        Socket Socket = new Socket(serverHostname, serverPort);
        System.out.println("Connected to " + serverHostname + " on port " + serverPort);

        PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));

        String message = "Client request successfully completed.";
        out.println(message);
        System.out.println(message);

        String response;
        while ((response = in.readLine()) != null) {
            System.out.println(response);
        }
        Socket.close();
    }
}    