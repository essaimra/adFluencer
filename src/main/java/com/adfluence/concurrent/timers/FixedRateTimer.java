package com.adfluence.concurrent.timers;

import commonj.timers.TimerListener;

/**
 * Fixed rate timer.
 */
public final class FixedRateTimer extends FooTimer {

    /**
     * Creates a new instance of FixedRateTimer.
     *
     * @param startTime start time
     * @param period    execution period
     * @param listener  the timer listener for this timer.
     */
    public FixedRateTimer(long startTime, long period, TimerListener listener) {
        super(startTime, period, listener);
    }

    /**
     * Compute the next execution time.
     *
     * @see com.adfluence.concurrent.timers.FooTimer#computeNextExecutionTime()
     */
    protected void computeNextExecutionTime() {
        long currentTime = System.currentTimeMillis();
        long execTime = scheduledExcecutionTime + period;

        while (execTime <= currentTime) {
            execTime += period;
        }

        scheduledExcecutionTime = execTime;
    }

}
