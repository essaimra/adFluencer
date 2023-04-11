package com.adfluence.concurrent.timers;


public final class TimerExecutor implements Runnable {

    private boolean running = false;
    private FooTimer timer;
    private FooTimerManager timerManager;

    /**
     * Creates a new instance of TimerExecutor.
     */
    public TimerExecutor(FooTimer timer, FooTimerManager timerManager) {
        this.timer = timer;
        this.timerManager = timerManager;
    }

    /**
     * run method to execute a timer
     */
    public void run() {

        running = true;
        try {
            // execute the timer
            timer.execute();

            // compute next execution time
            timer.computeNextExecutionTime();
        } catch (Exception e) {
            // ignore
        } finally {
            running = false;
            try {
                timerManager.notifyAll();
            } catch (Exception ex) {
                //ignore
            }
        }
    }

    /**
     * Getter for timer
     *
     * @return Returns the timer.
     */
    public FooTimer getTimer() {
        return timer;
    }

    /**
     * Setter for timer
     *
     * @param timer The timer to set.
     */
    public void setTimer(FooTimer timer) {
        this.timer = timer;
    }

    /**
     * Getter for timerManager
     *
     * @return Returns the timerManager.
     */
    public FooTimerManager getTimerManager() {
        return timerManager;
    }

    /**
     * Setter for timerManager
     *
     * @param timerManager The timerManager to set.
     */
    public void setTimerManager(FooTimerManager timerManager) {
        this.timerManager = timerManager;
    }

    /**
     * Is timer running
     *
     * @return <code>true</code> if timer is running
     */
    public boolean isRunning() {
        return running;
    }

}
