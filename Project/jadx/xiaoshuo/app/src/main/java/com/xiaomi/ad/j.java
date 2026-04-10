package com.xiaomi.ad;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7268b;
    public InputStream c;

    public j(int i, long j, InputStream inputStream) {
        this.f7267a = i;
        this.c = inputStream;
        this.f7268b = j;
    }

    public long a() {
        return this.f7268b;
    }

    public InputStream b() {
        return this.c;
    }

    public int c() {
        return this.f7267a;
    }

    public boolean d() {
        return this.f7267a == 200;
    }
}
