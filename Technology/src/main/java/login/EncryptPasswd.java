package login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;


/**
 * @description:
 * @author: HammerRay
 * @date:2023/11/3
 */
public class EncryptPasswd {
    private static final Logger logger = LogManager.getLogger(EncryptPasswd.class);
    public static void main(String[] args) {
        String passwd = "1318141213123123123";

        byte[] tmp = generateSalt();

        System.out.println(Arrays.toString(tmp));
        System.out.println(tmp);
        System.out.println();
        String encryptedPasswd = hashPassword(passwd,generateSalt());

        System.out.println("PASSWORD:"+passwd +"\nEncryptedPASSWORD:"+encryptedPasswd);

        assert encryptedPasswd != null;
        //添加随机salt值增加hash值的安全性后，加密形成的字符的字节大小，对应数据库中应该为相应的varchar(n)类型
        System.out.println(encryptedPasswd.getBytes().length);

    }

    /**
    * @decription: 生成随机的盐值
    * @author: GodHammer
    * @date: 2023-11-03 上午7:01
    * @version: v1.0
    */
    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }


    /**
    * @decription: 使用SHA-256哈希算法对密码和盐值进行哈希
    * @author: GodHammer
    * @date: 2023-11-03 上午7:00
    * @version: v1.0
    */
    public static String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            // 将盐值和哈希后的密码转换为Base64编码的字符串存储
            return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            logger.error("No Such AlgorithmException:"+e);
            return null;
        }
    }
    /**
    * @decription: 将sha-256加密后的哈希密码 解析出来，并返回密码的字符串  无知！Hash不可逆
    * @author: GodHammer
    * @date: 2023-11-03 下午12:32
    * @version: v1.0
    */
    public static String decodeHashPassword(String encryptedPasswd){
        String password = "";
        int shouldLen = 2;
        String []parts = encryptedPasswd.split(":");
        if(parts.length == shouldLen){
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[]hashedPassword = Base64.getDecoder().decode(parts[1]);

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }


        }


        return password;
    }
}
