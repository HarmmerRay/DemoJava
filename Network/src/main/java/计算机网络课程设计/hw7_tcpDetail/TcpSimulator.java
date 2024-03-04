package 计算机网络课程设计.hw7_tcpDetail;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午11:31
 */
public class TcpSimulator {
    private int serverSequenceNumber = 1000;
    private int clientSequenceNumber = 500;
    private final int win = 512;
    private int clientAck = 1;
    private int serverAck = 1;
    private int clientSeq = 1;
    private int serverSeq = 1;
    /**
     * nmj@lenovo:~$ sudo tcpdump -i lo port 15888
     * tcpdump: verbose output suppressed, use -v or -vv for full protocol decode
     * listening on lo, link-type EN10MB (Ethernet), capture size 262144 bytes
     * 11:12:39.492658 IP localhost.59158 > localhost.15888: Flags [S], seq 55317437, win 65495, options [mss 65495,sackOK,TS val 1192975044 ecr 0,nop,wscale 7], length 0
     * 11:12:39.492675 IP localhost.15888 > localhost.59158: Flags [S.], seq 292555204, ack 55317438, win 65483, options [mss 65495,sackOK,TS val 1192975044 ecr 1192975044,nop,wscale 7], length 0
     * 11:12:39.492689 IP localhost.59158 > localhost.15888: Flags [.], ack 1, win 512, options [nop,nop,TS val 1192975044 ecr 1192975044], length 0
     * <p>
     * 11:12:39.493481 IP localhost.59158 > localhost.15888: Flags [P.], seq 1:13, ack 1, win 512, options [nop,nop,TS val 1192975045 ecr 1192975044], length 12
     * 11:12:39.493496 IP localhost.15888 > localhost.59158: Flags [.], ack 13, win 512, options [nop,nop,TS val 1192975045 ecr 1192975045], length 0
     * 11:12:39.493806 IP localhost.15888 > localhost.59158: Flags [P.], seq 1:14, ack 13, win 512, options [nop,nop,TS val 1192975045 ecr 1192975045], length 13
     * 11:12:39.493817 IP localhost.59158 > localhost.15888: Flags [.], ack 14, win 512, options [nop,nop,TS val 1192975045 ecr 1192975045], length 0
     * <p>
     * 11:12:39.808713 IP localhost.15888 > localhost.59158: Flags [F.], seq 14, ack 13, win 512, options [nop,nop,TS val 1192975360 ecr 1192975045], length 0
     * 11:12:39.809076 IP localhost.59158 > localhost.15888: Flags [F.], seq 13, ack 15, win 512, options [nop,nop,TS val 1192975360 ecr 1192975360], length 0
     * 11:12:39.809095 IP localhost.15888 > localhost.59158: Flags [.], ack 14, win 512, options [nop,nop,TS val 1192975360 ecr 1192975360], length 0
     * <p>
     * zy_@hasee:~$ sudo tcpdump -i lo port 12345
     * 请输入密码:
     * 验证成功
     * tcpdump: verbose output suppressed, use -v or -vv for full protocol decode
     * listening on lo, link-type EN10MB (Ethernet), capture size 262144 bytes
     * 14:13:20.502298 IP localhost.56978 > localhost.12345: Flags [S], seq 3625753926, win 65495, options [mss 65495,sackOK,TS val 224911351 ecr 0,nop,wscale 7], length 0
     * 14:13:20.502310 IP localhost.12345 > localhost.56978: Flags [S.], seq 4215557825, ack 3625753927, win 65483, options [mss 65495,sackOK,TS val 224911351 ecr 224911351,nop,wscale 7], length 0
     * 14:13:20.502317 IP localhost.56978 > localhost.12345: Flags [.], ack 1, win 512, options [nop,nop,TS val 224911351 ecr 224911351], length 0
     * <p>
     * 14:13:20.502949 IP localhost.56978 > localhost.12345: Flags [P.], seq 1:15, ack 1, win 512, options [nop,nop,TS val 224911351 ecr 224911351], length 14
     * 14:13:20.502955 IP localhost.12345 > localhost.56978: Flags [.], ack 15, win 512, options [nop,nop,TS val 224911351 ecr 224911351], length 0
     * <p>
     * 14:13:20.503111 IP localhost.56978 > localhost.12345: Flags [F.], seq 15, ack 1, win 512, options [nop,nop,TS val 224911351 ecr 224911351], length 0
     * 14:13:20.503202 IP localhost.12345 > localhost.56978: Flags [F.], seq 1, ack 16, win 512, options [nop,nop,TS val 224911352 ecr 224911351], length 0
     * 14:13:20.503213 IP localhost.56978 > localhost.12345: Flags [.], ack 2, win 512, options [nop,nop,TS val 224911352 ecr 224911352], length 0
     *
     * tcpdump: verbose output suppressed, use -v or -vv for full protocol decode
     * listening on lo, link-type EN10MB (Ethernet), capture size 262144 bytes
     * 14:35:05.739285 IP localhost.47658 > localhost.12345: Flags [S], seq 2935478672, win 65495, options [mss 65495,sackOK,TS val 274210075 ecr 0,nop,wscale 7], length 0
     * 14:35:05.739299 IP localhost.12345 > localhost.47658: Flags [S.], seq 1969033672, ack 2935478673, win 65483, options [mss 65495,sackOK,TS val 274210075 ecr 274210075,nop,wscale 7], length 0
     * 14:35:05.739310 IP localhost.47658 > localhost.12345: Flags [.], ack 1, win 512, options [nop,nop,TS val 274210075 ecr 274210075], length 0
     *
     * 14:35:05.740169 IP localhost.47658 > localhost.12345: Flags [P.], seq 1:14, ack 1, win 512, options [nop,nop,TS val 274210076 ecr 274210075], length 13
     * 14:35:05.740179 IP localhost.12345 > localhost.47658: Flags [.], ack 14, win 512, options [nop,nop,TS val 274210076 ecr 274210076], length 0
     *
     * 14:35:05.740312 IP localhost.47658 > localhost.12345: Flags [P.], seq 14:27, ack 1, win 512, options [nop,nop,TS val 274210076 ecr 274210076], length 13
     * 14:35:05.740318 IP localhost.12345 > localhost.47658: Flags [.], ack 27, win 512, options [nop,nop,TS val 274210076 ecr 274210076], length 0
     *
     * 14:35:05.740436 IP localhost.47658 > localhost.12345: Flags [P.], seq 27:40, ack 1, win 512, options [nop,nop,TS val 274210077 ecr 274210076], length 13
     * 14:35:05.740441 IP localhost.12345 > localhost.47658: Flags [.], ack 40, win 512, options [nop,nop,TS val 274210077 ecr 274210077], length 0
     *
     * 14:35:05.740553 IP localhost.47658 > localhost.12345: Flags [F.], seq 40, ack 1, win 512, options [nop,nop,TS val 274210077 ecr 274210077], length 0
     * 14:35:05.740668 IP localhost.12345 > localhost.47658: Flags [F.], seq 1, ack 41, win 512, options [nop,nop,TS val 274210077 ecr 274210077], length 0
     * 14:35:05.740683 IP localhost.47658 > localhost.12345: Flags [.], ack 2, win 512, options [nop,nop,TS val 274210077 ecr 274210077], length 0
     *
     * zy_@hasee:~$ sudo tcpdump -i lo port 12345
     * 请输入密码:
     * 验证成功
     * tcpdump: verbose output suppressed, use -v or -vv for full protocol decode
     * listening on lo, link-type EN10MB (Ethernet), capture size 262144 bytes
     * 14:58:02.198367 IP localhost.57224 > localhost.12345: Flags [S], seq 1796817427, win 65495, options [mss 65495,sackOK,TS val 275586534 ecr 0,nop,wscale 7], length 0
     * 14:58:02.198380 IP localhost.12345 > localhost.57224: Flags [S.], seq 3497557417, ack 1796817428, win 65483, options [mss 65495,sackOK,TS val 275586534 ecr 275586534,nop,wscale 7], length 0
     * 14:58:02.198390 IP localhost.57224 > localhost.12345: Flags [.], ack 1, win 512, options [nop,nop,TS val 275586534 ecr 275586534], length 0
     *
     * 14:58:02.199129 IP localhost.57224 > localhost.12345: Flags [P.], seq 1:14, ack 1, win 512, options [nop,nop,TS val 275586535 ecr 275586534], length 13
     * 14:58:02.199137 IP localhost.12345 > localhost.57224: Flags [.], ack 14, win 512, options [nop,nop,TS val 275586535 ecr 275586535], length 0
     *
     * 14:58:02.199287 IP localhost.12345 > localhost.57224: Flags [P.], seq 1:55, ack 14, win 512, options [nop,nop,TS val 275586535 ecr 275586535], length 54
     * 14:58:02.199294 IP localhost.57224 > localhost.12345: Flags [.], ack 55, win 512, options [nop,nop,TS val 275586535 ecr 275586535], length 0
     *
     * 14:58:02.199404 IP localhost.57224 > localhost.12345: Flags [P.], seq 14:27, ack 55, win 512, options [nop,nop,TS val 275586535 ecr 275586535], length 13    TODO 这是什么机制？不像前一两次的那样收到请求后返回确认收到，再发送自己需要发送的数据。而是都连在一起发送了。
     * 14:58:02.199527 IP localhost.12345 > localhost.57224: Flags [P.], seq 55:109, ack 27, win 512, options [nop,nop,TS val 275586536 ecr 275586535], length 54
     *
     * 14:58:02.199581 IP localhost.12345 > localhost.57224: Flags [F.], seq 109, ack 27, win 512, options [nop,nop,TS val 275586536 ecr 275586535], length 0
     * 14:58:02.199640 IP localhost.57224 > localhost.12345: Flags [F.], seq 27, ack 110, win 512, options [nop,nop,TS val 275586536 ecr 275586536], length 0
     * 14:58:02.199666 IP localhost.12345 > localhost.57224: Flags [.], ack 28, win 512, options [nop,nop,TS val 275586536 ecr 275586536], length 0
     */
    private void threeWayHandshake() throws InterruptedException {

        System.out.println("Server: 等待从客户端来的SYN报文...");
        TimeUnit.SECONDS.sleep(1);
        String synPacket = "SYN: " + "seq:" + clientSequenceNumber + " ,win:" + 65495 + " ,length: " + 0;
        System.out.println("Client: 向服务端发送 " + synPacket + " 请求建立连接...");
        TimeUnit.SECONDS.sleep(1);

        clientSequenceNumber++;
        //TODO 为什么最开始的两次握手的win窗口大小65495那么大，到开始datatransfer的时候就变成512那么小
        String synAckPacket = "SYN-ACK: " + "seq: " + serverSequenceNumber + " ,ack: " + clientSequenceNumber + " ,win:" + 65495 + " ,length: " + 0;
        System.out.println("Server: 发送 " + synAckPacket + " 到客户端，确认收到");
        TimeUnit.SECONDS.sleep(1);

        serverSequenceNumber++;
        String clientAckPacket = "ACK: " + " ack: " + clientAck + " ,win: " + win + " ,length: " + 0;
        System.out.println("Client: 发送 " + clientAckPacket + " 到服务端,确认收到");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Server: 三次握手结束");
        System.out.println("Client: 三次握手结束，链接建立\n");
    }

    private int dataTransfer() throws InterruptedException {
        System.out.println("开始传输数据...");

        //滑动窗口 数据有4种状态
        // 1.发送端未发送，接收端也未准备接收
        // 2.发送端未发送，接收端准备接收
        // 3.发送端发送，接收端未发送ack
        // 4.发送端发送，接收端发送ack
        String dataToSend = "Hello, server! How are you?";
        int dataSize = dataToSend.getBytes().length;

        int endIndex = clientSeq + dataSize;
        System.out.println("进入发送端缓存，接收方已准备接收");
        String serverPshPacket = "PSH-ACK: " + " seq: " + clientSeq + ":" + endIndex + " ,ack:" + clientAck + " ,win:" + win + " ,length:" + dataSize + " ,data:" + dataToSend;
        System.out.println("Client: 发送数据 " + serverPshPacket + "到服务端");
        System.out.println("进入到滑动窗口中，已经发送但未确认，此时窗口大小:"+ (win - dataSize) + "byte");
        clientSeq = endIndex;

        TimeUnit.SECONDS.sleep(1);
        serverAck = endIndex;
        String clientAckPacket = "ACK: " + "ack: " + serverAck + " ,win: " + win + " ,length: " + 0;
        System.out.println("Server: 发送响应" + clientAckPacket + "到客户端");
        System.out.println("收到确认ack");

        TimeUnit.SECONDS.sleep(1);
        dataToSend = "Hello, client! I'm fine,thank you! And you?";
        dataSize = dataToSend.getBytes().length;

        endIndex = serverSeq + dataSize;
        System.out.println("进入发送端缓存，接收方已准备接收");
        String clientPshPacket = "PSH-ACK: " + " seq: " + serverSeq + ":" + endIndex + " ,ack: " + serverAck + " ,win:" + win + " ,length:" + dataSize + " ,data:" + dataToSend;
        System.out.println("Server: 发送数据" + clientPshPacket + "到客户端");
        System.out.println("进入到滑动窗口中，已经发送但未确认，此时窗口大小:"+ (win - dataSize) + "byte");
        serverSeq = endIndex;

        TimeUnit.SECONDS.sleep(1);
        clientAck = endIndex;
        String serverAckPacket = "ACK: " + "ack: " + clientAck + " ,win: " + win + " ,length: " + 0;
        System.out.println("Client: 发送响应" + serverAckPacket + "到服务端");
        System.out.println("收到确认ack");

        return endIndex;
    }

    private void releaseConnection() throws InterruptedException {
        //14:13:20.503111 IP localhost.56978 > localhost.12345: Flags [F.], seq 15, ack 1, win 512, options [nop,nop,TS val 224911351 ecr 224911351], length 0
        //14:13:20.503202 IP localhost.12345 > localhost.56978: Flags [F.], seq 1, ack 16, win 512, options [nop,nop,TS val 224911352 ecr 224911351], length 0
        //14:13:20.503213 IP localhost.56978 > localhost.12345: Flags [.], ack 2, win 512, options [nop,nop,TS val 224911352 ecr 224911352], length 0
        System.out.println("\n断开连接...");
        String serverFinPacket = " FIN-ACK: " + "seq:" + clientSeq + " ,ack: " + clientAck + " ,win:" + win + " ,length: " + 0;
        System.out.println("Client: 发送 " + serverFinPacket + " 到服务端");
        TimeUnit.SECONDS.sleep(1);

        serverAck = clientSeq + 1;
        String clientAckPacketA = "ACK: " + "ack: " + serverAck + " ,win: " + win + " ,length: " + 0;
        System.out.println("Server: 发送 " + clientAckPacketA + " 到客户端");

        String clientAckPacketB = "FIN-PSH: " + "seq: " + serverSeq + " ,ack:" + serverAck + " ,length: " + 0;
        System.out.println("Server: 发送 " + clientAckPacketB + " 到客户端 ");
        TimeUnit.SECONDS.sleep(1);

        clientAck = serverSeq + 1;
        String serverAckPacket = "ACK: " + "ack:" + clientAck + " ,length: " + 0;
        System.out.println("Client: 发送 " + serverAckPacket + " 到服务端端 ");
        System.out.println("Client: 等待 2*MSL...");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Server: 连接释放.四次挥手结束");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("Client: 连接释放.四次挥手结束，连接断开");
    }

    public void simulate() throws InterruptedException {
        System.out.println("模仿TCP连接，传输，断开:\n");

        threeWayHandshake();
        dataTransfer();
        releaseConnection();
    }

    public static void main(String[] args) throws InterruptedException {
        TcpSimulator tcpSimulator = new TcpSimulator();
        tcpSimulator.simulate();

    }
}

