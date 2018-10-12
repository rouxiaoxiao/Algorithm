package sohu;


import java.util.Scanner;

public class Main1ver2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = Integer.parseInt(in.nextLine());
        int count = 0;
        int[][] daily = new int[line][]; // start date, end date, bonus
        int taskBonus = 0;
        int endDate = 0;

        for (int i = 0; i < line; i++) {
            String p = in.nextLine();
            String[] c = (p.split(" "));
            if (c[0].equals("2")) taskBonus += Integer.parseInt(c[2]);
            else {
                endDate = Integer.parseInt(c[2]) > endDate ? Integer.parseInt(c[2]) : endDate;
                int[] day = {Integer.parseInt(c[1]), Integer.parseInt(c[2]), Integer.parseInt(c[3])};
                daily[count++] = day;
            }
        }

        int dailyBonus = dailyCalc(daily, endDate);
        int sum = dailyBonus + taskBonus;
        System.out.println(sum);
    }

    private static int dailyCalc(int[][] tasks, int endDate) {
        int result = 0;
        int[] day = new int[endDate + 1];
        for (int i = 0; i < endDate + 1; i++) {
            day[i] = Integer.MIN_VALUE;
        }

        for (int[] d : tasks) {
            if (d == null) break;
            for (int i = d[0]; i <= d[1]; i++) {

                day[i] = day[i] > d[2] ? day[i] : d[2];
            }
        }

        for (int b : day) {
            if (b == Integer.MIN_VALUE) b = 0;
            result += b;
        }

        return result;
    }
}