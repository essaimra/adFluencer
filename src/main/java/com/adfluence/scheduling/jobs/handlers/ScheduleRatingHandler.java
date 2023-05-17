package com.adfluence.scheduling.jobs.handlers;

import com.adfluence.services.rating.algorithm.RatingAlgorithm;
import com.adfluence.scheduling.Job;
import com.adfluence.util.SpringInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ScheduleRatingHandler implements IScheduleHandler{

    private final RatingAlgorithm ratingAlgorithm;

    public ScheduleRatingHandler(){
        this.ratingAlgorithm = SpringInjector.getInstanceByType(RatingAlgorithm.class);
    }

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
        this.ratingAlgorithm.rate();
    }
}
