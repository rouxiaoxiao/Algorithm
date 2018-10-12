package sohu;


import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Main1ver3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int first = 0;
        int f11, f12, f13, f21, f22;
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            first = sc.nextInt();
            if (first == 1) {
                f11 = sc.nextInt();
                f12 = sc.nextInt();
                f13 = sc.nextInt();
                for (int j = f11; j <= f12; j++) {
                    if (!hm.containsKey(j)) {
                        hm.put(j, f13);
                    } else {
                        int t = hm.get(j);
                        if (f13 > t) {
                            hm.put(j, f13);
                        }
                    }
                }
            } else {
                f21 = sc.nextInt();
                f22 = sc.nextInt();
                res = res + f22;
            }
        }
        Collection<Integer> values = hm.values();
        for (int s : values)
            res = res + s;
        System.out.println(res);
        sc.close();
    }
}