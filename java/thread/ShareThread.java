package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShareThread extends Thread{
    final static Logger log = LoggerFactory.getLogger(ShareThread.class);

    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        log.info("{}: count={}",this.currentThread().getName(),count);
    }
}
