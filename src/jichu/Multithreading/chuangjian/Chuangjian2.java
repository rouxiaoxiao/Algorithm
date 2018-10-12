package jichu.Multithreading.chuangjian;

/**
 * @Author: liangxiao
 * @Date: Created in 21:25 2018/9/14
 */
public class Chuangjian2 implements Runnable {
    private int i;

    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                Chuangjian2 rtt = new Chuangjian2();
                Thread t1 = new Thread(rtt, "新线程1");
                t1.start();
                t1.join();
                new Thread(rtt, "新线程2").start();
            }
        }

    }

}
