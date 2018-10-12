package algorithms.sort;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/12/2 19:28
 * 希尔排序
 */
public class ShellSort {
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

    private static void shellSort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;//1,4,13,40,121,...
        }
        while (h >= 1) {
            //将数组变为h有序
            for (int i = h; i < N; i++) {
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }


    //数组形式的希尔排序
    public void shellSort2(int[] a){
        int h=1,tem;
        while (h<a.length/3){
            h=h*3+1;
        }
        while (h>=1){
            for (int i=h;i<a.length;i++){
                for (int j=i;j>=h;j-=h){
                    if (a[j]<a[j-h]){
                        tem=a[j];
                        a[j]=a[j-h];
                        a[j-h]=tem;
                    }
                }
            }
            h=h/3;
        }
    }


    public static void main(String[] args) {
        ShellSort shellSort=new ShellSort();
        Comparable[] a = {1, 4, 3, 6, 7};
        shellSort(a);
        System.out.println(Arrays.toString(a));

        int[] b={1, 4, 3, 6, 7};
        shellSort.shellSort2(b);
        System.out.println(Arrays.toString(b));
    }

}
