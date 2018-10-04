package testSystem;

import java.io.IOException;
import java.util.Scanner;

import SourceComponent.ChatResponseHandler;
import SourceComponent.Client;
public class AppClient {
    public static void main(String[] args) {
        try {
            Client client = new Client("Client", "localhost",9999, new ChatResponseHandler() {
                @Override
                public void onMessage(String message) {
                    System.out.println("Server tra ve: " + message);
                }
            });

            client.start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Client gui len server day so la : ");
                String msg = scanner.nextLine();
                client.sendMessage(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
