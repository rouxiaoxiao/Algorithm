package ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 19:52 2018/9/7
 */
public class Hema {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dian = in.nextLine();
        String mian = in.nextLine();
        System.out.println(Arrays.deepToString(handleMian(mian)));
        int[][] dingdian = handleMian(mian);
        System.out.println("yes,0");

    }

    private static int[][] handleMian(String mian) {
        String[] dingdian = mian.split(",");
        int length = dingdian.length;
        int[][] result = new int[length / 2][2];
        for (int i = 0; i < length / 2; i++) {
            result[i][0] = Integer.parseInt(dingdian[2 * i]);
            result[i][1] = Integer.parseInt(dingdian[2 * i + 1]);
        }
        return result;
    }



}
