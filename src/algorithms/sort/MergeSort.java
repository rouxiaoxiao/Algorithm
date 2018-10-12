package algorithms.sort;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/11/23 15:12
 * 归并排序(自顶向下)
 */
public class MergeSort {
    //归并所需的辅助函数
    private static Comparable[] aux;

    //less()对元素进行比较
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //将a[lo...mid]和a[mid+1...hi]归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //将a[lo..hi]复制到aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    //将数组a[lo..hi]排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Comparable[] a = {1, 2, 6, 4, 5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
