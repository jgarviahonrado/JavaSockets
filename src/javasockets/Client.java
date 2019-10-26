package javasockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    static final String SERVER_IP_ADDRESS = "localhost";
    static final int SERVER_PORT = 4444;
    
    public static void main(String[] args) {
        
        try {
            Socket mySocket = new Socket (SERVER_IP_ADDRESS, SERVER_PORT);
            
            DataOutputStream myDataOutputStream = new DataOutputStream(mySocket.getOutputStream());
            
            myDataOutputStream.writeUTF("Client message");
            
            myDataOutputStream.close();      
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
