package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f9667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f9668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f9670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f9671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f9672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f9673i;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public k(Uri uri) {
        this(uri, 0);
    }

    public final boolean a(int i2) {
        return (this.f9673i & i2) == i2;
    }

    public final String toString() {
        return "DataSpec[" + this.f9667c + ", " + Arrays.toString(this.f9668d) + ", " + this.f9669e + ", " + this.f9670f + ", " + this.f9671g + ", " + this.f9672h + ", " + this.f9673i + "]";
    }

    public k(Uri uri, int i2) {
        this(uri, 0L, -1L, null, i2);
    }

    public final k a(long j2) {
        long j3 = this.f9671g;
        long j4 = j3 != -1 ? j3 - j2 : -1L;
        return (j2 == 0 && this.f9671g == j4) ? this : new k(this.f9667c, this.f9668d, this.f9669e + j2, this.f9670f + j2, j4, this.f9672h, this.f9673i);
    }

    public k(Uri uri, long j2, @Nullable String str) {
        this(uri, j2, j2, -1L, str, 0);
    }

    public k(Uri uri, long j2, long j3, @Nullable String str, int i2) {
        this(uri, j2, j2, j3, str, i2);
    }

    public k(Uri uri, long j2, long j3, long j4, @Nullable String str, int i2) {
        this(uri, null, j2, j3, j4, str, i2);
    }

    private k a(long j2, long j3) {
        return (j2 == 0 && this.f9671g == j3) ? this : new k(this.f9667c, this.f9668d, this.f9669e + j2, this.f9670f + j2, j3, this.f9672h, this.f9673i);
    }

    public k(Uri uri, @Nullable byte[] bArr, long j2, long j3, long j4, @Nullable String str, int i2) {
        boolean z2 = true;
        com.anythink.expressad.exoplayer.k.a.a(j2 >= 0);
        com.anythink.expressad.exoplayer.k.a.a(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z2 = false;
        }
        com.anythink.expressad.exoplayer.k.a.a(z2);
        this.f9667c = uri;
        this.f9668d = bArr;
        this.f9669e = j2;
        this.f9670f = j3;
        this.f9671g = j4;
        this.f9672h = str;
        this.f9673i = i2;
    }

    private k a(Uri uri) {
        return new k(uri, this.f9668d, this.f9669e, this.f9670f, this.f9671g, this.f9672h, this.f9673i);
    }
}
