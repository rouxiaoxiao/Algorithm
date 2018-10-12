package zhaohang;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:31 2018/9/16
 */
public class Tiaogezi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(JumpFloor(in.nextInt()));
    }

    public static int JumpFloor(int target) {

        //需要初始化次数，弯弯需要绕明白
        int kinds = 0;
        if (target == 1) {
            kinds = 1;
        } else if (target == 2) {
            kinds = 2;
        } else {
            kinds += JumpFloor(target - 1) + JumpFloor(target - 2);
        }
        return kinds;
    }
}
