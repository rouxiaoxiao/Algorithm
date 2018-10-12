package jichu.Multithreading.mashibing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题的更高效的方法，使用AtomicXXX类
 * AtomicXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 *
 *
 * @Author: liangxiao
 * @Date: Created in 17:14 2018/9/6
 */
public class T15 {

    AtomicInteger count = new AtomicInteger(0);

    void m() {
        for (int i = 0; i < 10000; i++) {
            // if count.get()<1000   如果多加一个这种方法，和后面的方法整体是没有原子性的
            count.incrementAndGet();//这个方法是原子方法，他是用系统相当底层的实现完成的，而不是用的synchronized，效率要高很多
        }
    }

    public static void main(String[] args) {
        T14 t = new T14();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "Thread" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();//优先执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);

    }

}
