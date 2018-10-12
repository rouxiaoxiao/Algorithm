package jichu.Multithreading.mashibing.T20;

import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用来替代synchronized
 * 本例中由于m1锁定this，只有m1执行完毕的时候，m2才能执行
 * 这里是复习synchronized最原始的语义
 * <p>
 * 用ReentrantLock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说3遍）
 * 用synchronized锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * <p>
 * 使用reentrantlock可以进行“尝试锁定”trylock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 * <p>
 * 使用reentrantlock可以调用lockInterruptibly方法，可以对线程的interrupt方法作出响应
 * 在一个线程等待锁的过程中，可以被打断
 * <p>
 * Reentrantlock还可以指定为公平锁(需要增加等待时间的计算，效率要比非公平锁低一点点)
 *
 * @Author: liangxiao
 * @Date: Created in 17:18 2018/10/12
 */
public class ReentrantLock5 extends Thread {
    private static ReentrantLock lock = new ReentrantLock(true);//参数为true表示为公平锁，请对比输出结果

    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(i + Thread.currentThread().getName() + "获得锁");

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r1 = new ReentrantLock5();
        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r1);
        th1.start();
        th2.start();
    }
}
