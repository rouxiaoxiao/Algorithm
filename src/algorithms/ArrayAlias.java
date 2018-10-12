package algorithms;

/**
 * @Author liangxiao
 * @Date 2017/10/20 10:28
 * 数组别名
 */


    //数组的重命名，直接将a数组赋给b，则a,b指向同一个数组
    //改变b中的值也就是改变a中的值
    //数组初始化是0
public class ArrayAlias {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0] =1;
        int[] b = a;
        b[0] = 123;
        Integer.toString(b[0]);
//        System.out.println(getType(b[0]));
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
    public static String getType(Object o){
        return o.getClass().toString();
    }



}
