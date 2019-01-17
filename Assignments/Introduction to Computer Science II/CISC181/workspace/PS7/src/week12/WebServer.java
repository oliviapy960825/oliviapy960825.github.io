package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer implements Runnable {
    private String[] RANDOM_IMAGES = {
                                      "http://3.bp.blogspot.com/_ALANjQ51Ft4/S4gIt6GRZAI/AAAAAAAAAAo/sLHDJhseYw8/s400/1.gif",
                                      "https://lh3.googleusercontent.com/_kA-LcX9uNiA/TWV9uNGlpVI/AAAAAAAAEBI/C9pzSySCjLM/seuss1.gif",
                                      "http://chiwowwow.com/WEBLOG/wp-content/uploads/2009/03/dr_seuss_thing1_thing2_plaque.jpg",
                                      "http://3.bp.blogspot.com/_aTXKKXTpXmY/TR51tWZtxKI/AAAAAAAAAig/pFpNFhkV9Ec/s320/dr%2Bseuss%2Bone%2Bfish%2Btwo%2Bfish.gif" };

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("WebServer, port 8080 running on " + address.getHostAddress());

            ServerSocket serverSocket = new ServerSocket(8080);
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Received connection from: " + socket.getInetAddress().getHostAddress());
    
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
    
                    String str;
                    while ((str = in.readLine()) != null) {
                        if (str.startsWith("GET")) {
                            String[] parsed = str.split(" ");
                            // what did they want to get?
    
                            // oh yeah, they wanted one of our random images
                            out.println("HTTP/1.0 200 OK");
                            out.println("Content-Type: text/html");
                            out.println("Server: It is a secret");
                            out.println("");
                            out.println("<html>");
                            out.println("Of course we have a " + parsed[1].substring(1) + "!  Here you go:");
                            out.println("<br><img src=\"" + RANDOM_IMAGES[(int) (Math.random() * RANDOM_IMAGES.length)]
                                        + "\"/>");
                            out.println("</html>");
                            out.flush();
                            break;
                        }
    
                    }
    
                    socket.close();
                }
            }
            finally {
                serverSocket.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WebServer().run();
    }
}
