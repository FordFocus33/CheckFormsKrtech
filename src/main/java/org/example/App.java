package org.example;

import org.quartz.SchedulerException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SchedulerException {

        ProgramScheduler.start();
    }
}
