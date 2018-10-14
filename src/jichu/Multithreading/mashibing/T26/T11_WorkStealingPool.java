package jichu.Multithreading.mashibing.T26;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 工作窃取（和ForkJoinPool其实是一种）
 * 每个线程都有自己的任务列表，当一个任务执行完后，会去其他线程的任务中找任务
 *
 * 是由ForkJoinPool实现的，很经典的算法，类似MapReduce经典
 *
 * 给ForkJoinPool封装了顶层接口
 * 线程池中的线程都是精灵线程
 *
 * 适合任务不均匀的情况，效率更高
 *
 * @Author: liangxiao
 * @Date: Created in 14:27 2018/10/14
 */
public class T11_WorkStealingPool {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());//查看是几核CPU

        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));//第五个任务一定是第一个线程去完成的

        //由于产生的是精灵daemon线程（守护线程、后台线程），主线程不阻塞的话，看不到输出
//        System.in.read();//这行是使主线程阻塞
        //精灵线程是在后台不断运行的，只要虚拟机不退出，他就不会退出，可以设置断点调试看到


    }

    static class R implements Runnable {
        int time;

        R(int t) {
            this.time = t;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time + " " + Thread.currentThread().getName());
        }
    }

}
