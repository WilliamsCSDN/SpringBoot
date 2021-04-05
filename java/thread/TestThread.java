package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class TestThread extends Thread {
    final static Logger log = LoggerFactory.getLogger(TestThread.class);
    private int i = 100;
    private String name ;
    private CountDownLatch countDown;

    public TestThread(String name, CountDownLatch countDown){
        this.name = name;
        this.countDown = countDown;
    }

    @Override
    public void run() {

        log.info("{}: i want you {}", Thread.currentThread().getName(), i);
        i--;
        countDown.countDown();

    }

}
