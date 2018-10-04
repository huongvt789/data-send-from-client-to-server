package testSystem;
import java.io.IOException;

import SourceComponent.Server;
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
