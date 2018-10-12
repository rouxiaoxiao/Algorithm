package algorithms;

/**
 * @Author liangxiao
 * @Date 2017/10/15 19:15
 * 求最大公约数
 *
 */
public class gcd {
    public static int gcd(int p,int q){
        if (q==0) {
            return p;
        }

        int r = p%q;
        return gcd(q,r);
    }

    public static int remainder(int p,int q){
        return p%q;
    }

    public static boolean testRemainder(int p,int q){
        int x = p%q;
        int y = q%p;
        if (x==y) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(2,4));
        System.out.println(remainder(2,4));
        System.out.println(testRemainder(3,4));
    }
}
