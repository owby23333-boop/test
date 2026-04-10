package com.danikula.videocache.q;

import java.io.File;

/* JADX INFO: compiled from: TotalSizeLruDiskUsage.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends e {
    private final long b;

    public g(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.b = j2;
    }

    @Override // com.danikula.videocache.q.e
    protected boolean a(File file, long j2, int i2) {
        return j2 <= this.b;
    }
}
