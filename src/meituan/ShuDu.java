package meituan;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:51 2018/10/9
 */
public class ShuDu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(helper(n, nums));
        }
    }

    private static String helper(int n, int[] nums) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        if (sum / 2 == n - 1) {
            return "Yes";
        } else {
            return "No";
        }

    }
}