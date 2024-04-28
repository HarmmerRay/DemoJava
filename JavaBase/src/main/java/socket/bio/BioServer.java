package socket.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 一个客户端连接分配一个线程去处理，处理完这个连接线程才释放。
 * @author: HammerRay
 * @date: 2024/4/27 下午2:27
 */
public class BioServer implements Runnable{
    private Socket socket;
    public BioServer(Socket socket){
        this.socket = socket;
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Bio服务器已经启动，等待连接~~~~");
        while (true){
            new Thread(new BioServer(serverSocket.accept())).start();
        }

    }

    @Override
    public void run() {
        System.out.print("当前的进程ID是：" + Thread.currentThread().getId());
        System.out.println(",我正在处理来自本地，端口：" + socket.getPort() + "的连接请求");
        try{
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream
            Thread.sleep(1000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("谢谢惠顾，欢迎下次光临！".getBytes());
            socket.close();
            System.out.println("处理完毕，连接断开");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
