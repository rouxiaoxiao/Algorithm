package jichu.Multithreading.mashibing.T25;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: liangxiao
 * @Date: Created in 19:55 2018/10/13
 */
public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> strsSync = Collections.synchronizedList(strs);
    }
}
