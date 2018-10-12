package toutiao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: liangxiao
 * @Date: Created in 19:34 2018/8/26
 */
public class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = Integer.parseInt(in.nextLine());

        for (int i = 0; i < line; i++) {
            String p = in.nextLine();
            String[] c = (p.split(" "));
            Set<String> set=new HashSet<>();
            set.addAll(Arrays.asList(c));
            System.out.println(set);
        }
    }

}
