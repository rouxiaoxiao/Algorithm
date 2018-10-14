package jichu.Multithreading.mashibing.T25;

import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * 可以用来执行定时任务
 *
 * 应用场景：两个小时之后给出警告，两个小时之后关机等
 *
 * @Author: liangxiao
 * @Date: Created in 21:16 2018/10/13
 */
public class T07_DelayQueue {
    static BlockingQueue<MyTask> tasks = new DelayQueue<>();
    static Random r = new Random();

    static class MyTask implements Delayed {
        long runningTime;

        MyTask(long rt) {
            this.runningTime = rt;
        }

        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.SECONDS) < o.getDelay(TimeUnit.SECONDS)) {
                return -1;
            } else if (this.getDelay(TimeUnit.SECONDS) > o.getDelay(TimeUnit.SECONDS)) {
                return 1;
            } else {
                return 0;
            }
        }

        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.SECONDS);
        }

        @Override
        public String toString() {
            return "" + runningTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask(now + 1000);
        MyTask t2 = new MyTask(now + 2000);
        MyTask t3 = new MyTask(now + 1500);
        MyTask t4 = new MyTask(now + 2500);
        MyTask t5 = new MyTask(now + 500);

        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);

        System.out.println(tasks);

        for (int i = 0; i < 5; i++) {
            System.out.println(tasks.take());
        }

    }
}
