package com.adfluence.scheduling.jobs.handlers;

import com.adfluence.scheduling.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduleRatingHandler implements IScheduleHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleRatingHandler.class);


    @Override
    public void handle(Job job) {
        LOGGER.info("Hello from Job {}", job);
    }
}
