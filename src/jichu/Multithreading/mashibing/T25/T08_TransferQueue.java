package jichu.Multithreading.mashibing.T25;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author: liangxiao
 * @Date: Created in 21:47 2018/10/13
 */
public class T08_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");//提供了一个特殊的方法transfer
        //生产者先不将产品放入队列，先看有没有消费者，如果有需要的直接给消费者
        //更高并发的情况下，提高效率
        //比如服务器接收客户端请求，然后有服务器等待请求的情形
        //找不到消费者的情形下，他会阻塞，所以后面的代码都执行不了了，这是个问题

        //现在的实时处理用TransferQueue的情况比较多，一些框架，如netty

    }
}
