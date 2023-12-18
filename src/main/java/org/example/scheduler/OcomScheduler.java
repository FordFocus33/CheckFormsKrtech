package org.example.scheduler;

import org.example.KrtechDialog;
import org.example.KrtechEcp;
import org.example.KrtechMainPage;
import org.example.KrtechOcom;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class OcomScheduler {

    public static void start() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail krtechOcom = JobBuilder.newJob(KrtechOcom.class)
                .withIdentity("krtechOcom", "group1")
                .build();


        Trigger krtechOcomTrigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger2", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 31 12 ? * MON"))
                .forJob(krtechOcom)
                .build();


        scheduler.scheduleJob(krtechOcom, krtechOcomTrigger);

        scheduler.start();
    }
}
