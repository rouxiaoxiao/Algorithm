package jichu.Multithreading.mashibing.T20;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
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
 *
 * @Author: liangxiao
 * @Date: Created in 16:55 2018/10/12
 */
public class ReentrantLock4 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("t1 start");
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();//不能被其他线程打断
                lock.lockInterruptibly();//可以被其他线程（这里是主线程）打断
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            } finally {
                lock.unlock();//这里其实应该设置一个布尔变量，判断是否上锁，否则可能会报异常
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
