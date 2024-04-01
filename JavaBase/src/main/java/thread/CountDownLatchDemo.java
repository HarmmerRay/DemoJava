package thread;

/**
 * @description: 创建线程计数器，5个线程公用一个计数器，计数器的初始数值为线程的个数5，每个线程执行完后，计数器减1，等最后计数器完成后则主线程停止wait
 * 计数器控制等待多少线程的执行完毕
 * @author: HammerRay
 * @date: 2024/4/1 下午4:10
 */
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            new Thread(new Worker(latch)).start();
        }

        // 主线程等待其他线程完成任务  计数器减为1后，await状态解除
        latch.await();
        System.out.println("所有线程任务完成");
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // 模拟耗时操作
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " 完成任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 完成任务后，计数器减1
                latch.countDown();
            }
        }
    }
}

