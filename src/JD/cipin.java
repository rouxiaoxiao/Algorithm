package JD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:01 2018/9/9
 */
public class cipin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
            nums[i][2] = in.nextInt();
        }
        int[] book = new int[n];
        System.out.println(numOfBook(helper(n, nums, book)));
        System.out.println(Arrays.deepToString(nums));
    }

    private static int numOfBook(int[] book) {
        int count = 0;
        for (int i = 0; i < book.length; i++) {
            if (book[i] == 1) {
                count++;
            }
        }
        return count;
    }

    //标记次品位置
    private static int[] helper(int n, int[][] nums, int[] book) {
        for (int i = 1; i < n; i++) {
            //之前添加的数组
            for (int j = 0; j < i; j++) {
                int compareRes = compare(nums[i], nums[j]);
                if (compareRes == 0) {
                    continue;
                } else if (compareRes == -1) {
                    book[i] = 1;
                } else {
                    book[j] = 1;
                }
            }

        }
        return book;
    }

    //如果o1均小于o2，输出-1，如果o1均大于o2，返回1，否则返回0
    private static int compare(int[] o1, int[] o2) {
        if (o1[0] < o2[0] && o1[1] < o2[1] && o1[2] < o2[2]) {
            return -1;
        } else if (o1[0] > o2[0] && o1[1] > o2[1] && o1[2] > o2[2]) {
            return 1;
        }
        return 0;
    }
}
