package hr.vgsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccessPointMonitor {
    public static void main( String[] args ) throws InterruptedException {
        if (args.length != 1) {
            System.err.println(
                "Usage: java -jar access-point-monitor <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        final Connection connection = new Connection(portNumber);

        try {
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Connection established on port: " + portNumber);
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                System.out.println("Sending line: " + userInput);
                connection.sendMessage(userInput);
            }
        } catch (IOException e) {
            System.out.println("Error in system input");
        }
    }
}
