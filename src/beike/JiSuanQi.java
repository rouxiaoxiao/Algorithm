package beike;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 19:41 2018/9/3
 */
public class JiSuanQi {
    private static int min = Integer.MAX_VALUE;
    private static int realN = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = 0;
        realN = n;
        helper(n, m, count);
        System.out.println(min);
    }

    private static void helper(int n, int m, int count) {
        if (n == m) {
            if (count < min) {
                min = count;
            }
            return;
        }
        if (n > m * 2) {
            count = count + n - m;
            if (count < min) {
                min = count;
            }
            return;
        }
        if (m / n >= 2) {
            while (n < m) {
                n = n * 2;
                count++;
            }
            int count1 = count;
            int count2 = count;
            if (m % 2 == 0) {
                count1 = n - m / 2 + 1;
            } else {
                count1 = n - m / 2 + 2;
            }
            count2 = 2 * n - m + 1;
            if (count1 < min) {
                min = count1;
            }
            if (count2 < min) {
                min = count2;
            }
            return;
        }
        helper(n - 1, m, count + 1);
        helper(n * 2, m, count + 1);
    }
}
