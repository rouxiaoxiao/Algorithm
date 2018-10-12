package offer;


/**
 * @author liangxiao
 * @date 2017/11/23 10:12
 *
 * 二进制中1的个数
 */
public class NumberOf1 {
    //选用的32位二进制
    //补码为反码加1
    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            //&&只要第一个条件不满足，后面条件就不再判断。而&要对所有的条件都进行判断。
            //int在进行逻辑运算时就已经进行二进制转换了
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    public static int NumberOf1a(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-1));
        System.out.println(NumberOf1a(-0));
    }
}
