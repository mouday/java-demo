package timer;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;


public class QuartzDemo {
    public static void main(String[] args) throws SchedulerException {
        // 创建JobDetail

        JobDetail jobDetail = JobBuilder
                .newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("name", "jobDetail")
                .build();

        // 3秒钟之后执行第一次，之后每隔2s执行一次，重复3次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ? *"))
                .build();

        // 通过工厂方法创建Scheduler实例
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

    }
}
