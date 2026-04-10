package com.bytedance.sdk.component.zk.e;

import com.bytedance.sdk.component.zk.e.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class tg<T extends d> {
    private BlockingQueue<T> bf = new LinkedBlockingQueue();
    private int e;

    private tg(int i) {
        this.e = i;
    }

    public static tg e(int i) {
        return new tg(i);
    }

    public T e() {
        return this.bf.poll();
    }

    public boolean e(T t) {
        if (t == null) {
            return false;
        }
        t.e();
        if (this.bf.size() >= this.e) {
            return false;
        }
        return this.bf.offer(t);
    }
}
