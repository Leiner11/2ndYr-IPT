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

public class Server_Test {
  
    public static void main(String[] args) throws IOException {

    	try (ServerSocket listener = new ServerSocket(12)) {
    		//printing out of the output if the server is running well
    		int serverport = 12;
    		System.out.println("The server is running...");
            
        while (true) {
            System.out.println("Using server socket: " + serverport);
            
            Socket clientSocket = listener.accept();
            
            InetAddress clientAddress = clientSocket.getInetAddress(); //GET IP ADDRESS
            System.out.println("IP Address & Host Name: " + clientAddress.getHostAddress() +
                " ("+ clientAddress.getHostName() + ") ");
            
            System.out.println("Port No.: " + clientSocket.getPort()); //GET PORT NO.

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                out.println(inputLine);
            }

            clientSocket.close();
            
        }}
			catch(Exception e) {
			System.out.println("Error is found");
			}
    	}
}

