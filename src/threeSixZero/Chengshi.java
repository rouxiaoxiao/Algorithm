package threeSixZero;

import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:56 2018/8/27
 * 题目：城市需要修建，N个民居坐标，都要包进城市，问城市的最小面积（城市为平行于坐标轴的正方形）
 * 输入：
 * 2
 * 0 0
 * 2 2
 * <p>
 * 输出：4
 * <p>
 * 输入：
 * 2
 * 0 0
 * 0 3
 * 输出：9
 *
 *
 * 注意取值范围 定义数据类型
 */
public class Chengshi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] heng = new int[n];
        int[] zong = new int[n];
        for (int i = 0; i < n; i++) {
            heng[i] = in.nextInt();
            zong[i] = in.nextInt();
        }
        int hengCha = findMaxS(heng);
        int zongCha = findMaxS(zong);
        int result = hengCha > zongCha ? (hengCha * hengCha) : (zongCha * zongCha);
        System.out.println(result);
    }

    private static int findMaxS(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return max - min;
    }
}
