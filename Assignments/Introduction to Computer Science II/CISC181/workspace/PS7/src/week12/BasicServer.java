package week12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BasicServer implements Runnable {

    private List<String> answers = Arrays.asList("math", "Target","mountain","cake");
    
    private Set<String> allConnections = new HashSet<String>();
    
    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("BasicServer, port 5000 running on " + address.getHostAddress());
            
            ServerSocket serverSocket = new ServerSocket(5000);
            BufferedWriter output = new BufferedWriter(new FileWriter("./connections.txt", true));
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    String host = socket.getInetAddress().getHostAddress();
                    if (allConnections.add(host)) {
                        // it is new, write it to file
                        output.write(host);
                        output.newLine();
                        output.flush();
                    }
                    System.out.println(host);
                    StringBuilder sb = new StringBuilder();
                    for (String connection : allConnections) {
                        sb.append(connection).append('\n');
                    }
    
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(answers);
                    out.writeObject(sb.toString());
                    socket.close();
                }
            }
            finally {
                serverSocket.close();
                output.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    private void parseConnections(Scanner input, Set<String> connections) {
        while (input.hasNext()) {
            connections.add(input.next());
        }
    }

    public static void main(String[] args) {
        BasicServer server = new BasicServer();
        try {
            server.parseConnections(new Scanner(new File("./connections.txt")), server.allConnections);
        }
        catch (IOException e) {
            // ignore
        }
        
        server.run();
    }
}
