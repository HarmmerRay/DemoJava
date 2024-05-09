package carl.stack;

import java.util.*;

/**
 * @description: 用栈实现队列  仅用两个栈，且栈不能用语言支持的栈得是list、Deque
 * @author: HammerRay
 * @date: 2024/5/9 下午7:21
 */
public class MyQueue {
    private Deque<Integer> stackLeft;
    private Deque<Integer> stackRight;
    public MyQueue() {
        stackLeft = new LinkedList<>();
        stackRight = new LinkedList<>();
    }

    public void push(int x) {
        stackLeft.push(x);

    }

    public int pop() {
        if (stackRight.isEmpty()) {
            while (!stackLeft.isEmpty()) {
                stackRight.push(stackLeft.pop());
            }
        }
        return stackRight.pop();
    }

    public int peek() {
        if (stackRight.isEmpty()) {
            while (!stackLeft.isEmpty()) {
                stackRight.push(stackLeft.pop());
            }
        }
        return stackRight.peek();
    }

    public boolean empty() {

        return stackLeft.isEmpty() && stackRight.isEmpty();
    }

}
