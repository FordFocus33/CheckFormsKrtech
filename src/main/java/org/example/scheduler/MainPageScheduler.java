package org.example.scheduler;

import org.example.KrtechDialog;
import org.example.KrtechEcp;
import org.example.KrtechMainPage;
import org.example.KrtechOcom;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MainPageScheduler {

    public static void start() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail krtechMainPage = JobBuilder.newJob(KrtechMainPage.class)
                .withIdentity("krtechMainPage", "group1")
                .build();

        Trigger krtechMainPageTrigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger3", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 31 12 ? * MON"))
                .forJob(krtechMainPage)
                .build();

        scheduler.scheduleJob(krtechMainPage, krtechMainPageTrigger);

        scheduler.start();
    }
}
