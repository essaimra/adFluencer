package com.adfluence.concurrent.util;

public class LinkedNode {
    public Object value;
    public LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(Object x) {
        value = x;
    }

    public LinkedNode(Object x, LinkedNode n) {
        value = x;
        next = n;
    }
}
