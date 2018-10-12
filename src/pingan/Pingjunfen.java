package pingan;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: liangxiao
 * @Date: Created in 21:33 2018/9/20
 */
public class Pingjunfen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Double, String> map = new TreeMap<>();
        int count = 0;
        while (in.hasNextLine()) {
            count++;
            String line = in.nextLine();
            if (line.length() == 0) break;
            String[] lineSub = line.split(" ");
            int sum = 0;
            for (int j = 1; j < lineSub.length; j++) {
                sum = sum + Integer.parseInt(lineSub[j]);
            }
            double avg = sum / (lineSub.length - 1);
            if (map.containsKey(avg)) {
                map.put(avg - Math.pow(0.1, count), line);
            } else {
                map.put(avg, line);
            }
        }


        map = ((TreeMap) map).descendingMap();
        for (double key : map.keySet()) {
            System.out.println(map.get(key).split(" ")[0] + " " + (int) (key + 0.7));
        }
    }


}
