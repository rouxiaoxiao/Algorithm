package jichu.duotai;

/**
 * @author：liangxiao
 * @date：2018/8/24
 */
public class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    @Override
    public String show(A obj) {
        return ("B and A");
    }

}
