package algorithms.sort;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/11/29 19:19
 * 选择排序
 */
public class SelectSort {
    static int[] selectSort(int[] a) {
        int i, j, tem;
        for (i = 0; i < a.length - 1; i++) {
            int min = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (i != min) {
                tem = a[min];
                a[min] = a[i];
                a[i] = tem;
            }


        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {21, 4, 5, 6, 2, 8};
        System.out.println(Arrays.toString(selectSort(a)));
    }
}
