package 计算机网络课程设计.hw4_portScan;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/1 下午10:33
 */
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class PortScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 获取用户输入的主机IP地址或域名
        System.out.print("Enter the host IP address or domain name: ");
        String host = scanner.nextLine();

        // 扫描端口范围
        System.out.print("Enter the starting port number: ");
        int startPort = scanner.nextInt();

        System.out.print("Enter the ending port number: ");
        int endPort = scanner.nextInt();

        // 调用端口扫描方法
        scanPorts(host, startPort, endPort);

        scanner.close();
    }

    private static void scanPorts(String host, int startPort, int endPort) {
        System.out.println("Scanning ports for " + host + "...");

        for (int port = startPort; port <= endPort; port++) {
            try {
                // 创建Socket对象并尝试连接指定端口
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), 1000); // 1000ms timeout

                // 如果连接成功，说明端口是打开的
                System.out.println("Port " + port + " is open. Service: " + getServiceName(port));

                // 关闭Socket连接
                socket.close();
            } catch (Exception e) {
                // 连接失败，端口可能是关闭的或被防火墙阻止
            }
        }

        System.out.println("Port scanning completed.");
    }

    private static String getServiceName(int port) {
        // 在实际应用中，你可以根据端口号查询常用端口对应的服务名称
        // 这里只是一个简单的演示，实际情况需要使用更复杂的服务端口映射表
        switch (port) {
            case 21:
                return "FTP";
            case 80:
                return "HTTP";
            case 443:
                return "HTTPS";
            case 22:
                return "SSH";
            case 6379:
                return "redis-server";
            default:
                return "Unknown";
        }
    }
}

