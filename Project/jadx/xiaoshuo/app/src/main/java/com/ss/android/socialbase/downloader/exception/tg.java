package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes4.dex */
public class tg extends BaseException {
    private final long bf;
    private final long e;

    public tg(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.e = j;
        this.bf = j2;
    }

    public long bf() {
        return this.bf;
    }

    public long e() {
        return this.e;
    }
}
