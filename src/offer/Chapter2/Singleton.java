package offer.Chapter2;

/**
 * 面试题2：实现单例模式(Singleton)
 * 参考：http://www.importnew.com/18872.html
 *
 * @Author: liangxiao
 * @Date: Created in 14:02 2018/8/18
 */
public class Singleton {

}


//饿汉式
class Singleton1 {
    private static Singleton1 s = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return s;
    }
}


//双重检测的懒汉式
class Singleton2 {
    private volatile static Singleton2 s = null;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (s == null) {
            synchronized (Singleton2.class) {
                if (s == null) {
                    s = new Singleton2();
                }
            }
        }
        return s;
    }
}


//枚举方式（INSTANCE就是类Singleton3的一个实例，调用就是Singleton3.INSTANCE.getName()....等等等）
enum Singleton3 {
    INSTANCE;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



