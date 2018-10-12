package toutiao;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 19:16 2018/10/8
 */
public class MeiLiShu {
    private static int mo = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        System.out.println(countBeautiful(a, b, k));
    }

    private static int countBeautiful(int a, int b, int k) {
        int count = 0;
        list:
        for (int num = (int) Math.pow(10, k - 1); num < (int) Math.pow(10, k); num++) {
            int tempNum = num;
            int sum = 0;
            int naWei = 1;
            while (tempNum / 10 != 0) {
                int wei = tempNum % 10;
                if (!(wei == a || wei == b)) {
                    num = (tempNum + 1) * (int) Math.pow(10, naWei - 1) - 1;
                    continue list;
                }
                sum = sum + wei;
                if (sum > 9) {
                    num = (tempNum / 10 + 1) * (int) Math.pow(10, naWei) - 1;
                    continue list;
                }
                tempNum = tempNum / 10;
                naWei++;
            }
            if (!(tempNum == a || tempNum == b)) {
                num = (tempNum + 1) * (int) Math.pow(10, naWei - 1) - 1;
                continue list;
            }
            sum = sum + tempNum;
            if (!(sum == a || sum == b)) {
                num = (tempNum / 10 + 1) * (int) Math.pow(10, naWei) - 1;
                continue list;
            }
            count++;
            if (count >= mo) {
                count = count - mo;
            }
        }
        return count;
    }
}
