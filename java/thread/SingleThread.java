package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleThread implements Runnable{
    final static Logger log = LoggerFactory.getLogger(SingleThread.class);

    private Integer count = 5;
    @Override
    public void run() {
        while (count > 0){
            log.info("{}:{}",Thread.currentThread().getName(),count);
            count--;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
