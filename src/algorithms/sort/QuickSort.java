package algorithms.sort;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/11/23 15:57
 * 快速排序
 */
public class QuickSort {

    //less()对元素进行比较
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //exch()将元素交换位置
    private void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            //扫描左右，检查是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);//将v=a[j]放入正确的位置
        return j;//a[lo..j-1],a[j],a[j+1..hi]达成
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);//切分
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    void sort(Comparable[] a) {
//        StdRandom.shuffle(a); //消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Comparable[] a = {1, 2, 4, 3, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
