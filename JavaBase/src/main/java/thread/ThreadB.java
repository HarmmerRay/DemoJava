package thread;

/**
 * @description:  线程的状态 创建 准备 运行 阻塞 结束
 * @author: HammerRay
 * @date: 2024/4/26 下午3:02
 */
public class ThreadB implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程ID：" + Thread.currentThread().getId());
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("当前线程ID：" + Thread.currentThread().getId());
        new Thread(new ThreadB()).start();
        new Thread(new ThreadB()).start();

    }
}

