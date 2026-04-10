package com.anythink.expressad.exoplayer;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Exception {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9069c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9071e;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private g(int i2, String str, Throwable th, int i3) {
        super(str, th);
        this.f9070d = i2;
        this.f9071e = i3;
    }

    public static g a(Exception exc, int i2) {
        return new g(1, null, exc, i2);
    }

    private Exception b() {
        com.anythink.expressad.exoplayer.k.a.b(this.f9070d == 1);
        return (Exception) getCause();
    }

    private RuntimeException c() {
        com.anythink.expressad.exoplayer.k.a.b(this.f9070d == 2);
        return (RuntimeException) getCause();
    }

    public static g a(IOException iOException) {
        return new g(0, null, iOException, -1);
    }

    static g a(RuntimeException runtimeException) {
        return new g(2, null, runtimeException, -1);
    }

    private IOException a() {
        com.anythink.expressad.exoplayer.k.a.b(this.f9070d == 0);
        return (IOException) getCause();
    }
}
