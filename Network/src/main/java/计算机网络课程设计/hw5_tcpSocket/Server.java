package 计算机网络课程设计.hw5_tcpSocket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午11:30
 */
public class Server {

    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        int port = 12345;

        ThreadFactory threadFactory =new CustomThreadFactory("ServerThread-");
        try {

            ExecutorService executorService = new ThreadPoolExecutor(THREAD_POOL_SIZE,
                                                                    THREAD_POOL_SIZE,
                                                                    0L,
                                                                    TimeUnit.MILLISECONDS,
                                                                    new ArrayBlockingQueue<>(THREAD_POOL_SIZE, true),threadFactory);
            // 创建服务器套接字
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            // 等待客户端连接
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());
                executorService.submit(() -> {
                    try {
                        handlerConnection(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handlerConnection(Socket clientSocket) throws IOException {
        // 向客户端返回消息
        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        // 接收客户端消息
        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        byte[] buffer = new byte[1024];
        for (int i = 0; i < 2; i++) {
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            //String message = read.readLine(); TODO 为什么这个就阻塞在了这里？
            System.out.println("Received message from client: " + message);
            writer.write("Hello client,I've received your message: " + message);
            writer.flush();
        }

        // 关闭连接
        clientSocket.close();
    }

    static class CustomThreadFactory implements ThreadFactory {
        private final String threadNamePrefix;

        public CustomThreadFactory(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, threadNamePrefix + Thread.currentThread().getId());
        }
    }

}

