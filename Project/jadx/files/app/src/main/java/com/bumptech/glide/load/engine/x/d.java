package com.bumptech.glide.load.engine.x;

import com.bumptech.glide.load.engine.x.m;
import java.util.Queue;

/* JADX INFO: compiled from: BaseKeyPool.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class d<T extends m> {
    private final Queue<T> a = com.bumptech.glide.util.l.a(20);

    d() {
    }

    abstract T a();

    public void a(T t2) {
        if (this.a.size() < 20) {
            this.a.offer(t2);
        }
    }

    T b() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }
}
