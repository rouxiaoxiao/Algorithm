package jichu.Multithreading;

/**
 * 《Java并发编程实战》 程序清单3-7
 * @Author: liangxiao
 * @Date: Created in 21:26 2018/9/6
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
