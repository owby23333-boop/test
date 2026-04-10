package com.anythink.expressad.exoplayer.l;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.d.k;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.anythink.expressad.exoplayer.l.h;
import com.anythink.expressad.exoplayer.m;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public class e extends com.anythink.expressad.exoplayer.f.b {
    private static boolean A = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f9948s = "MediaCodecVideoRenderer";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f9949t = "crop-left";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f9950u = "crop-right";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f9951v = "crop-bottom";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f9952w = "crop-top";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int[] f9953x = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f9954y = 10;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static boolean f9955z;
    private final Context B;
    private final f C;
    private final h.a D;
    private final long E;
    private final int F;
    private final boolean G;
    private final long[] H;
    private final long[] I;
    private a J;
    private boolean K;
    private Surface L;
    private Surface M;
    private int N;
    private boolean O;
    private long P;
    private long Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private long V;
    private int W;
    private float X;
    private int Y;
    private int Z;
    private int aa;
    private float ab;
    private int ac;
    private int ad;
    private int ae;
    private float af;
    private boolean ag;
    private int ah;
    private long ai;
    private long aj;
    private int ak;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    b f9956r;

    protected static final class a {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9957c;

        public a(int i2, int i3, int i4) {
            this.a = i2;
            this.b = i3;
            this.f9957c = i4;
        }
    }

    @TargetApi(23)
    private final class b implements MediaCodec.OnFrameRenderedListener {
        /* synthetic */ b(e eVar, MediaCodec mediaCodec, byte b) {
            this(mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j2, long j3) {
            e eVar = e.this;
            if (this != eVar.f9956r) {
                return;
            }
            eVar.C();
        }

        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    private e(Context context, com.anythink.expressad.exoplayer.f.c cVar) {
        this(context, cVar, (byte) 0);
    }

    private void D() {
        this.Q = this.E > 0 ? SystemClock.elapsedRealtime() + this.E : com.anythink.expressad.exoplayer.b.b;
    }

    private void E() {
        MediaCodec mediaCodecY;
        byte b2 = 0;
        this.O = false;
        if (af.a < 23 || !this.ag || (mediaCodecY = y()) == null) {
            return;
        }
        this.f9956r = new b(this, mediaCodecY, b2);
    }

    private void F() {
        if (this.O) {
            this.D.a(this.L);
        }
    }

    private void G() {
        this.ac = -1;
        this.ad = -1;
        this.af = -1.0f;
        this.ae = -1;
    }

    private void H() {
        if (this.Y == -1 && this.Z == -1) {
            return;
        }
        if (this.ac == this.Y && this.ad == this.Z && this.ae == this.aa && this.af == this.ab) {
            return;
        }
        this.D.a(this.Y, this.Z, this.aa, this.ab);
        this.ac = this.Y;
        this.ad = this.Z;
        this.ae = this.aa;
        this.af = this.ab;
    }

    private void I() {
        if (this.ac == -1 && this.ad == -1) {
            return;
        }
        this.D.a(this.ac, this.ad, this.ae, this.af);
    }

    private void J() {
        if (this.S > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.D.a(this.S, jElapsedRealtime - this.R);
            this.S = 0;
            this.R = jElapsedRealtime;
        }
    }

    private static boolean K() {
        return af.a <= 22 && "foster".equals(af.b) && "NVIDIA".equals(af.f9815c);
    }

    private static boolean d(long j2) {
        return g(j2);
    }

    private static boolean e(long j2) {
        return j2 < -500000;
    }

    private boolean f(long j2) throws com.anythink.expressad.exoplayer.g {
        int iB = b(j2);
        if (iB == 0) {
            return false;
        }
        ((com.anythink.expressad.exoplayer.f.b) this).f9051q.f8734i++;
        b(this.U + iB);
        B();
        return true;
    }

    private static boolean g(long j2) {
        return j2 < -30000;
    }

    private static boolean h(long j2) {
        return j2 < -500000;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @CallSuper
    protected final void A() {
        try {
            super.A();
        } finally {
            this.U = 0;
            Surface surface = this.M;
            if (surface != null) {
                if (this.L == surface) {
                    this.L = null;
                }
                this.M.release();
                this.M = null;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @CallSuper
    protected final void B() throws com.anythink.expressad.exoplayer.g {
        super.B();
        this.U = 0;
    }

    final void C() {
        if (this.O) {
            return;
        }
        this.O = true;
        this.D.a(this.L);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final int a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<k> gVar, m mVar) {
        boolean z2;
        int i2;
        int i3;
        String str = mVar.f9990h;
        if (!o.b(str)) {
            return 0;
        }
        com.anythink.expressad.exoplayer.d.e eVar = mVar.f9993k;
        if (eVar != null) {
            z2 = false;
            for (int i4 = 0; i4 < eVar.b; i4++) {
                z2 |= eVar.a(i4).f8814d;
            }
        } else {
            z2 = false;
        }
        com.anythink.expressad.exoplayer.f.a aVarA = cVar.a(str, z2);
        if (aVarA == null) {
            return (!z2 || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!com.anythink.expressad.exoplayer.a.a(gVar, eVar)) {
            return 2;
        }
        boolean zB = aVarA.b(mVar.f9987e);
        if (zB && (i2 = mVar.f9995m) > 0 && (i3 = mVar.f9996n) > 0) {
            if (af.a >= 21) {
                zB = aVarA.a(i2, i3, mVar.f9997o);
            } else {
                zB = i2 * i3 <= com.anythink.expressad.exoplayer.f.d.b();
                if (!zB) {
                    String str2 = "FalseCheck [legacyFrameSize, " + mVar.f9995m + "x" + mVar.f9996n + "] [" + af.f9817e + "]";
                }
            }
        }
        return (zB ? 4 : 3) | (aVarA.f9035f ? 16 : 8) | (aVarA.f9036g ? 32 : 0);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void b(m mVar) throws com.anythink.expressad.exoplayer.g {
        super.b(mVar);
        this.D.a(mVar);
        this.X = mVar.f9999q;
        this.W = mVar.f9998p;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @CallSuper
    protected final void c(long j2) {
        this.U--;
        while (true) {
            int i2 = this.ak;
            if (i2 == 0 || j2 < this.I[0]) {
                return;
            }
            long[] jArr = this.H;
            this.aj = jArr[0];
            this.ak = i2 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.ak);
            long[] jArr2 = this.I;
            System.arraycopy(jArr2, 1, jArr2, 0, this.ak);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void n() {
        super.n();
        this.S = 0;
        this.R = SystemClock.elapsedRealtime();
        this.V = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void o() {
        this.Q = com.anythink.expressad.exoplayer.b.b;
        J();
        super.o();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void p() {
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.aj = com.anythink.expressad.exoplayer.b.b;
        this.ai = com.anythink.expressad.exoplayer.b.b;
        this.ak = 0;
        G();
        E();
        this.C.b();
        this.f9956r = null;
        this.ag = false;
        try {
            super.p();
        } finally {
            this.D.b(((com.anythink.expressad.exoplayer.f.b) this).f9051q);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean u() {
        Surface surface;
        if (super.u() && (this.O || (((surface = this.M) != null && this.L == surface) || y() == null || this.ag))) {
            this.Q = com.anythink.expressad.exoplayer.b.b;
            return true;
        }
        if (this.Q == com.anythink.expressad.exoplayer.b.b) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Q) {
            return true;
        }
        this.Q = com.anythink.expressad.exoplayer.b.b;
        return false;
    }

    private e(Context context, com.anythink.expressad.exoplayer.f.c cVar, byte b2) {
        this(context, cVar, null, null);
    }

    private e(Context context, com.anythink.expressad.exoplayer.f.c cVar, @Nullable Handler handler, @Nullable h hVar) {
        this(context, cVar, 0L, null, handler, hVar, -1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, com.anythink.expressad.exoplayer.f.c cVar, long j2, @Nullable com.anythink.expressad.exoplayer.d.g<k> gVar, @Nullable Handler handler, @Nullable h hVar, int i2) {
        super(2, cVar, gVar, false);
        boolean z2 = false;
        this.E = j2;
        this.F = i2;
        this.B = context.getApplicationContext();
        this.C = new f(this.B);
        this.D = new h.a(handler, hVar);
        if (af.a <= 22 && "foster".equals(af.b) && "NVIDIA".equals(af.f9815c)) {
            z2 = true;
        }
        this.G = z2;
        this.H = new long[10];
        this.I = new long[10];
        this.aj = com.anythink.expressad.exoplayer.b.b;
        this.ai = com.anythink.expressad.exoplayer.b.b;
        this.Q = com.anythink.expressad.exoplayer.b.b;
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.N = 1;
        G();
    }

    private static boolean b(long j2, long j3) {
        return g(j2) && j3 > 100000;
    }

    private void b(MediaCodec mediaCodec, int i2) {
        ad.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        ad.a();
        b(1);
    }

    private void c(MediaCodec mediaCodec, int i2) {
        H();
        ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        ad.a();
        this.V = SystemClock.elapsedRealtime() * 1000;
        ((com.anythink.expressad.exoplayer.f.b) this).f9051q.f8730e++;
        this.T = 0;
        C();
    }

    private void b(int i2) {
        com.anythink.expressad.exoplayer.c.d dVar = ((com.anythink.expressad.exoplayer.f.b) this).f9051q;
        dVar.f8732g += i2;
        this.S += i2;
        this.T += i2;
        dVar.f8733h = Math.max(this.T, dVar.f8733h);
        if (this.S >= this.F) {
            J();
        }
    }

    private boolean b(com.anythink.expressad.exoplayer.f.a aVar) {
        if (af.a < 23 || this.ag || a(aVar.f9032c)) {
            return false;
        }
        return !aVar.f9037h || c.a(this.B);
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void a(boolean z2) {
        super.a(z2);
        this.ah = r().b;
        this.ag = this.ah != 0;
        this.D.a(((com.anythink.expressad.exoplayer.f.b) this).f9051q);
        this.C.a();
    }

    private static int b(com.anythink.expressad.exoplayer.f.a aVar, m mVar) {
        if (mVar.f9991i != -1) {
            int size = mVar.f9992j.size();
            int length = 0;
            for (int i2 = 0; i2 < size; i2++) {
                length += mVar.f9992j.get(i2).length;
            }
            return mVar.f9991i + length;
        }
        return a(aVar, mVar.f9990h, mVar.f9995m, mVar.f9996n);
    }

    @Override // com.anythink.expressad.exoplayer.a
    protected final void a(m[] mVarArr, long j2) {
        if (this.aj == com.anythink.expressad.exoplayer.b.b) {
            this.aj = j2;
        } else {
            int i2 = this.ak;
            if (i2 == this.H.length) {
                String str = "Too many stream changes, so dropping offset: " + this.H[this.ak - 1];
            } else {
                this.ak = i2 + 1;
            }
            long[] jArr = this.H;
            int i3 = this.ak;
            jArr[i3 - 1] = j2;
            this.I[i3 - 1] = this.ai;
        }
        super.a(mVarArr, j2);
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    protected final void a(long j2, boolean z2) throws com.anythink.expressad.exoplayer.g {
        super.a(j2, z2);
        E();
        this.P = com.anythink.expressad.exoplayer.b.b;
        this.T = 0;
        this.ai = com.anythink.expressad.exoplayer.b.b;
        int i2 = this.ak;
        if (i2 != 0) {
            this.aj = this.H[i2 - 1];
            this.ak = 0;
        }
        if (z2) {
            D();
        } else {
            this.Q = com.anythink.expressad.exoplayer.b.b;
        }
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i2, Object obj) throws com.anythink.expressad.exoplayer.g {
        if (i2 != 1) {
            if (i2 == 4) {
                this.N = ((Integer) obj).intValue();
                MediaCodec mediaCodecY = y();
                if (mediaCodecY != null) {
                    mediaCodecY.setVideoScalingMode(this.N);
                    return;
                }
                return;
            }
            super.a(i2, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.M;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.anythink.expressad.exoplayer.f.a aVarZ = z();
                if (aVarZ != null && b(aVarZ)) {
                    this.M = c.a(this.B, aVarZ.f9037h);
                    surface = this.M;
                }
            }
        }
        if (this.L != surface) {
            this.L = surface;
            int iA_ = a_();
            if (iA_ == 1 || iA_ == 2) {
                MediaCodec mediaCodecY2 = y();
                if (af.a >= 23 && mediaCodecY2 != null && surface != null && !this.K) {
                    mediaCodecY2.setOutputSurface(surface);
                } else {
                    A();
                    x();
                }
            }
            if (surface != null && surface != this.M) {
                I();
                E();
                if (iA_ == 2) {
                    D();
                    return;
                }
                return;
            }
            G();
            E();
            return;
        }
        if (surface == null || surface == this.M) {
            return;
        }
        I();
        if (this.O) {
            this.D.a(this.L);
        }
    }

    private void a(Surface surface) throws com.anythink.expressad.exoplayer.g {
        if (surface == null) {
            Surface surface2 = this.M;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.anythink.expressad.exoplayer.f.a aVarZ = z();
                if (aVarZ != null && b(aVarZ)) {
                    this.M = c.a(this.B, aVarZ.f9037h);
                    surface = this.M;
                }
            }
        }
        if (this.L != surface) {
            this.L = surface;
            int iA_ = a_();
            if (iA_ == 1 || iA_ == 2) {
                MediaCodec mediaCodecY = y();
                if (af.a >= 23 && mediaCodecY != null && surface != null && !this.K) {
                    mediaCodecY.setOutputSurface(surface);
                } else {
                    A();
                    x();
                }
            }
            if (surface != null && surface != this.M) {
                I();
                E();
                if (iA_ == 2) {
                    D();
                    return;
                }
                return;
            }
            G();
            E();
            return;
        }
        if (surface == null || surface == this.M) {
            return;
        }
        I();
        if (this.O) {
            this.D.a(this.L);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final boolean a(com.anythink.expressad.exoplayer.f.a aVar) {
        return this.L != null || b(aVar);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void a(com.anythink.expressad.exoplayer.f.a aVar, MediaCodec mediaCodec, m mVar, MediaCrypto mediaCrypto) {
        a aVar2;
        m[] mVarArrQ = q();
        int i2 = mVar.f9995m;
        int i3 = mVar.f9996n;
        int iB = b(aVar, mVar);
        byte b2 = 0;
        if (mVarArrQ.length == 1) {
            aVar2 = new a(i2, i3, iB);
        } else {
            int iMax = i3;
            int iMax2 = iB;
            boolean z2 = false;
            int iMax3 = i2;
            for (m mVar2 : mVarArrQ) {
                if (a(aVar.f9035f, mVar, mVar2)) {
                    z2 |= mVar2.f9995m == -1 || mVar2.f9996n == -1;
                    iMax3 = Math.max(iMax3, mVar2.f9995m);
                    iMax = Math.max(iMax, mVar2.f9996n);
                    iMax2 = Math.max(iMax2, b(aVar, mVar2));
                }
            }
            if (z2) {
                String str = "Resolutions unknown. Codec max resolution: " + iMax3 + "x" + iMax;
                Point pointA = a(aVar, mVar);
                if (pointA != null) {
                    iMax3 = Math.max(iMax3, pointA.x);
                    iMax = Math.max(iMax, pointA.y);
                    iMax2 = Math.max(iMax2, a(aVar, mVar.f9990h, iMax3, iMax));
                    String str2 = "Codec max resolution adjusted to: " + iMax3 + "x" + iMax;
                }
            }
            aVar2 = new a(iMax3, iMax, iMax2);
        }
        this.J = aVar2;
        a aVar3 = this.J;
        boolean z3 = this.G;
        int i4 = this.ah;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", mVar.f9990h);
        mediaFormat.setInteger("width", mVar.f9995m);
        mediaFormat.setInteger("height", mVar.f9996n);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.f9992j);
        float f2 = mVar.f9997o;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.f9998p);
        com.anythink.expressad.exoplayer.l.b bVar = mVar.f10002t;
        if (bVar != null) {
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.f9934c);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.a);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.f9935d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger("max-width", aVar3.a);
        mediaFormat.setInteger("max-height", aVar3.b);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "max-input-size", aVar3.f9957c);
        if (af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z3) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i4 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i4);
        }
        if (this.L == null) {
            com.anythink.expressad.exoplayer.k.a.b(b(aVar));
            if (this.M == null) {
                this.M = c.a(this.B, aVar.f9037h);
            }
            this.L = this.M;
        }
        mediaCodec.configure(mediaFormat, this.L, mediaCrypto, 0);
        if (af.a < 23 || !this.ag) {
            return;
        }
        this.f9956r = new b(this, mediaCodec, b2);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final int a(com.anythink.expressad.exoplayer.f.a aVar, m mVar, m mVar2) {
        if (!a(aVar.f9035f, mVar, mVar2)) {
            return 0;
        }
        int i2 = mVar2.f9995m;
        a aVar2 = this.J;
        if (i2 > aVar2.a || mVar2.f9996n > aVar2.b || b(aVar, mVar2) > this.J.f9957c) {
            return 0;
        }
        return mVar.b(mVar2) ? 1 : 3;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void a(String str, long j2, long j3) {
        this.D.a(str, j2, j3);
        this.K = a(str);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    @CallSuper
    protected final void a(com.anythink.expressad.exoplayer.c.e eVar) {
        this.U++;
        this.ai = Math.max(eVar.f8738f, this.ai);
        if (af.a >= 23 || !this.ag) {
            return;
        }
        C();
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z2 = mediaFormat.containsKey(f9950u) && mediaFormat.containsKey(f9949t) && mediaFormat.containsKey(f9951v) && mediaFormat.containsKey(f9952w);
        if (z2) {
            integer = (mediaFormat.getInteger(f9950u) - mediaFormat.getInteger(f9949t)) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.Y = integer;
        if (z2) {
            integer2 = (mediaFormat.getInteger(f9951v) - mediaFormat.getInteger(f9952w)) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.Z = integer2;
        this.ab = this.X;
        if (af.a >= 21) {
            int i2 = this.W;
            if (i2 == 90 || i2 == 270) {
                int i3 = this.Y;
                this.Y = this.Z;
                this.Z = i3;
                this.ab = 1.0f / this.ab;
            }
        } else {
            this.aa = this.W;
        }
        mediaCodec.setVideoScalingMode(this.N);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        if ((g(r8) && r10 - r19.V > 100000) != false) goto L72;
     */
    @Override // com.anythink.expressad.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean a(long r20, long r22, android.media.MediaCodec r24, java.nio.ByteBuffer r25, int r26, int r27, long r28, boolean r30) throws com.anythink.expressad.exoplayer.g {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.l.e.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    private void a(MediaCodec mediaCodec, int i2) {
        ad.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        ad.a();
        ((com.anythink.expressad.exoplayer.f.b) this).f9051q.f8731f++;
    }

    @TargetApi(21)
    private void a(MediaCodec mediaCodec, int i2, long j2) {
        H();
        ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j2);
        ad.a();
        this.V = SystemClock.elapsedRealtime() * 1000;
        ((com.anythink.expressad.exoplayer.f.b) this).f9051q.f8730e++;
        this.T = 0;
        C();
    }

    @TargetApi(23)
    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    private static void a(MediaFormat mediaFormat, int i2) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i2);
    }

    @SuppressLint({"InlinedApi"})
    private static MediaFormat a(m mVar, a aVar, boolean z2, int i2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", mVar.f9990h);
        mediaFormat.setInteger("width", mVar.f9995m);
        mediaFormat.setInteger("height", mVar.f9996n);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.f9992j);
        float f2 = mVar.f9997o;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.f9998p);
        com.anythink.expressad.exoplayer.l.b bVar = mVar.f10002t;
        if (bVar != null) {
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.f9934c);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.a);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.f9935d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger("max-width", aVar.a);
        mediaFormat.setInteger("max-height", aVar.b);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "max-input-size", aVar.f9957c);
        if (af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z2) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i2 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i2);
        }
        return mediaFormat;
    }

    private static a a(com.anythink.expressad.exoplayer.f.a aVar, m mVar, m[] mVarArr) {
        int i2 = mVar.f9995m;
        int i3 = mVar.f9996n;
        int iB = b(aVar, mVar);
        if (mVarArr.length == 1) {
            return new a(i2, i3, iB);
        }
        int iMax = i3;
        int iMax2 = iB;
        boolean z2 = false;
        int iMax3 = i2;
        for (m mVar2 : mVarArr) {
            if (a(aVar.f9035f, mVar, mVar2)) {
                z2 |= mVar2.f9995m == -1 || mVar2.f9996n == -1;
                iMax3 = Math.max(iMax3, mVar2.f9995m);
                iMax = Math.max(iMax, mVar2.f9996n);
                iMax2 = Math.max(iMax2, b(aVar, mVar2));
            }
        }
        if (z2) {
            String str = "Resolutions unknown. Codec max resolution: " + iMax3 + "x" + iMax;
            Point pointA = a(aVar, mVar);
            if (pointA != null) {
                iMax3 = Math.max(iMax3, pointA.x);
                iMax = Math.max(iMax, pointA.y);
                iMax2 = Math.max(iMax2, a(aVar, mVar.f9990h, iMax3, iMax));
                String str2 = "Codec max resolution adjusted to: " + iMax3 + "x" + iMax;
            }
        }
        return new a(iMax3, iMax, iMax2);
    }

    private static Point a(com.anythink.expressad.exoplayer.f.a aVar, m mVar) {
        boolean z2 = mVar.f9996n > mVar.f9995m;
        int i2 = z2 ? mVar.f9996n : mVar.f9995m;
        int i3 = z2 ? mVar.f9995m : mVar.f9996n;
        float f2 = i3 / i2;
        for (int i4 : f9953x) {
            int i5 = (int) (i4 * f2);
            if (i4 <= i2 || i5 <= i3) {
                break;
            }
            if (af.a >= 21) {
                int i6 = z2 ? i5 : i4;
                if (!z2) {
                    i4 = i5;
                }
                Point pointA = aVar.a(i6, i4);
                if (aVar.a(pointA.x, pointA.y, mVar.f9997o)) {
                    return pointA;
                }
            } else {
                int iA = af.a(i4, 16) * 16;
                int iA2 = af.a(i5, 16) * 16;
                if (iA * iA2 <= com.anythink.expressad.exoplayer.f.d.b()) {
                    int i7 = z2 ? iA2 : iA;
                    if (z2) {
                        iA2 = iA;
                    }
                    return new Point(i7, iA2);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.anythink.expressad.exoplayer.f.a r7, java.lang.String r8, int r9, int r10) {
        /*
            r0 = -1
            if (r9 == r0) goto La9
            if (r10 != r0) goto L7
            goto La9
        L7:
            int r1 = r8.hashCode()
            r2 = 5
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 2
            switch(r1) {
                case -1664118616: goto L46;
                case -1662541442: goto L3c;
                case 1187890754: goto L32;
                case 1331836730: goto L28;
                case 1599127256: goto L1e;
                case 1599127257: goto L14;
                default: goto L13;
            }
        L13:
            goto L50
        L14:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 5
            goto L51
        L1e:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 3
            goto L51
        L28:
            java.lang.String r1 = "video/avc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 2
            goto L51
        L32:
            java.lang.String r1 = "video/mp4v-es"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 1
            goto L51
        L3c:
            java.lang.String r1 = "video/hevc"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 4
            goto L51
        L46:
            java.lang.String r1 = "video/3gpp"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L50
            r8 = 0
            goto L51
        L50:
            r8 = -1
        L51:
            if (r8 == 0) goto La0
            if (r8 == r3) goto La0
            if (r8 == r6) goto L61
            if (r8 == r5) goto La0
            if (r8 == r4) goto L5e
            if (r8 == r2) goto L5e
            return r0
        L5e:
            int r9 = r9 * r10
            goto La3
        L61:
            java.lang.String r8 = com.anythink.expressad.exoplayer.k.af.f9816d
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L9f
            java.lang.String r8 = com.anythink.expressad.exoplayer.k.af.f9815c
            java.lang.String r1 = "Amazon"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L8e
            java.lang.String r8 = com.anythink.expressad.exoplayer.k.af.f9816d
            java.lang.String r1 = "KFSOWI"
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L9f
            java.lang.String r8 = com.anythink.expressad.exoplayer.k.af.f9816d
            java.lang.String r1 = "AFTS"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L8e
            boolean r7 = r7.f9037h
            if (r7 == 0) goto L8e
            goto L9f
        L8e:
            r7 = 16
            int r8 = com.anythink.expressad.exoplayer.k.af.a(r9, r7)
            int r9 = com.anythink.expressad.exoplayer.k.af.a(r10, r7)
            int r8 = r8 * r9
            int r8 = r8 * 16
            int r9 = r8 * 16
            goto La2
        L9f:
            return r0
        La0:
            int r9 = r9 * r10
        La2:
            r4 = 2
        La3:
            int r9 = r9 * 3
            int r4 = r4 * 2
            int r9 = r9 / r4
            return r9
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.l.e.a(com.anythink.expressad.exoplayer.f.a, java.lang.String, int, int):int");
    }

    private static boolean a(boolean z2, m mVar, m mVar2) {
        if (mVar.f9990h.equals(mVar2.f9990h) && mVar.f9998p == mVar2.f9998p) {
            return (z2 || (mVar.f9995m == mVar2.f9995m && mVar.f9996n == mVar2.f9996n)) && af.a(mVar.f10002t, mVar2.f10002t);
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:368:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x05cb A[Catch: all -> 0x05d3, TryCatch #0 {, blocks: (B:9:0x0014, B:11:0x0018, B:12:0x0020, B:369:0x059b, B:372:0x05a1, B:388:0x05cd, B:387:0x05cb, B:377:0x05b2, B:380:0x05bc, B:371:0x059f, B:14:0x0025, B:17:0x0031, B:20:0x003d, B:23:0x0049, B:26:0x0055, B:29:0x0061, B:32:0x006d, B:35:0x0079, B:38:0x0085, B:41:0x0091, B:44:0x009d, B:47:0x00a9, B:50:0x00b5, B:53:0x00bf, B:56:0x00cb, B:59:0x00d7, B:62:0x00e3, B:65:0x00ef, B:68:0x00fb, B:71:0x0106, B:74:0x0112, B:77:0x011e, B:80:0x012a, B:83:0x0136, B:86:0x0142, B:89:0x014e, B:92:0x015a, B:95:0x0166, B:98:0x0172, B:101:0x017e, B:104:0x018a, B:107:0x0196, B:110:0x01a2, B:113:0x01ae, B:116:0x01ba, B:119:0x01c5, B:122:0x01d1, B:125:0x01dd, B:128:0x01e9, B:131:0x01f5, B:134:0x0201, B:137:0x020d, B:140:0x0219, B:143:0x0225, B:146:0x0231, B:149:0x023d, B:152:0x0249, B:155:0x0255, B:158:0x0261, B:161:0x026d, B:164:0x0278, B:167:0x0284, B:170:0x0290, B:173:0x029c, B:176:0x02a8, B:179:0x02b4, B:182:0x02c0, B:185:0x02cc, B:188:0x02d8, B:191:0x02e3, B:194:0x02ee, B:197:0x02f9, B:200:0x0305, B:203:0x0311, B:206:0x031d, B:209:0x0329, B:212:0x0335, B:215:0x0341, B:218:0x034d, B:221:0x0359, B:224:0x0365, B:227:0x0371, B:230:0x037d, B:233:0x0389, B:236:0x0395, B:239:0x03a1, B:242:0x03ad, B:245:0x03b9, B:248:0x03c5, B:251:0x03d1, B:254:0x03dd, B:257:0x03e9, B:260:0x03f5, B:263:0x0401, B:266:0x040d, B:269:0x0419, B:272:0x0425, B:275:0x0431, B:278:0x043d, B:281:0x0449, B:284:0x0454, B:287:0x0460, B:290:0x046c, B:293:0x0478, B:296:0x0484, B:299:0x048f, B:302:0x049b, B:305:0x04a7, B:308:0x04b3, B:311:0x04bf, B:314:0x04cb, B:317:0x04d7, B:320:0x04e3, B:323:0x04ef, B:326:0x04fb, B:329:0x0507, B:332:0x0513, B:335:0x051f, B:338:0x052b, B:341:0x0537, B:344:0x0542, B:347:0x054d, B:350:0x0558, B:353:0x0563, B:356:0x056e, B:359:0x0579, B:362:0x0584, B:365:0x058f, B:389:0x05cf), top: B:396:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 2210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.l.e.a(java.lang.String):boolean");
    }
}
