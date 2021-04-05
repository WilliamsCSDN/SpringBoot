package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class PushThread implements Runnable{
    private AtomicInteger cout = new AtomicInteger(5);

    @Override
    public void run() {
        while (cout.get() > 0){
            System.out.println(Thread.currentThread().getName() +":" + cout);
            cout.decrementAndGet();
        }
    }
}