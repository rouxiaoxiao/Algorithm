package offer.Chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题3：数组中的重复数字
 *
 * @Author: liangxiao
 * @Date: Created in 8:43 2018/8/19
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] results = new int[1];
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        findDuplicate2(nums, results);
        System.out.println(results[0]);
    }


    //普通方法
    private static int findDuplicate1(int[] nums) {
        int length = nums.length;
        Set<Integer> integerSet = new HashSet<Integer>();
        for (int i = 0; i < length; i++) {
            if (integerSet.contains(nums[i])) {
                return nums[i];
            }
            integerSet.add(nums[i]);
        }
        return -1;
    }

    //不占用额外空间，复杂度O(n)的算法
    private static boolean findDuplicate2(int[] nums, int[] duplication) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int index = nums[i];
            //按着数组中的值找到对应索引位置的值，看是否是被标记过得
            if (index >= length) {
                index = nums[i] - length;
            }

            if (nums[index] >= length) {
                duplication[0] = index;
                return false;
            }
            //每次第i个数组中数字索引的位置的数字都要加length，标记已经有过
            nums[index] = nums[index] + length;
        }
        return true;
    }
}
