package 计算机网络课程设计.hw1_arp;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午3:19
 */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class ARPDiscovery {
    public static void main(String[] args) {
        try {
            // 获取本地网络接口
            NetworkInterface networkInterface = NetworkInterface.getByName("eth0"); // 请根据实际情况修改网卡名称

            // 获取所有可用的网络接口
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            // 遍历所有网络接口
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface currentInterface = networkInterfaces.nextElement();

                // 获取当前网络接口的所有IP地址
                Enumeration<InetAddress> inetAddresses = currentInterface.getInetAddresses();

                // 遍历所有IP地址
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();

                    // 构造ARP请求数据帧
                    byte[] arpRequest = constructARPRequest(inetAddress);

                    // 发送ARP请求数据帧
                    sendARPRequest(arpRequest, currentInterface);

                    // 接收并解析目的主机的响应数据帧
                    byte[] arpResponse = receiveARPResponse();

                    // 解析响应数据帧并显示IP地址和MAC地址的对应关系
                    if (arpResponse != null) {
                        parseARPResponse(arpResponse);
                    }
                }
            }
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static byte[] constructARPRequest(InetAddress targetIP) throws UnknownHostException {
        // 构造ARP请求数据帧的逻辑
        // ...
        return null; // 返回构造好的ARP请求数据帧
    }

    private static void sendARPRequest(byte[] arpRequest, NetworkInterface networkInterface) {
        // 发送ARP请求数据帧的逻辑
        // ...
    }

    private static byte[] receiveARPResponse() {
        // 接收并解析目的主机的响应数据帧的逻辑
        // ...
        return null; // 返回解析好的响应数据帧
    }

    private static void parseARPResponse(byte[] arpResponse) {
        // 解析响应数据帧并显示IP地址和MAC地址的对应关系的逻辑
        // ...
    }
}

