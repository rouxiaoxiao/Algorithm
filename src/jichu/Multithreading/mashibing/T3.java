package jichu.Multithreading.mashibing;

/**
 * synchronized(this)的简便写法
 * 等同于synchronized(this)
 *
 * @Author: liangxiao
 * @Date: Created in 11:08 2018/9/6
 */
public class T3 {
    private int count = 10;

    public synchronized void m() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);

    }
}
