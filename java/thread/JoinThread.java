package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinThread extends Thread{
    final static Logger log = LoggerFactory.getLogger(JoinThread.class);
    private String name;

    public JoinThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        super.run();
        //dosomething
        log.info("{}执行任务",name);
    }
}
