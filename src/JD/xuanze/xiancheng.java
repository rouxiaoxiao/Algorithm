package JD.xuanze;

import java.util.ArrayList;

/**
 * @Author: liangxiao
 * @Date: Created in 10:18 2018/9/10
 */
public class xiancheng {

    public static ArrayList<String> list = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new xiancheng().new MyThread();
        Thread t2 = new Thread((new xiancheng().new MyRunnable()));
        t1.start();
        t2.start();
        t2.join();

        for (int i = 0; i < 100000; i++) {
            i++;
        }

        list.add("main");
        t1.join();

        for (String s:list){
            System.out.println(s);
        }
    }

    class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 100000; i++) {
                i++;
            }
            list.add("Thread 1");
        }
    }

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                Thread.yield();
                i++;
            }
            list.add("Thread 2");
        }
    }
}
