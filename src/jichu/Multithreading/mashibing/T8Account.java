package jichu.Multithreading.mashibing;

import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 容易产生脏读问题
 * 只加写锁，不加读锁是会产生脏读；读写都加锁则不会
 * 解决脏读问题经常会用到的是CopyOnWrite（写值复制，后面会讲），解决了脏读问题，并且对读的性能没有什么影响
 * @Author: liangxiao
 * @Date: Created in 11:46 2018/9/6
 */
public class T8Account {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        //设置睡眠时间让问题暴露出来
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ Double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        T8Account a = new T8Account();
        new Thread(() -> a.set("zhangsan", 100.0)).start();
        //睡一秒是因为同步函数中设置的时间内，所以读取的数值是有可能被修改过的
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));


    }

}
