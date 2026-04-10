package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.e.dl;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2107a;
    private long dl;
    private long e;
    private boolean fo;
    private int g;
    private String gc;
    private int gz;
    private int m = 0;
    protected Notification z;

    public abstract void z(com.ss.android.socialbase.downloader.gc.z zVar, boolean z);

    public z(int i, String str) {
        this.g = i;
        this.gc = str;
    }

    public void z(dl dlVar) {
        if (dlVar == null) {
            return;
        }
        this.g = dlVar.e();
        this.gc = dlVar.fo();
    }

    public int z() {
        return this.g;
    }

    public long g() {
        return this.dl;
    }

    public void z(long j) {
        this.dl = j;
    }

    public long dl() {
        return this.f2107a;
    }

    public void g(long j) {
        this.f2107a = j;
    }

    public String a() {
        return this.gc;
    }

    public int gc() {
        return this.m;
    }

    public void z(int i, com.ss.android.socialbase.downloader.gc.z zVar, boolean z) {
        z(i, zVar, z, false);
    }

    public void z(int i, com.ss.android.socialbase.downloader.gc.z zVar, boolean z, boolean z2) {
        if (z2 || this.m != i) {
            this.m = i;
            z(zVar, z);
        }
    }

    public long m() {
        if (this.e == 0) {
            this.e = System.currentTimeMillis();
        }
        return this.e;
    }

    public void z(long j, long j2) {
        this.dl = j;
        this.f2107a = j2;
        this.m = 4;
        z((com.ss.android.socialbase.downloader.gc.z) null, false);
    }

    public void z(Notification notification) {
        if (this.g == 0 || notification == null) {
            return;
        }
        g.z().z(this.g, this.m, notification);
    }

    public synchronized void e() {
        this.gz++;
    }

    public boolean gz() {
        return this.fo;
    }
}
