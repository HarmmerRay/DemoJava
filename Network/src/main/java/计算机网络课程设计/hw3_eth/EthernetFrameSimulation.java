package 计算机网络课程设计.hw3_eth;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午10:31
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class EthernetFrameSimulation {

    public static void main(String[] args) {
        // Simulate Ethernet frame sending
        simulateEthernetFrameSending();

        // Simulate Ethernet frame receiving and parsing
        simulateEthernetFrameReceivingAndParsing();
    }

    private static void simulateEthernetFrameSending() {
        try {
            // Simulate sending an Ethernet frame
            byte[] frameData = constructEthernetFrame("Hello, Ethernet!");
            sendEthernetFrame(frameData);

            System.out.println("Ethernet frame sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void simulateEthernetFrameReceivingAndParsing() {
        try {
            // Simulate receiving and parsing an Ethernet frame
            byte[] receivedFrame = receiveEthernetFrame();
            parseEthernetFrame(receivedFrame);

            System.out.println("Ethernet frame received and parsed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] constructEthernetFrame(String message) {
        // Simulate constructing an Ethernet frame
        // For simplicity, we are using the message as the payload
        byte[] payload = message.getBytes();

        // Simulate Ethernet frame structure: [Destination MAC] + [Source MAC] + [Type] + [Payload]
        byte[] frame = new byte[12 + payload.length];

        // Set Destination MAC address (6 bytes)
        // For simulation purposes, use a placeholder MAC address
        frame[0] = 0x00;
        frame[1] = 0x11;
        frame[2] = 0x22;
        frame[3] = 0x33;
        frame[4] = 0x44;
        frame[5] = 0x55;

        // Set Source MAC address (6 bytes)
        // For simulation purposes, use another placeholder MAC address
        frame[6] = (byte) 0xAA;
        frame[7] = (byte) 0xBB;
        frame[8] = (byte) 0xCC;
        frame[9] = (byte) 0xDD;
        frame[10] = (byte) 0xEE;
        frame[11] = (byte) 0xFF;

        // Set Type field (2 bytes) - For simplicity, use a placeholder type (e.g., 0x0800 for IP)
        frame[12] = 0x08;
        frame[13] = 0x00;

        // Copy payload into the frame
        System.arraycopy(payload, 0, frame, 14, payload.length);

        return frame;
    }

    private static void sendEthernetFrame(byte[] frameData) throws Exception {
        // Simulate sending the Ethernet frame over the network
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(frameData, frameData.length,
                InetAddress.getByName("localhost"), 12345);
        socket.send(packet);
        socket.close();
    }

    private static byte[] receiveEthernetFrame() throws Exception {
        // Simulate receiving an Ethernet frame from the network
        DatagramSocket socket = new DatagramSocket(12345);
        byte[] buffer = new byte[1500]; // Assuming maximum Ethernet frame size
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        socket.close();

        // Return the received frame data
        return packet.getData();
    }

    private static void parseEthernetFrame(byte[] frameData) {
        // Simulate parsing the received Ethernet frame
        // Extract information such as Destination MAC, Source MAC, Type, and Payload
        // For simplicity, we are printing the contents of the frame
        System.out.println("Received Ethernet Frame:");
        System.out.println("Destination MAC: " + getMacAddress(frameData, 0));
        System.out.println("Source MAC: " + getMacAddress(frameData, 6));
        System.out.println("Type: " + getType(frameData, 12));
        System.out.println("Payload: " + new String(Arrays.copyOfRange(frameData, 14, frameData.length)));
    }

    private static String getMacAddress(byte[] frameData, int startIndex) {
        // Extract and format MAC address from the frame
        StringBuilder macAddress = new StringBuilder();
        for (int i = startIndex; i < startIndex + 6; i++) {
            macAddress.append(String.format("%02X", frameData[i]));
            if (i < startIndex + 5) {
                macAddress.append(":");
            }
        }
        return macAddress.toString();
    }

    private static String getType(byte[] frameData, int startIndex) {
        // Extract and format the Type field from the frame
        return String.format("%02X%02X", frameData[startIndex], frameData[startIndex + 1]);
    }
}

