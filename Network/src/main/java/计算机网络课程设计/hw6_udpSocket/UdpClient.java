package 计算机网络课程设计.hw6_udpSocket;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午11:32
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) {
        try {
            // 创建DatagramSocket
            DatagramSocket clientSocket = new DatagramSocket();

            // 服务器地址和端口
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            int serverPort = 12345;

            // 要发送的数据
            String data = "Hello, server!";
            byte[] sendData = data.getBytes();

            // 创建数据包
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

            // 发送数据
            clientSocket.send(sendPacket);
            System.out.println("Data sent to server: " + data);

            // 关闭Socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
