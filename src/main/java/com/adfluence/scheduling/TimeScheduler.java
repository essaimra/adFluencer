package com.adfluence.scheduling;

import com.adfluence.scheduling.jobs.handlers.IScheduleHandler;
import com.adfluence.scheduling.jobs.handlers.ScheduleHandlerFactory;

public class TimeScheduler extends AbstractScheduler{

    public TimeScheduler(SlotTimeQueue jobs){
        super(jobs);
    }

    @Override
    public void runJobs() {
        while (!jobs.isEmpty()){
            Job job = jobs.poll();
            IScheduleHandler scheduleHandler = ScheduleHandlerFactory.getHandler(job);
            scheduleHandler.handle(job);
        }
    }
}
