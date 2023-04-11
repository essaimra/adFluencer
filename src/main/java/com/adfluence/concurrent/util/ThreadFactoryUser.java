package com.adfluence.concurrent.util;

public class ThreadFactoryUser {

    protected ThreadFactory threadFactory_ = new DefaultThreadFactory();

    protected static class DefaultThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable command) {
            Thread thread = new Thread(command);
            thread.setPriority(Thread.MIN_PRIORITY);
            return thread;
        }

        @Override
        public Thread newThread(Runnable command, int i) {
            Thread thread = null;
            if (i % 5 == 0) {
                thread = new Thread(command);
                thread.setPriority(Thread.MAX_PRIORITY);
            }else {
                thread = newThread(command);
            }
            return thread;
        }
    }

    /**
     * Set the factory for creating new threads.
     * By default, new threads are created without any special priority,
     * threadgroup, or status parameters.
     * You can use a different factory
     * to change the kind of Thread class used or its construction
     * parameters.
     *
     * @param factory the factory to use
     * @return the previous factory
     **/

    public synchronized ThreadFactory setThreadFactory(ThreadFactory factory) {
        ThreadFactory old = threadFactory_;
        threadFactory_ = factory;
        return old;
    }

    /**
     * Get the factory for creating new threads.
     **/
    public synchronized ThreadFactory getThreadFactory() {
        return threadFactory_;
    }

}
