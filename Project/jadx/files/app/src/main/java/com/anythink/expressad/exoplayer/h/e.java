package com.anythink.expressad.exoplayer.h;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.s;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends f<Void> {
    private final s a;
    private final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f9304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayList<d> f9305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ae.b f9306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Object f9307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f9308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b f9309k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f9310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f9311m;

    public static final class b extends IOException {
        public static final int a = 0;
        public static final int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9316c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9317d;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public b(int i2) {
            StringBuilder sb = new StringBuilder("Illegal clipping: ");
            sb.append(i2 != 0 ? i2 != 1 ? i2 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count");
            super(sb.toString());
            this.f9317d = i2;
        }

        private static String a(int i2) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    private e(s sVar, long j2, long j3) {
        this(sVar, j2, j3, true, false);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        super.a(hVar, z2);
        a((Object) null, this.a);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.s
    public final void b() throws b {
        b bVar = this.f9309k;
        if (bVar != null) {
            throw bVar;
        }
        super.b();
    }

    @Deprecated
    private e(s sVar, long j2, long j3, boolean z2) {
        this(sVar, j2, j3, z2, false);
    }

    private e(s sVar, long j2) {
        this(sVar, 0L, j2, true, true);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        d dVar = new d(this.a.a(aVar, bVar), this.f9302d, this.f9310l, this.f9311m);
        this.f9305g.add(dVar);
        return dVar;
    }

    private e(s sVar, long j2, long j3, boolean z2, boolean z3) {
        com.anythink.expressad.exoplayer.k.a.a(j2 >= 0);
        this.a = (s) com.anythink.expressad.exoplayer.k.a.a(sVar);
        this.b = j2;
        this.f9301c = j3;
        this.f9302d = z2;
        this.f9303e = false;
        this.f9304f = z3;
        this.f9305g = new ArrayList<>();
        this.f9306h = new ae.b();
    }

    private void b(com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        if (this.f9309k != null) {
            return;
        }
        this.f9307i = obj;
        a(aeVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.f9305g.remove(rVar));
        this.a.a(((d) rVar).a);
        if (!this.f9305g.isEmpty() || this.f9303e) {
            return;
        }
        a(this.f9308j.b);
    }

    private long b(long j2) {
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        long jA = com.anythink.expressad.exoplayer.b.a(this.b);
        long jMax = Math.max(0L, j2 - jA);
        long j3 = this.f9301c;
        return j3 != Long.MIN_VALUE ? Math.min(com.anythink.expressad.exoplayer.b.a(j3) - jA, jMax) : jMax;
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.f9309k = null;
        this.f9308j = null;
    }

    private void a(com.anythink.expressad.exoplayer.ae aeVar) {
        long j2;
        long j3;
        aeVar.a(0, this.f9306h, false);
        long j4 = this.f9306h.f8480j;
        if (this.f9308j != null && !this.f9305g.isEmpty() && !this.f9303e) {
            long j5 = this.f9310l - j4;
            j3 = this.f9301c != Long.MIN_VALUE ? this.f9311m - j4 : Long.MIN_VALUE;
            j2 = j5;
        } else {
            long j6 = this.b;
            long j7 = this.f9301c;
            if (this.f9304f) {
                long j8 = this.f9306h.f8478h;
                j6 += j8;
                j7 += j8;
            }
            this.f9310l = j4 + j6;
            this.f9311m = this.f9301c != Long.MIN_VALUE ? j4 + j7 : Long.MIN_VALUE;
            int size = this.f9305g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f9305g.get(i2).a(this.f9310l, this.f9311m);
            }
            j2 = j6;
            j3 = j7;
        }
        try {
            this.f9308j = new a(aeVar, j2, j3);
            a(this.f9308j, this.f9307i);
        } catch (b e2) {
            this.f9309k = e2;
        }
    }

    private static final class a extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f9312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f9313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f9314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f9315f;

        /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.anythink.expressad.exoplayer.ae r10, long r11, long r13) throws com.anythink.expressad.exoplayer.h.e.b {
            /*
                r9 = this;
                r9.<init>(r10)
                int r0 = r10.c()
                r1 = 1
                r2 = 0
                if (r0 != r1) goto L77
                com.anythink.expressad.exoplayer.ae$b r0 = new com.anythink.expressad.exoplayer.ae$b
                r0.<init>()
                com.anythink.expressad.exoplayer.ae$b r10 = r10.a(r2, r0, r2)
                r3 = 0
                long r11 = java.lang.Math.max(r3, r11)
                r5 = -9223372036854775808
                int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r0 != 0) goto L23
                long r13 = r10.f8479i
                goto L27
            L23:
                long r13 = java.lang.Math.max(r3, r13)
            L27:
                long r5 = r10.f8479i
                r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 == 0) goto L52
                int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r0 <= 0) goto L37
                r13 = r5
            L37:
                int r0 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
                if (r0 == 0) goto L46
                boolean r0 = r10.f8474d
                if (r0 == 0) goto L40
                goto L46
            L40:
                com.anythink.expressad.exoplayer.h.e$b r10 = new com.anythink.expressad.exoplayer.h.e$b
                r10.<init>(r1)
                throw r10
            L46:
                int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r0 > 0) goto L4b
                goto L52
            L4b:
                com.anythink.expressad.exoplayer.h.e$b r10 = new com.anythink.expressad.exoplayer.h.e$b
                r11 = 2
                r10.<init>(r11)
                throw r10
            L52:
                r9.f9312c = r11
                r9.f9313d = r13
                int r0 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r0 != 0) goto L5c
                r11 = r7
                goto L5e
            L5c:
                long r11 = r13 - r11
            L5e:
                r9.f9314e = r11
                boolean r11 = r10.f8475e
                if (r11 == 0) goto L73
                int r11 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r11 == 0) goto L74
                long r10 = r10.f8479i
                int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
                if (r12 == 0) goto L73
                int r12 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
                if (r12 != 0) goto L73
                goto L74
            L73:
                r1 = 0
            L74:
                r9.f9315f = r1
                return
            L77:
                com.anythink.expressad.exoplayer.h.e$b r10 = new com.anythink.expressad.exoplayer.h.e$b
                r10.<init>(r2)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.e.a.<init>(com.anythink.expressad.exoplayer.ae, long, long):void");
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final ae.b a(int i2, ae.b bVar, boolean z2, long j2) {
            this.b.a(0, bVar, z2, 0L);
            long j3 = bVar.f8480j;
            long j4 = this.f9312c;
            bVar.f8480j = j3 + j4;
            bVar.f8479i = this.f9314e;
            bVar.f8475e = this.f9315f;
            long j5 = bVar.f8478h;
            if (j5 != com.anythink.expressad.exoplayer.b.b) {
                bVar.f8478h = Math.max(j5, j4);
                long j6 = this.f9313d;
                bVar.f8478h = j6 == com.anythink.expressad.exoplayer.b.b ? bVar.f8478h : Math.min(bVar.f8478h, j6);
                bVar.f8478h -= this.f9312c;
            }
            long jA = com.anythink.expressad.exoplayer.b.a(this.f9312c);
            long j7 = bVar.b;
            if (j7 != com.anythink.expressad.exoplayer.b.b) {
                bVar.b = j7 + jA;
            }
            long j8 = bVar.f8473c;
            if (j8 != com.anythink.expressad.exoplayer.b.b) {
                bVar.f8473c = j8 + jA;
            }
            return bVar;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final ae.a a(int i2, ae.a aVar, boolean z2) {
            this.b.a(0, aVar, z2);
            long jB = aVar.b() - this.f9312c;
            long j2 = this.f9314e;
            return aVar.a(aVar.a, aVar.b, j2 == com.anythink.expressad.exoplayer.b.b ? -9223372036854775807L : j2 - jB, jB);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ long a(long j2) {
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        long jA = com.anythink.expressad.exoplayer.b.a(this.b);
        long jMax = Math.max(0L, j2 - jA);
        long j3 = this.f9301c;
        return j3 != Long.MIN_VALUE ? Math.min(com.anythink.expressad.exoplayer.b.a(j3) - jA, jMax) : jMax;
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* bridge */ /* synthetic */ void a(Void r1, s sVar, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        if (this.f9309k == null) {
            this.f9307i = obj;
            a(aeVar);
        }
    }
}
