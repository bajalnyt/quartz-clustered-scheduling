## Quartz Scheduler

![Java CI with Maven](https://github.com/bajalnyt/quartz-clustered-scheduling/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)

This project is a prototype to learn Quartz' scheduling capabilities, especially in a distributed (multi instance) enviroment. It uses a JDBC datasource (H2 or Oracle) to make sure the job runs only once.
To emulate a cluster, run the spring boot app multiple times (From IDE or via gradle)

The cron expressions are defined in ConfigureJob.java. There are two jobs defined to run every minute (Chase and Amex). Running multiple instances of the app causes the jobs to get randomly assigned to a spring boot instance.
