package jichu.Multithreading.mashibing.T25;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 队列是并发容器中最重要也是用的最多的结构
 *
 * 高并发的情况下，可以使用两种队列
 * 1.ConcurrentLinkedQueue（并发加锁）
 * 2.BlockingQueue（阻塞式队列）：LinkedBlockingQueue、ArrayBlockingQueue
 * 之前的生产者消费者模式就是一个阻塞模式的实现
 * @Author: liangxiao
 * @Date: Created in 19:58 2018/10/13
 */
public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 10; i++) {
            strs.offer("a" + i);
        }
        System.out.println(strs);

        System.out.println(strs.size());

        System.out.println(strs.poll());//拿出，并删除
        System.out.println(strs.size());

        System.out.println(strs.peek());//拿出，不删除
        System.out.println(strs.size());


        //双端队列叫Deque
    }

}
