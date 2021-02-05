package hr.vgsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class AccessPointDisplay {
    public static void main( String[] args ) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar access-point-display <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        System.out.println( "Started listening on port: " +  portNumber);
        try (
            ServerSocket serverSocket =
                new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println( "Connection established on port: " +  portNumber);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
