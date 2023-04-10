package com.adfluence.scheduling.jobs.handlers;

import com.adfluence.scheduling.Job;

public interface IScheduleHandler{

    void handle(Job job);
}
