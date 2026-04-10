package com.anythink.expressad.exoplayer;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.a.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ae {
    public static final ae a = new ae() { // from class: com.anythink.expressad.exoplayer.ae.1
        @Override // com.anythink.expressad.exoplayer.ae
        public final int a(Object obj) {
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final b a(int i2, b bVar, boolean z2, long j2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return 0;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return 0;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final a a(int i2, a aVar, boolean z2) {
            throw new IndexOutOfBoundsException();
        }
    };

    public static final class a {
        public Object a;
        public Object b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f8471e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.anythink.expressad.exoplayer.h.a.a f8472f;

        private long e() {
            return com.anythink.expressad.exoplayer.b.a(this.f8470d);
        }

        private long f() {
            return this.f8470d;
        }

        public final a a(Object obj, Object obj2, long j2, long j3) {
            return a(obj, obj2, 0, j2, j3, com.anythink.expressad.exoplayer.h.a.a.f9167f);
        }

        public final long b() {
            return this.f8471e;
        }

        public final int c() {
            return this.f8472f.f9168g;
        }

        public final int d(int i2) {
            return this.f8472f.f9170i[i2].a;
        }

        public final a a(Object obj, Object obj2, int i2, long j2, long j3, com.anythink.expressad.exoplayer.h.a.a aVar) {
            this.a = obj;
            this.b = obj2;
            this.f8469c = i2;
            this.f8470d = j2;
            this.f8471e = j3;
            this.f8472f = aVar;
            return this;
        }

        public final int b(int i2) {
            return this.f8472f.f9170i[i2].a(-1);
        }

        public final boolean c(int i2) {
            return !this.f8472f.f9170i[i2].a();
        }

        public final long d() {
            return this.f8472f.f9171j;
        }

        public final long c(int i2, int i3) {
            a.C0192a c0192a = this.f8472f.f9170i[i2];
            return c0192a.a != -1 ? c0192a.f9174d[i3] : com.anythink.expressad.exoplayer.b.b;
        }

        public final int b(long j2) {
            com.anythink.expressad.exoplayer.h.a.a aVar = this.f8472f;
            int i2 = 0;
            while (true) {
                long[] jArr = aVar.f9169h;
                if (i2 >= jArr.length || jArr[i2] == Long.MIN_VALUE || (j2 < jArr[i2] && aVar.f9170i[i2].a())) {
                    break;
                }
                i2++;
            }
            if (i2 < aVar.f9169h.length) {
                return i2;
            }
            return -1;
        }

        public final long a() {
            return com.anythink.expressad.exoplayer.b.a(this.f8471e);
        }

        public final boolean b(int i2, int i3) {
            a.C0192a c0192a = this.f8472f.f9170i[i2];
            return (c0192a.a == -1 || c0192a.f9173c[i3] == 0) ? false : true;
        }

        public final long a(int i2) {
            return this.f8472f.f9169h[i2];
        }

        public final int a(int i2, int i3) {
            return this.f8472f.f9170i[i2].a(i3);
        }

        public final int a(long j2) {
            com.anythink.expressad.exoplayer.h.a.a aVar = this.f8472f;
            int length = aVar.f9169h.length - 1;
            while (length >= 0) {
                long[] jArr = aVar.f9169h;
                if (jArr[length] != Long.MIN_VALUE && jArr[length] <= j2) {
                    break;
                }
                length--;
            }
            if (length < 0 || !aVar.f9170i[length].a()) {
                return -1;
            }
            return length;
        }
    }

    public abstract int a(Object obj);

    public abstract a a(int i2, a aVar, boolean z2);

    public abstract b a(int i2, b bVar, boolean z2, long j2);

    public final boolean a() {
        return b() == 0;
    }

    public abstract int b();

    public int b(int i2, int i3, boolean z2) {
        if (i3 == 0) {
            if (i2 == b(z2)) {
                return -1;
            }
            return i2 - 1;
        }
        if (i3 == 1) {
            return i2;
        }
        if (i3 == 2) {
            return i2 == b(z2) ? a(z2) : i2 - 1;
        }
        throw new IllegalStateException();
    }

    public abstract int c();

    public int a(int i2, int i3, boolean z2) {
        if (i3 == 0) {
            if (i2 == a(z2)) {
                return -1;
            }
            return i2 + 1;
        }
        if (i3 == 1) {
            return i2;
        }
        if (i3 == 2) {
            return i2 == a(z2) ? b(z2) : i2 + 1;
        }
        throw new IllegalStateException();
    }

    public int b(boolean z2) {
        return a() ? -1 : 0;
    }

    public int a(boolean z2) {
        if (a()) {
            return -1;
        }
        return b() - 1;
    }

    public final boolean b(int i2, a aVar, b bVar, int i3, boolean z2) {
        return a(i2, aVar, bVar, i3, z2) == -1;
    }

    private b a(int i2, b bVar) {
        return a(i2, bVar, false);
    }

    public final b a(int i2, b bVar, boolean z2) {
        return a(i2, bVar, z2, 0L);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i2, long j2) {
        return a(bVar, aVar, i2, j2, 0L);
    }

    public static final class b {

        @Nullable
        public Object a;
        public long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f8474d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8475e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8476f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8477g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f8478h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f8479i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f8480j;

        private long b() {
            return this.f8478h;
        }

        private long c() {
            return com.anythink.expressad.exoplayer.b.a(this.f8479i);
        }

        private long d() {
            return this.f8479i;
        }

        private long e() {
            return com.anythink.expressad.exoplayer.b.a(this.f8480j);
        }

        private long f() {
            return this.f8480j;
        }

        public final b a(@Nullable Object obj, long j2, long j3, boolean z2, boolean z3, long j4, long j5, long j6) {
            this.a = obj;
            this.b = j2;
            this.f8473c = j3;
            this.f8474d = z2;
            this.f8475e = z3;
            this.f8478h = j4;
            this.f8479i = j5;
            this.f8476f = 0;
            this.f8477g = 0;
            this.f8480j = j6;
            return this;
        }

        private long a() {
            return com.anythink.expressad.exoplayer.b.a(this.f8478h);
        }
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i2, long j2, long j3) {
        com.anythink.expressad.exoplayer.k.a.a(i2, b());
        a(i2, bVar, false, j3);
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            j2 = bVar.f8478h;
            if (j2 == com.anythink.expressad.exoplayer.b.b) {
                return null;
            }
        }
        int i3 = bVar.f8476f;
        long j4 = bVar.f8480j + j2;
        long j5 = a(i3, aVar, false).f8470d;
        while (j5 != com.anythink.expressad.exoplayer.b.b && j4 >= j5 && i3 < bVar.f8477g) {
            j4 -= j5;
            i3++;
            j5 = a(i3, aVar, false).f8470d;
        }
        return Pair.create(Integer.valueOf(i3), Long.valueOf(j4));
    }

    private a a(int i2, a aVar) {
        return a(i2, aVar, false);
    }

    public final int a(int i2, a aVar, b bVar, int i3, boolean z2) {
        int i4 = a(i2, aVar, false).f8469c;
        if (a(i4, bVar, false).f8477g != i2) {
            return i2 + 1;
        }
        int iA = a(i4, i3, z2);
        if (iA == -1) {
            return -1;
        }
        return a(iA, bVar, false).f8476f;
    }
}
