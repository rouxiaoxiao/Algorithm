package jichu.Multithreading.mashibing;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile关键字并不能保证多个线程共同修改running所带来的不一致问题，也就是说volatile并不能代替synchronized
 *
 *
 * 修改后再写回的时候不会在检查是否值更新，所以这里就会产生问题
 *
 * @Author: liangxiao
 * @Date: Created in 16:48 2018/9/6
 */
public class T13 {
    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T13 t = new T13();
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
