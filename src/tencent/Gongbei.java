package tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 11:32 2018/9/16
 */
public class Gongbei {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = findM(n);
        System.out.println(ans);
    }

    //因式分解
    private static Map<Integer, Integer> yinshi(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i < num; i++) {
            while (num % i == 0) {
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
                num = num / i;
            }
        }
        if (num > 1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map;

    }

    private static int findM(int n) {
        int m = n + 1;

        long[] arr2 = new long[m];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 1 + i;
        }
        long lcm1 = commonMultiple(n + 1, m);
        long lcm2 = commonMultiple(arr2);
        while (true) {
            if (lcm1 == lcm2) {
                return m;
            }
            m++;
            lcm1 = commonMultiple(lcm1, m);
            lcm2 = commonMultiple(lcm2, m);
        }
    }

    private static long commonDivisor(long n, long m) {
        // 求两个数的最大公约数
        // 辗转相除法是用大的除以小的，如果N<zoom.qishui.M,第一次相当N与M值交换(例如2%3，商0余2)
        while (n % m != 0) {
            long temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }


    private static long commonMultiple(long n, long m) {
        // 求两个数的最小公倍数
        // 两个数相乘等于这两个数的最大公约数和最小公倍数的积。
        return n * m / commonDivisor(n, m);
    }

    private static long commonMultiple(long[] a) {// 求多个数的最小公倍数
        long value = a[0];
        for (int i = 1; i < a.length; i++) {
            value = commonMultiple(value, a[i]);
        }
        return value;
    }
}

