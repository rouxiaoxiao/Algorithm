package jichu.Multithreading.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * 程序执行过程中，如果出现异常，默认情况锁会被释放
 * 所以在并发处理过程中，有异常要多加小心，不然可能会发生不一致的情况
 * 比如在一个web app处理过程中，多个servlet线程共同访问同一个资源，这时如果异常处理不合适
 * 在某一个线程中抛出异常，其他线程就会进入同步代码区，有可能会访问到异常产生时的数据
 * 因此要非常小心的处理同步业务逻辑中的异常
 *
 * t1抛出异常后默认锁被释放，t2才会被执行，不然t1中有死循环，会一直占用锁，t2没有机会被执行
 * 如果发生异常后不想释放锁，可在try catch中捕获异常
 *
 * @Author: liangxiao
 * @Date: Created in 15:37 2018/9/6
 */
public class T11 {

    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + "start...");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;
            }
        }
    }

    public static void main(String[] args) {
        T11 t11 = new T11();
        new Thread(() -> t11.m(), "t1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> t11.m(), "t2").start();


    }
}
