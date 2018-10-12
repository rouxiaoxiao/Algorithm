package threeSixZero;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 19:44 2018/9/16
 */
public class Weilizhi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] nums1 = new long[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = in.nextInt();
        }

        long[] result = new long[n];
        for (int i = 0; i < n; i++) {
            int l = i - nums2[i] + 1;
            int r = i;
            long min = Integer.MAX_VALUE;
            long max = Integer.MIN_VALUE;
            for (; l <= r; l++) {
                if (nums1[l] < min) {
                    min = nums1[l];
                }
                if (nums1[l] > max) {
                    max = nums1[l];
                }
            }
            result[i] = max * min;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }


    }
}
