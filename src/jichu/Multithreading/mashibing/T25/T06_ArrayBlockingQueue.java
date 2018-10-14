package jichu.Multithreading.mashibing.T25;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liangxiao
 * @Date: Created in 20:36 2018/10/13
 */
public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        strs.put("aaa");//满了就会阻塞
//        strs.add("aaa");//add满了再加会报异常
//        strs.offer("aaa");//offer满了再加不会报异常
//        strs.offer("aaa",1, TimeUnit.SECONDS);//一秒钟之后加不进去就不往里加了
        System.out.println(strs);
    }
}
