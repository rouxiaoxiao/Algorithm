package jichu.Multithreading.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某对象o，如果o的属性发生改变，不影响锁的使用
 * 但是如果o又变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外的对象
 *
 * 正常情况下t2是执行不了的
 *
 * @Author: liangxiao
 * @Date: Created in 17:47 2018/9/6
 */
public class T17 {
    Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T17 t = new T17();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(t::m, "t2");
        t.o = new Object();
        t2.start();
    }
}
