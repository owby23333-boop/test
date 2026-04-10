package com.bytedance.sdk.component.uy.g;

import com.bytedance.sdk.component.uy.g.dl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class a<T extends dl> {
    private BlockingQueue<T> g = new LinkedBlockingQueue();
    private int z;

    public static a z(int i) {
        return new a(i);
    }

    private a(int i) {
        this.z = i;
    }

    public T z() {
        return this.g.poll();
    }

    public boolean z(T t) {
        if (t == null) {
            return false;
        }
        t.z();
        if (this.g.size() >= this.z) {
            return false;
        }
        return this.g.offer(t);
    }
}
