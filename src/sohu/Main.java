package sohu;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int sig = sc.nextInt();
            if (sig == 1) {
                ArrayList<Integer> input1 = new ArrayList<Integer>();
                for (int j = 0; j < 3; j++) {
                    input1.add(sc.nextInt());
                }
                result1.add(input1);
                continue;
            }
            if (sig == 2) {
                ArrayList<Integer> input2 = new ArrayList<Integer>();
                for (int j = 0; j < 2; j++) {
                    input2.add(sc.nextInt());
                }
                result2.add(input2);
                continue;
            }

        }
        System.out.println(input1helper() + input2helper());
    }

    //每日成长值
    private static int input1helper() {
        int[] meirifenzhi = new int[1000000];
        for (int i = 0; i < meirifenzhi.length; i++) {
            meirifenzhi[i] = Integer.MIN_VALUE;
        }
        int sum = 0;
        for (int i = 0; i < result1.size(); i++) {
            int start = result1.get(i).get(0);
            int end = result1.get(i).get(1);
            int fenzhi = result1.get(i).get(2);
            for (int j = start; j <= end; j++) {
                if (j < meirifenzhi.length && meirifenzhi[j] < fenzhi) {
                    meirifenzhi[j] = fenzhi;
                } else if (j >= meirifenzhi.length) {
                    meirifenzhi[j] = fenzhi;
                }
            }
        }
        for (int i = 0; i < meirifenzhi.length; i++) {
            if (meirifenzhi[i] != Integer.MIN_VALUE) {
                sum = meirifenzhi[i] + sum;
            }

        }
        return sum;
    }

    //任务成长值
    private static int input2helper() {
        int[] renwu = new int[1000000];
        for (int i = 0; i < renwu.length; i++) {
            renwu[i] = Integer.MIN_VALUE;
        }
        int sum = 0;
        for (int i = 0; i < result2.size(); i++) {
            int index = result2.get(i).get(0);
            int fenzhi = result2.get(i).get(1);
            if (renwu[index] < fenzhi) {
                renwu[index] = fenzhi;
            }
        }
        for (int i = 0; i < renwu.length; i++) {
            if (renwu[i] != Integer.MIN_VALUE) {
                sum = renwu[i] + sum;
            }
        }
        return sum;


    }
}
