package zuoyebang;

import java.util.Scanner;

/**
 * 扇形着色问题，可用数学解决
 * https://blog.csdn.net/maozezhong0/article/details/79537137
 * @Author: liangxiao
 * @Date: Created in 20:45 2018/9/5
 */
public class Shangse {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] circle = new int[n];
        helper(n, 0, 1, circle);
        helper(n, 0, 2, circle);
        helper(n, 0, 3, circle);
        helper(n, 0, 4, circle);
        System.out.println(count);

    }

    //假设4种颜色是1234
    private static void helper(int n, int index, int color, int[] circle) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            count = n;
        }
        if (index >= n) {
            return;
        }
        circle[index] = color;
        if (index > 0 && circle[index] == circle[index - 1] && circle[index] != 0) {
            return;
        }
        if (index == n - 1 && circle[0] != circle[n - 1]) {
            count++;
            return;
        }
        if (index == n - 1 && circle[0] == circle[n - 1]) {
            return;
        }
        helper(n, index + 1, 1, circle);
        helper(n, index + 1, 2, circle);
        helper(n, index + 1, 3, circle);
        helper(n, index + 1, 4, circle);
    }
}
