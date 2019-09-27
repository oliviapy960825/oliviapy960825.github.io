package week12;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BasicClient implements Runnable {
    @Override
    public void run() {
        Socket socket = new Socket();
        try {
          // connect to 10.0.0.3, will need to change this to the address of the server
          socket.connect(new InetSocketAddress("128.4.103.155", 5000), 4000); // 4 second timeout
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          Object o = in.readObject();
          System.out.println(o);
          System.out.println(in.readObject());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            }
            catch (IOException e) {
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        new BasicClient().run();
    }

}
