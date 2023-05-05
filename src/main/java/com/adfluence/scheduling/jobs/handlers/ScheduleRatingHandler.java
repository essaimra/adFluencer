package com.adfluence.scheduling.jobs.handlers;

import com.adfluence.scheduling.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ScheduleRatingHandler implements IScheduleHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleRatingHandler.class);


    @Override
    public void handle(Job job) {

        List<KillGC> killGCS = new ArrayList<>();

        for (int i=0;i<1000;i++){
            KillGC killGC = new KillGC();
            killGCS.add(killGC);
        }

        LOGGER.info("Hello from Job {}", killGCS.size());
    }
}
