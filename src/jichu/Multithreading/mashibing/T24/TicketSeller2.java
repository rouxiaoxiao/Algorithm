package jichu.Multithreading.mashibing.T24;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 虽然vector是同步容器，但是判断size和remove是分开操作的，所以总体不是原子的
 * @Author: liangxiao
 * @Date: Created in 23:05 2018/10/12
 */
public class TicketSeller2 {
    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "销售了" + tickets.remove(0));
                }
            }).start();
        }
    }
}
