package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.r;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.j.h;
import com.anythink.expressad.exoplayer.j.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class ac implements r, t.a<b> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9207i = 1024;
    final com.anythink.expressad.exoplayer.m b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f9208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f9209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f9210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f9211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    byte[] f9212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f9213h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.k f9214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final h.a f9215k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f9216l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final t.a f9217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final af f9218n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final long f9220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9221q;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ArrayList<a> f9219o = new ArrayList<>();
    final com.anythink.expressad.exoplayer.j.t a = new com.anythink.expressad.exoplayer.j.t("Loader:SingleSampleMediaPeriod");

    private final class a implements y {
        private static final int b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f9222c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f9223d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f9224e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f9225f;

        private a() {
        }

        private void d() {
            if (this.f9225f) {
                return;
            }
            ac.this.f9217m.a(com.anythink.expressad.exoplayer.k.o.d(ac.this.b.f9990h), ac.this.b, 0, (Object) null, 0L);
            this.f9225f = true;
        }

        public final void a() {
            if (this.f9224e == 2) {
                this.f9224e = 1;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return ac.this.f9210e;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() throws IOException {
            ac acVar = ac.this;
            if (acVar.f9208c) {
                return;
            }
            acVar.a.c();
        }

        /* synthetic */ a(ac acVar, byte b2) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z2) {
            int i2 = this.f9224e;
            if (i2 == 2) {
                eVar.b(4);
                return -4;
            }
            if (!z2 && i2 != 0) {
                ac acVar = ac.this;
                if (!acVar.f9210e) {
                    return -3;
                }
                if (acVar.f9211f) {
                    eVar.f8738f = 0L;
                    eVar.b(1);
                    eVar.d(ac.this.f9213h);
                    ByteBuffer byteBuffer = eVar.f8737e;
                    ac acVar2 = ac.this;
                    byteBuffer.put(acVar2.f9212g, 0, acVar2.f9213h);
                    d();
                } else {
                    eVar.b(4);
                }
                this.f9224e = 2;
                return -4;
            }
            nVar.a = ac.this.b;
            this.f9224e = 1;
            return -5;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j2) {
            if (j2 <= 0 || this.f9224e == 2) {
                return 0;
            }
            this.f9224e = 2;
            d();
            return 1;
        }
    }

    static final class b implements t.c {
        public final com.anythink.expressad.exoplayer.j.k a;
        private final com.anythink.expressad.exoplayer.j.h b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f9227d;

        public b(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.h hVar) {
            this.a = kVar;
            this.b = hVar;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void a() {
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void b() {
            int iA = 0;
            this.f9226c = 0;
            try {
                this.b.a(this.a);
                while (iA != -1) {
                    this.f9226c += iA;
                    if (this.f9227d == null) {
                        this.f9227d = new byte[1024];
                    } else if (this.f9226c == this.f9227d.length) {
                        this.f9227d = Arrays.copyOf(this.f9227d, this.f9227d.length * 2);
                    }
                    iA = this.b.a(this.f9227d, this.f9226c, this.f9227d.length - this.f9226c);
                }
            } finally {
                com.anythink.expressad.exoplayer.k.af.a(this.b);
            }
        }
    }

    public ac(com.anythink.expressad.exoplayer.j.k kVar, h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j2, int i2, t.a aVar2, boolean z2) {
        this.f9214j = kVar;
        this.f9215k = aVar;
        this.b = mVar;
        this.f9220p = j2;
        this.f9216l = i2;
        this.f9217m = aVar2;
        this.f9208c = z2;
        this.f9218n = new af(new ae(mVar));
        aVar2.a();
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* bridge */ /* synthetic */ int a(t.c cVar, long j2, long j3, IOException iOException) {
        b bVar = (b) cVar;
        this.f9221q++;
        boolean z2 = this.f9208c && this.f9221q >= this.f9216l;
        this.f9217m.a(bVar.a, 1, -1, this.b, 0, null, 0L, this.f9220p, j2, j3, bVar.f9226c, iOException, z2);
        if (!z2) {
            return 0;
        }
        this.f9210e = true;
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j2, com.anythink.expressad.exoplayer.ac acVar) {
        return j2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j2, boolean z2) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final af b() {
        return this.f9218n;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j2) {
        if (this.f9210e || this.a.a()) {
            return false;
        }
        this.f9217m.a(this.f9214j, 1, -1, this.b, 0, null, 0L, this.f9220p, this.a.a(new b(this.f9214j, this.f9215k.a()), this, this.f9216l));
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.f9210e ? Long.MIN_VALUE : 0L;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return (this.f9210e || this.a.a()) ? Long.MIN_VALUE : 0L;
    }

    public final void f() {
        this.a.a((t.d) null);
        this.f9217m.b();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j2) {
        for (int i2 = 0; i2 < this.f9219o.size(); i2++) {
            this.f9219o.get(i2).a();
        }
        return j2;
    }

    private void b(b bVar, long j2, long j3) {
        this.f9217m.b(bVar.a, 1, -1, null, 0, null, 0L, this.f9220p, j2, j3, bVar.f9226c);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (this.f9209d) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        this.f9217m.c();
        this.f9209d = true;
        return com.anythink.expressad.exoplayer.b.b;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(t.c cVar, long j2, long j3) {
        b bVar = (b) cVar;
        this.f9217m.a(bVar.a, 1, -1, this.b, 0, null, 0L, this.f9220p, j2, j3, bVar.f9226c);
        this.f9213h = bVar.f9226c;
        this.f9212g = bVar.f9227d;
        this.f9210e = true;
        this.f9211f = true;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(t.c cVar, long j2, long j3, boolean z2) {
        this.f9217m.b(((b) cVar).a, 1, -1, null, 0, null, 0L, this.f9220p, j2, j3, r3.f9226c);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(r.a aVar, long j2) {
        aVar.a((r) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        byte b2 = 0;
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            if (yVarArr[i2] != null && (fVarArr[i2] == null || !zArr[i2])) {
                this.f9219o.remove(yVarArr[i2]);
                yVarArr[i2] = null;
            }
            if (yVarArr[i2] == null && fVarArr[i2] != null) {
                a aVar = new a(this, b2);
                this.f9219o.add(aVar);
                yVarArr[i2] = aVar;
                zArr2[i2] = true;
            }
        }
        return j2;
    }

    private void a(b bVar, long j2, long j3) {
        this.f9217m.a(bVar.a, 1, -1, this.b, 0, null, 0L, this.f9220p, j2, j3, bVar.f9226c);
        this.f9213h = bVar.f9226c;
        this.f9212g = bVar.f9227d;
        this.f9210e = true;
        this.f9211f = true;
    }

    private int a(b bVar, long j2, long j3, IOException iOException) {
        this.f9221q++;
        boolean z2 = this.f9208c && this.f9221q >= this.f9216l;
        this.f9217m.a(bVar.a, 1, -1, this.b, 0, null, 0L, this.f9220p, j2, j3, bVar.f9226c, iOException, z2);
        if (!z2) {
            return 0;
        }
        this.f9210e = true;
        return 2;
    }
}
