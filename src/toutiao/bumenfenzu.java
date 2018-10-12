package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 10:05 2018/9/9
 */
public class bumenfenzu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        System.out.println(helper(n, nums));
    }

    private static int helper(int n, int[][] nums) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    int[][] newNums = findLin(n, nums, i, j);
                    return 1 + helper(n, newNums);
                }
            }
        }
        return 0;

    }

    //找到相邻的并修改为0
    private static int[][] findLin(int n, int[][] nums, int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < n && nums[i][j] == 1) {
            nums[i][j] = 0;
            findLin(n, nums, i + 1, j);
            findLin(n, nums, i, j + 1);
            findLin(n, nums, i - 1, j);
            findLin(n, nums, i, j - 1);
        }
        return nums;
    }
}
