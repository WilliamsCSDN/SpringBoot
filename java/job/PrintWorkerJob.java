package job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintWorkerJob implements Job {
    private AtomicInteger cout = new AtomicInteger(1);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("当前时间为" + new Date());
        System.out.println("当前次数为" + cout);
        cout.incrementAndGet();
    }
}
