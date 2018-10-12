package tencent;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int A = sc.nextInt();
        int X = sc.nextInt();
        int B = sc.nextInt();
        int Y = sc.nextInt();
        int result = helper(K, A, X, B, Y);
        System.out.println(result);
    }

    private static int helper(int K, int A, int X, int B, int Y) {
        ArrayList<Integer> xs = new ArrayList<Integer>();
        ArrayList<Integer> ys = new ArrayList<Integer>();
        int index = 0;
        int result = 0;
        for (int i = 0; i < K / A && i <= X && ((K - A * i) / B) <= Y; i++) {
            int j = (K - A * i) / B;
            if (A * i + B * j == K) {
                xs.add(index, i);
                ys.add(index, j);
                index++;
            }
        }
        for (int m = 0; m < index; m++) {
            int i = xs.get(m);
            int j = ys.get(m);
            int countx = jiecheng(X) / (jiecheng(i) * jiecheng(X - i));//A长的可选方案
            int county = jiecheng(Y) / (jiecheng(j) * jiecheng(Y - j));//B长的可选方案
            int count = countx * county;//这种方案的总取法
            result = result + count;
        }
        return result % 1000000007;
    }

    private static int jiecheng(int n) {
        int jiecheng = 1;
        for (int i = 1; i <= n; i++) {
            jiecheng = jiecheng * i;
        }
        return jiecheng;
    }

}
