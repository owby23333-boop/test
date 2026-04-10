package com.anythink.expressad.exoplayer.i;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.i.f;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    public static final int a = 10000;
    public static final int b = 25000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9489c = 25000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f9490d = 0.75f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f9491e = 0.75f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f9492f = 2000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.d f9493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f9494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f9495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f9496m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f9497n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float f9498o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f9499p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.c f9500q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f9501r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f9502s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f9503t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f9504u;

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.i.a$a, reason: collision with other inner class name */
    public static final class C0197a implements f.a {
        private final com.anythink.expressad.exoplayer.j.d a;
        private final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f9506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f9507e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f9508f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f9509g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.k.c f9510h;

        public C0197a(com.anythink.expressad.exoplayer.j.d dVar) {
            this(dVar, 10000, 25000, 25000, 0.75f, com.anythink.expressad.exoplayer.k.c.a);
        }

        private a b(ae aeVar, int... iArr) {
            return new a(aeVar, iArr, this.a, this.b, this.f9505c, this.f9506d, this.f9507e, this.f9508f, this.f9509g, this.f9510h);
        }

        @Override // com.anythink.expressad.exoplayer.i.f.a
        public final /* synthetic */ f a(ae aeVar, int[] iArr) {
            return new a(aeVar, iArr, this.a, this.b, this.f9505c, this.f9506d, this.f9507e, this.f9508f, this.f9509g, this.f9510h);
        }

        private C0197a(com.anythink.expressad.exoplayer.j.d dVar, int i2, int i3, int i4, float f2) {
            this(dVar, i2, i3, i4, f2, com.anythink.expressad.exoplayer.k.c.a);
        }

        private C0197a(com.anythink.expressad.exoplayer.j.d dVar, int i2, int i3, int i4, float f2, com.anythink.expressad.exoplayer.k.c cVar) {
            this.a = dVar;
            this.b = i2;
            this.f9505c = i3;
            this.f9506d = i4;
            this.f9507e = f2;
            this.f9508f = 0.75f;
            this.f9509g = a.f9492f;
            this.f9510h = cVar;
        }
    }

    private a(ae aeVar, int[] iArr, com.anythink.expressad.exoplayer.j.d dVar) {
        this(aeVar, iArr, dVar, 10000L, 25000L, 25000L, 0.75f, 0.75f, f9492f, com.anythink.expressad.exoplayer.k.c.a);
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final void a() {
        this.f9504u = com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b() {
        return this.f9502s;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c() {
        return this.f9503t;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    @Nullable
    public final Object d() {
        return null;
    }

    public a(ae aeVar, int[] iArr, com.anythink.expressad.exoplayer.j.d dVar, long j2, long j3, long j4, float f2, float f3, long j5, com.anythink.expressad.exoplayer.k.c cVar) {
        super(aeVar, iArr);
        this.f9493j = dVar;
        this.f9494k = j2 * 1000;
        this.f9495l = j3 * 1000;
        this.f9496m = j4 * 1000;
        this.f9497n = f2;
        this.f9498o = f3;
        this.f9499p = j5;
        this.f9500q = cVar;
        this.f9501r = 1.0f;
        this.f9503t = 1;
        this.f9504u = com.anythink.expressad.exoplayer.b.b;
        this.f9502s = a(Long.MIN_VALUE);
    }

    private long b(long j2) {
        return (j2 > com.anythink.expressad.exoplayer.b.b ? 1 : (j2 == com.anythink.expressad.exoplayer.b.b ? 0 : -1)) != 0 && (j2 > this.f9494k ? 1 : (j2 == this.f9494k ? 0 : -1)) <= 0 ? (long) (j2 * this.f9498o) : this.f9494k;
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final void a(float f2) {
        this.f9501r = f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    @Override // com.anythink.expressad.exoplayer.i.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r7, long r9) {
        /*
            r6 = this;
            com.anythink.expressad.exoplayer.k.c r0 = r6.f9500q
            long r0 = r0.a()
            int r2 = r6.f9502s
            int r3 = r6.a(r0)
            r6.f9502s = r3
            int r3 = r6.f9502s
            if (r3 != r2) goto L13
            return
        L13:
            boolean r0 = r6.b(r2, r0)
            if (r0 != 0) goto L5b
            com.anythink.expressad.exoplayer.m r0 = r6.a(r2)
            int r1 = r6.f9502s
            com.anythink.expressad.exoplayer.m r1 = r6.a(r1)
            int r3 = r1.f9986d
            int r4 = r0.f9986d
            if (r3 <= r4) goto L4d
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 == 0) goto L3a
            long r3 = r6.f9494k
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 > 0) goto L3a
            r3 = 1
            goto L3b
        L3a:
            r3 = 0
        L3b:
            if (r3 == 0) goto L44
            float r9 = (float) r9
            float r10 = r6.f9498o
            float r9 = r9 * r10
            long r9 = (long) r9
            goto L46
        L44:
            long r9 = r6.f9494k
        L46:
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 >= 0) goto L4d
            r6.f9502s = r2
            goto L5b
        L4d:
            int r9 = r1.f9986d
            int r10 = r0.f9986d
            if (r9 >= r10) goto L5b
            long r9 = r6.f9495l
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L5b
            r6.f9502s = r2
        L5b:
            int r7 = r6.f9502s
            if (r7 == r2) goto L62
            r7 = 3
            r6.f9503t = r7
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.a.a(long, long):void");
    }

    @Override // com.anythink.expressad.exoplayer.i.b, com.anythink.expressad.exoplayer.i.f
    public final int a(long j2, List<? extends com.anythink.expressad.exoplayer.h.b.i> list) {
        int i2;
        int i3;
        long jA = this.f9500q.a();
        long j3 = this.f9504u;
        if (j3 != com.anythink.expressad.exoplayer.b.b && jA - j3 < this.f9499p) {
            return list.size();
        }
        this.f9504u = jA;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (af.b(list.get(size - 1).f9247g - j2, this.f9501r) < this.f9496m) {
            return size;
        }
        m mVarA = a(a(jA));
        for (int i4 = 0; i4 < size; i4++) {
            com.anythink.expressad.exoplayer.h.b.i iVar = list.get(i4);
            m mVar = iVar.f9244d;
            if (af.b(iVar.f9247g - j2, this.f9501r) >= this.f9496m && mVar.f9986d < mVarA.f9986d && (i2 = mVar.f9996n) != -1 && i2 < 720 && (i3 = mVar.f9995m) != -1 && i3 < 1280 && i2 < mVarA.f9996n) {
                return i4;
            }
        }
        return size;
    }

    private int a(long j2) {
        long jA = (long) (this.f9493j.a() * this.f9497n);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f9513h; i3++) {
            if (j2 == Long.MIN_VALUE || !b(i3, j2)) {
                if (Math.round(a(i3).f9986d * this.f9501r) <= jA) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }
}
