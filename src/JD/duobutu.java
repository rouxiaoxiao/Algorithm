package JD;

import java.util.*;

/**
 * @Author: liangxiao
 * @Date: Created in 20:31 2018/9/9
 */
public class duobutu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] nums = new int[M][2];
            for (int j = 0; j < M; j++) {
                nums[j][0] = in.nextInt();
                nums[j][1] = in.nextInt();
            }
            System.out.println(helper(M, nums));
            Map<Integer, Set<Integer>> map = helper(M, nums);
            if (N>map.size()){
                System.out.println("No");
            }
            for (int k = 0; k < N; k++) {

            }
        }
    }

    private static Map<Integer, Set<Integer>> helper(int M, int[][] nums) {
        Map<Integer, Set<Integer>> results = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int a = nums[i][0];
            int b = nums[i][1];
            if (results.containsKey(a)) {
                results.get(a).add(b);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(b);
                results.put(a, set);
            }
            if (results.containsKey(b)) {
                results.get(b).add(a);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(a);
                results.put(b, set);
            }
        }
        return results;
    }
}
