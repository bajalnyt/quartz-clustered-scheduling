package com.example.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

public class AmexJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        System.out.println(new Date() + ": Running Amex Job!");
    }
}
