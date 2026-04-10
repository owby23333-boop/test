package com.liulishuo.filedownloader;

import android.os.SystemClock;

/* JADX INFO: compiled from: DownloadSpeedMonitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements s, r {
    private long a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f17070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f17071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17073f = 1000;

    @Override // com.liulishuo.filedownloader.s
    public void end(long j2) {
        if (this.f17071d <= 0) {
            return;
        }
        long j3 = j2 - this.f17070c;
        this.a = 0L;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f17071d;
        if (jUptimeMillis <= 0) {
            this.f17072e = (int) j3;
        } else {
            this.f17072e = (int) (j3 / jUptimeMillis);
        }
    }

    @Override // com.liulishuo.filedownloader.s
    public void reset() {
        this.f17072e = 0;
        this.a = 0L;
    }

    @Override // com.liulishuo.filedownloader.s
    public void start(long j2) {
        this.f17071d = SystemClock.uptimeMillis();
        this.f17070c = j2;
    }

    @Override // com.liulishuo.filedownloader.s
    public void update(long j2) {
        if (this.f17073f <= 0) {
            return;
        }
        boolean z2 = true;
        if (this.a != 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.a;
            if (jUptimeMillis >= this.f17073f || (this.f17072e == 0 && jUptimeMillis > 0)) {
                this.f17072e = (int) ((j2 - this.b) / jUptimeMillis);
                this.f17072e = Math.max(0, this.f17072e);
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this.b = j2;
            this.a = SystemClock.uptimeMillis();
        }
    }
}
