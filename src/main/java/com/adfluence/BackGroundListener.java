package com.adfluence;

import com.adfluence.resources.loader.Resource;
import com.adfluence.resources.loader.ResourceLoader;
import com.adfluence.scheduling.BackGroundTask;
import com.adfluence.scheduling.Job;
import com.adfluence.scheduling.SlotTimeQueue;
import com.adfluence.scheduling.TimeScheduler;
import com.adfluence.util.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class BackGroundListener implements ApplicationListener<ApplicationReadyEvent>{

    private final List<Resource> resources;
    private final Integer threadPoolSize;
    private final Integer delayTime;

    @Autowired
    public BackGroundListener(ResourceLoader resourceLoader,
                              @Value("${THREAD_POOL_SIZE}") Integer threadPoolSize,
                              @Value("${DELAY_TIME}") Integer delayTime){
        this.resources = resourceLoader.getResources();
        this.threadPoolSize = threadPoolSize;
        this.delayTime = delayTime;
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
        ThreadPool threadPool = new ThreadPool(new ScheduledThreadPoolExecutor(threadPoolSize));
        threadPool.submitScheduled(new BackGroundTask(new TimeScheduler(queue)), delayTime, TimeUnit.SECONDS);
    }
}
