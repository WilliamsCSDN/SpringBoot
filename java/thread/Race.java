package thread;

import java.util.concurrent.Callable;

public class Race implements Callable<Integer> {
    private int step = 0;
    private String name ;
    private long time;
    private boolean flage = true;
    public Race(String name, long time){
        this.name = name;
        this.time = time;
    }
    @Override
    public Integer call() throws Exception {
        while (flage){
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public void setFlage(boolean flage){
        this.flage = false;
    }
}
