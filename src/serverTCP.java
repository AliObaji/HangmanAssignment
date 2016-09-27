import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ashariri95 on 9/23/2016.
 *
 * This program will be the server of the hangman application in adhering to TCP.
 *
 * Used references
 * https://systembash.com/a-simple-java-tcp-server-and-tcp-client/
 * https://www.youtube.com/watch?v=vCDrGJWqR8w
 */

public class serverTCP {
    public static void main(String args[]) throws IOException{
        String clientInput;
        String word;

        ServerSocket serverSocket = new ServerSocket(1234);

        Socket connectionSocket = serverSocket.accept();

        Scanner inFromClient = new Scanner(connectionSocket.getInputStream());



        clientInput = inFromClient.next();

        System.out.println("received: " + clientInput );

        if(clientInput.equals("PLAY")) {
            System.out.println("Now Playing (from server) ...");


            PrintStream backToClient = new PrintStream(connectionSocket.getOutputStream());
            backToClient.println("Word");
        }


    }
}
