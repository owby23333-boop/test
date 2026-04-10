package com.bytedance.sdk.component.uy.z;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class z<T> implements BlockingQueue<T> {
    private final BlockingQueue<T> z;

    @Override // java.util.Collection
    public Object[] toArray() {
        return new Object[0];
    }

    public z(BlockingQueue blockingQueue) {
        if (blockingQueue == null) {
            this.z = new SynchronousQueue();
        } else {
            this.z = blockingQueue;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public T take() throws InterruptedException {
        return this.z.take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public T poll(long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            return this.z.poll(j, timeUnit);
        } catch (IllegalMonitorStateException unused) {
            return null;
        }
    }

    public final String z() {
        return this.z.getClass().getName();
    }

    public final BlockingQueue g() {
        return this.z;
    }

    public int dl() {
        return this.z.size();
    }

    @Override // java.util.Collection
    public final int size() {
        return dl();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection
    public boolean add(T t) {
        return this.z.add(t);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.z.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.z.clear();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean contains(Object obj) {
        return this.z.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.z.containsAll(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return this.z.drainTo(collection);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i) {
        return this.z.drainTo(collection, i);
    }

    @Override // java.util.Queue
    public T element() {
        return this.z.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.z.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.z.iterator();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue
    public boolean offer(T t) {
        return this.z.offer(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(T t, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.z.offer(t, j, timeUnit);
    }

    @Override // java.util.Queue
    public T peek() {
        return this.z.peek();
    }

    @Override // java.util.Queue
    public T poll() {
        return this.z.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(T t) throws InterruptedException {
        this.z.put(t);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.z.remainingCapacity();
    }

    @Override // java.util.Queue
    public T remove() {
        return this.z.remove();
    }

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection
    public boolean remove(Object obj) {
        return this.z.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.z.removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.z.retainAll(collection);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }
}
