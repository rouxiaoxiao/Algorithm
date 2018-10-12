package jichu.Multithreading.mashibing;

/**
 * synchronized关键字对某个对象加锁
 *
 * 这是互斥锁，只要有一个线程拿到这把锁，其他线程就拿不到这把锁
 * @Author: liangxiao
 * @Date: Created in 10:52 2018/9/6
 */
public class T1 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (o) {//任何一个线程要执行下面代码，要先申请到o这个对象的锁（堆中的对象，而不是引用）
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

}
