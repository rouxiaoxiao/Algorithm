package nineChapter.chapter2;

import java.util.Arrays;

/**
 * 二分法的通用模板
 *
 * @Author: liangxiao
 * @Date: Created in 11:25 2018/5/15
 */
public class BinarySearchCommon {
    public static void main(String[] args) {
        int[] nums={2,4,5,6,8,32};
        Arrays.sort(nums);
        System.out.println(binarySearch(nums,9));
    }
    // version 1: with jiuzhang template
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
                // or start = mid + 1
            } else {
                end = mid;
                // or end = mid - 1
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

//     version 2: without jiuzhang template
    public static int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
}
