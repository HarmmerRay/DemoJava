package carl.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:  用队列模拟栈  一个队列模拟，把队列当成一个环
 * @author: HammerRay
 * @date: 2024/5/9 下午7:45
 */
public class MyStack {
    private Queue<Integer> queue ;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int num = queue.size();
        queue.add(x);
        for(int i = 0 ; i < num ; i++) {
            queue.add(queue.remove());
        }
//        // 返回false
//        queue.offer(x);
//        // 返回null
//        queue.peek();
//        // 抛异常
//        queue.add(x);

    }

    public int pop() {
        return queue.remove();
//        // 返回null
//        queue.poll();
//        // 抛异常
//        queue.remove();
//        queue.element();
    }

    public int top() {
        return queue.element();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
