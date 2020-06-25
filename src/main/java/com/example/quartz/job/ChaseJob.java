package com.example.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

@DisallowConcurrentExecution
public class ChaseJob implements Job {


    @Override
    public void execute(JobExecutionContext context) {
        System.out.println(new Date() + ": Running Chase Job!");
        try {
            System.out.println(new Date() + ": sleeping in Chase Job!");
            Thread.sleep(60 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + ": Completed Chase Job!");
    }
}
