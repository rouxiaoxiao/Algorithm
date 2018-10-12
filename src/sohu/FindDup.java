package sohu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:35 2018/9/15
 */
public class FindDup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] cs = line.split(" ");
        int[] nums = new int[cs.length];
        int n = cs.length - 1;
        for (int i = 0; i < cs.length; i++) {
            nums[i] = Integer.parseInt(cs[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + i;
        }
        int cssum = 0;
        for (int i = 0; i < cs.length; i++) {
            cssum = cssum + nums[i];
        }
        System.out.println(cssum-sum);
    }
}
