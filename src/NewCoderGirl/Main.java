package NewCoderGirl;

/**
 * @author liangxiao
 * @date 2017/12/23 14:13
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<List<Integer>> method(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return null;
        }
        return results;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.method(null));
    }
}