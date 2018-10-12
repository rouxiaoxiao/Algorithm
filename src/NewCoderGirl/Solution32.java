package NewCoderGirl;

/**
 * @author liangxiao
 * @date 2017/12/23 14:49
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0, x,temp;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            nums.add(x);
        }
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == i + 1) {
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                int m=i;
                int v=i;
                for (int j = i + 1; j < n; j++) {
                    if (nums.get(j) != i + 1) {
                        a = Math.abs(i - j);
                        m=j;
                        break;
                    }
                }
                for (int h = i - 1; h >= 0; h--) {
                    if (nums.get(h) != i + 1) {
                        b = Math.abs(i - h);
                        n=h;
                        break;
                    }
                }
                int min = Math.min(a, b);
                if (a<b){
                    temp=nums.get(m);
                    nums.set(m,nums.get(v));
                    nums.set(v,temp);
                }
                count = count + min;
            }
        }
        System.out.println(count);
    }

}

