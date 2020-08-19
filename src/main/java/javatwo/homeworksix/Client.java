package javatwo.homeworksix;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 9999);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner readInput = new Scanner(System.in);
        System.out.print("Введите ваш ник: ");
        String nickname = readInput.nextLine();
        new Thread(()->{
            while(true) {
                System.out.print("Введите сообщение: ");
                String message = readInput.nextLine();
                if(message.equalsIgnoreCase("/exit")){
                    try {
                        out.writeUTF(message);
                        in.close();
                        out.close();
                        socket.close();
                        System.out.println("Вы отключились от чата.");
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    out.writeUTF("\r" + nickname + ": " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while(true){
            try {
                String message = in.readUTF();
                System.out.print(message);
            } catch (IOException e){

            }
        }
    }
}
