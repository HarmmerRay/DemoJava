package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/29 下午11:35
 */
public class ThreadD {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo info : threadInfos){
            System.out.println(info.getThreadId() + "--" + info.getThreadName() + "--" + info.getThreadState().name());
        }
    }
}
