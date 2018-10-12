package offer;

import java.util.Stack;

/**
 * @author liangxiao
 * @date 2017/12/4 16:23
 * 得到栈最小元素的min函数
 */
public class StackMin {
    private Stack<Integer> minStack=new Stack<Integer>();
    private Stack<Integer> dataStack=new Stack<Integer>();
    private int min = Integer.MAX_VALUE;
    public void push(Integer item){
        minStack.push(min);
        dataStack.push(item);
        if (dataStack.size()==0 || item <min){
            minStack.push(item);
            min=item;
        }else {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop(){
        if (dataStack.size() == 0 || minStack.size() == 0) {
            return null;
        }
        minStack.pop();
        return dataStack.pop();
    }

    public Integer min(){
        if (minStack.size()==0){
            return null;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackMin stackMin=new StackMin();
        stackMin.push(5);
        stackMin.push(3);
        stackMin.push(2);
        System.out.println(stackMin.min());


//        //测试peek
//        Stack<Integer> stack=new Stack<Integer>();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.peek());

    }
}
