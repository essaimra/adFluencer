package com.adfluence.scheduling;


import java.util.Queue;

/**
 * this class is responsible for scheduling a configuration to run rating for the influencers.
 * */
public abstract class AbstractScheduler{

    protected final SlotTimeQueue jobs;

    protected AbstractScheduler(SlotTimeQueue jobs){
        this.jobs = jobs;
    }

    public abstract void runJobs();

}
