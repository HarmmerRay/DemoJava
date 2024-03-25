package threadAndLock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/1/5 下午3:07
 */
public class UnfairLock {
    /**
     * 创建一个非公平锁
     */
    private static final int THREAD_POOL_SIZE = 10;
    private static final ThreadFactory threadFactory =new CustomThreadFactory("Thread---");
    private static final Lock LOCK = new ReentrantLock(false);
    private static ExecutorService poolExecutor = new ThreadPoolExecutor(THREAD_POOL_SIZE,THREAD_POOL_SIZE,0L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(THREAD_POOL_SIZE, true),threadFactory);
    public static void main(String[] args) {

        poolExecutor.submit(() -> {
            while (true) {
                if (LOCK.tryLock()) {
                    try {
                        // 成功获取锁，执行相应操作
                        System.out.println(Thread.currentThread().getName() + " acquired the lock");
                        // ... 执行一些操作
                        // 跳出循环，任务完成
                        break;
                    } finally {
                        // 释放锁
                        LOCK.unlock();
                    }
                } else {
                    // 获取锁失败，等待一段时间后重试
                    try {
                        // 等待2秒后重试
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        poolExecutor.shutdown();
    }
    private static class CustomThreadFactory implements ThreadFactory {
        private final String threadNamePrefix;

        public CustomThreadFactory(String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, threadNamePrefix + Thread.currentThread().getId());
        }
    }
}
