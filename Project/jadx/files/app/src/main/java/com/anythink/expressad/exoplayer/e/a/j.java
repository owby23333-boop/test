package com.anythink.expressad.exoplayer.e.a;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f8971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f8972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.anythink.expressad.exoplayer.m f8974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final long[] f8976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final long[] f8977k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final k[] f8979m;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public j(int i2, int i3, long j2, long j3, long j4, com.anythink.expressad.exoplayer.m mVar, int i4, @Nullable k[] kVarArr, int i5, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f8969c = i2;
        this.f8970d = i3;
        this.f8971e = j2;
        this.f8972f = j3;
        this.f8973g = j4;
        this.f8974h = mVar;
        this.f8975i = i4;
        this.f8979m = kVarArr;
        this.f8978l = i5;
        this.f8976j = jArr;
        this.f8977k = jArr2;
    }

    public final k a(int i2) {
        k[] kVarArr = this.f8979m;
        if (kVarArr == null) {
            return null;
        }
        return kVarArr[i2];
    }
}
