package javatwo.homeworksix;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static List<Socket> socketsList = new ArrayList();

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Сервер запущен.");
        executor.submit(()-> {
            while (true) {
                Socket socket = serverSocket.accept();
                socketsList.add(socket);
                System.out.print("\rНовый пользователь вошел в чат.\nВведите сообщение: ");
                executor.submit(() -> {
                    try {
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        while (true) {
                            String message = in.readUTF();
                            if(message.equalsIgnoreCase("/exit")){
                                socketsList.remove(socket);
                                in.close();
                                socket.close();
                                System.out.print("\rПользователь вышел из чата.\nВведите сообщение: ");
                                return;
                            }
                            System.out.print(message + "\nВведите сообщение: ");
                            for (Socket send : socketsList) {
                                DataOutputStream out = new DataOutputStream(send.getOutputStream());
                                out.writeUTF(message + "\nВведите сообщение: ");
                            }
                        }
                    } catch (Exception e) {

                    }
                });
            }
        });
        while(true){
            Scanner readInput = new Scanner(System.in);
            System.out.print("Введите сообщение: ");
            String message = readInput.nextLine();
            if(message.equalsIgnoreCase("/exit")){
                for (Socket send : socketsList) {
                    DataOutputStream out = new DataOutputStream(send.getOutputStream());
                    out.writeUTF("\nВы были отключены от чата.\n");
                    send.close();
                }
                socketsList.clear();
                System.out.println("Все пользователи отключены от чата.");
            }
            message = "\rАдминистратор: " + message;

            if(!socketsList.isEmpty()) {
                System.out.println(message);
                for (Socket send : socketsList) {
                    DataOutputStream out = new DataOutputStream(send.getOutputStream());
                    out.writeUTF(message + "\nВведите сообщение: ");
                }
            } else {
                System.out.println("В чате никого нет.");
            }
        }
    }
}

