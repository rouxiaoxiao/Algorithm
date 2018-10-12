package groceries;

import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//工作数
        System.out.println(n);
        int m = sc.nextInt();//人数
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                jobs[i][0] = sc.nextInt();
                jobs[i][1] = sc.nextInt();
                ;
            }
        }

        System.out.println(n);
        int[] power = new int[m];
        int[] result = helper(jobs, power);
        for (int i = 0; i < power.length; i++) {
            System.out.println(result[i]);
        }

    }

    private static int[] helper(int[][] jobs, int[] power) {
        int[] result = new int[power.length];
        for (int j = 0; j < power.length; j++) {
            for (int i = 0; i < jobs.length; i++) {
                if (power[j] >= jobs[i][0] && jobs[i][0] > result[j]) {
                    result[j] = jobs[i][1];
                }
            }
        }
        return result;
    }
}