import cn.ubattery.console.account.entity.NomanAdmin;
import cn.ubattery.console.account.mapper.NomanAdminMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thread.*;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    final static Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String []args) throws Exception {
//        runnable();
//        singleThreadExecutor();
//        fixThreadPool();
//        log.info("{}",Math.random());
//        System.out.println("");
//        hashThread();

//        Collections collections = Collections.synchronizedMap(map);
//        concurrentHash();
//        String []a = {"a","b","c"};
//        List list = Arrays.stream(a).collect(Collectors.toList());
//        System.out.println(list.get(2));
//        String b = "asdf";
//        b.intern();
//        String d = "s";
//        b.equals(d);
//
//        HashMap map = new HashMap<>();
//        int i = 17;
//        while(i>0){
//            map.put(i,i);
//            i--;
//        }

//        ConcurrentHashMap
//        for(Integer a :map.keySet()){
//
//        }

//        fixThreadPool();


//        PushThread pushThread = new PushThread();
//        PushThread pushThread1 = new PushThread();
//        PushThread pushThread2 = new PushThread();
//        PushThread pushThread3 = new PushThread();
//        ThreadPoolExecutor poolexecutor = new ThreadPoolExecutor(4,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
//        poolexecutor.execute(pushThread);
//        poolexecutor.execute(pushThread1);
//        poolexecutor.execute(pushThread2);
//        poolexecutor.execute(pushThread3);
//        poolexecutor.shutdown();

        List<String> list = new ArrayList<>();

        Map<String,Object> map = new HashMap<>();

//        String xml  = "NomanAdminMapper.xml";
//        InputStream inputStream = Resources.getResourceAsStream(xml);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//        NomanAdminMapper mapper = session.getMapper(NomanAdminMapper.class);
//        NomanAdmin admin = mapper.selectByPrimaryKey(1);
//        System.out.println(admin.getAdminName());


    }


    public static void countDown() throws Exception{
        CountDownLatch count = new CountDownLatch(4);
        //四个线程并行
        TestThread A = new TestThread("A",count);
        TestThread B = new TestThread("B",count);
        TestThread C = new TestThread("C",count);
        TestThread D = new TestThread("D",count);

        A.start();
        B.start();
        C.start();
        D.start();
        //等待ABCD线程跑完，跑主线程
        count.await();
        dosomething();
    }

    public static void join() throws Exception{
        JoinThread A = new JoinThread("A");
        JoinThread B = new JoinThread("B");
        JoinThread C = new JoinThread("C");
        JoinThread D = new JoinThread("D");

        A.start();
        B.start();
        C.start();
        D.start();
        A.join();
        B.join();
        C.join();
        D.join();
        //mainThread dosomething
        dosomething();
    }

    public static void callable() throws Exception{
        Race rabbit = new Race("rabbit",0);
        Race tortoise = new Race("tortoise",100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> reR = executorService.submit(rabbit);
        Future<Integer> reT = executorService.submit(tortoise);

        Thread.sleep(3000);
        rabbit.setFlage(false);
        tortoise.setFlage(false);

        int stepR = reR.get();
        int stepT = reT.get();

        log.info("兔子步数为:{}",stepR);
        log.info("乌龟步数为:{}",stepT);

        executorService.shutdown();
    }

    public static void shareSecurityData(){
        ShareThread shareThread = new ShareThread();
        Thread A = new Thread(shareThread,"A");
        Thread B = new Thread(shareThread,"B");
        Thread C = new Thread(shareThread,"C");
        Thread D = new Thread(shareThread,"D");
        A.start();
        B.start();
        C.start();
        D.start();

    }

    public static void runnable() throws InterruptedException{
        log.info("task start");
        CountDownLatch countDownLatch = new CountDownLatch(5);
        RunnableTest runnableTest = new RunnableTest(countDownLatch);
        Thread A = new Thread(runnableTest ,"A");
        Thread B = new Thread(runnableTest, "B");
        Thread C = new Thread(runnableTest, "C");
        Thread D = new Thread(runnableTest, "D");
        Thread E = new Thread(runnableTest, "E");
        A.start();
        B.start();
        C.start();
        D.start();
        E.start();

        countDownLatch.await();
        log.info("task stop");
    }

    public static void singleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        SingleThread singleThread = new SingleThread();
        SingleThread singleThread1 = new SingleThread();
        executorService.execute(singleThread);
        executorService.execute(singleThread1);

        executorService.shutdown();
    }

    public static void fixThreadPool(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        SingleThread singleThread = new SingleThread();
        SingleThread singleThread1 = new SingleThread();
        executorService.execute(singleThread);
        executorService.execute(singleThread1);
        executorService.shutdown();
    }

    public static void hashThread() throws InterruptedException{
        Map<Integer, Object> hashMap = new HashMap();
        HashThread hashThread = new HashThread(hashMap, 1);
        Thread A = new Thread(hashThread, "A");
        Thread B = new Thread(hashThread, "B");
        Thread C = new Thread(hashThread, "C");
        Thread D = new Thread(hashThread, "D");
        Thread E = new Thread(hashThread, "E");
        A.start();
        B.start();
        C.start();
        D.start();
        E.start();

        A.join();
        B.join();
        C.join();
        D.join();
        E.join();


        for(Integer key :hashMap.keySet()){
            log.info("{}:{}",key,hashMap.get(key));
        }
    }

    public static void concurrentHash() throws InterruptedException{
        Map<Integer, Object> concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashThread concurrentHashThread = new ConcurrentHashThread(concurrentHashMap);
        Thread A = new Thread(concurrentHashThread,"A");
        Thread B = new Thread(concurrentHashThread,"B");
        Thread C = new Thread(concurrentHashThread,"C");
        Thread D = new Thread(concurrentHashThread,"D");

        A.start();
        B.start();
        C.start();
        D.start();

        A.join();
        B.join();
        C.join();
        D.join();

        for(Map.Entry<Integer, Object> entry : concurrentHashMap.entrySet()){
            log.info("{}:{}", entry.getKey(), entry.getValue());
        }

    }

//    public static int

    public static void dosomething(){
        log.info("主线程执行任务");
    }


}

