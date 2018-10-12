package jichu.rongqi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: liangxiao
 * @Date: Created in 21:16 2018/9/11
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap();
        map.put("hhh", "jjj");
    }
}
