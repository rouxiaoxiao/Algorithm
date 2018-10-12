package algorithms.sort;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/11/29 19:36
 * 插入排序
 */
public class InsertSort {

    //less()对元素进行比较
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //exch()将元素交换位置
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void insertSort(Comparable[] a) {
        int N=a.length;
        for (int i=1;i<N;i++){
            for (int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }

    public void insertSort2(int[] a){
        int tem;
        for (int i=1;i<a.length;i++){
            for (int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    tem=a[j];
                    a[j]=a[j-1];
                    a[j-1]=tem;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort=new InsertSort();
        Comparable[] a = {21, 4, 5, 6, 2, 8};
        insertSort(a);
        System.out.println(Arrays.toString(a));
        int[] b={21, 4, 5, 6, 2, 8};
        insertSort.insertSort2(b);
        System.out.println(Arrays.toString(b));
    }
}
