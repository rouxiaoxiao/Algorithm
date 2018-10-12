package jichu.io;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类
 * @Author: liangxiao
 * @Date: Created in 17:25 2018/9/3
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
