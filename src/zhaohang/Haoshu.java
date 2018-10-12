package zhaohang;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:40 2018/9/16
 */
public class Haoshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(count(in.nextInt()));
    }

    private static int count(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isHao(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isHao(int num) {
        boolean result = true;
        int[] nums = convert(num);
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 || nums[i] == 1 || nums[i] == 8) {
                continue;
            } else if (nums[i] == 6 || nums[i] == 9 || nums[i] == 2 || nums[i] == 5) {
                flag = true;
            } else {
                result = false;
                break;
            }
        }
        return flag ? result : false;

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
