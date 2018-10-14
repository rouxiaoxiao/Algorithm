package jichu.Multithreading.mashibing.T24;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 加锁可以实现线程安全，可是效率并不高
 * @Author: liangxiao
 * @Date: Created in 8:55 2018/10/13
 */
public class TicketSeller3 {
    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() == 0) {
                            break;
                        }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "销售了" + tickets.remove(0));
                    }
                }


            }).start();
        }
    }
}
