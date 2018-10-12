package jichu.Multithreading;

/**
 * 内置锁可重入
 *
 * @Author: liangxiao
 * @Date: Created in 20:32 2018/9/5
 */
public class Chongru {
    public static void main(String[] args) {
        Son son = new Son();
        son.doSomething();
    }

}

class Father {
    public synchronized void doSomething() {
        System.out.println("Father this=" + this);
        System.out.println("Father doSomething...");
    }
}

class Son extends Father {
    public synchronized void doSomething() {
        System.out.println("Son this=" + this);
        System.out.println("son doSomething...");
        super.doSomething();
    }
}
