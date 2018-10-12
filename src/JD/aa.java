package JD;

import java.util.ArrayList;
import java.util.Scanner;


//多部图的大神题解
public class aa {

    static class M {

        public void init() {
            Scanner aa = new Scanner(System.in);
            int J = aa.nextInt();
            for (int JD = 1; JD <= J; JD++) {
                int n = aa.nextInt();
                long m = aa.nextInt();
                int a[][] = new int[n][n];
                for (long i = 0; i < m; i++) {
                    int x = aa.nextInt();
                    int y = aa.nextInt();
                    a[x - 1][y - 1] = 1;
                    a[y - 1][x - 1] = 1;
                }
                if (m == 0) {
                    System.out.println("Yes");
                    continue;
                }
                boolean[] flag = new boolean[n];
                boolean res = true;
                while (true) {
                    ArrayList<Integer> list2 = new ArrayList<>();
                    int index = -1;
                    for (int i = 0; i < n; i++) {
                        if (flag[i] == false) {
                            index = i;
                            break;
                        }
                    }
                    //标记数组全为true 则跳出循环
                    if (index == -1)
                        break;
                    list2.add(index);
                    flag[index] = true;
                    for (int i = 0; i < n; i++) {
                        if (i != index && flag[i] == false && a[index][i] == 0) {
                            list2.add(i);
                            flag[i] = true;
                        }
                    }
                    if (!isRight(list2, a)) {
                        res = false;
                        break;
                    }
                    list2.clear();
                }
                if (res)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }

        public boolean isRight(ArrayList<Integer> list, int a[][]) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < a.length; j++) {
                    if (list.contains(j)) {
                        if (a[list.get(i)][j] == 1)
                            return false;
                    } else {
                        if (a[list.get(i)][j] == 0)
                            return false;
                    }
                }
            }
            return true;
        }

    }

    public static void main(String[] argsa) {
        new M().init();

    }
}