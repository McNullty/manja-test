package hr.vgsoft;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
  private PrintWriter out;
  private Socket echoSocket;

  public Connection(int portNumber) throws InterruptedException {
    final String hostName = "localhost";

    System.out.println("Connecting to port: " +  portNumber);

    Boolean connecting = Boolean.TRUE;
    while (connecting) {
      try {
        echoSocket = new Socket(hostName, portNumber);
        out =
            new PrintWriter(echoSocket.getOutputStream(), true);
        connecting =  Boolean.FALSE;
      } catch (UnknownHostException e) {
        System.err.println("Don't know about host " + hostName);
        System.exit(1);
      } catch (IOException e) {
        System.out.println("Couldn't get I/O for the connection to " +
            hostName);
        System.out.println("Waiting for connection...");
        Thread.sleep(2000);
      }
    }
  }

  public void sendMessage(String message) {
    out.println(message);
  }

}
