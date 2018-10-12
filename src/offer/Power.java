package offer;

import java.nio.DoubleBuffer;

/**
 * @author liangxiao
 * @date 2017/11/23 11:46
 *
 * 数值的整数次方
 */
public class Power {
    public static double Power(double base, int n) {
        double res = 1, curr = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不能为0");
            }
            exponent = -n;
        } else {// n==0
            return 1;// 0的0次方
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1) {
                res *= curr;
            }
            curr *= curr;// 翻倍
            exponent >>= 1;// 右移一位
        }
        return n >= 0 ? res : (1 / res);
    }

    public static void main(String[] args) {
        System.out.println(Power(0, 0));
        //double类型不能用==直接比较，因为浮点数精度丢失问题
        //根本原因在于，数学意义上的小数不是每个都能用二进制在有限位数内精确的表示。
        //像 0.1，1.1 这样的小数没有精确的二进制表示，然后求和就不是1.2了。
        double a=1.1+0.1;
        double b=1.2;
        if (a==b){
            System.out.println("haha");
        }
    }
}
