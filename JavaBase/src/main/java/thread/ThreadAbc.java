package thread;

/**
 * @description:
 * @author: HammerRay
 * @date: 2023/12/26 上午8:47
 */

public class ThreadAbc implements Runnable{
    private String name;
    private Object prev;
    private     Object now;
    public ThreadAbc(String name, Object prev, Object now){
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
    public static void main(String[] args) throws InterruptedException {
        // 查看编译后的class文件可知道： O长度的字节数组只需要3个操作码，new Object需要7个。 所以需要锁的时候用byte[]数组生成
        byte[] lock = new byte[0];
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreadAbc aa = new ThreadAbc("A",c,a);
        ThreadAbc bb = new ThreadAbc("B",a,b);
        ThreadAbc cc = new ThreadAbc("C",b,c);

        new Thread(aa).start();
        new Thread(bb).start();
        new Thread(cc).start();
        Thread.sleep(1000);
        System.out.println("66666666666");
    }
}
