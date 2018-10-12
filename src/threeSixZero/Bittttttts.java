package threeSixZero;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:14 2018/9/17
 */
public class Bittttttts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int[] ks = new int[q];
        int[] ls = new int[q];
        int[] rs = new int[q];
        for (int i = 0; i < q; i++) {
            ks[i] = in.nextInt();
            ls[i] = in.nextInt();
            rs[i] = in.nextInt();
        }
        for (int i=0;i<q;i++){
            System.out.println(helper(ks[i], ls[i], rs[i]));
        }

    }

    private static int helper(int k, int l, int r) {
        int result = -1;
        int count = 0;
        for (int i = l; i <= r; i++) {
            int temp = i;
            int counttemp = 0;
            while (temp / k != 0) {
                if (temp % k == (k - 1)) {
                    counttemp++;
                }
                temp = temp / k;
            }
            if (temp % k == (k - 1)) {
                counttemp++;
            }
            if (counttemp > count) {
                count = counttemp;
                result = i;
            }
        }
        return result;
    }
}
