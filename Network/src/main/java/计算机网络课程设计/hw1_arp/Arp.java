package 计算机网络课程设计.hw1_arp;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午2:58
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Arp {
    public static void main(String[] args) {
        try {
            // 创建一个DatagramSocket实例，用于发送和接收数据包
            DatagramSocket socket = new DatagramSocket();
            // 创建一个数据包
            // ARP请求数据包大小通常为35字节
            byte[] buffer = new byte[35];
            // 广播地址和任意端口
            DatagramPacket request = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), 9999);
            // 发送ARP请求
            socket.send(request);
            // 设置超时时间为1秒
            socket.setSoTimeout(1000);
            // 接收ARP响应
            DatagramPacket response = new DatagramPacket(buffer, buffer.length,InetAddress.getByName("255.255.255.255"), 9999);
            // 接收ARP响应数据包
            socket.receive(response);

            // 解析ARP响应数据包，获取IP地址和MAC地址的对应关系
            // 获取IP地址
            String ipAddress = response.getAddress().getHostAddress();
            // 获取MAC地址
            byte[] macAddress = response.getData();
            System.out.println("IP Address: " + ipAddress);
            // 将字节数组转换为十六进制字符串表示
            System.out.println("MAC Address: " + bytesToHex(macAddress));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}

