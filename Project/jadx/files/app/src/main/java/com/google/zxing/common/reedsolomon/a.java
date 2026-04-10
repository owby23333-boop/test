package com.google.zxing.common.reedsolomon;

import com.qq.e.comm.adevent.AdEventType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;

/* JADX INFO: compiled from: GenericGF.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f16171h = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f16172i = new a(DownloadErrorCode.ERROR_CHUNK_NOT_EQUALS_CACHE, 1024, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f16173j = new a(67, 64, 1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f16174k = new a(19, 16, 1);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f16175l = new a(285, 256, 0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f16176m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f16177n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f16178o;
    private final int[] a;
    private final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f16179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f16180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16183g;

    static {
        a aVar = new a(AdEventType.VIDEO_PAGE_OPEN, 256, 1);
        f16176m = aVar;
        f16177n = aVar;
        f16178o = f16173j;
    }

    public a(int i2, int i3, int i4) {
        this.f16182f = i2;
        this.f16181e = i3;
        this.f16183g = i4;
        this.a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.a[i7]] = i7;
        }
        this.f16179c = new b(this, new int[]{0});
        this.f16180d = new b(this, new int[]{1});
    }

    static int c(int i2, int i3) {
        return i2 ^ i3;
    }

    b a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f16179c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new b(this, iArr);
    }

    b b() {
        return this.f16180d;
    }

    int c(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    b d() {
        return this.f16179c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f16182f) + ',' + this.f16181e + ')';
    }

    int b(int i2) {
        if (i2 != 0) {
            return this.a[(this.f16181e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c() {
        return this.f16181e;
    }

    int b(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f16181e - 1)];
    }

    int a(int i2) {
        return this.a[i2];
    }

    public int a() {
        return this.f16183g;
    }
}
