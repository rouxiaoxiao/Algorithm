package nineChapter.chapter1;

import java.util.*;

/**
 * 全子集问题
 * 给定一个含不同整数的集合，返回其所有的子集
 * If S = [1,2,3], a solution is:[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 *
 * @Author: liangxiao
 * @Date: Created in 23:25 2018/5/2
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = subsets1(nums);
        System.out.println(results);
        for (int j = 0; j < 3; j++) {
            System.out.println(1 << j);
        }
    }


    //法1：通用版DFS
    private static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        helper1(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }

    private static void helper1(ArrayList<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(subset));//一定要创建一个新的对象，不然会被覆盖
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper1(subset, nums, i + 1, results);
            //回溯
            subset.remove(subset.size() - 1);
        }
    }


    //法二：广度优先搜索
    private static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);

        //BFS
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        queue.offer(new LinkedList<Integer>());

        while (!queue.isEmpty()) {
            List<Integer> subset = queue.poll();
            results.add(subset);

            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> nextSubset = new LinkedList<Integer>(subset);
                    nextSubset.add(nums[i]);
                    queue.offer(nextSubset);
                }
            }
        }
        return results;
    }

    //法三：组合类专用DFS
    private static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<Integer>(), results);
        return results;
    }

    private static void dfs(int index, int[] nums, List<Integer> subset, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        //递归的拆解
        subset.add(nums[index]);
        dfs(index + 1, nums, subset, results);
        subset.remove(subset.size() - 1);
        dfs(index + 1, nums, subset, results);

    }

    //法四：二进制每个元素都可以表示为0和1，不选和选
    private static List<List<Integer>> subsets4(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        // 1 << n is 2^n
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                //1<<j 1,2,4  其实就是为了按位
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            results.add(subset);
        }
        return results;
    }

}
