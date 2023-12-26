package ru.jucharick.Client_Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer(){
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Подключен новый клиент!");
                ClientManager client = new ClientManager(socket);
                Thread thread = new Thread(client);
                thread.start();
            }
        } catch (IOException e) {
            closedSocket();
        }
    }

    public void closedSocket(){
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1300);
        Server server = new Server(serverSocket);
        server.runServer();
    }

}
