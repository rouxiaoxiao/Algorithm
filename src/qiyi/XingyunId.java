package qiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 10:50 2018/9/15
 */
public class XingyunId {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[6];
        nums = convert(n);
        int[] kejia1 = new int[6];
        int[] kejia2 = new int[6];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 6; i++) {
            //分两段
            if (i < 3) {
                sum1 = sum1 + nums[i];
                //前面加后面减
                kejia1[i] = 9 - nums[i];
                kejia2[i] = nums[i];
            } else {
                sum2 = sum2 + nums[i];
                //前面减后面加
                kejia1[i] = nums[i];
                kejia2[i] = 9 - nums[i];
            }
        }
        Arrays.sort(kejia1);
        Arrays.sort(kejia2);
        int chazhi = sum1 - sum2;
        int count = 0;
        int sum = 0;
        if (chazhi < 0) {
            for (int i = 5; i >= 0 && sum < Math.abs(chazhi); i--) {
                count++;
                sum = sum + kejia1[i];
            }
        } else if (chazhi > 0) {
            for (int i = 5; i >= 0 && sum < chazhi; i--) {
                count++;
                sum = sum + kejia2[i];
            }
        } else {
            count = 0;
        }
        System.out.println(count);
    }

    //将输入的数字字符串转为数组
    private static int[] convert(int n) {
        int[] nums = new int[6];
        for (int i = 5; ; i--) {
            nums[i] = n % 10;
            if (n / 10 == 0) {
                nums[i] = n;
                break;
            }
            n = n / 10;
        }
        return nums;
    }
}
