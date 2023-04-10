package com.adfluence;

import com.adfluence.resources.loader.Resource;
import com.adfluence.resources.loader.ResourceLoader;
import com.adfluence.scheduling.BackGroundTask;
import com.adfluence.scheduling.Job;
import com.adfluence.scheduling.SlotTimeQueue;
import com.adfluence.scheduling.TimeScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackGroundListener implements ApplicationListener<ApplicationReadyEvent>{

    private final List<Resource> resources;

    @Autowired
    public BackGroundListener(ResourceLoader resourceLoader){
        this.resources = resourceLoader.getResources();
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        SlotTimeQueue queue = new SlotTimeQueue();

        resources.forEach(
                resource -> {
                    Job job = new Job(resource);
                    queue.add(job);
                }
        );

        Thread thread = new Thread(
                new BackGroundTask(new TimeScheduler(queue))
        );

        thread.start();
    }
}
