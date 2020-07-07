package com.example.quartz.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {

    @Value("${chaseJobCronExpression}")
    private String chaseJobCronExpression;

    @Value("${amexJobCronExpression}")
    private String amexJobCronExpression;

    @Bean
    public JobDetail chaseJobDetails() {
        return JobBuilder.newJob(ChaseJob.class).withIdentity("ChaseJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger chaseJobTrigger(JobDetail chaseJobDetails) {
        return TriggerBuilder.newTrigger().forJob(chaseJobDetails)
                .withIdentity("ChaseTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(chaseJobCronExpression)) //Every 30 secs
                .build();
    }

    @Bean
    public JobDetail amexJobDetails() {
        // Set Retry Limit
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("retries", 3);
        return JobBuilder.newJob(AmexJob.class).withIdentity("AmexJob")
                .usingJobData(jobDataMap)
                .storeDurably().build();
    }

    @Bean
    public Trigger amexJobTrigger(JobDetail amexJobDetails) {
        return TriggerBuilder.newTrigger().forJob(amexJobDetails)
                .withIdentity("AmexTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(amexJobCronExpression)) //Every minute
                .build();
    }

}
