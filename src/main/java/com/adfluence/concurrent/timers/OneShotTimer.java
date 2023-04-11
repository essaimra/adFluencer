package com.adfluence.concurrent.timers;

import commonj.timers.TimerListener;

public final class OneShotTimer extends FooTimer {

    /**
     * Creates a new instance of OneShotTimer.
     *
     * @param startTime start time
     * @param listener  the timer listener
     */
    public OneShotTimer(long startTime, TimerListener listener) {
        super(startTime, 0L, listener);
    }

    /**
     * Compute the next execution time - never again.
     *
     * @see com.adfluence.concurrent.timers.FooTimer#computeNextExecutionTime()
     */
    protected void computeNextExecutionTime() {
        // empty
    }

}
