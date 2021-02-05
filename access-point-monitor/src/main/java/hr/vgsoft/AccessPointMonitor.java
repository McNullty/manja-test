package hr.vgsoft;

import java.io.IOException;

public class AccessPointMonitor {
    public static void main( String[] args ) throws InterruptedException, IOException {
        if (args.length != 2) {
            System.err.println(
                "Usage: java -jar access-point-monitor <port number> <path to file>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        String filePath = args[1];

        final Connection connection = new Connection(portNumber);
        System.out.println("Connection established on port: " + portNumber);

        final FileMonitor fileMonitor = new FileMonitor(filePath);

        final AccessPointFileParser accessPointFileParser = new AccessPointFileParser(filePath);
        AccessPoints oldAccessPoints = accessPointFileParser.getData();
        while(fileMonitor.monitor()) {
            AccessPoints newAccessPoints = accessPointFileParser.getData();

            for (String message : CompareAccessLists.compare(oldAccessPoints, newAccessPoints)) {
                connection.sendMessage(message);
            }
            
            oldAccessPoints = newAccessPoints;
        }
    }
}
