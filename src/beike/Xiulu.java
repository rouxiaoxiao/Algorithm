package beike;

import java.util.Scanner;

/**
 * 第3题：
 * 将所有基站连同，修路的费用只与海拔有关，就是较高的基站的海拔
 * 怎样费用最少
 * 输入：5    2 5 8 1 4  输出为：19
 * @Author: liangxiao
 * @Date: Created in 20:21 2018/8/18
 */
public class Xiulu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sum = sum + nums[i];
        }
        System.out.println(sum - min);
    }


}
