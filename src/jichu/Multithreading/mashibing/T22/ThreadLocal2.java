package jichu.Multithreading.mashibing.T22;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal 线程局部变量
 * <p>
 * ThreadLocal是使用空间换时间，synchronized是时间换空间
 * 比如在Hibernate中Session就存在于ThreadLocal中(提高效率)，避免synchronized使用
 * Session多线程共同访问的时候，是需要加锁的，使用ThreadLocal，每个线程自己访问，就不需要再加锁了
 * <p>
 * 运行下面的程序，理解ThreadLocal
 * ThreadLocal可能会导致内存泄漏
 *
 * @Author: liangxiao
 * @Date: Created in 21:32 2018/10/12
 */
public class ThreadLocal2 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}
