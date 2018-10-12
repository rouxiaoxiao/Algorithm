package offer;

import java.util.Stack;

/**
 * @author liangxiao
 * @date 2017/12/5 10:27
 * 判断是否为该压栈序列的弹出序列
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!s.empty() && s.peek() == popA[popIndex]) {
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {

        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 1, 2};
        IsPopOrder isPopOrder = new IsPopOrder();

        System.out.println(isPopOrder.isPopOrder(pushA, popA));
    }
}
