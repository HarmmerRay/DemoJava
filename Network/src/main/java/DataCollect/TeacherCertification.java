package DataCollect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: DemoJava
 * @package: DataCollect
 * @className: TeacherCertification 教师资格证考试真题获取
 * @author: HammerRay
 * @description: 请求https://www.gkzenti.cn/api 网址的接口，获取教资历年真题试卷
 * @date: 1/19/2024 10:59 PM
 * @version: 1.0
 */

public class TeacherCertification {
    static class Link{
        private String url;
        private String title;
        private String source;
    }

    public static void main(String[] args) {
        try {
            getLink();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 接口地址
     * https://www.gkzenti.cn/api/json?cls={试卷类别}&province={区域}
     * 接口说明
     * 其中cls为试卷类别[行测、申论、面试、事业单位......]，province为区域[浙江、山东、江苏......]，返回结果为包含试卷链接[No]、试卷标题[Title]、试卷来源[Source]的JSON结构体。
     * 调用举例（HTTP.GET）
     * 比如我们要获取[浙江]历年的[行测]试卷，则调用如下：
     * https://www.gkzenti.cn/api/json?cls=行测&province=浙江
     * 可点击上面链接查看浙江历年行测试卷获取结果。
     * 接口返回JSON结构体
     * [{"No":"试卷链接","Title":"试卷标题","Source":"来源"},{"No":"试卷链接","Title":"试卷标题","Source":"来源"}......]
     * 提醒
     * 接口调用频次基本不受限，但也有极小的概率被误ban，给我发邮件解除即可：admin@gkzenti.cn
     * 通过gkzenti.cn/api网址的接口获取相应的真题S所处的网络url
     * @return ArrayList<Link>
     * @author "HammerRay"
     * @date 1/19/2024 11:12 PM
     */

    private static void getLink() throws IOException {
        List<Link> linkList = new ArrayList<>();
        String clz = "教师资格";
        String province = "高中";
        URL url = new URL("https://www.gkzenti.cn/api/json?cls="+clz+"&province="+province);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            byte []buffer = new byte[1024];
            StringBuilder response = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String tmp = bufferedReader.readLine();
            while (tmp  != null){
                response.append(tmp);
                tmp = bufferedReader.readLine();
            }

//            while (conn.getInputStream().read(buffer) != 0){
//                System.out.printf(Arrays.toString(buffer));
//                response.append(Arrays.toString(buffer));
//            }

            System.out.printf(response.toString());

        }


    }
}
