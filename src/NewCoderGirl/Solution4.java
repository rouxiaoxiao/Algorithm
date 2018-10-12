package NewCoderGirl;

/**
 * @author liangxiao
 * @date 2017/12/23 16:11
 */

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int v = in.nextInt();
        int[][] nums = new int[s][5];
        for (int m = 0; m < s; m++) {
            for (int n = 0; n < 5; n++) {
                nums[m][n] = in.nextInt();
            }
        }


        int sum = 0;
        for (int j = 0; j < 5; j++) {
            sum = sum + Math.max(nums[0][j],nums[2][j]);


        }
        System.out.println(sum);
    }

}
