package jichu.Multithreading.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
 * 也就是说synchronized获得的锁是可重入的
 * 这种情况在继承中也可能发生（也就是《Java并发编程实战》书中所举的例子）
 * synchronized方法访问的都是this，就是new TT()中的TT对象
 * @Author: liangxiao
 * @Date: Created in 15:30 2018/9/6
 */
public class T10 {
    synchronized void m(){
        System.out.println("m start...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end...");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T10{
    synchronized void m(){
        System.out.println("child m start...");
        super.m();
        System.out.println("child m end...");

    }
}
