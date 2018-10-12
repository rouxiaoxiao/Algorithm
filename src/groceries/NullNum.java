package groceries;

/**
 * @author liangxiao
 * @date 2017/12/6 16:20
 * 数组长度为0和数组为空
 */
public class NullNum {

    public static void main(String[] args) {
        int[] a;
        int[] b=null;
        int[] c=new int[0];
//        if (a==null||a.length==0){
//            System.out.println("a,haha");
//        }
        //提示未初始化变量
//        if (b.length==0){
//            System.out.println("b的长度为0");
//        }

        if (c==null){
            System.out.println("c是null");
        }
//所以一般要用if(a==null||a.length==0)，顺序不能改，否则报错，利用了||的短路特性
    }
}
