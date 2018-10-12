package offer;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Author: liangxiao
 * @Date: Created in 20:23 2018/8/26
 */
public class MainTest {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(7, nums));
        //lambda表达式  比较器
        String[] planets = new String[]{"aaa", "bbbbb", "c", "dddddddddddd"};
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        String a=new String("haha");
        String b=new String("haha");
        char[] c={'h','a','h','a'};
        System.out.println(b.equals(c.toString()));
//        System.out.println(b==c);
        System.out.println(a.equals(b));
        System.out.println(b.equals(new String("haha")));
        System.out.println(a==b);


    }

    private static boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
