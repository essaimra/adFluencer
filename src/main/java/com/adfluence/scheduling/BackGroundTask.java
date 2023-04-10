package com.adfluence.scheduling;

public class BackGroundTask implements Runnable{

    private final AbstractScheduler scheduler;

    public BackGroundTask(AbstractScheduler scheduler){
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        scheduler.runJobs();
    }
}
