package com.adfluence.scheduling;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlotTimeQueue{

    private final Queue<Job> queue = new PriorityQueue<>(Comparator.comparing(o -> o.getResource().getDate()));

    public void add(Job job){
        queue.add(job);
    }

    public Job poll(){
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void addAll(List<Job> jobs){
        queue.addAll(jobs);
    }
}
