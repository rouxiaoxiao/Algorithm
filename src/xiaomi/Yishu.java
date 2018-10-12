package xiaomi;

import java.util.*;

/**
 * @Author: liangxiao
 * @Date: Created in 19:41 2018/9/20
 */
public class Yishu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> results = new LinkedHashMap<>();
        List<String> lines = new ArrayList<>();
        List<Integer> resultValList = new ArrayList<>();
        while (true) {
            String line = in.nextLine();
            lines.add(line);
            if ("END".equals(line)) {
                break;
            }
            String[] nm = line.split("#");
            int mLength = nm[1].length();
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int resultVal = helper(n, m, mLength);
            resultValList.add(resultVal);
            if (results.containsKey(resultVal)) {
                results.put(resultVal, results.get(resultVal) + 1);
            } else {
                results.put(resultVal, 1);
            }
        }
        int count = 0;
        for (Integer key : results.keySet()) {
            if (results.get(key) == 1) {
                for (int i = 0; i < resultValList.size(); i++) {
                    if (resultValList.get(i) == key) {
                        System.out.println(lines.get(i));
                    }
                }
                count++;
            }
        }
        if (count == 0) {
            System.out.println("None");
        }
//        System.out.println(helper(10, 15, 2));

    }

    private static int helper(int n, int m, int mLength) {
        int result = 0;
        for (int i = 0; i < mLength; i++) {
            int wei = 0;
            if (m / 10 == 0) {
                wei = m;
            } else {
                wei = m % 10;
            }

            result = result + wei * ((int) Math.pow(n, i));
            m = m / 10;
        }
        return result;
    }
}
