package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/27 下午2:09
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);

        Socket socket = serverSocket.accept();
        byte []buffer = new byte[1024];

        InputStream inputStream = socket.getInputStream();
        int readCount;
        while ((readCount = inputStream.read(buffer)) > 0){
            System.out.println(new String(buffer,0,readCount));
        }
    }
}
