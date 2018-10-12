package threeSixZero;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:39 2018/9/17
 */
public class Mugun {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int sum = 0;
        int result = -1;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            int maxTemp = 0;
            if (nums[i] > maxTemp) {
                maxTemp = nums[i];
            }
            if (i > 1 && sum - maxTemp > maxTemp) {
                result = i + 1;
                break;
            }
        }
        System.out.println(result);
    }
}
