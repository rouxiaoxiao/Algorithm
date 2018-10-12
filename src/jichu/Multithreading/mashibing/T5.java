package jichu.Multithreading.mashibing;

/**
 * 分析一下这个程序的输出
 * 出现问题的原因是因为线程重入，一个线程还没执行完就被其他线程打断了
 *
 * @Author: liangxiao
 * @Date: Created in 11:15 2018/9/6
 */
public class T5 implements Runnable {

    private int count = 0;

    public /*synchronized*/ void run() {
        count++;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static void main(String[] args) {
        T5 t5 = new T5();//只new了一个对象，好多线程共同访问这个对象  这些线程访问的都是一个t5对象
        for (int i = 0; i < 1000; i++) {
            new Thread(t5, "Thread" + i).start();
        }
    }
}
