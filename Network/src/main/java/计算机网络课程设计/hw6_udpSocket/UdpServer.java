package 计算机网络课程设计.hw6_udpSocket;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午11:32
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) {
        try {
            // 创建DatagramSocket并绑定端口
            DatagramSocket serverSocket = new DatagramSocket(12345);

            System.out.println("Server started. Waiting for data...");

            // 创建数据包用于接收数据
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            while (true) {
                // 接收数据
                serverSocket.receive(receivePacket);

                // 处理接收到的数据
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received data from " + receivePacket.getAddress().getHostAddress() + ": " + receivedMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
