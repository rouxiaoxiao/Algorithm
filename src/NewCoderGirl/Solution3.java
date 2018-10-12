package NewCoderGirl;

/**
 * @author liangxiao
 * @date 2017/12/23 14:49
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0, x;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            nums.add(x);
        }
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == i + 1) {
                int a=0,b=0;
                for (int j = i + 1; j < n; j++) {
                    if (nums.get(j) == i + 1) {
                        a++;
                    } else {
                        break;
                    }
                }
                for (int j = i - 1; j >=0; j--) {
                    if (nums.get(j) != i + 1) {
                        b=Math.abs(i-j);
                    }

                }
                int min =Math.min(a,b);
                count=count+min;
            }
        }
        System.out.println(count);
    }
}
