package jichu.Multithreading.mashibing;

/**
 * @Author: liangxiao
 * @Date: Created in 11:11 2018/9/6
 */
public class T4 {
    private static int count = 10;

    public synchronized static void m() {//这里等同于synchronized (T4.class)
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);

    }

    public static void mm() {
        synchronized (T4.class) {//T.class是Class类的一个对象
            count--;
        }
    }
}
