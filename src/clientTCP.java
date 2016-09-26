import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ashariri95 on 9/23/2016.
 *
 * This program allows the user to initialise a game of hangman with the server, after which he/she
 * can start sending his/her guesses.
 * This client uses TCP.
 *
 * Used references
 * https://systembash.com/a-simple-java-tcp-server-and-tcp-client/
 * https://www.youtube.com/watch?v=vCDrGJWqR8w
 */

public class clientTCP {
    public static void main(String args[]) throws IOException{
        Scanner user = new Scanner(System.in);

        Socket clientSocket = new Socket("127.0.0.1",1342);
        PrintStream sendToServer = new PrintStream(clientSocket.getOutputStream());

        Scanner fromServer = new Scanner(clientSocket.getInputStream());


        System.out.println("Would you like to play Hangman? Y/N?");
        String play = user.next();

        if(play.toLowerCase().equals("y")){
            boolean playing = true;
            sendToServer.print("PLAY");
            String word;
            System.out.println("Playing from client");
          //  while(playing) {
                word = fromServer.next();
                System.out.print(word);

           // }

        } else if(play.toLowerCase().equals("n")) {
            System.out.println("Okay... Bye!");
        } else {
            System.out.println("LOL you funny... Bye!");
        }
    }
}
