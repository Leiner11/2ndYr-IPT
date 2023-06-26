package mid_LA2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class test_client {
    public static void main(String[] args) throws IOException {
        // need host and port, we want to connect to the ServerSocket at port 12
        Socket socket = new Socket("127.0.0.1", 12);
        System.out.println("Connected!");

        // get the input stream from the connected socket
        InputStream inputStream = socket.getInputStream();
        // create a DataInputStream so we can read data from it.
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        
        // get the output stream from the socket.
        OutputStream outputStream = socket.getOutputStream();
        // create a data output stream from the output stream so we can send data through it
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        System.out.println("Input amount of investment: ");

        // input the data we want to send
        Scanner insertInvestment = new Scanner(System.in);
        String investment = insertInvestment.nextLine();
        dataOutputStream.writeUTF(investment);
        
        
        System.out.println("Input Years of investment: ");
        Scanner insertYears = new Scanner(System.in);
        String years = insertYears.nextLine();
        int yr_int = Integer.parseInt(years);
        dataOutputStream.writeUTF(years);
        
        System.out.println("Input Interest rate of investment: ");
        Scanner insertIR = new Scanner(System.in);
        String interestRate = insertIR.nextLine();
        dataOutputStream.writeUTF(interestRate);
        
        dataOutputStream.flush();
        
        yr_int = yr_int+2;
        
        for(int x=0;x<yr_int;x++) {
                try {
                    String message = dataInputStream.readUTF();
                    System.out.println(message);
                } catch (EOFException e) {
                    System.err.println("Connection closed by server.");
                    break;
                }
            }
        
        //String test_2 = dataInputStream.readUTF();
        //System.out.println(test_2);
        
        //String test_3 = dataInputStream.readUTF();
        //System.out.println(test_3);
        
         // send the message
        //dataOutputStream.close(); // close the output stream when we're done.

        //System.out.println("Closing socket and terminating program.");
        //socket.close();
    }
}