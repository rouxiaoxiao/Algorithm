package shangtang;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 19:53 2018/10/15
 */
public class KuoHao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(helper(n, m));
    }

    private static int helper(int n, int m) {
        int cha = Math.abs(n - m);
        int result = 1;
        if (m > cha) {
            while (n > m) {
                result = result * n;
                n = n - 1;
            }
            result = result / jiecheng(cha);
        } else {
            while (n > cha) {
                result = result * n;
                n = n - 1;
            }
            result = result / jiecheng(m);
        }
        return result;
    }

    private static int jiecheng(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;

    }
}
