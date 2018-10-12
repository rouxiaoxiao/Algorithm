package jichu.Multithreading.mashibing;

/**
 * synchronized 关键字
 * 每次都new一个专门加锁的对象太麻烦了
 * synchronized(this) 把自身对象锁定
 * 理解：synchronized锁定的不是代码块，锁定的是一个对象（是要执行这段代码的时候，锁定当前对象）
 *
 * @Author: liangxiao
 * @Date: Created in 11:05 2018/9/6
 */
public class T2 {
    private int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }
}
