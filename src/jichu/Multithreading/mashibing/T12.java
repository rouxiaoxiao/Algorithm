package jichu.Multithreading.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字，使一个变量在多个线程间可见
 * A B线程都用到一个变量，Java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道
 * 使用volatile关键字，会让所有线程都会读到变量的修改值
 * <p>
 * 在下面的代码中，running是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把running值从内存中读到t1线程的工作区，在运行过程中直接使用这个copy
 * 并不会每次都去读取堆内存，这样，当主线程修改running的值之后，t1线程感知不到，所以不会停止运行
 * <p>
 * 使用volatile关键字，会强制所有线程都去堆内存中读取running的值
 * volatile关键字并不能保证多个线程共同修改running所带来的不一致问题，也就是说volatile并不能代替synchronized
 *
 * @Author: liangxiao
 * @Date: Created in 16:03 2018/9/6
 */
public class T12 {

    /*volatile*/ boolean running = true;

    void m() {
        System.out.println("m start...");
        while (running) {
            //如果这里 加上睡眠或者输出什么，则有可能可以看到主线程对running的更新值（但不是一定的）
            //因为这里CPU空闲了，则有可能去主内存更新一下线程中的缓存
        }
        System.out.println("m end...");

    }

    public static void main(String[] args) {
        T12 t12 = new T12();
        new Thread(() -> t12.m(), "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t12.running = false;
    }
}
