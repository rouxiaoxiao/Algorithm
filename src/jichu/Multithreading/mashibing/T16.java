package jichu.Multithreading.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * synchronized优化
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 *
 * @Author: liangxiao
 * @Date: Created in 17:19 2018/9/6
 */
public class T16 {
    int count = 0;

    synchronized void m1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            count++;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
