package beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:03 2018/8/18
 *
 * 第1题：
 * n个社团占一间教室，每个社团占用时间为[li,ri]
 * 必须且最多取消一个社团，让剩下的社团满足不重复，当[1,3] [3,10]这种的不重复
 *
 * 输入用例：3      3 10   20 30   1 3  输出为：3 [1,2,3]
 * 输入用例：3     1 5    2 6   3 7  输出为：0 []
 * 输入用例：4    3 10   20 30  1 3   1 39   输出为：1 [4]
 */
public class Shetuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        int min = (int) Math.pow(10, 6);
        int max = 0;

        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }
        //找出最大最小值
        for (int i = 0; i < n; i++) {
            if (nums[i][0] > max) {
                max = nums[i][0];
            }
            if (nums[i][0] < min) {
                min = nums[i][0];
            }
            if (nums[i][1] > max) {
                max = nums[i][1];
            }
            if (nums[i][1] < min) {
                min = nums[i][1];
            }
        }
        List<Integer> results = new ArrayList<Integer>();
        results = numOfTeam(n, nums, min, max);
        System.out.println(results.size() + " " + results);
    }


    private static List<Integer> numOfTeam(int n, int[][] nums, int min, int max) {
        List<Integer> results = new ArrayList<Integer>();

        //依次减去一个社团
        for (int x = 0; x < n; x++) {
            int[] time = new int[max];
            //减去出去的社团
            //遍历所有社团
            for (int i = 0; i < n; i++) {
                //做一个时间轴标记数组
                if (i == x) {
                    continue;
                }
                int start = nums[i][0];
                int end = nums[i][1];
                for (int j = start; j < end; j++) {
                    time[j] = time[j] + 1;
                }
            }
            int timeMax = 0;
            for (int i = min; i < max; i++) {
                if (time[i] > timeMax) {
                    timeMax = time[i];
                }
                if (time[i] >= 2) {
                    break;
                }
            }
            if (timeMax < 2) {
                results.add(x + 1);
            }
        }
        return results;
    }
}
