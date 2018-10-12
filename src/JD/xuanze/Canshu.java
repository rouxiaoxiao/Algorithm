package JD.xuanze;

/**
 * @Author: liangxiao
 * @Date: Created in 22:52 2018/9/10
 */
public class Canshu {
    private static int x = 3;
    private static Integer y = 3;

    private static void updateX(int value) {
        value = 3 * value;
    }

    private static void updateY(int value) {
        value = 3 * value;
    }

    public static void main(String[] args) {
        updateX(x);
        updateY(y);
        System.out.println(x + "...." + y);
    }

}
