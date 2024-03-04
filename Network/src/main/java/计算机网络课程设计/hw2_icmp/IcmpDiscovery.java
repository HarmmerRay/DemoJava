package 计算机网络课程设计.hw2_icmp;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午11:36
 */
import java.io.IOException;
import java.net.*;

public class IcmpDiscovery {

    public static void main(String[] args) {
        // 替换为你的本地网络接口的名称
        String networkInterfaceName = "eth0";

        // 发送 ICMP 请求
        sendIcmpRequest(networkInterfaceName);

        // 接收 ICMP 响应并显示活动主机
        receiveIcmpResponse();
    }

    private static void sendIcmpRequest(String networkInterfaceName) {
        try {
            // 获取本地网络接口
            NetworkInterface networkInterface = NetworkInterface.getByName(networkInterfaceName);

            // 构造 ICMP 请求数据报
            byte[] icmpRequestData = new byte[]{8, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

            // 创建 ICMP Socket
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);

            // 构造 ICMP 请求报文
            DatagramPacket icmpRequestPacket = new DatagramPacket(icmpRequestData, icmpRequestData.length,
                    InetAddress.getByName("255.255.255.255"), 0);
            socket.send(icmpRequestPacket);

            // 关闭 Socket
            socket.close();

            System.out.println("ICMP request sent.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveIcmpResponse() {
        try {
            // 创建 ICMP Socket
            DatagramSocket socket = new DatagramSocket(0);

            // 设置超时时间为5秒
            socket.setSoTimeout(5000);

            byte[] buffer = new byte[1024];

            // 接收 ICMP 响应报文
            while (true) {
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                // 解析 ICMP 响应报文
                InetAddress sourceAddress = responsePacket.getAddress();
                System.out.println("Active host discovered: " + sourceAddress.getHostAddress());
            }
        } catch (IOException e) {
            // 超时或其他异常，可以处理
            System.out.println("ICMP response received.");
        }
    }
}

