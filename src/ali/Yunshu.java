package ali;

import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * @Author: liangxiao
 * @Date: Created in 10:19 2018/8/4
 */
public class Yunshu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //读取坐标到数组
        int[][] zuobiaoInt = new int[n + 1][2];
        zuobiaoInt[0][0] = 0;
        zuobiaoInt[0][1] = 0;
        for (int i = 1; i < n + 1; i++) {
            String zuobiao = sc.next();
            String[] zuobiaoSub = zuobiao.split(",");
            zuobiaoInt[i][0] = Integer.parseInt(zuobiaoSub[0]);
            zuobiaoInt[i][1] = Integer.parseInt(zuobiaoSub[1]);
        }
        //定义一个距离数组
        int[][] juliInt = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                juliInt[i][j] = abs(zuobiaoInt[i][0] - zuobiaoInt[j][0]) + abs(zuobiaoInt[i][1] - zuobiaoInt[j][1]);
            }
        }
//        for (int i=;)
//        int sum = 0;
        int sumTmp = 0;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (juliInt[i][j] > juliInt[i][k] + juliInt[k][j]) {
                        juliInt[i][j] = juliInt[i][k] + juliInt[k][j];
                    }
                }
            }
        }


    }
}
