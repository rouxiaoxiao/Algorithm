package threeSixZero;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:55 2018/9/17
 */
public class P {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int absSum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                absSum = absSum + Math.abs(nums[i] - nums[j]);
            }
        }
        System.out.println(absSum * (n + 1));
    }
}
