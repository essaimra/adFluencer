package com.adfluence.concurrent.util;

public interface ThreadFactory {
    /**
     * Create a new thread that will run the given command when started
     **/
    Thread newThread(Runnable command);

    Thread newThread(Runnable command, int i);
}
