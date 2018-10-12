package jichu.Multithreading.mashibing.T21;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 面试题：写一个固定容量的同步容器，拥有put和get方法，以及getCount方法
 * 能够支持2个生产者线程和10个消费者线程的阻塞调用
 * <p>
 * 使用wait和notify/notifyAll来实现
 *
 * @Author: liangxiao
 * @Date: Created in 17:46 2018/10/12
 */
public class MyContainer1<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        while (lists.size() == MAX) {//想想为什么是while不是if
            try {
                this.wait();//effective java  99%的wait都是结合的while，因为多个线程添加的时候
                //有可能一个线程添加了，另一个线程不知情况的也添加了，wait会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();//通知消费者线程进行消费
        //这里为什么药用notifyAll而不是notify，因为怕唤醒的是消费者，还会被阻塞
        //effective Java中有句话，永远要使用notifyAll而不要使用notify
    }

    public synchronized T get() {
        T t = null;
        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count--;
        this.notifyAll();//通知生产者进行生产
        return t;
    }

    public static void main(String[] args) {
        MyContainer1<String> c = new MyContainer1<>();
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
