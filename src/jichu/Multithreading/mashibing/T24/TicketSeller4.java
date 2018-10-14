package jichu.Multithreading.mashibing.T24;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * 1.5之后新增加的并发容器，比加锁效率高
 *
 * Queue中不能存空值，否则会抛出异常
 *
 * @Author: liangxiao
 * @Date: Created in 9:00 2018/10/13
 */
public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();//poll就是往外拿一个数据，poll是同步的，底层是CAS原理
                    if (s == null) {
                        break;
                    } else {
                        System.out.println("销售了--" + s);
                    }
                }
            }).start();
        }
    }
}
