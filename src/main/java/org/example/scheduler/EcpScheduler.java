package org.example.scheduler;

import org.example.KrtechEcp;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class EcpScheduler {

    public static void start() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail krtechEcp = JobBuilder.newJob(KrtechEcp.class)
                .withIdentity("krtechEcp", "group1")
                .build();


        Trigger krtechEcpTrigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger4", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 31 12 ? * MON"))
                .forJob(krtechEcp)
                .build();

        scheduler.scheduleJob(krtechEcp, krtechEcpTrigger);

        scheduler.start();
    }
}
