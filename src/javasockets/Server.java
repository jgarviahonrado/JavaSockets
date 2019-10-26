package javasockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        
        Thread myThread = new Thread(myServer);
        
        /** start() es el encargado de llamar al método run(), 
         * que contiene el código a ser ejecutado asíncronamente 
         * por el Thread
         */
        myThread.start();
    }
}

class MyServer extends Thread {

    static final int SERVER_PORT = 4444;

    @Override
    public void run() {
        System.out.println("Server thread running...");

        try {

            ServerSocket myServerSocket = new ServerSocket(SERVER_PORT);

            /**
             * Mantenemos al servidor esperando de forma continua la llegada 
             * de conexiones de clientes.
             */
            while (true) {
                Socket mySocket = myServerSocket.accept();

                DataInputStream myDataInputStream = new DataInputStream(mySocket.getInputStream());

                System.out.println(myDataInputStream.readUTF());

                mySocket.close();

                myDataInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
