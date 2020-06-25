## Quartz Scheduler

This uses a local datasource to make sure the job runs only once.
The purpose is to test if the jobs get allocated to an instance. To simulate a cluster, run the spting boot app multiple times (From IDE or via gradle)

The crons are defined in java class ConfigureJob but it can be taken out to a file as well. There are two jobs defined to run every minute (Chase and Amex). Then I booted up multiple instances of the spring boot app in my local and made sure the 2 jobs only run once every minute (They get randomly assigned to a spring boot instance)
