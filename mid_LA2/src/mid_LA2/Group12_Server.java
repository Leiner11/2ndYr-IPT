package mid_LA2;

//classes importation
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//start of the program
public class Group12_Server {
    public static void main(String[] args) throws IOException { //creating main method with proper error handler / IOException
        try (ServerSocket listener = new ServerSocket(12)) { //creating server socket the group (12) is the port number
            System.out.println("The server is running..."); //printing out of the output if the server is running well
            
            while (true) { //start of loop to accept client connection
                try (Socket socket = listener.accept()) { //try statement to connect to client
                    System.out.println("Client: " + socket);
                    InputStream inputStream = socket.getInputStream(); // get the input stream from the connected socket
                    DataInputStream dataInputStream = new DataInputStream(inputStream); // create a DataInputStream to read data.

                    OutputStream outputStream = socket.getOutputStream(); // output stream to the connected socket
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream); // create a DataOutputStream to send messages.

                    //String declaration to save client inputs to a variable//
                    String inv_str = dataInputStream.readUTF(); // read the message from the socket
                    float investment = Float.parseFloat(inv_str); //convert string to float
                    System.out.println("Investment: " + investment); //outputs statement with additional variable

                    String yr_str = dataInputStream.readUTF();
                    int yr_int = Integer.parseInt(yr_str);
                    System.out.println("Years: " + yr_int);

                    String int_str = dataInputStream.readUTF();
                    float interest_float = Float.parseFloat(int_str);
                    System.out.println("Interest rate: " + interest_float);

                    //float variables to hold formulas
                    float initial_int_rate = (investment * interest_float) / 100; //to get the exact interest based on the investment amount
                    float int_rate = initial_int_rate+(initial_int_rate*interest_float)/100; //to get the interest after 1 year
                    float new_int_rate= (initial_int_rate*interest_float)/100; //just a holder for the interest
                    float start_balance = investment + initial_int_rate; //holder for the start balance
                    float end_balance = investment; //holder for the ending balance
                    float total_interest = initial_int_rate; //total interest variable holder
                    
                    
                    /*String declaration for the header/output. "%" Specifies the output should be string, "-" indicator for 
                    left-justified, 10 indicates the minimum width, "n" for next line*/
                    
                    String header = String.format("%-10s %-20s%-20s%-15s%n", "Year", "Starting Balance", "Interest", "Ending Balance");
                    dataOutputStream.writeUTF(header);
                    
                    //Outputs the first year of the computation
                    String output = String.format("%-10s %-20s%-20s%-15s%n", 1, investment, initial_int_rate, start_balance);
                    dataOutputStream.writeUTF(output);
                    
                    //Start of the loop for the computation
                    for (int x = 2; x <= yr_int; x++) { //indicates that the loop should start after the 1st year.
                        end_balance = start_balance + int_rate;
                        total_interest = total_interest + int_rate;
                        
                        //rounds up the decimal of the result
                        double round_int_rate = Math.round(int_rate * 100.0) / 100.0; 
                        double round_end_balance = Math.round(end_balance * 100.0) / 100.0;
                        
                        //outputs the result with proper alignment
                        output = String.format("%-10s %-20s%-20s%-15s%n", x, start_balance, round_int_rate, round_end_balance);
                        dataOutputStream.writeUTF(output);
                        
                        start_balance = end_balance; //updates the start balance for the next year
                        
                        
                        //updates the interest rate to produce updated numbers
                        int_rate = (initial_int_rate+new_int_rate+((initial_int_rate+new_int_rate)*interest_float)/100);
                        initial_int_rate = initial_int_rate+((initial_int_rate+new_int_rate)*interest_float)/100; 
                        
                    }
                    //rounds up the result
                    double round_end_balance = Math.round(end_balance * 100.0) / 100.0;
                    double round_total_interest = Math.round(total_interest * 100.0) / 100.0;
                    
                    //outputs the ending balance and total interest earned after the loop
                    output = ("Ending Balance: $" + round_end_balance + "\n" + 
                    			"Total Interest Earned: $" + round_total_interest );
                    dataOutputStream.writeUTF(output);
                    
                } catch (Exception e) {
                    System.out.println("Error is found");
                }
            }
        }
    }
}
