package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @description: 查看线程的三种方法
 * 一、命令行 1.top -Hp [pid] 2.pstree -p [pid] 3. cat /proc/pid/status | grep Thread
 * 二、java api
 * 三、jstack- l [pid]
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
