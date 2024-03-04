//package 计算机网络课程设计;
//
///**
// * @description:
// * @author: HammerRay
// * @date: 2024/1/1 下午7:46
// */
//import jpcap.*;
//import jpcap.packet.*;
//
//public class ARPSender {
//    public static void main(String[] args) {
//        try {
//            NetworkInterface[] devices = JpcapCaptor.getDeviceList();
//
//            // Choose a network interface (you may need to change the index)
//            NetworkInterface device = devices[0];
//
//            // Open a JpcapSender
//            JpcapSender sender = JpcapSender.openDevice(device);
//
//            // Construct ARP packet
//            ARPPacket arpPacket = new ARPPacket();
//            arpPacket.hardtype = ARPPacket.HARDTYPE_ETHER;
//            arpPacket.prototype = ARPPacket.PROTOTYPE_IP;
//            arpPacket.operation = ARPPacket.ARP_REQUEST;
//            arpPacket.hlen = 6;
//            arpPacket.plen = 4;
//
//            // Set source and target MAC addresses
//            arpPacket.sender_hardaddr = new byte[]{0x00, 0x11, 0x22, 0x33, 0x44, 0x55}; // replace with your MAC address
//            arpPacket.sender_protoaddr = new byte[]{192, 168, 1, 1}; // replace with your IP address
//            arpPacket.target_hardaddr = new byte[]{(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff}; // broadcast
//            arpPacket.target_protoaddr = IPAddress.valueOf("www.baidu.com").getAddress(); // replace with the target IP address
//
//            // Create an Ethernet packet to encapsulate the ARP packet
//            EthernetPacket etherPacket = new EthernetPacket();
//            etherPacket.frametype = EthernetPacket.ETHERTYPE_ARP;
//            etherPacket.src_mac = arpPacket.sender_hardaddr;
//            etherPacket.dst_mac = arpPacket.target_hardaddr;
//
//            // Assemble the packet
//            Packet packet = new Packet();
//            packet.data = arpPacket;
//            packet.datalink = etherPacket;
//
//            // Send the packet
//            sender.sendPacket(packet);
//
//            // Close the sender
//            sender.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
