package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/27 下午2:09
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6666);

        String info = "hello ,我是客户端! ";

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(info.getBytes());


        socket.close();
    }
}
