package jichu.Multithreading.Chatper3;

/**
 * 程序清单3-1
 * 这是一个线程不安全的类
 * 没有同步的情况下共享变量
 * 可能输出42 或0（编译器重排序） 或者无法停止（读线程看不到ready的值）
 * @Author: liangxiao
 * @Date: Created in 9:22 2018/9/6
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        while (true){
            new ReaderThread().start();
            number = 42;
            ready = true;
        }
    }
}
