package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liangxiao
 * @date 2017/12/6 17:01
 * 求set的子集(深度优先搜索)
 */
public class SubSet {
    public ArrayList<ArrayList<Integer>> findSubSet(int[] nums) {

        ArrayList<ArrayList<Integer>> resualts = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return resualts;
        }
        ArrayList<Integer> subSet = new ArrayList<Integer>();
        //含重复数字时，排序是必须的
        Arrays.sort(nums);
        DFSHelper(nums, 0, subSet, resualts);
        return resualts;
    }

    //把所有以subSet开头的集合都丢到results里去
    public void DFSHelper(int[] nums, int startIndex, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> resualts) {
        //放在这里也可以
        //resualts.add(new ArrayList<Integer>(subSet));
        for (int i = startIndex; i < nums.length; i++) {
            //为了不重复取数组中重复数字，i > startIndex是为了确定nums[i-1]不在subSet中
            //在挑了第二个2，却没有挑第一个2的情况下，continue
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            subSet.add(nums[i]);
            resualts.add(new ArrayList<Integer>(subSet));//放在for循环内或者开头都可以
            DFSHelper(nums, i + 1, subSet, resualts);
            subSet.remove(subSet.size() - 1);
        }

    }

    public static void main(String[] args) {
        SubSet subSet = new SubSet();
        int[] a = {1, 2, 2, 3};
        System.out.println(subSet.findSubSet(a));
    }
}
