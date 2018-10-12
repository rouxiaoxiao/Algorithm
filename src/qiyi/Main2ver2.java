package qiyi;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/04/19 0019.
 */
public class Main2ver2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] numstr = in.nextLine().split(" ");
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++)
            nums[i] = Integer.parseInt(numstr[i]);
        System.out.println(helper(nums));
    }

    private static int helper(int[] nums) {
        Arrays.sort(nums);
        int max = nums[2] - nums[0];
        int min = nums[2] - nums[1];
        int chanMax = max / 2;
        nums[0] += 2 * chanMax;
        int chanMin = min / 2;
        nums[1] += 2 * chanMin;
        if (nums[2] - nums[0] == 0 && nums[2] - nums[1] == 0) return chanMax + chanMin;
        else if (nums[2] - nums[0] == 1 && nums[2] - nums[1] == 1) return chanMax + chanMin + 1;
        else return chanMax + chanMin + 2;
    }

}

