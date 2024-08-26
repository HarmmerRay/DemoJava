package thread.pool;

import java.util.concurrent.*;


/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/1 上午9:26
 */
public class MyThreadPoolExecutor {

    public static void main(String[] args) {
        final int TASKNUM = 250;
        // 核心线程数
        int corePoolSize = 5;
        // 最大线程数
        int maxSize = 10;
        // 等待时间
        int keepAliveTime = 60;
        // 时间单位
        TimeUnit unit = TimeUnit.SECONDS;
        // 线程工厂
        ThreadFactory threadFactory = new CustomThreadFactory("demo-");
        // 拒绝策略
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        // 阻塞队列
        new ArrayBlockingQueue<>(200);
        // newFixedThreadPool  newCachedThreadPool newSingleThreadPoolExecutor newScheduledThreadPool
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxSize,keepAliveTime,unit,
                new ArrayBlockingQueue<>(200),threadFactory,rejectedExecutionHandler);

        for (int i = 0; i < TASKNUM; i++) {
            final int taskId = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("Executing task: " + taskId + " on thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 模拟耗时任务
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 关闭线程池，不再接受新任务，等待已提交任务执行完毕
        threadPoolExecutor.shutdown();
        try {
            // 等待所有任务执行完毕
            if (!threadPoolExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("ThreadPool did not terminate");
            }
        } catch (InterruptedException ie) {
            // 如果等待过程中被中断，重新设置中断状态
            Thread.currentThread().interrupt();
        }

    }
}
