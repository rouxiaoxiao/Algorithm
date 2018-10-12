package offer;

/**
 * @author liangxiao
 * @since 1.0
 *
 * 斐波那契数列
 */


public class Fibonacci {

    public static int Fibonacci(int n) {
        int num1=0;
        int num2=1;
        int tem=0;//局部变量不会自动初始化，需要给初值
        if (n==0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            for (int i = 2; i <= n; i++) {
                tem = num1 + num2;
                num1 = num2;
                num2 = tem;
            }
        }
        return tem;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}

