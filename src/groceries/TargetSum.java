package groceries;

/**
 * Created by liangxiao on 2018/4/20.
 */
public class TargetSum {
    private static int answer = 0;

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
        System.out.println(findTargetSumWays(nums,5));
    }

    private static int findTargetSumWays(int[] nums, int S) {
        int[] s = new int[nums.length];
        s[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            s[i] = s[i + 1] + nums[i];
        }

        dfsHelper(nums, S, 0, 0, s);
        return answer;
    }

    private static void dfsHelper(int[] nums, int S, int index, int currSum, int[] s) {
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
