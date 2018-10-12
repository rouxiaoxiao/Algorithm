package kedaxunfei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 17:01 2018/9/7  36%
 */
public class Shashou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            people[i] = in.nextInt();
        }
        System.out.println(helper(people));

    }

    private static int helper(int[] peo) {
        if (peo == null && peo.length == 0) {
            return 0;
        }
        if (peo.length < 2) {
            return 0;
        }
        int[] people = new int[peo.length];
        for (int i = 0; i < people.length; i++) {
            people[i] = peo[i];
        }
        Arrays.sort(peo);
        if (Arrays.equals(peo, people)) {
            return 0;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < people.length - 1; i++) {
            int biaozhi = people[i];
            while (i < people.length - 1 && people[i] > people[i + 1]) {
                i++;
            }
            result.add(biaozhi);
        }
        int[] resultnum = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultnum[i] = result.get(i);
        }
        return 1 + helper(resultnum);
    }
}
