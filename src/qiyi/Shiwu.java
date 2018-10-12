package qiyi;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 11:36 2018/9/15
 */
public class Shiwu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int P = in.nextInt();
        int[] Ai = new int[N];
        for (int i = 0; i < N; i++) {
            Ai[i] = in.nextInt();
        }
        int[] Mi = new int[M];
        for (int i = 0; i < M; i++) {
            if (in.next().equals("B")) {
                Mi[i] = (-1) * in.nextInt();
            } else {
                Mi[i] = in.nextInt();
            }
        }
        int[] sortAi = MDayAfter(Ai, Mi);
        System.out.println(sort(sortAi, P));

    }

    private static int[] MDayAfter(int[] Ai, int[] Mi) {

        for (int i = 0; i < Mi.length; i++) {
            int Mii = Mi[i];
            if (Mii > 0) {
                Ai[Mii - 1] = Ai[Mii - 1] + 1;
            } else {
                Ai[-Mii - 1] = Ai[-Mii - 1] - 1;
            }
        }
        return Ai;
    }

    private static int sort(int[] AiSorted, int P) {
        int num = AiSorted[P - 1];
        int count = 1;
        for (int i = 0; i < AiSorted.length; i++) {
            if (AiSorted[i] > num) {
                count++;
            }
        }
        return count;
    }
}
