package com.adfluence.concurrent.util;

public interface Takable {

    /**
     * Return and remove an item from channel,
     * possibly waiting indefinitely until
     * such an item exists.
     *
     * @return some item from the channel. Different implementations
     * may guarantee various properties (such as FIFO) about that item
     * @throws InterruptedException if the current thread has
     *                              been interrupted at a point at which interruption
     *                              is detected, in which case state of the channel is unchanged.
     **/
    Object take() throws InterruptedException;


    /**
     * Return and remove an item from channel only if one is available within
     * msecs milliseconds. The time bound is interpreted in a coarse
     * grained, best-effort fashion.
     *
     * @param msecs the number of milliseconds to wait. If less than
     *              or equal to zero, the operation does not perform any timed waits,
     *              but might still require
     *              access to a synchronization lock, which can impose unbounded
     *              delay if there is a lot of contention for the channel.
     * @return some item, or null if the channel is empty.
     * @throws InterruptedException if the current thread has
     *                              been interrupted at a point at which interruption
     *                              is detected, in which case state of the channel is unchanged
     *                              (i.e., equivalent to a false return).
     **/

    Object poll(long msecs) throws InterruptedException;

}
