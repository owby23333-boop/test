package com.anythink.expressad.exoplayer.d;

import android.annotation.TargetApi;
import com.anythink.expressad.exoplayer.d.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public interface f<T extends i> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8817d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8818e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8819f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8820g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8821h = 4;

    public static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    int e();

    a f();

    T g();

    Map<String, String> h();

    byte[] i();
}
