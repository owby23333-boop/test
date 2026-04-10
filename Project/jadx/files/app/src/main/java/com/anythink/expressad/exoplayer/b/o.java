package com.anythink.expressad.exoplayer.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.b.g;
import com.anythink.expressad.exoplayer.b.h;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.v;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class o extends com.anythink.expressad.exoplayer.f.b implements com.anythink.expressad.exoplayer.k.n {
    private int A;
    private int B;
    private long C;
    private boolean D;
    private boolean E;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Context f8621r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final g.a f8622s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final h f8623t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f8624u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f8625v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f8626w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private MediaFormat f8627x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f8628y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8629z;

    private final class a implements h.c {
        private a() {
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i2) {
            o.this.f8622s.a(i2);
        }

        /* synthetic */ a(o oVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a() {
            o.b(o.this);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i2, long j2, long j3) {
            o.this.f8622s.a(i2, j2, j3);
        }
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar) {
        this(context, cVar, null);
    }

    private static void C() {
    }

    private static void D() {
    }

    private static void E() {
    }

    private void F() {
        long jA = this.f8623t.a(v());
        if (jA != Long.MIN_VALUE) {
            if (!this.E) {
                jA = Math.max(this.C, jA);
            }
            this.C = jA;
            this.E = false;
        }
    }

    static /* synthetic */ boolean b(o oVar) {
        oVar.E = true;
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.k.n c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            F();
        }
        return this.C;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v e() {
        return this.f8623t.f();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void n() {
        super.n();
        this.f8623t.a();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void o() {
        F();
        this.f8623t.h();
        super.o();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void p() {
        try {
            this.f8623t.j();
            try {
                super.p();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean u() {
        return this.f8623t.e() || super.u();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return super.v() && this.f8623t.d();
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void w() throws com.anythink.expressad.exoplayer.g {
        try {
            this.f8623t.c();
        } catch (h.d e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(context, cVar, gVar, null, null);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final int a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.m mVar) {
        boolean z2;
        int i2;
        int i3;
        String str = mVar.f9990h;
        boolean z3 = false;
        if (!com.anythink.expressad.exoplayer.k.o.a(str)) {
            return 0;
        }
        int i4 = af.a >= 21 ? 32 : 0;
        boolean zA = com.anythink.expressad.exoplayer.a.a(gVar, mVar.f9993k);
        if (zA && a(str) && cVar.a() != null) {
            return i4 | 8 | 4;
        }
        if ((com.anythink.expressad.exoplayer.k.o.f9878w.equals(str) && !this.f8623t.a(mVar.f10005w)) || !this.f8623t.a(2)) {
            return 1;
        }
        com.anythink.expressad.exoplayer.d.e eVar = mVar.f9993k;
        if (eVar != null) {
            z2 = false;
            for (int i5 = 0; i5 < eVar.b; i5++) {
                z2 |= eVar.a(i5).f8814d;
            }
        } else {
            z2 = false;
        }
        com.anythink.expressad.exoplayer.f.a aVarA = cVar.a(str, z2);
        if (aVarA == null) {
            return (!z2 || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!zA) {
            return 2;
        }
        if (af.a < 21 || (((i2 = mVar.f10004v) == -1 || aVarA.a(i2)) && ((i3 = mVar.f10003u) == -1 || aVarA.b(i3)))) {
            z3 = true;
        }
        return i4 | 8 | (z3 ? 4 : 3);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void b(com.anythink.expressad.exoplayer.m mVar) throws com.anythink.expressad.exoplayer.g {
        super.b(mVar);
        this.f8622s.a(mVar);
        this.f8628y = com.anythink.expressad.exoplayer.k.o.f9878w.equals(mVar.f9990h) ? mVar.f10005w : 2;
        this.f8629z = mVar.f10003u;
        this.A = mVar.f10006x;
        this.B = mVar.f10007y;
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, @Nullable Handler handler, @Nullable g gVar) {
        this(context, cVar, null, handler, gVar);
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, @Nullable Handler handler, @Nullable g gVar2) {
        this(context, cVar, gVar, handler, gVar2, null, new f[0]);
    }

    public o(Context context, com.anythink.expressad.exoplayer.f.c cVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, @Nullable Handler handler, @Nullable g gVar2, @Nullable c cVar2, f... fVarArr) {
        this(context, cVar, gVar, handler, gVar2, new l(cVar2, fVarArr));
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, @Nullable Handler handler, @Nullable g gVar2, h hVar) {
        super(1, cVar, gVar, false);
        this.f8621r = context.getApplicationContext();
        this.f8623t = hVar;
        this.f8622s = new g.a(handler, gVar2);
        hVar.a(new a(this, (byte) 0));
    }

    private int b(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        PackageManager packageManager;
        if (af.a < 24 && "OMX.google.raw.decoder".equals(aVar.f9032c)) {
            boolean z2 = true;
            if (af.a == 23 && (packageManager = this.f8621r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) {
                z2 = false;
            }
            if (z2) {
                return -1;
            }
        }
        return mVar.f9991i;
    }

    private static boolean b(String str) {
        if (af.a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(af.f9815c)) {
            return af.b.startsWith("zeroflte") || af.b.startsWith("herolte") || af.b.startsWith("heroqlte");
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final com.anythink.expressad.exoplayer.f.a a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.m mVar, boolean z2) {
        com.anythink.expressad.exoplayer.f.a aVarA;
        return (!a(mVar.f9990h) || (aVarA = cVar.a()) == null) ? super.a(cVar, mVar, z2) : aVarA;
    }

    private boolean a(String str) {
        int iE = com.anythink.expressad.exoplayer.k.o.e(str);
        return iE != 0 && this.f8623t.a(iE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    @Override // com.anythink.expressad.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a(com.anythink.expressad.exoplayer.f.a r7, android.media.MediaCodec r8, com.anythink.expressad.exoplayer.m r9, android.media.MediaCrypto r10) {
        /*
            r6 = this;
            r6.q()
            int r0 = com.anythink.expressad.exoplayer.k.af.a
            r1 = 23
            r2 = 1
            r3 = 24
            r4 = 0
            if (r0 >= r3) goto L32
            java.lang.String r0 = r7.f9032c
            java.lang.String r5 = "OMX.google.raw.decoder"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L32
            int r0 = com.anythink.expressad.exoplayer.k.af.a
            if (r0 != r1) goto L2d
            android.content.Context r0 = r6.f8621r
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r0 == 0) goto L2d
            java.lang.String r5 = "android.software.leanback"
            boolean r0 = r0.hasSystemFeature(r5)
            if (r0 == 0) goto L2d
            r0 = 0
            goto L2e
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L32
            r0 = -1
            goto L34
        L32:
            int r0 = r9.f9991i
        L34:
            r6.f8624u = r0
            java.lang.String r0 = r7.f9032c
            int r5 = com.anythink.expressad.exoplayer.k.af.a
            if (r5 >= r3) goto L6d
            java.lang.String r3 = "OMX.SEC.aac.dec"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L6d
            java.lang.String r0 = com.anythink.expressad.exoplayer.k.af.f9815c
            java.lang.String r3 = "samsung"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L6d
            java.lang.String r0 = com.anythink.expressad.exoplayer.k.af.b
            java.lang.String r3 = "zeroflte"
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L6e
            java.lang.String r0 = com.anythink.expressad.exoplayer.k.af.b
            java.lang.String r3 = "herolte"
            boolean r0 = r0.startsWith(r3)
            if (r0 != 0) goto L6e
            java.lang.String r0 = com.anythink.expressad.exoplayer.k.af.b
            java.lang.String r3 = "heroqlte"
            boolean r0 = r0.startsWith(r3)
            if (r0 == 0) goto L6d
            goto L6e
        L6d:
            r2 = 0
        L6e:
            r6.f8626w = r2
            boolean r0 = r7.f9038i
            r6.f8625v = r0
            java.lang.String r7 = r7.f9033d
            if (r7 != 0) goto L7a
            java.lang.String r7 = "audio/raw"
        L7a:
            int r0 = r6.f8624u
            android.media.MediaFormat r2 = new android.media.MediaFormat
            r2.<init>()
            java.lang.String r3 = "mime"
            r2.setString(r3, r7)
            int r7 = r9.f10003u
            java.lang.String r5 = "channel-count"
            r2.setInteger(r5, r7)
            int r7 = r9.f10004v
            java.lang.String r5 = "sample-rate"
            r2.setInteger(r5, r7)
            java.util.List<byte[]> r7 = r9.f9992j
            com.anythink.expressad.exoplayer.f.e.a(r2, r7)
            java.lang.String r7 = "max-input-size"
            com.anythink.expressad.exoplayer.f.e.a(r2, r7, r0)
            int r7 = com.anythink.expressad.exoplayer.k.af.a
            if (r7 < r1) goto La7
            java.lang.String r7 = "priority"
            r2.setInteger(r7, r4)
        La7:
            r7 = 0
            r8.configure(r2, r7, r10, r4)
            boolean r8 = r6.f8625v
            if (r8 == 0) goto Lb9
            r6.f8627x = r2
            android.media.MediaFormat r7 = r6.f8627x
            java.lang.String r8 = r9.f9990h
            r7.setString(r3, r8)
            return
        Lb9:
            r6.f8627x = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.o.a(com.anythink.expressad.exoplayer.f.a, android.media.MediaCodec, com.anythink.expressad.exoplayer.m, android.media.MediaCrypto):void");
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void a(String str, long j2, long j3) {
        this.f8622s.a(str, j2, j3);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.anythink.expressad.exoplayer.g {
        int iE;
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.f8627x;
        if (mediaFormat2 != null) {
            iE = com.anythink.expressad.exoplayer.k.o.e(mediaFormat2.getString("mime"));
            mediaFormat = this.f8627x;
        } else {
            iE = this.f8628y;
        }
        int i3 = iE;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f8626w && integer == 6 && (i2 = this.f8629z) < 6) {
            iArr = new int[i2];
            for (int i4 = 0; i4 < this.f8629z; i4++) {
                iArr[i4] = i4;
            }
        } else {
            iArr = null;
        }
        try {
            this.f8623t.a(i3, integer, integer2, iArr, this.A, this.B);
        } catch (h.a e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void a(boolean z2) {
        super.a(z2);
        this.f8622s.a(((com.anythink.expressad.exoplayer.f.b) this).f9051q);
        int i2 = r().b;
        if (i2 != 0) {
            this.f8623t.c(i2);
        } else {
            this.f8623t.g();
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void a(long j2, boolean z2) throws com.anythink.expressad.exoplayer.g {
        super.a(j2, z2);
        this.f8623t.i();
        this.C = j2;
        this.D = true;
        this.E = true;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v a(v vVar) {
        return this.f8623t.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void a(com.anythink.expressad.exoplayer.c.e eVar) {
        if (!this.D || eVar.b()) {
            return;
        }
        if (Math.abs(eVar.f8738f - this.C) > 500000) {
            this.C = eVar.f8738f;
        }
        this.D = false;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2) throws com.anythink.expressad.exoplayer.g {
        if (this.f8625v && (i3 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i2, false);
            return true;
        }
        if (z2) {
            mediaCodec.releaseOutputBuffer(i2, false);
            ((com.anythink.expressad.exoplayer.f.b) this).f9051q.f8731f++;
            this.f8623t.b();
            return true;
        }
        try {
            if (!this.f8623t.a(byteBuffer, j4)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i2, false);
            ((com.anythink.expressad.exoplayer.f.b) this).f9051q.f8730e++;
            return true;
        } catch (h.b | h.d e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i2, Object obj) {
        if (i2 == 2) {
            this.f8623t.a(((Float) obj).floatValue());
        } else if (i2 != 3) {
            super.a(i2, obj);
        } else {
            this.f8623t.a((b) obj);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat a(com.anythink.expressad.exoplayer.m mVar, String str, int i2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", mVar.f10003u);
        mediaFormat.setInteger("sample-rate", mVar.f10004v);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.f9992j);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "max-input-size", i2);
        if (af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        return mediaFormat;
    }

    private static boolean a(com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        return mVar.f9990h.equals(mVar2.f9990h) && mVar.f10003u == mVar2.f10003u && mVar.f10004v == mVar2.f10004v && mVar.f10006x == 0 && mVar.f10007y == 0 && mVar2.f10006x == 0 && mVar2.f10007y == 0 && mVar.b(mVar2);
    }

    private int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        PackageManager packageManager;
        if (af.a < 24 && "OMX.google.raw.decoder".equals(aVar.f9032c)) {
            boolean z2 = true;
            if (af.a == 23 && (packageManager = this.f8621r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) {
                z2 = false;
            }
            if (z2) {
                return -1;
            }
        }
        return mVar.f9991i;
    }
}
