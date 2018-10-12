package kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 16:41 2018/9/7
 */
public class Gaichengji {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int j = 0; j < T; j++) {
            int n = in.nextInt();
            int X = in.nextInt();
            int[] stu = new int[n];
            for (int i = 0; i < n; i++) {
                stu[i] = in.nextInt();
            }
            System.out.println(helper(n, stu, X));
        }
    }

    private static int helper(int n, int[] stu, int X) {
        int[] fen = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            fen[i] = 100 - stu[i];
            sum = sum + stu[i];
        }
        Arrays.sort(fen);
        int cha = X * n - sum;
        int count = 0;
        if (cha <= 0) {
            return count;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (cha <= 0) {
                break;
            }
            cha = cha - fen[i];
            count++;
        }
        return count;
    }
}
