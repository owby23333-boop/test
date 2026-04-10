package com.anythink.expressad.exoplayer.h.a;

import android.net.Uri;
import androidx.annotation.CheckResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9164c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9165d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9166e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f9167f = new a(new long[0]);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f9169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C0192a[] f9170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f9171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f9172k;

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.h.a.a$a, reason: collision with other inner class name */
    public static final class C0192a {
        public final int a;
        public final Uri[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f9173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f9174d;

        public C0192a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private int c() {
            return a(-1);
        }

        public final int a(int i2) {
            int i3 = i2 + 1;
            while (true) {
                int[] iArr = this.f9173c;
                if (i3 >= iArr.length || iArr[i3] == 0 || iArr[i3] == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        @CheckResult
        public final C0192a b(int i2) {
            com.anythink.expressad.exoplayer.k.a.a(this.a == -1 && this.f9173c.length <= i2);
            return new C0192a(i2, a(this.f9173c, i2), (Uri[]) Arrays.copyOf(this.b, i2), a(this.f9174d, i2));
        }

        private C0192a(int i2, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.anythink.expressad.exoplayer.k.a.a(iArr.length == uriArr.length);
            this.a = i2;
            this.f9173c = iArr;
            this.b = uriArr;
            this.f9174d = jArr;
        }

        public final boolean a() {
            return this.a == -1 || a(-1) < this.a;
        }

        @CheckResult
        public final C0192a a(Uri uri, int i2) {
            int i3 = this.a;
            com.anythink.expressad.exoplayer.k.a.a(i3 == -1 || i2 < i3);
            int[] iArrA = a(this.f9173c, i2 + 1);
            com.anythink.expressad.exoplayer.k.a.a(iArrA[i2] == 0);
            long[] jArrA = this.f9174d;
            if (jArrA.length != iArrA.length) {
                jArrA = a(jArrA, iArrA.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.b, iArrA.length);
            uriArr[i2] = uri;
            iArrA[i2] = 1;
            return new C0192a(this.a, iArrA, uriArr, jArrA);
        }

        @CheckResult
        public final C0192a b() {
            if (this.a == -1) {
                return new C0192a(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.f9173c;
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length);
            for (int i2 = 0; i2 < length; i2++) {
                if (iArrCopyOf[i2] == 1 || iArrCopyOf[i2] == 0) {
                    iArrCopyOf[i2] = 2;
                }
            }
            return new C0192a(length, iArrCopyOf, this.b, this.f9174d);
        }

        @CheckResult
        public final C0192a a(int i2, int i3) {
            int i4 = this.a;
            com.anythink.expressad.exoplayer.k.a.a(i4 == -1 || i3 < i4);
            int[] iArrA = a(this.f9173c, i3 + 1);
            com.anythink.expressad.exoplayer.k.a.a(iArrA[i3] == 0 || iArrA[i3] == 1 || iArrA[i3] == i2);
            long[] jArrA = this.f9174d;
            if (jArrA.length != iArrA.length) {
                jArrA = a(jArrA, iArrA.length);
            }
            Uri[] uriArr = this.b;
            if (uriArr.length != iArrA.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, iArrA.length);
            }
            iArrA[i3] = i2;
            return new C0192a(this.a, iArrA, uriArr, jArrA);
        }

        @CheckResult
        public final C0192a a(long[] jArr) {
            com.anythink.expressad.exoplayer.k.a.a(this.a == -1 || jArr.length <= this.b.length);
            int length = jArr.length;
            Uri[] uriArr = this.b;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            }
            return new C0192a(this.a, this.f9173c, this.b, jArr);
        }

        @CheckResult
        private static int[] a(int[] iArr, int i2) {
            int length = iArr.length;
            int iMax = Math.max(i2, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        @CheckResult
        private static long[] a(long[] jArr, int i2) {
            int length = jArr.length;
            int iMax = Math.max(i2, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, com.anythink.expressad.exoplayer.b.b);
            return jArrCopyOf;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    private a(long... jArr) {
        this.f9168g = 0;
        this.f9169h = Arrays.copyOf(jArr, 0);
        this.f9170i = new C0192a[0];
        this.f9171j = 0L;
        this.f9172k = com.anythink.expressad.exoplayer.b.b;
    }

    private int a(long j2) {
        int length = this.f9169h.length - 1;
        while (length >= 0) {
            long[] jArr = this.f9169h;
            if (jArr[length] != Long.MIN_VALUE && jArr[length] <= j2) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.f9170i[length].a()) {
            return -1;
        }
        return length;
    }

    private int b(long j2) {
        int i2 = 0;
        while (true) {
            long[] jArr = this.f9169h;
            if (i2 >= jArr.length || jArr[i2] == Long.MIN_VALUE || (j2 < jArr[i2] && this.f9170i[i2].a())) {
                break;
            }
            i2++;
        }
        if (i2 < this.f9169h.length) {
            return i2;
        }
        return -1;
    }

    @CheckResult
    private a c(int i2, int i3) {
        C0192a[] c0192aArr = this.f9170i;
        C0192a[] c0192aArr2 = (C0192a[]) Arrays.copyOf(c0192aArr, c0192aArr.length);
        c0192aArr2[i2] = c0192aArr2[i2].a(2, i3);
        return new a(this.f9169h, c0192aArr2, this.f9171j, this.f9172k);
    }

    @CheckResult
    private a d(int i2, int i3) {
        C0192a[] c0192aArr = this.f9170i;
        C0192a[] c0192aArr2 = (C0192a[]) Arrays.copyOf(c0192aArr, c0192aArr.length);
        c0192aArr2[i2] = c0192aArr2[i2].a(4, i3);
        return new a(this.f9169h, c0192aArr2, this.f9171j, this.f9172k);
    }

    @CheckResult
    private a a(int i2, int i3) {
        com.anythink.expressad.exoplayer.k.a.a(i3 > 0);
        C0192a[] c0192aArr = this.f9170i;
        if (c0192aArr[i2].a == i3) {
            return this;
        }
        C0192a[] c0192aArr2 = (C0192a[]) Arrays.copyOf(c0192aArr, c0192aArr.length);
        c0192aArr2[i2] = this.f9170i[i2].b(i3);
        return new a(this.f9169h, c0192aArr2, this.f9171j, this.f9172k);
    }

    @CheckResult
    private a b(int i2, int i3) {
        C0192a[] c0192aArr = this.f9170i;
        C0192a[] c0192aArr2 = (C0192a[]) Arrays.copyOf(c0192aArr, c0192aArr.length);
        c0192aArr2[i2] = c0192aArr2[i2].a(3, i3);
        return new a(this.f9169h, c0192aArr2, this.f9171j, this.f9172k);
    }

    @CheckResult
    private a c(long j2) {
        return this.f9171j == j2 ? this : new a(this.f9169h, this.f9170i, j2, this.f9172k);
    }

    @CheckResult
    private a d(long j2) {
        return this.f9172k == j2 ? this : new a(this.f9169h, this.f9170i, this.f9171j, j2);
    }

    private a(long[] jArr, C0192a[] c0192aArr, long j2, long j3) {
        this.f9168g = c0192aArr.length;
        this.f9169h = jArr;
        this.f9170i = c0192aArr;
        this.f9171j = j2;
        this.f9172k = j3;
    }

    @CheckResult
    private a a(int i2, int i3, Uri uri) {
        C0192a[] c0192aArr = this.f9170i;
        C0192a[] c0192aArr2 = (C0192a[]) Arrays.copyOf(c0192aArr, c0192aArr.length);
        c0192aArr2[i2] = c0192aArr2[i2].a(uri, i3);
        return new a(this.f9169h, c0192aArr2, this.f9171j, this.f9172k);
    }

    @CheckResult
    private a a(int i2) {
        C0192a[] c0192aArr = this.f9170i;
        C0192a[] c0192aArr2 = (C0192a[]) Arrays.copyOf(c0192aArr, c0192aArr.length);
        c0192aArr2[i2] = c0192aArr2[i2].b();
        return new a(this.f9169h, c0192aArr2, this.f9171j, this.f9172k);
    }

    @CheckResult
    public final a a(long[][] jArr) {
        C0192a[] c0192aArr = this.f9170i;
        C0192a[] c0192aArr2 = (C0192a[]) Arrays.copyOf(c0192aArr, c0192aArr.length);
        for (int i2 = 0; i2 < this.f9168g; i2++) {
            c0192aArr2[i2] = c0192aArr2[i2].a(jArr[i2]);
        }
        return new a(this.f9169h, c0192aArr2, this.f9171j, this.f9172k);
    }
}
