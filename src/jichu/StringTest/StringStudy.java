package jichu.StringTest;

import java.util.*;

/**
 * String类的相关操作
 *
 * @author：liangxiao
 * @date：2018/8/24
 */
public class StringStudy {
    public static void main(String[] args) {
        String a = new String("aaa");
        String b = new String("aaa");
        System.out.println(a == b);

        char[] c = {'a', 'a', 'a'};
        System.out.println(a.equals(c));

        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();


        StringBuffer str = new StringBuffer("aaa");
        System.out.println(str.toString().equals("aaa"));


        String line = "vfdsvfrom ip:111,111 aaakey:aa]kkkk uid:wheofh;fdjsa;ticket:djasof";
        String[] biaozhi = {"key:", "ip:"};
        String ip = line.split("ip:")[1].split("key")[0];
        String key = line.split("key:")[1].split("]")[0];
        String uid = line.split("uid:")[1].split(";")[0];
        String ticket = line.split("ticket:")[1];
        String result = ip + " " + uid + " " + uid + " " + ticket;
        System.out.println(result);


    }
}
