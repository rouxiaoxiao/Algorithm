package tencent;

import java.util.Scanner;


//&& n <= (10 ^ 9) && 1 <= m && n % (2 * m) == 0
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();
            if (n >= 2 && n <= (int) Math.pow(10, 9) && 1 <= m && n % (2 * m) == 0) {
                int result = n / (2 * m) * m * m;
                System.out.println(result);
            } else {
                System.out.println("else print...");
            }
        }
    }
}
