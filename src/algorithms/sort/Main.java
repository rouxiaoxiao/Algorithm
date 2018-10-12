package algorithms.sort;

import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//数组数目
        int[][] num = new int[n][5];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                num[i][j] = sc.nextInt();
                sum[i] = sum[i] + num[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            if (sum[i] % 5 == 0) {
                System.out.println(sum[i] / 5);
            } else {
                System.out.println(-1);
            }
        }
    }

}
