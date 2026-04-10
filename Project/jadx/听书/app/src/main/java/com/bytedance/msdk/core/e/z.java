package com.bytedance.msdk.core.e;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<Long> f384a = new LinkedList();
    private long dl;
    private long g;

    private z() {
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void z(long j, long j2) {
        synchronized (z.class) {
            if (this.g != j || this.dl != j2) {
                this.g = j;
                this.dl = j2;
                this.f384a.clear();
            }
        }
    }

    public boolean g() {
        synchronized (z.class) {
            if (this.g > 0 && this.dl > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.f384a.size() >= this.g) {
                    while (this.f384a.size() > this.g) {
                        this.f384a.poll();
                    }
                    if (Math.abs(jCurrentTimeMillis - this.f384a.peek().longValue()) <= this.dl) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }
}
