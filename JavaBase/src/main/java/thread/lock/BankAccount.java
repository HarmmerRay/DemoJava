package thread.lock;

/**
 * @description: ReentrantLock 使用
 * @author: HammerRay
 * @date: 2024/5/6 上午2:13
 */
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // 存款方法
    public void deposit(double amount) {
        lock.lock(); // 获取锁
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " 存款后余额: " + balance);
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    // 取款方法
    public void withdraw(double amount) {
        lock.lock(); // 再次尝试获取锁
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " 取款后余额: " + balance);

                // 假设这里有一个复杂的操作，它也需要同步
                performComplexOperation();
            } else {
                System.out.println(Thread.currentThread().getName() + " 余额不足！");
            }
        } finally {
            lock.unlock(); // 确保释放锁
        }
    }

    // 假设这是一个复杂的、也需要同步的操作
    private void performComplexOperation() {
        lock.lock(); // 这里尝试获取锁，由于是可重入锁，即使在withdraw方法中已持有锁，也能成功获取
        try {
            // 执行一些需要同步的复杂计算或操作...
            System.out.println("执行复杂操作...");
        } finally {
            lock.unlock(); // 完成后释放锁
        }
    }
}