package didi;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:07 2018/9/18
 */
public class Pailiexiaoqiu {
    private static int countSum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int np = in.nextInt();
        int nq = in.nextInt();
        int nr = in.nextInt();
        int n = np + nq + nr;
        int[] book = new int[n];
        count(book, 0, n, np, nq, nr);
        System.out.println(countSum);

    }

    private static void count(int[] book, int index, int n, int np, int nq, int nr) {
        if (index == n) {
            countSum++;
        }
        if (np > 0 && (index == 0 || book[index - 1] != 1)) {
            book[index] = 1;
            count(book, index + 1, n, np - 1, nq, nr);
        }
        if (nq > 0 && (index == 0 || book[index - 1] != 2)) {
            book[index] = 2;
            count(book, index + 1, n, np, nq - 1, nr);
        }
        if (nr > 0 && (index == 0 || book[index - 1] != 3)) {
            book[index] = 3;
            count(book, index + 1, n, np, nq, nr - 1);
        }
    }
}
