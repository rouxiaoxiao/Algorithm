package offer;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/11/24 17:10
 *
 * 调整数组顺序使奇数位于偶数前面
 */
public class ReOrderArray {
    /**
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.終止條件：j向後遍歷查找失敗。
     */
    public static void reOrderArray(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int i = 0, j;
        while (i < a.length) {
            while (i < a.length && !isEven(a[i])) {
                i++;
            }
            j = i + 1;
            while (j < a.length && isEven(a[j])) {
                j++;
            }
            if (j < a.length) {
                int tmp = a[j];
                for (int j2 = j - 1; j2 >= i; j2--) {
                    a[j2 + 1] = a[j2];
                }
                a[i++] = tmp;
            } else {// 查找失敗
                break;
            }
        }
    }

    static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }

    /**
     * 整体思路：
     * 首先统计奇数的个数
     * 然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始 遍历，填数
     */
    public static void reOrderArray2(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return;
        }
        int oddCount = 0, oddBegin = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddCount++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                newArray[oddBegin++] = array[i];
            } else {
                newArray[oddCount++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[i];
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray2(b);
        System.out.println(Arrays.toString(b));
    }
}
