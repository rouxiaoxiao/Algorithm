package zhaohang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liangxiao
 * @Date: Created in 20:19 2018/9/16
 */
public class Tangguo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String weikou = in.nextLine();
        String tangguo = in.nextLine();
        String[] weis = weikou.split(" ");
        String[] tangs = tangguo.split(" ");
        int[] wei = new int[weis.length];
        for (int i = 0; i < weis.length; i++) {
            wei[i] = Integer.parseInt(weis[i]);
        }
        int[] tang = new int[tangs.length];
        for (int i = 0; i < tangs.length; i++) {
            tang[i] = Integer.parseInt(tangs[i]);
        }
        //糖果排序
        Arrays.sort(tang);
        Arrays.sort(wei);
        int count = 0;
        for (int i = 0; i < tang.length; i++) {
            for (int j = 0; j < wei.length; j++) {
                if (tang[i] >= wei[j]) {
                    count++;
                    if (i < tang.length - 1 && j < wei.length - 1) {
                        i++;
                        j++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);

    }
}
