package 计算机网络课程设计.hw5_tcpSocket;


import java.io.*;
import java.net.Socket;
import java.nio.BufferUnderflowException;
import java.util.Scanner;
/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午11:30
 */
public class Client {

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 12345;

        try {
            // 创建客户端套接字
            Socket clientSocket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server at " + clientSocket.getInetAddress());

            OutputStream outputStream = clientSocket.getOutputStream();
            InputStream inputStream = clientSocket.getInputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // 发送消息给服务器
            for (int i = 0; i < 2; i++) {
            String message = "hello server!";

            writer.write(message);
            writer.flush();
            System.out.println("Sent message to server: " + message);

            byte[] buffer = new byte[1024];

                int bytesRead = inputStream.read(buffer);
                if(bytesRead == -1){
                    throw new RuntimeException("没有收到服务器的响应");
                }
                String serverResponse = new String(buffer, 0, bytesRead);
                System.out.println("Server response: " + serverResponse);
            }


            // 关闭连接
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
