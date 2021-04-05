package job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MySchedule {
    public static void main(String[] args) {

//        Properties prop = new Properties();
//
//        prop.put("org.quartz.scheduler.instanceName", "HuskyScheduler");
//        // 设置为AUTO时使用，默认的实现org.quartz.scheduler.SimpleInstanceGenerator是基于主机名称和时间戳生成。
//        prop.put("org.quartz.scheduler.instanceId", "AUTO");
//        // 线程池配置
//        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
//        prop.put("org.quartz.threadPool.threadCount", "3");
//        prop.put("org.quartz.threadPool.threadPriority", "5");
//        // JobStore配置:Scheduler在运行时用来存储相关的信息
//        // JDBCJobStore和JobStoreTX都使用关系数据库来存储Schedule相关的信息。
//        // JobStoreTX在每次执行任务后都使用commit或者rollback来提交更改。
//        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
//        // 集群配置：如果有多个调度器实体的话则必须设置为true
//        prop.put("org.quartz.jobStore.isClustered", "true");
//        // 集群配置：检查集群下的其他调度器实体的时间间隔
//        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
//        // 设置一个频度(毫秒)，用于实例报告给集群中的其他实例
//        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
//        // 触发器触发失败后再次触犯的时间间隔
//        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
//        // 数据库表前缀
//        prop.put("org.quartz.jobStore.tablePrefix", "qrtz_");
//        // 从 LOCKS 表查询一行并对这行记录加锁的 SQL 语句
//        prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");


        SchedulerFactory factory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = factory.getScheduler();
            JobDetail detail = JobBuilder.newJob(PrintWorkerJob.class).withIdentity("job1","group1").build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1","triggerGroup1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(1)
                    .repeatForever()).build();

            scheduler.scheduleJob(detail, trigger);
            System.out.println("-----scheduler start ! -----");
            scheduler.start();

            TimeUnit.SECONDS.sleep(10);
            scheduler.shutdown();
            System.out.println("-----scheduler shutdown ! -----");


        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
