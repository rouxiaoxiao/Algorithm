package yixin;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 17:18 2018/10/8
 */
public class HuaiZhang {
    private static int mo = 100003;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long w = sc.nextLong();
        long tmp = mi(n, w) - n * mi(n - 1, w - 1);
        while (tmp < 0) {
            tmp += mo;
        }
        System.out.println(tmp);
    }

    private static long mi(long a, long b) {
        long ans = 1;
        a %= mo;
        while (b != 0) {
            if ((b & 1) != 0) ans = (ans * a) % mo;
            b >>= 1;
            a = (a * a) % mo;
        }
        return ans % mo;
    }
}

