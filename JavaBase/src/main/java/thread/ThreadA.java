package thread;

/**
 * @description:
 * @author: HammerRay
 * @date: 2024/4/26 下午2:56
 */
public class ThreadA extends Thread{
    private String threadName;
    public ThreadA(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        System.out.println(threadName);
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("当前线程ID:"+Thread.currentThread().getId());
    }
}
class Main{
    public static void main(String[] args) {
        System.out.println("当前线程ID:"+Thread.currentThread().getId());
        ThreadA threadA = new ThreadA("A");
        ThreadA threadB = new ThreadA("B");
        threadA.start();
        threadB.start();
    }
}