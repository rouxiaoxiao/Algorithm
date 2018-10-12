package jichu.Multithreading.mashibing;

/**
 * 同步方法和非同步方法是否可以同时调用(可以)
 * <p>
 * 在一个同步方法执行过程中，非同步方法是可以执行的
 *
 * @Author: liangxiao
 * @Date: Created in 11:31 2018/9/6
 */
public class T7 {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "m1 start...");
        try {
            //睡10秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end...");
    }

    public void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2");
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
//        new Thread(() -> t7.m1(), "t71").start();
//        new Thread(() -> t7.m2(), "t72").start();

        //另一种更简单的写法
//        new Thread(t7::m1, "t71").start();
//        new Thread(t7::m2, "t72").start();


        //最原始的写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                t7.m1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                t7.m2();
            }
        }).start();
    }
}
