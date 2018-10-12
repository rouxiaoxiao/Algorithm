package algorithms;

import java.util.Arrays;

/**
 * @Author liangxiao
 * @Date 2017/10/17 19:16
 * 二分查找
 */
public class BinarySearch {
    public static int rank(int key,int[] a ){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if (key < a[mid]) {
                hi=mid-1;
            }
            else if(key > a[mid]){
                lo=mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a ={1,10,4,99,7,9,10,13,14};
        Arrays.sort(a);
        Math.abs(-2147483648);
        double d=Double.POSITIVE_INFINITY;
        double p=Double.NEGATIVE_INFINITY;
        int u=3;
        if (u<3.1){
            System.out.println(getType(u));
        }
        int q=-4,f=3;
        int c=q/f;
        System.out.println("向零取整："+c);
        System.out.println(d+"分割"+p);
        System.out.println(Arrays.toString(a));
        System.out.println("连接一个非字符串输出的数组会自动转换为字符串："+a);
        System.out.println(rank(14,a));

    }
    public static String getType(Object o){
        return o.getClass().toString();
    }
}
