package jichu.Multithreading.mashibing;

/**
 * @Author: liangxiao
 * @Date: Created in 11:30 2018/9/6
 */
public class T6 implements Runnable {
    private int count = 0;

    public synchronized void run() {
        count++;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static void main(String[] args) {
        T6 t6 = new T6();//只new了一个对象，好多线程共同访问这个对象  这些线程访问的都是一个t5对象
        for (int i = 0; i < 1000; i++) {
            new Thread(t6, "Thread" + i).start();
        }
    }
}
