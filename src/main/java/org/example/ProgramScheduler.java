package org.example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;

public class ProgramScheduler {

    public static void start() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail krtechDialog = JobBuilder.newJob(KrtechDialog.class)
                                .withIdentity("krtechDialog", "group1")
                                .build();
        JobDetail krtechOcom = JobBuilder.newJob(KrtechOcom.class)
                                .withIdentity("krtechOcom", "group1")
                                .build();
        JobDetail krtechMainPage = JobBuilder.newJob(KrtechMainPage.class)
                                .withIdentity("krtechMainPage", "group1")
                                .build();
        JobDetail krtechEcp = JobBuilder.newJob(KrtechEcp.class)
                                .withIdentity("krtechEcp", "group1")
                                .build();

        Trigger krtechDialogTrigger = TriggerBuilder.newTrigger()
                                .withIdentity("myTrigger", "group1")
                                .withSchedule(CronScheduleBuilder.cronSchedule("0 35 9 ? * MON"))
                                .forJob(krtechDialog)
                                .build();

        Trigger krtechOcomTrigger = TriggerBuilder.newTrigger()
                                .withIdentity("myTrigger2", "group1")
                                .withSchedule(CronScheduleBuilder.cronSchedule("0 35 9 ? * MON"))
                                .forJob(krtechOcom)
                                .build();

        Trigger krtechMainPageTrigger = TriggerBuilder.newTrigger()
                                .withIdentity("myTrigger3", "group1")
                                .withSchedule(CronScheduleBuilder.cronSchedule("0 35 9 ? * MON"))
                                .forJob(krtechMainPage)
                                .build();

        Trigger krtechEcpTrigger = TriggerBuilder.newTrigger()
                                .withIdentity("myTrigger4", "group1")
                                .withSchedule(CronScheduleBuilder.cronSchedule("0 35 9 ? * MON"))
                                .forJob(krtechEcp)
                                .build();

        scheduler.scheduleJob(krtechDialog, krtechDialogTrigger);
        scheduler.scheduleJob(krtechMainPage, krtechMainPageTrigger);
        scheduler.scheduleJob(krtechOcom, krtechOcomTrigger);
        scheduler.scheduleJob(krtechEcp, krtechEcpTrigger);

        scheduler.start();
    }
}
