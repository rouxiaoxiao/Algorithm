package jichu.Multithreading.mashibing.T23;

import java.util.Arrays;

/**
 * @Author: liangxiao
 * @Date: Created in 22:46 2018/10/12
 */
public class Singleton {
    private Singleton() {
        System.out.println("single");
    }

    private static class Inner {
        private static Singleton s = new Singleton();
    }

    private static Singleton getSingle() {
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[200];
        for (int i = 0; i < ths.length; i++) {
            ths[i]=new Thread(()->{
                Singleton.getSingle();
            });
        }
        Arrays.asList(ths).forEach(o->o.start());
    }

}
