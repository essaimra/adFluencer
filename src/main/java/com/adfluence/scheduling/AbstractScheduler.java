package com.adfluence.scheduling;


/**
 * this class is responsible for scheduling a configuration to run rating for the influencers.
 * */
public abstract class AbstractScheduler{

    protected final SlotTimeQueue jobs;

    protected AbstractScheduler(SlotTimeQueue jobs){
        this.jobs = jobs;
    }

    public abstract void runJobs();

    public boolean noJobsMore(){
        return jobs.isEmpty();
    }

}
