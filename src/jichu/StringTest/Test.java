package jichu.StringTest;

/**
 * @Author: liangxiao
 * @Date: Created in 20:17 2018/9/25
 */
public class Test {
    //有问题
//    private synchronized Object o;

//    void go() {
//        synchronized () {
//        }
//    }

//    public synchronized void go(){}

//    private synchronized(this) void go(){}

    void go(){
        synchronized (Object.class){}
    }






}

class Parent {
}

class Child extends Parent {


    public static void main(String[] args) {
        Parent p1 = new Child();
        Parent p2 = new Parent();
        Child c1 = new Child();
        //会报错
//        Child c2 = new Parent();


        String foo = "base";
        foo.substring(0, 3);
        foo.concat("ket");
        foo += "ball";
        System.out.println(foo);


    }
}
