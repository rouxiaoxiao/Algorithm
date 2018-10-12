package algorithms.sort;

import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/11/29 17:50
 * 最简单的排序方法
 *
 */
public class EasiestSort {
    static int[] EasiestSort(int[] a){
        int i,j,tem;
        for (i=0;i<a.length;i++){
            for (j=i+1;j<a.length;j++){
                if (a[i]>a[j]){
                    tem=a[i];
                    a[i]=a[j];
                    a[j]=tem;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={21,4,5,6,2,8};
        System.out.println(Arrays.toString(EasiestSort(a)));
        System.out.println(Arrays.toString(a));
    }
}
