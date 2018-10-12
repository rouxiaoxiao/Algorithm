package meituan;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:32 2018/10/9
 */
public class WaiMaiManJian {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int X = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        helper(n, 0, X, nums, true, nums[0]);
        helper(n, 0, X, nums, false, 0);
        System.out.println(min);
    }

    private static void helper(int n, int index, int X, int[] nums, boolean select, int sum) {
        if (index >= n) {
            return;
        }
        if (sum > X) {
            if (sum < min) {
                min = sum;
            }
            return;
        }
        if (!(sum == X)) {
            helper(n, index + 1, X, nums, false, sum);
            helper(n, index + 1, X, nums, true, sum + nums[index]);
        }
    }
}
