package com.ss.android.socialbase.downloader.gc;

/* JADX INFO: loaded from: classes4.dex */
public class gc extends z {
    private final long g;
    private final long z;

    public gc(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.z = j;
        this.g = j2;
    }

    public long a() {
        return this.z;
    }

    public long gc() {
        return this.g;
    }
}
