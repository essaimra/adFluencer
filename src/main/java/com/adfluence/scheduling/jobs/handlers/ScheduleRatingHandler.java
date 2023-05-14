package com.adfluence.scheduling.jobs.handlers;

import com.adfluence.scheduling.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ScheduleRatingHandler implements IScheduleHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleRatingHandler.class);
    @Override
    public void handle(Job job) {

        Date date = new Date();

        if (date.before(job.getResource().getDate())){
            process();
        }else {
            LOGGER.info("Hello from Job {}", Thread.currentThread().getName());
        }
    }


    private void process(){

    }

}
