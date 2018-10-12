package qiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(helper(nums));
    }

    private static int helper(int[] nums) {
        Arrays.sort(nums);
        int count = nums[2] - nums[1];
        nums[1] = nums[2];
        nums[0] = nums[0] + count;
        if ((nums[2] - nums[0]) % 2 == 0) {
            count = count + (nums[2] - nums[0]) / 2;
        } else {
            count = count + (nums[2] - nums[0]) / 2 + 1;
        }
        return count;
    }
}
