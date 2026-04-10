package com.anythink.expressad.exoplayer.f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.d.f;
import com.anythink.expressad.exoplayer.d.g;
import com.anythink.expressad.exoplayer.d.k;
import com.anythink.expressad.exoplayer.f.d;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.n;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public abstract class b extends com.anythink.expressad.exoplayer.a {
    private static final int A = 1;
    private static final int B = 2;
    private static final byte[] C = af.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int D = 32;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static final int f9039n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected static final int f9040o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected static final int f9041p = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f9042r = "MediaCodecRenderer";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final long f9043s = 1000;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f9044t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f9045u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f9046v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f9047w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f9048x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f9049y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f9050z = 0;
    private final com.anythink.expressad.exoplayer.f.c E;

    @Nullable
    private final g<k> F;
    private final boolean G;
    private final com.anythink.expressad.exoplayer.c.e H;
    private final com.anythink.expressad.exoplayer.c.e I;
    private final n J;
    private final List<Long> K;
    private final MediaCodec.BufferInfo L;
    private m M;
    private f<k> N;
    private f<k> O;
    private MediaCodec P;
    private com.anythink.expressad.exoplayer.f.a Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private ByteBuffer[] aa;
    private ByteBuffer[] ab;
    private long ac;
    private int ad;
    private int ae;
    private ByteBuffer af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected com.anythink.expressad.exoplayer.c.d f9051q;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface a {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    protected @interface c {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface d {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface e {
    }

    public b(int i2, com.anythink.expressad.exoplayer.f.c cVar, @Nullable g<k> gVar, boolean z2) {
        super(i2);
        com.anythink.expressad.exoplayer.k.a.b(af.a >= 16);
        this.E = (com.anythink.expressad.exoplayer.f.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
        this.F = gVar;
        this.G = false;
        this.H = new com.anythink.expressad.exoplayer.c.e(0);
        this.I = com.anythink.expressad.exoplayer.c.e.e();
        this.J = new n();
        this.K = new ArrayList();
        this.L = new MediaCodec.BufferInfo();
        this.ai = 0;
        this.aj = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean C() throws com.anythink.expressad.exoplayer.g {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.b.C():boolean");
    }

    private void D() {
        if (af.a < 21) {
            this.aa = this.P.getInputBuffers();
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void E() {
        if (af.a < 21) {
            this.aa = null;
            this.ab = null;
        }
    }

    private boolean F() {
        return this.ae >= 0;
    }

    private void G() {
        this.ad = -1;
        this.H.f8737e = null;
    }

    private void H() {
        this.ae = -1;
        this.af = null;
    }

    private static long I() {
        return 0L;
    }

    private void J() {
        MediaFormat outputFormat = this.P.getOutputFormat();
        if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.Z = true;
            return;
        }
        if (this.X) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.P, outputFormat);
    }

    private void K() {
        if (af.a < 21) {
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void L() throws com.anythink.expressad.exoplayer.g {
        if (this.aj == 2) {
            A();
            x();
        } else {
            this.an = true;
            w();
        }
    }

    private static boolean M() {
        if ("Amazon".equals(af.f9815c)) {
            return "AFTM".equals(af.f9816d) || "AFTB".equals(af.f9816d);
        }
        return false;
    }

    private ByteBuffer b(int i2) {
        return af.a >= 21 ? this.P.getInputBuffer(i2) : this.aa[i2];
    }

    private ByteBuffer c(int i2) {
        return af.a >= 21 ? this.P.getOutputBuffer(i2) : this.ab[i2];
    }

    private boolean d(long j2) {
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.K.get(i2).longValue() == j2) {
                this.K.remove(i2);
                return true;
            }
        }
        return false;
    }

    protected void A() {
        this.ac = com.anythink.expressad.exoplayer.b.b;
        G();
        H();
        this.ao = false;
        this.ag = false;
        this.K.clear();
        if (af.a < 21) {
            this.aa = null;
            this.ab = null;
        }
        this.Q = null;
        this.ah = false;
        this.ak = false;
        this.S = false;
        this.T = false;
        this.R = 0;
        this.U = false;
        this.V = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.al = false;
        this.ai = 0;
        this.aj = 0;
        MediaCodec mediaCodec = this.P;
        if (mediaCodec != null) {
            this.f9051q.b++;
            try {
                mediaCodec.stop();
                try {
                    this.P.release();
                    this.P = null;
                    f<k> fVar = this.N;
                    if (fVar == null || this.O == fVar) {
                        return;
                    }
                    try {
                        this.F.a(fVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.P = null;
                    f<k> fVar2 = this.N;
                    if (fVar2 != null && this.O != fVar2) {
                        try {
                            this.F.a(fVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.P.release();
                    this.P = null;
                    f<k> fVar3 = this.N;
                    if (fVar3 != null && this.O != fVar3) {
                        try {
                            this.F.a(fVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.P = null;
                    f<k> fVar4 = this.N;
                    if (fVar4 != null && this.O != fVar4) {
                        try {
                            this.F.a(fVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    protected void B() throws com.anythink.expressad.exoplayer.g {
        this.ac = com.anythink.expressad.exoplayer.b.b;
        G();
        H();
        this.ap = true;
        this.ao = false;
        this.ag = false;
        this.K.clear();
        this.Y = false;
        this.Z = false;
        if (this.T || ((this.V && this.al) || this.aj != 0)) {
            A();
            x();
        } else {
            this.P.flush();
            this.ak = false;
        }
        if (!this.ah || this.M == null) {
            return;
        }
        this.ai = 1;
    }

    protected int a(com.anythink.expressad.exoplayer.f.a aVar, m mVar, m mVar2) {
        return 0;
    }

    protected abstract int a(com.anythink.expressad.exoplayer.f.c cVar, g<k> gVar, m mVar);

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(m mVar) throws com.anythink.expressad.exoplayer.g {
        try {
            return a(this.E, this.F, mVar);
        } catch (d.b e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void a(com.anythink.expressad.exoplayer.c.e eVar) {
    }

    protected abstract void a(com.anythink.expressad.exoplayer.f.a aVar, MediaCodec mediaCodec, m mVar, MediaCrypto mediaCrypto);

    protected void a(String str, long j2, long j3) {
    }

    protected abstract boolean a(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z2);

    protected boolean a(com.anythink.expressad.exoplayer.f.a aVar) {
        return true;
    }

    protected void c(long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.z
    public final int m() {
        return 8;
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected void n() {
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected void o() {
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected void p() {
        this.M = null;
        try {
            A();
            try {
                if (this.N != null) {
                    this.F.a(this.N);
                }
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.N != null) {
                    this.F.a(this.N);
                }
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.y
    public boolean u() {
        if (this.M == null || this.ao) {
            return false;
        }
        if (t() || F()) {
            return true;
        }
        return this.ac != com.anythink.expressad.exoplayer.b.b && SystemClock.elapsedRealtime() < this.ac;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public boolean v() {
        return this.an;
    }

    protected void w() {
    }

    protected final void x() throws com.anythink.expressad.exoplayer.g {
        m mVar;
        MediaCrypto mediaCryptoA;
        boolean zA;
        if (this.P != null || (mVar = this.M) == null) {
            return;
        }
        this.N = this.O;
        String str = mVar.f9990h;
        f<k> fVar = this.N;
        boolean z2 = false;
        if (fVar != null) {
            k kVar = (k) fVar.g();
            if (kVar != null) {
                mediaCryptoA = kVar.a();
                zA = kVar.a(str);
            } else {
                if (this.N.f() == null) {
                    return;
                }
                mediaCryptoA = null;
                zA = false;
            }
            if ("Amazon".equals(af.f9815c) && ("AFTM".equals(af.f9816d) || "AFTB".equals(af.f9816d))) {
                int iE = this.N.e();
                if (iE == 1) {
                    throw com.anythink.expressad.exoplayer.g.a(this.N.f(), s());
                }
                if (iE != 4) {
                    return;
                }
            }
        } else {
            mediaCryptoA = null;
            zA = false;
        }
        if (this.Q == null) {
            try {
                this.Q = a(this.E, this.M, zA);
                if (this.Q == null && zA) {
                    this.Q = a(this.E, this.M, false);
                    if (this.Q != null) {
                        String str2 = "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.Q.f9032c + ".";
                    }
                }
            } catch (d.b e2) {
                a(new C0189b(this.M, e2, zA, -49998));
            }
            if (this.Q == null) {
                a(new C0189b(this.M, (Throwable) null, zA, -49999));
            }
        }
        if (a(this.Q)) {
            String str3 = this.Q.f9032c;
            this.R = (af.a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str3) && (af.f9816d.startsWith("SM-T585") || af.f9816d.startsWith("SM-A510") || af.f9816d.startsWith("SM-A520") || af.f9816d.startsWith("SM-J700"))) ? 2 : (af.a >= 24 || !(("OMX.Nvidia.h264.decode".equals(str3) || "OMX.Nvidia.h264.decode.secure".equals(str3)) && ("flounder".equals(af.b) || "flounder_lte".equals(af.b) || "grouper".equals(af.b) || "tilapia".equals(af.b)))) ? 0 : 1;
            this.S = af.a < 21 && this.M.f9992j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str3);
            int i2 = af.a;
            this.T = i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str3) || "OMX.SEC.avc.dec.secure".equals(str3))) || (af.a == 19 && af.f9816d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str3) || "OMX.Exynos.avc.dec.secure".equals(str3)));
            com.anythink.expressad.exoplayer.f.a aVar = this.Q;
            String str4 = aVar.f9032c;
            this.U = (af.a <= 17 && ("OMX.rk.video_decoder.avc".equals(str4) || "OMX.allwinner.video.decoder.avc".equals(str4))) || ("Amazon".equals(af.f9815c) && "AFTS".equals(af.f9816d) && aVar.f9037h);
            this.V = (af.a <= 23 && "OMX.google.vorbis.decoder".equals(str3)) || (af.a <= 19 && "hb2000".equals(af.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str3) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str3)));
            this.W = af.a == 21 && "OMX.google.aac.decoder".equals(str3);
            m mVar2 = this.M;
            if (af.a <= 18 && mVar2.f10003u == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str3)) {
                z2 = true;
            }
            this.X = z2;
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ad.a("createCodec:".concat(String.valueOf(str3)));
                this.P = MediaCodec.createByCodecName(str3);
                ad.a();
                ad.a("configureCodec");
                a(this.Q, this.P, this.M, mediaCryptoA);
                ad.a();
                ad.a("startCodec");
                this.P.start();
                ad.a();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str3, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                if (af.a < 21) {
                    this.aa = this.P.getInputBuffers();
                    this.ab = this.P.getOutputBuffers();
                }
            } catch (Exception e3) {
                a(new C0189b(this.M, e3, zA, str3));
            }
            this.ac = a_() == 2 ? SystemClock.elapsedRealtime() + 1000 : com.anythink.expressad.exoplayer.b.b;
            G();
            H();
            this.ap = true;
            this.f9051q.a++;
        }
    }

    protected final MediaCodec y() {
        return this.P;
    }

    protected final com.anythink.expressad.exoplayer.f.a z() {
        return this.Q;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.f.b$b, reason: collision with other inner class name */
    public static class C0189b extends Exception {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f9052e = -50000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f9053f = -49999;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f9054g = -49998;
        public final String a;
        public final boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f9055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f9056d;

        public C0189b(m mVar, Throwable th, boolean z2, int i2) {
            super("Decoder init failed: [" + i2 + "], " + mVar, th);
            this.a = mVar.f9990h;
            this.b = z2;
            this.f9055c = null;
            this.f9056d = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i2 < 0 ? "neg_" : "") + Math.abs(i2);
        }

        @TargetApi(21)
        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String a(int i2) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i2 < 0 ? "neg_" : "") + Math.abs(i2);
        }

        public C0189b(m mVar, Throwable th, boolean z2, String str) {
            super("Decoder init failed: " + str + ", " + mVar, th);
            this.a = mVar.f9990h;
            this.b = z2;
            this.f9055c = str;
            String diagnosticInfo = null;
            if (af.a >= 21 && (th instanceof MediaCodec.CodecException)) {
                diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            this.f9056d = diagnosticInfo;
        }
    }

    protected com.anythink.expressad.exoplayer.f.a a(com.anythink.expressad.exoplayer.f.c cVar, m mVar, boolean z2) {
        return cVar.a(mVar.f9990h, z2);
    }

    private void a(C0189b c0189b) throws com.anythink.expressad.exoplayer.g {
        throw com.anythink.expressad.exoplayer.g.a(c0189b, s());
    }

    private boolean b(boolean z2) throws com.anythink.expressad.exoplayer.g {
        if (this.N == null || (!z2 && this.G)) {
            return false;
        }
        int iE = this.N.e();
        if (iE != 1) {
            return iE != 4;
        }
        throw com.anythink.expressad.exoplayer.g.a(this.N.f(), s());
    }

    private static boolean c(String str) {
        if (af.a <= 23 && "OMX.google.vorbis.decoder".equals(str)) {
            return true;
        }
        if (af.a > 19 || !"hb2000".equals(af.b)) {
            return false;
        }
        return "OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str);
    }

    private static boolean d(String str) {
        return af.a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected void a(boolean z2) {
        this.f9051q = new com.anythink.expressad.exoplayer.c.d();
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected void a(long j2, boolean z2) throws com.anythink.expressad.exoplayer.g {
        this.am = false;
        this.an = false;
        if (this.P != null) {
            B();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b(com.anythink.expressad.exoplayer.m r6) throws com.anythink.expressad.exoplayer.g {
        /*
            r5 = this;
            com.anythink.expressad.exoplayer.m r0 = r5.M
            r5.M = r6
            com.anythink.expressad.exoplayer.m r6 = r5.M
            com.anythink.expressad.exoplayer.d.e r6 = r6.f9993k
            r1 = 0
            if (r0 != 0) goto Ld
            r2 = r1
            goto Lf
        Ld:
            com.anythink.expressad.exoplayer.d.e r2 = r0.f9993k
        Lf:
            boolean r6 = com.anythink.expressad.exoplayer.k.af.a(r6, r2)
            r2 = 1
            r6 = r6 ^ r2
            if (r6 == 0) goto L4d
            com.anythink.expressad.exoplayer.m r6 = r5.M
            com.anythink.expressad.exoplayer.d.e r6 = r6.f9993k
            if (r6 == 0) goto L4b
            com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> r6 = r5.F
            if (r6 == 0) goto L3b
            android.os.Looper r1 = android.os.Looper.myLooper()
            com.anythink.expressad.exoplayer.m r3 = r5.M
            com.anythink.expressad.exoplayer.d.e r3 = r3.f9993k
            com.anythink.expressad.exoplayer.d.f r6 = r6.a(r1, r3)
            r5.O = r6
            com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> r6 = r5.O
            com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> r1 = r5.N
            if (r6 != r1) goto L4d
            com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> r1 = r5.F
            r1.a(r6)
            goto L4d
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r6.<init>(r0)
            int r0 = r5.s()
            com.anythink.expressad.exoplayer.g r6 = com.anythink.expressad.exoplayer.g.a(r6, r0)
            throw r6
        L4b:
            r5.O = r1
        L4d:
            com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> r6 = r5.O
            com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.k> r1 = r5.N
            r3 = 0
            if (r6 != r1) goto L8b
            android.media.MediaCodec r6 = r5.P
            if (r6 == 0) goto L8b
            com.anythink.expressad.exoplayer.f.a r6 = r5.Q
            com.anythink.expressad.exoplayer.m r1 = r5.M
            int r6 = r5.a(r6, r0, r1)
            if (r6 == 0) goto L8b
            if (r6 == r2) goto L8a
            r1 = 3
            if (r6 != r1) goto L84
            r5.ah = r2
            r5.ai = r2
            int r6 = r5.R
            r1 = 2
            if (r6 == r1) goto L80
            if (r6 != r2) goto L81
            com.anythink.expressad.exoplayer.m r6 = r5.M
            int r1 = r6.f9995m
            int r4 = r0.f9995m
            if (r1 != r4) goto L81
            int r6 = r6.f9996n
            int r0 = r0.f9996n
            if (r6 != r0) goto L81
        L80:
            r3 = 1
        L81:
            r5.Y = r3
            goto L8a
        L84:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L8a:
            r3 = 1
        L8b:
            if (r3 != 0) goto L9a
            boolean r6 = r5.ak
            if (r6 == 0) goto L94
            r5.aj = r2
            return
        L94:
            r5.A()
            r5.x()
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.b.b(com.anythink.expressad.exoplayer.m):void");
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j2, long j3) throws com.anythink.expressad.exoplayer.g {
        if (this.an) {
            w();
            return;
        }
        if (this.M == null) {
            this.I.a();
            int iA = a(this.J, this.I, true);
            if (iA != -5) {
                if (iA == -4) {
                    com.anythink.expressad.exoplayer.k.a.b(this.I.c());
                    this.am = true;
                    L();
                    return;
                }
                return;
            }
            b(this.J.a);
        }
        x();
        if (this.P != null) {
            ad.a("drainAndFeed");
            while (b(j2, j3)) {
            }
            while (C()) {
            }
            ad.a();
            return;
        }
        this.f9051q.f8729d += b(j2);
        this.I.a();
        int iA2 = a(this.J, this.I, false);
        if (iA2 == -5) {
            b(this.J.a);
        } else if (iA2 == -4) {
            com.anythink.expressad.exoplayer.k.a.b(this.I.c());
            this.am = true;
            L();
        }
    }

    private boolean b(long j2, long j3) throws com.anythink.expressad.exoplayer.g {
        boolean zA;
        int iDequeueOutputBuffer;
        ByteBuffer outputBuffer;
        boolean z2;
        if (!F()) {
            if (this.W && this.al) {
                try {
                    iDequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
                } catch (IllegalStateException unused) {
                    L();
                    if (this.an) {
                        A();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
            }
            if (iDequeueOutputBuffer < 0) {
                if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.P.getOutputFormat();
                    if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.Z = true;
                    } else {
                        if (this.X) {
                            outputFormat.setInteger("channel-count", 1);
                        }
                        a(this.P, outputFormat);
                    }
                    return true;
                }
                if (iDequeueOutputBuffer == -3) {
                    if (af.a < 21) {
                        this.ab = this.P.getOutputBuffers();
                    }
                    return true;
                }
                if (this.U && (this.am || this.aj == 2)) {
                    L();
                }
                return false;
            }
            if (this.Z) {
                this.Z = false;
                this.P.releaseOutputBuffer(iDequeueOutputBuffer, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.L;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                L();
                return false;
            }
            this.ae = iDequeueOutputBuffer;
            if (af.a >= 21) {
                outputBuffer = this.P.getOutputBuffer(iDequeueOutputBuffer);
            } else {
                outputBuffer = this.ab[iDequeueOutputBuffer];
            }
            this.af = outputBuffer;
            ByteBuffer byteBuffer = this.af;
            if (byteBuffer != null) {
                byteBuffer.position(this.L.offset);
                ByteBuffer byteBuffer2 = this.af;
                MediaCodec.BufferInfo bufferInfo2 = this.L;
                byteBuffer2.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            long j4 = this.L.presentationTimeUs;
            int size = this.K.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z2 = false;
                    break;
                }
                if (this.K.get(i2).longValue() == j4) {
                    this.K.remove(i2);
                    z2 = true;
                    break;
                }
                i2++;
            }
            this.ag = z2;
        }
        if (this.W && this.al) {
            try {
                zA = a(j2, j3, this.P, this.af, this.ae, this.L.flags, this.L.presentationTimeUs, this.ag);
            } catch (IllegalStateException unused2) {
                L();
                if (this.an) {
                    A();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec = this.P;
            ByteBuffer byteBuffer3 = this.af;
            int i3 = this.ae;
            MediaCodec.BufferInfo bufferInfo3 = this.L;
            zA = a(j2, j3, mediaCodec, byteBuffer3, i3, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.ag);
        }
        if (zA) {
            c(this.L.presentationTimeUs);
            boolean z3 = (this.L.flags & 4) != 0;
            H();
            if (!z3) {
                return true;
            }
            L();
        }
        return false;
    }

    private static MediaCodec.CryptoInfo a(com.anythink.expressad.exoplayer.c.e eVar, int i2) {
        MediaCodec.CryptoInfo cryptoInfoA = eVar.f8736d.a();
        if (i2 == 0) {
            return cryptoInfoA;
        }
        if (cryptoInfoA.numBytesOfClearData == null) {
            cryptoInfoA.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfoA.numBytesOfClearData;
        iArr[0] = iArr[0] + i2;
        return cryptoInfoA;
    }

    private static boolean a(String str) {
        int i2 = af.a;
        if (i2 < 18) {
            return true;
        }
        if (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (af.a == 19 && af.f9816d.startsWith("SM-G800")) {
            return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
        }
        return false;
    }

    private static boolean a(String str, m mVar) {
        return af.a < 21 && mVar.f9992j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static int b(String str) {
        if (af.a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (af.f9816d.startsWith("SM-T585") || af.f9816d.startsWith("SM-A510") || af.f9816d.startsWith("SM-A520") || af.f9816d.startsWith("SM-J700"))) {
            return 2;
        }
        if (af.a >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(af.b) || "flounder_lte".equals(af.b) || "grouper".equals(af.b) || "tilapia".equals(af.b)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean b(com.anythink.expressad.exoplayer.f.a aVar) {
        String str = aVar.f9032c;
        if (af.a > 17 || !("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) {
            return "Amazon".equals(af.f9815c) && "AFTS".equals(af.f9816d) && aVar.f9037h;
        }
        return true;
    }

    private static boolean b(String str, m mVar) {
        return af.a <= 18 && mVar.f10003u == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
