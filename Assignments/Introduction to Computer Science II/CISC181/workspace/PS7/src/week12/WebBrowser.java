package week12;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class WebBrowser implements Runnable {
    public static final String PAGE = "/";
    public static final String SERVER = "www.unixtimestamp.com";
    
    @Override
    public void run() {
        try {
            Socket socket = new Socket(InetAddress.getByName(SERVER), 80);
            OutputStream out = socket.getOutputStream();
            Scanner in = new Scanner(socket.getInputStream());
            in.useDelimiter(">");
            out.write(("GET " + PAGE + " HTTP/1.1\r\nHost: " + SERVER + "\r\n\r\n").getBytes());
            out.flush();
            
            
            while (in.hasNext()) {
                String txt = in.next();
                System.out.print(txt+">");
                if (txt.endsWith("</html")) {
                    break;
                }
            }
            in.close();
            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new WebBrowser().run();
    }
    
}
