package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 19:46 2018/9/7
 */
public class Shuzu {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int[] book = new int[n];
        helper(n, A, book);
        System.out.println(count);

    }

    private static void helper(int n, int[] A, int[] book) {
        boolean quan1 = true;
        for (int i = 0; i < n; i++) {
            if (book[i] == 0) {
                quan1 = false;
                break;
            }
        }
        if (quan1) {
            count++;
        }
        List<Integer> templist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (book[i] != 0) {
                continue;
            }
            templist.add(A[i]);
            if (templist.size() > 2 && !ifOk(templist)) {
                break;
            }
            book[i] = 1;
            helper(n, A, book);
            //回溯
            templist.remove(templist.size() - 1);
            book[i] = 0;
        }
    }


    //判断是否为等差等比且长度大于2
    private static boolean ifOk(List<Integer> list) {
        if (list.size() < 3) {
            return false;
        }
        boolean flag1 = true;
        boolean flag2 = true;

        int cha = list.get(1) - list.get(0);
        double shang = list.get(1) / list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) != cha) {
                flag1 = false;
                break;
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) / list.get(i) != shang) {
                flag2 = false;
                break;
            }
        }
        return flag1 || flag2;
    }
}
