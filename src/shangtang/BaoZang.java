package shangtang;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:20 2018/10/15
 */
public class BaoZang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            if (i != n - 1) {
                System.out.print(helper(s, A, B) + " ");
            } else {
                System.out.print(helper(s, A, B));
            }
        }
    }

    private static int helper(int s, int A, int B) {
        int count = 0;
        while (s > 0) {
            count++;
            if (count % 2 == 1) {
                s = s - A;
            } else {
                s = s - B;
            }
        }
        if (count % 2 == 1) {
            //B
            return 1;
        } else {
            return -1;
        }
    }
}
