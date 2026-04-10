package com.yuewen;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class ya4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20276b;
    public final String c;
    public final int d;

    public ya4() {
        this(0, 0L, "", 0);
    }

    public ya4(Context context, int i, long j, int i2, int i3) {
        this(i, j, context.getResources().getString(i2), i3);
    }

    public ya4(int i, long j, String str, int i2) {
        this.f20275a = i;
        this.f20276b = j;
        this.c = str;
        this.d = i2;
    }
}
