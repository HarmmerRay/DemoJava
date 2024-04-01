package thread;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/26 上午8:47
 */

public class Abc implements Runnable{
    private String name;
    private Object prev;
    private     Object now;
    public Abc (String name,Object prev,Object now){
        this.name = name;
        this.prev = prev;
        this.now = now;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            synchronized (prev){
                synchronized (now){
                    System.out.print(name);
                    count--;

                    now.notify();
                }
                System.out.println(name + "对象锁已释放");
                try {
                    prev.wait();
                    System.out.println();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    class ObjectLock{

    }
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Abc aa = new Abc("A",c,a);
        Abc bb = new Abc("B",a,b);
        Abc cc = new Abc("C",b,c);

        new Thread(aa).start();
        new Thread(bb).start();
        new Thread(cc).start();
        Thread.sleep(1000);
        System.out.println("66666666666");
    }
}
