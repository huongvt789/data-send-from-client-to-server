package test;
import component.Server;
import java.io.IOException;
public class AppServer {
    public static void main(String[] args) {
        try {
            Server server = new Server("Server", 9999);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
