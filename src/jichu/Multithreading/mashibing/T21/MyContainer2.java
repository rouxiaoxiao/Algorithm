package jichu.Multithreading.mashibing.T21;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：写一个固定容量的同步容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者线程和10个消费者线程的阻塞调用
 * <p>
 * 使用wait和notify/notifyAll来实现
 * <p>
 * 使用lock和condition来实现
 * 对比两种方式，condition可以更加精确的指定哪些线程被唤醒(这样比唤醒所有线程的效率要高很多)
 *
 * @Author: liangxiao
 * @Date: Created in 19:53 2018/10/12
 */
public class MyContainer2<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;//最多10个元素
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            while (lists.size() == MAX) {
                producer.await();//注意这里是await不是wait，wait要和synchronized一起使用
            }
            lists.add(t);
            ++count;
            consumer.signalAll();//通知消费者进行消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll();//通知生产者进行生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c = new MyContainer2<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }
    }
}
