package jichu.Multithreading.mashibing.T25;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * ConcurrentHashMap比Hashtable效率高，ConcurrentHashMap每次把桶分成16块，每次只锁定一块，不需要锁定整个对象，
 * 把大锁分成小锁，锁的细化，效率也比Collections.synchronizedXXX高
 *
 * @Author: liangxiao
 * @Date: Created in 9:20 2018/10/13
 */
public class T01_ConcurrentMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        //跳表结构，插入效率也是比较高的，而且是排好序的（高并发并且排序的情况下使用）
//        Map<String, String> map = new ConcurrentSkipListMap<>();
//        Map<String, String> map = new Hashtable<>();

        //给HashMap加锁，就是调用Collections.synchronizedXXX，等同于HashTable（并发不很高的情况下使用）
//        Map<String, String> map = new HashMap<>();
        //TreeMap


        Random r = new Random();

        Thread[] ths = new Thread[100];
        //门栓
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                }
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(t -> t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println(end - start);


    }
}
