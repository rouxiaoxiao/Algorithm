package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 10:51 2018/9/9
 */
public class bianma {
    private static boolean flag = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        helper(n, nums, 0);
        System.out.println(flag ? 1 : 0);
    }

    //根据开始判断是几字节编码,然后判断后面的结果对不对，如果对则传入数组中后续内容再判断，如果不对，直接返回0
    private static void helper(int n, int[] nums, int start) {
        if (start >= 0 && start < n) {
            int startNum = nums[start];
            //一字节编码
            if ((startNum & 128) == 0) {
                helper(n, nums, start + 1);
            } else if ((startNum & 128) == 128 && (startNum & 64) == 64 && (startNum & 32) == 0) {
                //2字节，判断后面一个字节格式
                if (start + 1 >= n) {
                    flag = false;
                    return;
                }
                int NextNum = nums[start + 1];
                if (ifYiLing(NextNum)) {
                    helper(n, nums, start + 2);
                } else {
                    flag = false;
                }
            } else if ((startNum & 224) == 224 && (startNum & 16) == 0) {
                //3字节
                if (start + 2 >= n) {
                    flag = false;
                    return;
                }
                if (ifYiLing(nums[start+1])&&ifYiLing(nums[start+2])) {
                    helper(n, nums, start + 3);
                } else {
                    flag = false;
                }
            } else if ((startNum & 240) == 240 && (startNum & 8) == 0) {
                //4字节
                if (start + 3 >= n) {
                    flag = false;
                    return;
                }
                if (ifYiLing(nums[start+1])&&ifYiLing(nums[start+2])&&ifYiLing(nums[start+3])) {
                    helper(n, nums, start + 4);
                } else {
                    flag = false;
                }
            } else {
                //错误编码
                flag = false;
            }
        }
    }

    private static boolean ifYiLing(int n) {
        return (n & 192) == 128;
    }
}
