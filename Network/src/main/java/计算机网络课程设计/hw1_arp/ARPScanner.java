package 计算机网络课程设计.hw1_arp;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午3:20
 */

import java.io.IOException;
import java.net.*;

public class ARPScanner {

    public static void main(String[] args) throws SocketException, UnknownHostException {
        try {
            // 目标IP地址 百度
            String targetIP = "39.156.66.10";
            // 发送方IP地址  我当时连接手机热点给自动分配的地址 在wlp5s0网卡上
            String senderIP = "192.168.106.143";
            // 发送方MAC地址
            NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] mac = network.getHardwareAddress();

            // 构造并发送ARP请求帧
            byte[] arpRequest = buildArpRequest(senderIP, mac, targetIP);
            int m = 1;
            for (byte t : arpRequest) {
                System.out.print(t + " ");
                if (m == 16) {
                    System.out.println();
                }
                if (m == 8 || m == 24) {
                    System.out.print("***  ");
                }

                m++;
            }
            sendARPPacket(arpRequest, targetIP);

            // 等待响应并解析
            byte[] arpResponse = receiveARPPacket();


            if (arpResponse != null) {
                // 从frame数组中读取发送方MAC地址
                byte[] senderMACBytes = new byte[6];
                for (int i = 22; i < 28; i++) {
                    senderMACBytes[i - 22] = arpResponse[i];
                }
                String senderMACAddress = byteArrayToMACAddress(senderMACBytes);
                System.out.println("Sender MAC Address: " + senderMACAddress);

                // 从frame数组中读取发送方IP地址
                byte[] senderIPBytes = new byte[4];
                for (int i = 28; i < 32; i++) {
                    senderIPBytes[i - 28] = arpResponse[i];
                }
                String senderIPAddress = byteArrayToIPAddress(senderIPBytes);
                System.out.println("Sender IP Address: " + senderIPAddress);

            } else {
                System.out.println("未收到响应");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 辅助方法，将字节数组转换为MAC地址字符串
     */
    private static String byteArrayToMACAddress(byte[] macBytes) {
        StringBuilder macAddress = new StringBuilder();
        for (byte b : macBytes) {
            macAddress.append(String.format("%02X", b));
            macAddress.append(":");
        }
        // 移除最后一个冒号
        macAddress.deleteCharAt(macAddress.length() - 1);
        return macAddress.toString();
    }

    /**
     * 辅助方法，将字节数组转换为IP地址字符串
     */
    private static String byteArrayToIPAddress(byte[] ipBytes) {
        StringBuilder ipAddress = new StringBuilder();
        for (byte b : ipBytes) {
            ipAddress.append(b & 0xFF).append(".");
        }
        // 移除最后一个点
        ipAddress.deleteCharAt(ipAddress.length() - 1);
        return ipAddress.toString();
    }


    private static byte[] buildArpRequest(String senderIp, byte[] mac, String targetIp) throws SocketException, UnknownHostException {
        // ARP请求数据帧的长度通常是28字节
        byte[] frame = new byte[28];
//        Hardware type: Ethernet (1)  2字节
        frame[0] = 0x00;
        frame[1] = 0x01;
//        Protocol type: IPV4 (0X0800) 2字节
        frame[2] = 0x08;
        frame[3] = 0x00;
//        Hardware size: 6  1byte
        frame[4] = 0x06;
//        Protocol size: 4  1byte
        frame[5] = 0x04;
//        opcode: request (1) 2byte
        frame[6] = 0x00;
        frame[7] = 0x01;

//        SENDER MAC ADDRESS: 8A:70:65:C2:51:4 (8A:70:65:C2:51:4b) 6byte
        frame[8] = mac[0];
        frame[9] = mac[1];
        frame[10] = mac[2];
        frame[11] = mac[3];
        frame[12] = mac[4];
        frame[13] = mac[5];
//        Sender IP address: 192.168.106.143 4 byte
        String[] re1 = senderIp.split("\\.");
        int tmp1 = 14;
        for (String t : re1) {
            System.out.println(Integer.valueOf(t));
            frame[tmp1++] = Integer.valueOf(t).byteValue();
        }
//        TARGET MAC ADDRESS: XEROX Q0:00:00 (O0:00:00:00:00:00) 6byte
        frame[18] = 0x00;
        frame[19] = 0x00;
        frame[20] = 0x00;
        frame[21] = 0x00;
        frame[22] = 0x00;
        frame[23] = 0x00;
//        TARGET IP ADDRESS: 39.156.66.10（百度） 4byte
        String[] re = targetIp.split("\\.");
        int tmp = 24;
        for (String t : re) {
            frame[tmp++] = Integer.valueOf(t).byteValue();
        }
        return frame;
    }


    private static void sendARPPacket(byte[] arpPacket, String targetIp) throws IOException {

        DatagramSocket socket = new DatagramSocket(13889);
        //端口为零表示不关心端口
        DatagramPacket datagramPacket = new DatagramPacket(arpPacket, arpPacket.length, InetAddress.getByName(targetIp), 0);
        socket.send(datagramPacket);
        System.out.println("ARP请求已发送");

    }

    private static byte[] receiveARPPacket() throws IOException {
        int port = 13888;
        // 创建DatagramSocket并绑定到指定端口
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("等待接收ARP请求...");

        // 创建用于接收数据的缓冲区
        // ARP请求数据帧的长度通常是28字节
        byte[] buffer = new byte[28];

        // 创建DatagramPacket用于接收数据
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 接收数据
        socket.receive(packet);

        System.out.println("接收到ARP请求");

        return buffer;
    }

}


