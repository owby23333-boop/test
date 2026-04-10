package com.iflytek.aikit.core;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes7.dex */
public class SyncFIFO<E> extends LinkedList<E> {
    private final ReentrantLock lock = new ReentrantLock();

    public E get() throws InterruptedException {
        this.lock.lockInterruptibly();
        while (isEmpty()) {
            try {
                wait();
            } finally {
                this.lock.unlock();
            }
        }
        return poll();
    }

    public void put(E e) throws InterruptedException {
        this.lock.lockInterruptibly();
        try {
            addLast(e);
        } finally {
            this.lock.unlock();
        }
    }
}
