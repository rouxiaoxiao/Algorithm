package NewCoderGirl;

/**
 * @author liangxiao
 * @date 2017/12/23 14:25
 */

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        StringBuilder result = new StringBuilder();
        int count = 0;
        while ((a-1) / 2 > 0) {
            count++;
            int b = (a-1) % 2;
            if (b == 0) {
                result.append("N");
            } else {
                result.append("G");
            }
            a = (a-1) / 2;
        }
        if (a==1){
            result.append("N");
        }else {
            result.append("G");
        }
        System.out.println(result.reverse());

    }
}