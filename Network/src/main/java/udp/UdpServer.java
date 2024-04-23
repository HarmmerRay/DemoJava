package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/22 下午9:47
 */
public class UdpServer {
    public static void main(String[] args) {
        // 监听的端口号
        int port = 8888;

        try {
            // 创建DatagramSocket对象，并绑定到指定的端口
            DatagramSocket socket = new DatagramSocket(port);

            // 准备用于接收数据的字节数组
            byte[] receiveData = new byte[1024];

            // 创建DatagramPacket对象，用于接收数据
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // 接收数据报文
            socket.receive(receivePacket);

            // 从接收的数据包中提取数据
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // 打印接收到的消息
            System.out.println("Received message: " + message);

            // 关闭socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
