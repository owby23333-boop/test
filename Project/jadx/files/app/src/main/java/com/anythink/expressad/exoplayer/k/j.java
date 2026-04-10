package com.anythink.expressad.exoplayer.k;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public final int a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f9855h;

    private j(byte[] bArr, int i2) {
        r rVar = new r(bArr);
        rVar.a(i2 * 8);
        this.a = rVar.c(16);
        this.b = rVar.c(16);
        this.f9850c = rVar.c(24);
        this.f9851d = rVar.c(24);
        this.f9852e = rVar.c(20);
        this.f9853f = rVar.c(3) + 1;
        this.f9854g = rVar.c(5) + 1;
        this.f9855h = ((((long) rVar.c(4)) & 15) << 32) | (((long) rVar.c(32)) & 4294967295L);
    }

    private int a() {
        return this.b * this.f9853f * (this.f9854g / 8);
    }

    private int b() {
        return this.f9854g * this.f9852e;
    }

    private long c() {
        return (this.f9855h * 1000000) / ((long) this.f9852e);
    }

    private long d() {
        long j2;
        long j3;
        int i2 = this.f9851d;
        if (i2 > 0) {
            j2 = (((long) i2) + ((long) this.f9850c)) / 2;
            j3 = 1;
        } else {
            int i3 = this.a;
            j2 = ((((i3 != this.b || i3 <= 0) ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : i3) * ((long) this.f9853f)) * ((long) this.f9854g)) / 8;
            j3 = 64;
        }
        return j2 + j3;
    }

    private long a(long j2) {
        return af.a((j2 * ((long) this.f9852e)) / 1000000, this.f9855h - 1);
    }

    private j(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2) {
        this.a = i2;
        this.b = i3;
        this.f9850c = i4;
        this.f9851d = i5;
        this.f9852e = i6;
        this.f9853f = i7;
        this.f9854g = i8;
        this.f9855h = j2;
    }
}
