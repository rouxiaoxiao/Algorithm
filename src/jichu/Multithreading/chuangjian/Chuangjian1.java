package jichu.Multithreading.chuangjian;

/**
 * @Author: liangxiao
 * @Date: Created in 21:07 2018/9/14
 */
public class Chuangjian1 extends Thread {
    int i = 0;

    //重写run方法，run方法的方法体就是现场执行体
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "  " + i);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
            if (i == 20) {
                new Chuangjian1().start();
                new Chuangjian1().start();
            }
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }

}
