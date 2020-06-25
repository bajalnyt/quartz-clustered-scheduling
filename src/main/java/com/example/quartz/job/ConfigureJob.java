package com.example.quartz.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {

    @Bean
    public JobDetail chaseJobDetails() {
        return JobBuilder.newJob(ChaseJob.class).withIdentity("ChaseJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail chaseJobDetails) {
        return TriggerBuilder.newTrigger().forJob(chaseJobDetails)
                .withIdentity("ChaseTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * ? * * *")) //Every 30 secs
                .build();
    }


    @Bean
    public JobDetail amexJobDetails() {
        return JobBuilder.newJob(AmexJob.class).withIdentity("AmexJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger amexJobTrigger(JobDetail amexJobDetails) {
        return TriggerBuilder.newTrigger().forJob(amexJobDetails)
                .withIdentity("AmexTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * ? * * *")) //Every minute
                .build();
    }

}
