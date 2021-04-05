package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class RunnableTest implements Runnable{
    final static Logger log = LoggerFactory.getLogger(RunnableTest.class);

    private Integer count = 5;

    private CountDownLatch countDownLatch;

    public RunnableTest(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public synchronized void run(){
            log.info("{}:{}", Thread.currentThread().getName(), count);
            count--;
            countDownLatch.countDown();
    }
}
