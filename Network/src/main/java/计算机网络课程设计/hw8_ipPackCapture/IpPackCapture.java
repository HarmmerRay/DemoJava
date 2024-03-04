package 计算机网络课程设计.hw8_ipPackCapture;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午11:34
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class IpPackCapture {

    public static void main(String[] args) {
        try {
            // 创建DatagramSocket并绑定到任意可用端口
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);

            System.out.println("Listening for IP packets...");

            // 接收数据包
            while (true) {
                byte[] buffer = new byte[1500]; // 最大IP数据包大小
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // 获取源IP和目标IP
                InetAddress sourceIp = packet.getAddress();
                InetAddress destinationIp = InetAddress.getLocalHost(); // 本机IP

                // 进行IP地址合法性检查
                if (isValidIpAddress(sourceIp.getHostAddress()) && isValidIpAddress(destinationIp.getHostAddress())) {
                    // 统计IP数据包信息
                    System.out.println("Source IP: " + sourceIp.getHostAddress());
                    System.out.println("Destination IP: " + destinationIp.getHostAddress());
                    System.out.println("------------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidIpAddress(String ipAddress) {
        // 实际中可能需要更复杂的IP地址合法性检查
        return ipAddress.matches("\\d+\\.\\d+\\.\\d+\\.\\d+");
    }
}

