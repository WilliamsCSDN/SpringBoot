package thread;

import java.util.Map;

public class HashThread implements Runnable{

    private Map<Integer, Object> hashMap;
    private Integer count;

    public HashThread(Map hashMap, Integer count){
        this.hashMap = hashMap;
        this.count = count;
    }
    @Override
    synchronized public void run() {
        double a= Math.random();
        hashMap.put(count,a);
        System.out.println(a);
    }
}
