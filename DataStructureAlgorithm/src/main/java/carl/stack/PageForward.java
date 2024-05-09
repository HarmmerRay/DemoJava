package carl.stack;

import java.util.Stack;

/**
 * @description: 用栈制作一个标签页的前进后退
 * @author: HammerRay
 * @date: 2024/5/9 下午6:20
 */
public class PageForward {
    private final Stack<Integer> stackLeft;
    private final Stack<Integer> stackRight;
    public PageForward() {
        this.stackLeft = new Stack<>();
        this.stackRight = new Stack<>();
    }
    /**
     * description:
     * @paramType [java.lang.Integer]
     * @param url:
     * @returnType: boolean
     * @author: GodHammer
     * @date: 2024-05-09 下午7:10
     */
    private boolean open(Integer url){

        stackLeft.push(url);
        System.out.println("当前打开的页面是：" + url);
        return true;
    }
    /**
     * description:  url标志页面 1页面，2页面，88页面..
     * @returnType: boolean
     * @author: GodHammer
     * @date: 2024-05-09 下午6:23
     */
    private boolean forward() {
        int url = stackRight.pop();
        stackLeft.push(url);
        System.out.println("当前前进到的页面是："+ url);
        return true;
    }

    private boolean back() {
        int url = stackLeft.pop();
        stackRight.push(url);
        System.out.println("当前后退到的页面是: " + stackLeft.peek());
        return true;
    }

    public static void main(String[] args) {
        PageForward pageForward = new PageForward();
        pageForward.open(1);
        pageForward.open(2);
        pageForward.open(3);
        pageForward.back();
        pageForward.forward();
    }
}
