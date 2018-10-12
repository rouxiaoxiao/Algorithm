package offer;

/**
 * @author liangxiao
 * @date 2017/11/17 16:36
 * <p>
 * 跳台阶（斐波那契数列）
 */
public class JumpFloor {
    static int JumpFloor(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(6));
    }
}
