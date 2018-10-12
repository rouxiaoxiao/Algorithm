package jichu.Multithreading.mashibing;

import java.util.ArrayList;
import java.util.List;

/**
 * 对比上一个程序，synchronized既保证原子性，又保证可见性，可以解决上面的问题
 *
 * @Author: liangxiao
 * @Date: Created in 16:48 2018/9/6
 */
public class T14 {
    int count = 0;

    synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(count);
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

