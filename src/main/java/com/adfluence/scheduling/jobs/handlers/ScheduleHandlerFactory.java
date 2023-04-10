package com.adfluence.scheduling.jobs.handlers;

import com.adfluence.scheduling.Job;

public class ScheduleHandlerFactory{

    private ScheduleHandlerFactory(){
        throw new IllegalStateException("UTILITY CLASS");
    }

    public static IScheduleHandler getHandler(Job job){
        return new ScheduleRatingHandler();
    }

}
