package JD;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            long N = in.nextLong();
            if (N % 2 != 0) {
                System.out.println("No");
                continue;
            }
            long x = 0, y = 0;
            for (long j = 2; j <= N; j = j + 2) {
                if (N % j == 0 && (N / j) % 2 == 1) {
                    x = N / j;
                    y = j;
                }
                System.out.println(x + " " + y);
                break;
            }
        }
    }
}
