package com.adfluence.concurrent.util;

public interface BoundedChannel extends Channel {
    /**
     * Return the maximum number of elements that can be held.
     *
     * @return the capacity of this channel.
     **/
    int capacity();
}