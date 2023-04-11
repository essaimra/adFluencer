package com.adfluence.concurrent.timers;

import commonj.timers.TimerListener;

/**
 * Fixed delay timer.
 */
public final class FixedDelayTimer extends FooTimer {

    /**
     * Creates a new instance of FixedDelayTimer.
     *
     * @param startTime start time
     * @param period    execution period
     * @param listener  the timer listener for this timer.
     */
    public FixedDelayTimer(long startTime, long period, TimerListener listener) {
        super(startTime, period, listener);
    }

    /**
     * Compute the next execution time.
     *
     * @see com.adfluence.concurrent.timers.FooTimer#computeNextExecutionTime()
     */
    protected void computeNextExecutionTime() {
        scheduledExcecutionTime = System.currentTimeMillis() + period;
    }

}
