package jichu.JVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangxiao
 * @Date: Created in 11:50 2018/9/17
 */
public class HeapOOM {
    //如果不带static参数创建对象的时候要new HeapOOM().new OOMObject()
    //如果带static参数，只需new OOMObject()，默认有this
    static class OOMObject {
    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());

        }
    }
}
