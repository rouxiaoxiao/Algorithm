package offer;

import java.util.Stack;

/**
 * @Author liangxiao
 * @Date 2017/10/27 10:59
 * <p>
 * 用两个栈实现队列
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
//        stackToQueue.pop();
        stackToQueue.push(1);
        stackToQueue.push(2);
        System.out.println(stackToQueue.pop());
    }
}


