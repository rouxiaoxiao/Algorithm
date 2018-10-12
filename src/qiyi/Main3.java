package qiyi;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] ints = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            ints[i][0] = sc.nextInt();
//            ints[i][1] = sc.nextInt();
//        }
//        int count = 0;
//        System.out.println(helper(ints, m, count));
        int[] nums={1,2};
        System.out.println(findTargetSumWays(nums,5));
    }

    private static int helper(int[][] ints, int m, int count) {
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum = sum + ints[i][0];
        }
        int chazhi = m - sum;
        int[] nums = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            nums[i] = ints[i][1] - ints[i][0];
        }
        return findTargetSumWays(nums,chazhi);
    }

    private static int answer = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        int[] s = new int[nums.length];
        s[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            s[i] = s[i + 1] + nums[i];
        }

        dfsHelper(nums, S, 0, 0, s);
        return answer;
    }

    public static void dfsHelper(int[] nums, int S, int index, int currSum, int[] s) {
        if (index == nums.length) {
            if (currSum == S) {
                answer++;
            }
        } else if (Math.abs(S - currSum) <= s[index]) {
            dfsHelper(nums, S, index + 1, currSum + nums[index], s);
            dfsHelper(nums, S, index + 1, currSum - nums[index], s);
        }
    }
}


