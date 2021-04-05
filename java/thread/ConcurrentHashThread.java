package thread;

import java.util.Map;

public class ConcurrentHashThread implements Runnable{

    private Map<Integer, Object> concurrentHashMap;

    public ConcurrentHashThread(Map<Integer, Object> concurrentHashMap){
        this.concurrentHashMap = concurrentHashMap;
    }

    @Override
    public void run() {
        double a = Math.random();
        concurrentHashMap.put(1,a);
        System.out.println(a);

    }
}
