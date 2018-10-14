package jichu.Multithreading.mashibing.T26;

import java.util.concurrent.Executor;

/**
 * Executor 执行器
 *
 * @Author: liangxiao
 * @Date: Created in 22:42 2018/10/13
 */
public class T01_MyExecutor implements Executor {
    public static void main(String[] args) {
        new T01_MyExecutor().execute(()-> System.out.println("hello world!"));
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
