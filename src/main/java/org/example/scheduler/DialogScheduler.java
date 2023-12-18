package org.example.scheduler;

import org.example.KrtechDialog;
import org.example.KrtechEcp;
import org.example.KrtechMainPage;
import org.example.KrtechOcom;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class DialogScheduler {

    public static void start() throws SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail krtechDialog = JobBuilder.newJob(KrtechDialog.class)
                .withIdentity("krtechDialog", "group1")
                .build();

        Trigger krtechDialogTrigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 31 12 ? * MON"))
                .forJob(krtechDialog)
                .build();

        scheduler.scheduleJob(krtechDialog, krtechDialogTrigger);

        scheduler.start();
    }
}
