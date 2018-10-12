package tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 11:04 2018/9/16
 */
public class Girl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            boolean flag = false;
            for (int p = 1; p < 100; p++) {
                if ((a * p) % b == c) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.println("NO");
            }

        }
    }
}
