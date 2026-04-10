package com.yuewen;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes12.dex */
public abstract class az3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<T> f8916a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8917b = 30;

    public T a() {
        T tPoll = this.f8916a.poll();
        return tPoll == null ? c() : tPoll;
    }

    public abstract void b(T t);

    public abstract T c();

    public void d(T t) {
        b(t);
        if (this.f8916a.size() < 30) {
            this.f8916a.add(t);
        }
    }
}
