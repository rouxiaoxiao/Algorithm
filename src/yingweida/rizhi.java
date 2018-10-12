package yingweida;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 日志分析
 * @Author: liangxiao
 * @Date: Created in 20:13 2018/9/4
 */
public class rizhi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String[] rizhi = new String[n];
            in.nextLine();
            for (int i = 0; i < n; i++) {
                rizhi[i] = in.nextLine().split("]: ")[0].replace("[", "");
            }
            System.out.println(helper(n, rizhi));
        }

    }

    private static int helper(int n, String[] rizhi) {
        int count = 1;

        for (int i = 0; i < n - 1; i++) {
            int result = compare(rizhi[i], rizhi[i + 1]);
            if (result == 1) {
                count++;
            }
            int minCount = 0;
            while (result == 0) {
                minCount++;
                i++;
                result = compare(rizhi[i], rizhi[i + 1]);
                if (minCount == 10) {
                    count++;
                    i--;
                    break;
                }
            }
        }
        return count;
    }

    //1比2小返回-1，比2大返回1，相等返回0
    private static int compare(String s1, String s2) {
        int hour1 = Integer.parseInt(s1.split(" ")[0].split(":")[0]);
        int hour2 = Integer.parseInt(s2.split(" ")[0].split(":")[0]);
        int min1 = Integer.parseInt(s1.split(" ")[0].split(":")[1]);
        int min2 = Integer.parseInt(s2.split(" ")[0].split(":")[1]);
        String biaozhi1 = s1.split(" ")[1];
        String biaozhi2 = s2.split(" ")[1];
        if ("a.m.".equals(biaozhi1) && "a.m.".equals(biaozhi2)) {
            return compareTime(hour1, hour2, min1, min2);
        } else if ("a.m.".equals(biaozhi1) && "p.m.".equals(biaozhi2)) {
            return -1;
        } else if ("p.m.".equals(biaozhi1) && "a.m.".equals(biaozhi2)) {
            return 1;
        } else {
            return compareTime(hour1, hour2, min1, min2);
        }
    }

    //相同上下午的比较
    private static int compareTime(int hour1, int hour2, int min1, int min2) {
        if (hour1 == hour2) {
            if (min1 == min2) {
                return 0;
            } else if (min1 > min2) {
                return 1;
            } else {
                return -1;
            }
        } else if (hour1 > hour2) {
            return 1;
        } else {
            return -1;
        }
    }
}
