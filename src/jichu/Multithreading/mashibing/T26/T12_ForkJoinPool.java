package jichu.Multithreading.mashibing.T26;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Fork就是分开，Join就是合并，类似MapReduce
 *
 * @Author: liangxiao
 * @Date: Created in 14:39 2018/10/14
 */
public class T12_ForkJoinPool {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
        //stream不是并行，parallel stream使用并行
    }

//    static class AddTask extends RecursiveAction {
//        int start, end;
//
//        AddTask(int s, int e) {
//            start = s;
//            end = e;
//        }
//
//        @Override
//        protected void compute() {
//            //如果长度小于指定的任务数，则计算，大于阈值则继续拆分
//            if (end - start <= MAX_NUM) {
//                long sum = 0L;
//                for (int i = start; i < end; i++) {
//                    sum += nums[i];
//                }
//                System.out.println("from:" + start + "to:" + end + "=" + sum);//由于RecursiveAction是没有返回值的，所以只能打印，不能返回
//            } else {
//                int middle = start + (end - start) / 2;
//
//                AddTask subTask1 = new AddTask(start, middle);
//                AddTask subTask2 = new AddTask(middle, end);
//
//                subTask1.fork();
//                subTask2.fork();
//
//            }
//        }

    static class AddTask extends RecursiveTask<Long> {
        int start, end;

        AddTask(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        protected Long compute() {
            //如果长度小于指定的任务数，则计算，大于阈值则继续拆分
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                return sum;
            } else {
                int middle = start + (end - start) / 2;

                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);

                subTask1.fork();
                subTask2.fork();

                return subTask1.join() + subTask2.join();//有返回值了就需要用join函数了

            }
        }

        public static void main(String[] args) throws IOException {
            ForkJoinPool fjp = new ForkJoinPool();
            AddTask task = new AddTask(0, nums.length);
            fjp.execute(task);

            //使用RecursiveTask调用的函数，join本身就是阻塞的，所以直接输出就可以了
            long result = task.join();
            System.out.println(result);

            //使用RecursiveAction调用的函数，需要阻塞主函数
            System.in.read();
        }
    }
}
