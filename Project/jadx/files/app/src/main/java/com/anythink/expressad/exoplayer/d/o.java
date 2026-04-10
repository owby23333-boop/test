package com.anythink.expressad.exoplayer.d;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends Exception {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8829c;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    private o(int i2) {
        this.f8829c = i2;
    }

    public o(Exception exc) {
        super(exc);
        this.f8829c = 2;
    }
}
