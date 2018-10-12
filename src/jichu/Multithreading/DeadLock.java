package jichu.Multithreading;

/**
 * 一个死锁的例子（实际当中应该比这个复杂，有可能是死锁链）
 * 活锁在真正的开发中很少见，只存在于理论当中
 *
 * @Author: liangxiao
 * @Date: Created in 15:24 2018/9/6
 */
public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}

class Lock1 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Lock1 running");
            while (true) {
                synchronized (DeadLock.obj1) {
                    System.out.println("Lock1 lock obj1");
                    Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                    synchronized (DeadLock.obj2) {
                        System.out.println("Lock1 lock obj2");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Lock2 running");
            while (true) {
                synchronized (DeadLock.obj2) {
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obj1) {
                        System.out.println("Lock2 lock obj1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
