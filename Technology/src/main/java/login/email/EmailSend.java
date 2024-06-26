package login.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

/**
 * @description:  引入javax.mail包 --> 拷贝从qq邮箱上得到的授权码（以qq邮箱为smtp服务器） --> 根据qq邮箱url、授权码、是否需要用户认证、是否开启TLS加密等配置属性，创建Session对话 --> MineMessage创建信息格式，用session发送信息
 * @author: HammerRay
 * @date: 2023/10/26
 */
public class EmailSend {
    private static Properties loadProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = EmailSend.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IOException("Sorry, unable to find " + fileName);
            }
            properties.load(input);
        }
        return properties;
    }

    public static Session emailSessionGenerator() throws IOException {
        Properties properties = loadProperties("info.properties");



        //	账号信息
        //	邮箱发送账号
        String username = properties.getProperty("email_username_2");
//        String username = "14879945@qq.com";
        //	邮箱授权码
        String password = properties.getProperty("email_password_2");
//        String password = "slwawoihfkgxbjaf";//rgxfiootentddjch

        //	创建一个配置文件，并保存
        Properties props = new Properties();

        //	SMTP服务器连接信息
        //  126--smtp.126.com
        //  163--smtp.163.com
        //   qq--smtp.qq.com"

        //	SMTP主机名
        props.put("mail.smtp.host", "smtp.qq.com");
        //126——25  163——465  qq-587
        //	主机端口号
        props.put("mail.smtp.port", "587");
        //	是否需要用户认证
        props.put("mail.smtp.auth", "true");
        //	启用TlS加密
        props.put("mail.smtp.starttls.enable", "true");

        //	创建session会话
        //	参数1:smtp服务器连接参数
        //	参数2:账号和密码的授权认证对象
        Session session =Session.getInstance(props,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        session.setDebug(true);

        return session;
    }
    public static void main(String[] args) throws MessagingException, IOException {
        Session session = EmailSend.emailSessionGenerator();
        MimeMessage message = new MimeMessage(session);
        message.setSubject("我是赵阳这是，我用Java 引用的javax.email包，借用qq的SMTP服务给你发送的邮件");
        message.setText("1.qq上设置打开SMTP服务，并获得校验码 \n " +
                "2.建立emailSender的邮件地址实例，和password = '获取的校验码' ,建立一个Properties实例，配置smtp主机名，smtp主机端口（qq是587）TLS加密为true，开启用户认证" +
                "\n3.Session.getInstance(props,authenticator)获取与SMTP通信的Session \n 4.mimeMessage设置标题 正文 来自哪里 发送到哪里  \n \5" +
                ".使用Transport.send(mimeMessage)发送出去");

        message.setFrom(new InternetAddress("2624773733@qq.com","赵阳"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("14879945@qq.com"));
        Transport.send(message);
    }
}
