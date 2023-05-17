package com.adfluence.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool{


    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPool.class);
    private final ExecutorService executorService;


    public ThreadPool(ExecutorService executorService){
        this.executorService = executorService;
    }

    public void submitScheduled(Runnable task, int delay, TimeUnit timeUnit){
        if (!(executorService instanceof ScheduledExecutorService)){
            LOGGER.error("You need to schedule in not scheduled thread pool? try to not use it");
            return;
        }

        ((ScheduledExecutorService) executorService).scheduleAtFixedRate(task, 0, delay, timeUnit);
    }

}
