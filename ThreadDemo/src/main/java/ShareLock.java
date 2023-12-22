/**
 * @description:
 * @author: HammerRay
 * @date:2023/10/29
 */
public class ShareLock {
     class SharedResource {
        private int value = 0;

        public synchronized void increment() {
            value++;
        }

        public synchronized int getValue() {
            return value;
        }
    }

        public void run(String[] args) {
            SharedResource resource = new SharedResource();

            Runnable task = () -> {
                for (int i = 0; i < 1000; i++) {
                    resource.increment();
                }
            };

            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final Value: " + resource.getValue());
        }

}
