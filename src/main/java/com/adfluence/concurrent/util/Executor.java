package com.adfluence.concurrent.util;

public interface Executor {

    /**
     * Execute the given command. This method is guaranteed
     * only to arrange for execution, that may actually
     * occur sometime later; for example in a new
     * thread. However, in fully generic use, callers
     * should be prepared for execution to occur in
     * any fashion at all, including immediate direct
     * execution.
     * <p>
     * The method is defined not to throw
     * any checked exceptions during execution of the command. Generally,
     * any problems encountered will be asynchronous and
     * so must be dealt with via callbacks or error handler
     * objects. If necessary, any context-dependent
     * catastrophic errors encountered during
     * actions that arrange for execution could be accompanied
     * by throwing context-dependent unchecked exceptions.
     * <p>
     * However, the method does throw InterruptedException:
     * It will fail to arrange for execution
     * if the current thread is currently interrupted.
     * Further, the general contract of the method is to avoid,
     * suppress, or abort execution if interruption is detected
     * in any controllable context surrounding execution.
     **/
    void execute(Runnable command) throws InterruptedException;

}
