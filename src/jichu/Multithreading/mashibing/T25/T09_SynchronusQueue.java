package jichu.Multithreading.mashibing.T25;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 *
 * SynchronusQueue容量为0的队列
 * 只要来的任务，消费者必须马上消费
 * @Author: liangxiao
 * @Date: Created in 21:59 2018/10/13
 */
public class T09_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa");//put阻塞等待消费者消费，其实put里面用的是transfer
//        strs.add("aaa");// java.lang.IllegalStateException: Queue full
        System.out.println(strs.size());
    }
}
