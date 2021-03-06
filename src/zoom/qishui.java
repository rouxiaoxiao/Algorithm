package zoom;

import java.util.*;

/**
 * @Author: liangxiao
 * @Date: Created in 17:32 2018/9/29
 * 三个空瓶可以在换一个饮料，问一共最多可以喝多少瓶
 *
 */
public class qishui {
    static int num2 = 0;//喝道的饮料数

    public static void main(String[] args) {
        int[] num1 = new int[10];//空瓶子数
        int count = 0, temp;
        Scanner sc = new Scanner(System.in);

        temp = sc.nextInt();
        num1[count] = temp;
        count++;

        for (int i = 0; i < count; i++) {
            num2 = 0;
            fun(num1[i]);
            System.out.println(num2);
        }
    }

    public static void fun(int n) {
        if (n == 1) {
            return;
        }
        if (n == 2) {
            num2++;
            return;
        } else if (n >= 3) {
            num2 = num2 + n / 3;
            fun(n / 3 + n % 3);
        }
    }
}
