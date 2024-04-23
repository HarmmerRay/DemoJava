package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/22 下午9:46
 */
public class UdpClient {
    public static void main(String[] args) {
        // 目标主机和端口号
        String host = "127.0.0.1";
        int port = 8888;

        try {
            // 创建DatagramSocket对象
            DatagramSocket socket = new DatagramSocket();

            // 准备发送的数据
            String message = "Hello, UDP!";
            byte[] sendData = message.getBytes();

            // 创建DatagramPacket对象，指定目标主机和端口号
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, port);

            // 发送数据报文
            socket.send(packet);

            System.out.println("Sent message: " + message);

            // 关闭socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
