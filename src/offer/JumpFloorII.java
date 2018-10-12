package offer;

/**
 * @author liangxiao
 * @date 2017/11/17 17:39
 * <p>
 * 变态跳台阶（每次可跳1,2，...,n阶）
 */
public class JumpFloorII {
    static int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(5));
    }
}
