package algorithms.sort;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/11/29 18:50
 * 冒泡排序
 */


public class BubbleSort {

    //正确实例
    private static int[] bubbleSort(int[] a) {
        int i, j, tem;
        for (i = 0; i < a.length - 1; i++) {
            for (j = a.length - 2; j >= i; j--) {
                if (a[j] > a[j + 1]) {
                    tem = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tem;
                }
            }
        }
        return a;
    }

    private static int[] bubbleSort4(int[] a) {
        int i, j, tem;
        for (i = 0; i < a.length - 1; i++) {
            for (j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    tem = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tem;
                }
            }
        }
        return a;
    }


    //错误实例
    static int[] bubbleSort2(int[] a) {
        int i, j, tem;
        for (j = 0; j < a.length - 1; j++) {
            for (i = j; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    tem = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tem;
                }
            }
        }
        return a;
    }

    //(错误示例修改)
    static int[] bubbleSort3(int[] a) {
        int i, j, tem;
        for (j = 0; j < a.length - 1; j++) {
            for (i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    tem = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tem;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {

        int[] b = {21, 4, 5, 6, 2, 8};
        System.out.println("正确冒泡：" + Arrays.toString(bubbleSort(b)));
        int[] d = {21, 4, 5, 6, 2, 8};
        System.out.println("改变索引后的冒泡："+Arrays.toString(bubbleSort4(d)));
        int[] a = {21, 4, 5, 6, 2, 8};
        System.out.println("错误冒泡：" + Arrays.toString(bubbleSort2(a)));
        int[] c = {21, 4, 5, 6, 2, 8};
        System.out.println("错误代码修改后：" + Arrays.toString(bubbleSort3(b)));
    }
}
