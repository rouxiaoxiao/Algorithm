package toutiao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 11:28 2018/9/9
 */

public class ip {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ip = in.nextInt();
        int[] nums = putInInts(ip);
        helper(nums, 0, 0);
        System.out.println(count);

    }


    private static void helper(int[] nums, int index, int lunshu) {
        if (nums.length < 4) {
            return;
        }
        if (index >= nums.length) {
            return;
        }
        if (index == nums.length - 1 && lunshu == 3) {
            count++;
        }
        if(lunshu==3&&nums.length-index>3){
            return;
        }
        int sanwei = -1;
        int erwei = -1;
        for (int i = index; i < 3 + index; i++) {
            if (index + 2 < nums.length) {
                sanwei = nums[index] * 100 + nums[index + 1] * 10 + nums[index + 2];
            }
        }
        for (int i = index; i < 2 + index; i++) {
            if (index + 1 < nums.length) {
                erwei = nums[index] * 10 + nums[index + 1];
            }
        }
        int yiwei = nums[index];
        if (ifOk(yiwei)) {
            helper(nums, index + 1, lunshu + 1);
        }
        if (ifOk(erwei)) {
            helper(nums, index + 2, lunshu + 1);
        }
        if (ifOk(sanwei)) {
            helper(nums, index + 3, lunshu + 1);
        }
    }

    //将ip放入数组
    private static int[] putInInts(int ip) {
        int weishu = weishu(ip);
        int[] nums = new int[weishu];
        int index = weishu - 1;
        while (ip / 10 != 0) {
            nums[index] = ip % 10;
            ip = ip / 10;
            index--;
        }
        nums[index] = ip;
        return nums;

    }

    //判断单个位置上的值是否符合要求
    private static boolean ifOk(int n) {
        return n >= 0 && n < 256;
    }

    //计算位数
    private static int weishu(int ip) {
        int weishu = 0;
        int temp = ip;
        while (temp / 10 != 0) {
            weishu++;
            temp = temp / 10;
        }
        return weishu + 1;
    }
}
