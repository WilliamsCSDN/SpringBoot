package cn.ubattery.console;

import cn.ubattery.console.inspector.entity.NomanInspector;
import cn.ubattery.console.inspector.service.NomanInspectorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
class ConsoleApplicationTests {

    @Autowired
    NomanInspectorService service ;

    @Test
    void contextLoads() {
        PushThread pushThread = new PushThread(service);
        PushThread pushThread1 = new PushThread(service);
        PushThread pushThread2 = new PushThread(service);
        PushThread pushThread3 = new PushThread(service);
        ThreadPoolExecutor poolexecutor = new ThreadPoolExecutor(4,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        System.out.println("任务开始");
        poolexecutor.execute(pushThread);
        poolexecutor.execute(pushThread1);
        poolexecutor.execute(pushThread2);
        poolexecutor.execute(pushThread3);
        poolexecutor.shutdown();
        System.out.println("任务结束");
//        System.out.println("手机"+ service.selectByPrimaryKey(1).getInspectorPhone());

    }

    public class PushThread implements Runnable{
        private AtomicInteger cout = new AtomicInteger(5);

        private NomanInspectorService service;

        public PushThread(NomanInspectorService service){
            this.service = service;
        }

        @Override
        public void run() {
            while (cout.get() > 0){
                System.out.println("巡检员电话");
                System.out.println("：" + service.selectByPrimaryKey(cout.get()).getInspectorPhone());
                System.out.println(Thread.currentThread().getName() +":" + cout);
                cout.decrementAndGet();
            }
        }
    }

}
