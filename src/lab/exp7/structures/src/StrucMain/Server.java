/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package StrucMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import javax.swing.JTextArea;


/**
 *
 * @author abhiramj
 */
public class Server {
    public String host;
    public int port = 2000;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;
    static stateHandler st;
    Server( String host){
    this.host=host;
    }
    boolean initConn(){
    return false;
    }
    boolean  communicate(String input) throws IOException{


        try {

    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("Listening on port: "+port);
    clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            st=new stateHandler();
        } catch (Exception e) {
            System.out.println("Accept failed.");
        }
    st.state=1;
   // return true;
} catch (Exception e) {
    Random r1 =new Random();
    int newport= r1.nextInt(40000);
    System.out.println("Could not listen on port: "+ port);
    port = newport;
    return false;
}


        String inputLine;
//st.input = st.processInput(input);
out.println(st.input);

while ((inputLine = in.readLine()) != null) {
    System.out.println(inputLine);
    st.reply = st.processInput(inputLine);

    out.println(st.reply);
    if (inputLine.equals("Bye."))
        break;

    }
return true;
    }
}
