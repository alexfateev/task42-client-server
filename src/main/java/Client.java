import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8089;

        Scanner scanner = new Scanner(System.in);

        try (Socket client = new Socket(host, port);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {
            out.println("This is out text");
            String resp = in.readLine();
            System.out.println(resp);
            String name = scanner.nextLine();
            out.println(name);
            resp = in.readLine();
            System.out.println(resp);
            String child = scanner.nextLine();
            out.println(child);
            resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
