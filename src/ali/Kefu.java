package ali;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 19:58 2018/5/11
 */
public class Kefu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) {
            String line = sc.next();
            String[] numss = line.split(",");
            nums[i][0] = Integer.parseInt(numss[0]);
            nums[i][1] = Integer.parseInt(numss[1]);

        }
        if (helper(n, nums)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }


    private static boolean helper(int n, int[][] nums) {
        if (n<0){
            return false;
        }
        int[] book = new int[n * 2 + 1];
        //初始化一个标记数组
        for (int i = 1; i <= n * 2; i++) {
            book[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] > nums[i][1]) {
                int temp = nums[i][0];
                nums[i][0] = nums[i][1];
                nums[i][1] = temp;
            }
            if (nums[i][0] % 2 == 0) {
                book[nums[i][1]] = nums[i][0] - 1;
            } else {
                book[nums[i][1]] = nums[i][0] + 1;
            }
            if (book[nums[i][1]] % 2 == 0) {
                if (book[nums[i][1]] == book[nums[i][1] - 1]) {
                    return false;
                }
            } else {
                if (book[nums[i][1]] == book[nums[i][1] + 1]) {
                    return false;
                }
            }
        }
        for (int i = 1; i <= n * 2; i++) {
            if (i % 2 == 0 && book[i] == book[i - 1]) {
                return false;
            } else if (i % 2 != 0 && book[i] == book[i + 1]) {
                return false;
            }

        }

        return true;
    }
}
