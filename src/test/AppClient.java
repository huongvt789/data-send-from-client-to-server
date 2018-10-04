package test;

import component.ChatResponseHandler;
import component.Client;
import java.io.IOException;
import java.util.Scanner;
public class AppClient {
    public static void main(String[] args) {
        try {
            Client client = new Client("Client", "localhost",9999, new ChatResponseHandler() {
                @Override
                public void onMessage(String message) {
                    System.out.println("Server response: " + message);
                }
            });

            client.start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter message : ");
                String msg = scanner.nextLine();
                client.sendMessage(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
