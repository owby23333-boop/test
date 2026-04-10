package com.anythink.expressad.exoplayer.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.b.h;
import com.anythink.expressad.exoplayer.b.j;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements h {
    public static boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f8579c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f8580d = 250000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f8581e = 750000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f8582f = 250000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8583g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8584h = -2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8585i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f8586j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f8587k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    private static final int f8588l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f8589m = "AudioTrack";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f8590n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f8591o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f8592p = 2;

    @Nullable
    private h.c A;

    @Nullable
    private AudioTrack B;
    private AudioTrack C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private com.anythink.expressad.exoplayer.b.b J;
    private boolean K;
    private boolean L;
    private int M;

    @Nullable
    private v N;
    private v O;
    private long P;
    private long Q;

    @Nullable
    private ByteBuffer R;
    private int S;
    private int T;
    private long U;
    private long V;
    private int W;
    private long X;
    private long Y;
    private int Z;
    private int aa;
    private long ab;
    private float ac;
    private com.anythink.expressad.exoplayer.b.f[] ad;
    private ByteBuffer[] ae;

    @Nullable
    private ByteBuffer af;

    @Nullable
    private ByteBuffer ag;
    private byte[] ah;
    private int ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private int am;
    private boolean an;
    private long ao;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private final com.anythink.expressad.exoplayer.b.c f8593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final a f8594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f8595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final k f8596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final u f8597u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.b.f[] f8598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.b.f[] f8599w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ConditionVariable f8600x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final j f8601y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final ArrayDeque<d> f8602z;

    public interface a {
        long a(long j2);

        v a(v vVar);

        com.anythink.expressad.exoplayer.b.f[] a();

        long b();
    }

    public static class b implements a {
        private final com.anythink.expressad.exoplayer.b.f[] a;
        private final q b = new q();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final t f8603c = new t();

        public b(com.anythink.expressad.exoplayer.b.f... fVarArr) {
            this.a = (com.anythink.expressad.exoplayer.b.f[]) Arrays.copyOf(fVarArr, fVarArr.length + 2);
            com.anythink.expressad.exoplayer.b.f[] fVarArr2 = this.a;
            fVarArr2[fVarArr.length] = this.b;
            fVarArr2[fVarArr.length + 1] = this.f8603c;
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final com.anythink.expressad.exoplayer.b.f[] a() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final long b() {
            return this.b.j();
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final v a(v vVar) {
            this.b.a(vVar.f10070d);
            return new v(this.f8603c.a(vVar.b), this.f8603c.b(vVar.f10069c), vVar.f10070d);
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final long a(long j2) {
            return this.f8603c.a(j2);
        }
    }

    public static final class c extends RuntimeException {
        /* synthetic */ c(String str, byte b) {
            this(str);
        }

        private c(String str) {
            super(str);
        }
    }

    private static final class d {
        private final v a;
        private final long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f8604c;

        /* synthetic */ d(v vVar, long j2, long j3, byte b) {
            this(vVar, j2, j3);
        }

        private d(v vVar, long j2, long j3) {
            this.a = vVar;
            this.b = j2;
            this.f8604c = j3;
        }
    }

    private final class e implements j.a {
        private e() {
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + l.this.r() + ", " + l.this.s();
            if (l.f8579c) {
                throw new c(str, (byte) 0);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void b(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + l.this.r() + ", " + l.this.s();
            if (l.f8579c) {
                throw new c(str, (byte) 0);
            }
        }

        /* synthetic */ e(l lVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(long j2) {
            "Ignoring impossibly large audio latency: ".concat(String.valueOf(j2));
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(int i2, long j2) {
            if (l.this.A != null) {
                l.this.A.a(i2, j2, SystemClock.elapsedRealtime() - l.this.ao);
            }
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface f {
    }

    public l(@Nullable com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.b.f[] fVarArr) {
        this(cVar, fVarArr, (byte) 0);
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        for (com.anythink.expressad.exoplayer.b.f fVar : v()) {
            if (fVar.a()) {
                arrayList.add(fVar);
            } else {
                fVar.h();
            }
        }
        int size = arrayList.size();
        this.ad = (com.anythink.expressad.exoplayer.b.f[]) arrayList.toArray(new com.anythink.expressad.exoplayer.b.f[size]);
        this.ae = new ByteBuffer[size];
        l();
    }

    private void l() {
        int i2 = 0;
        while (true) {
            com.anythink.expressad.exoplayer.b.f[] fVarArr = this.ad;
            if (i2 >= fVarArr.length) {
                return;
            }
            com.anythink.expressad.exoplayer.b.f fVar = fVarArr[i2];
            fVar.h();
            this.ae[i2] = fVar.f();
            i2++;
        }
    }

    private void m() {
        this.f8600x.block();
        this.C = t();
        int audioSessionId = this.C.getAudioSessionId();
        if (b && af.a < 21) {
            AudioTrack audioTrack = this.B;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                p();
            }
            if (this.B == null) {
                this.B = new AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
            }
        }
        if (this.am != audioSessionId) {
            this.am = audioSessionId;
            h.c cVar = this.A;
            if (cVar != null) {
                cVar.a(audioSessionId);
            }
        }
        this.O = this.L ? this.f8594r.a(this.O) : v.a;
        k();
        this.f8601y.a(this.C, this.I, this.W, this.M);
        o();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean n() throws com.anythink.expressad.exoplayer.b.h.d {
        /*
            r9 = this;
            int r0 = r9.aj
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.K
            if (r0 == 0) goto Ld
            r0 = 0
            goto L10
        Ld:
            com.anythink.expressad.exoplayer.b.f[] r0 = r9.ad
            int r0 = r0.length
        L10:
            r9.aj = r0
        L12:
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.aj
            com.anythink.expressad.exoplayer.b.f[] r5 = r9.ad
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.e()
        L28:
            r9.a(r7)
            boolean r0 = r4.g()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.aj
            int r0 = r0 + r2
            r9.aj = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.ag
            if (r0 == 0) goto L44
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.ag
            if (r0 == 0) goto L44
            return r3
        L44:
            r9.aj = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.l.n():boolean");
    }

    private void o() {
        if (q()) {
            if (af.a >= 21) {
                this.C.setVolume(this.ac);
                return;
            }
            AudioTrack audioTrack = this.C;
            float f2 = this.ac;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private void p() {
        final AudioTrack audioTrack = this.B;
        if (audioTrack == null) {
            return;
        }
        this.B = null;
        new Thread() { // from class: com.anythink.expressad.exoplayer.b.l.2
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                audioTrack.release();
            }
        }.start();
    }

    private boolean q() {
        return this.C != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        return this.D ? this.U / ((long) this.T) : this.V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long s() {
        return this.D ? this.X / ((long) this.W) : this.Y;
    }

    private AudioTrack t() throws h.b {
        AudioTrack audioTrack;
        if (af.a >= 21) {
            AudioAttributes audioAttributesBuild = this.an ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.J.a();
            AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.H).setEncoding(this.I).setSampleRate(this.G).build();
            int i2 = this.am;
            audioTrack = new AudioTrack(audioAttributesBuild, audioFormatBuild, this.M, 1, i2 != 0 ? i2 : 0);
        } else {
            int iF = af.f(this.J.f8522d);
            int i3 = this.am;
            audioTrack = i3 == 0 ? new AudioTrack(iF, this.G, this.H, this.I, this.M, 1) : new AudioTrack(iF, this.G, this.H, this.I, this.M, 1, i3);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new h.b(state, this.G, this.H, this.M);
    }

    @TargetApi(21)
    private AudioTrack u() {
        AudioAttributes audioAttributesBuild = this.an ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.J.a();
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.H).setEncoding(this.I).setSampleRate(this.G).build();
        int i2 = this.am;
        return new AudioTrack(audioAttributesBuild, audioFormatBuild, this.M, 1, i2 != 0 ? i2 : 0);
    }

    private com.anythink.expressad.exoplayer.b.f[] v() {
        return this.E ? this.f8599w : this.f8598v;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final v f() {
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void g() {
        if (this.an) {
            this.an = false;
            this.am = 0;
            i();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void h() {
        this.al = false;
        if (q() && this.f8601y.c()) {
            this.C.pause();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void i() {
        if (q()) {
            this.U = 0L;
            this.V = 0L;
            this.X = 0L;
            this.Y = 0L;
            this.Z = 0;
            v vVar = this.N;
            if (vVar != null) {
                this.O = vVar;
                this.N = null;
            } else if (!this.f8602z.isEmpty()) {
                this.O = this.f8602z.getLast().a;
            }
            this.f8602z.clear();
            this.P = 0L;
            this.Q = 0L;
            this.af = null;
            this.ag = null;
            l();
            this.ak = false;
            this.aj = -1;
            this.R = null;
            this.S = 0;
            this.aa = 0;
            if (this.f8601y.b()) {
                this.C.pause();
            }
            final AudioTrack audioTrack = this.C;
            this.C = null;
            this.f8601y.d();
            this.f8600x.close();
            new Thread() { // from class: com.anythink.expressad.exoplayer.b.l.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        l.this.f8600x.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void j() {
        i();
        p();
        for (com.anythink.expressad.exoplayer.b.f fVar : this.f8598v) {
            fVar.i();
        }
        for (com.anythink.expressad.exoplayer.b.f fVar2 : this.f8599w) {
            fVar2.i();
        }
        this.am = 0;
        this.al = false;
    }

    private l(@Nullable com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.b.f[] fVarArr, byte b2) {
        this(cVar, new b(fVarArr));
    }

    private long f(long j2) {
        return (j2 * ((long) this.G)) / 1000000;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(h.c cVar) {
        this.A = cVar;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void b() {
        if (this.aa == 1) {
            this.aa = 2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void c() {
        if (!this.ak && q() && n()) {
            this.f8601y.d(s());
            this.C.stop();
            this.S = 0;
            this.ak = true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean d() {
        if (q()) {
            return this.ak && !e();
        }
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean e() {
        return q() && this.f8601y.e(s());
    }

    private l(@Nullable com.anythink.expressad.exoplayer.b.c cVar, a aVar) {
        this.f8593q = cVar;
        this.f8594r = (a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        this.f8595s = false;
        this.f8600x = new ConditionVariable(true);
        this.f8601y = new j(new e(this, (byte) 0));
        this.f8596t = new k();
        this.f8597u = new u();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new p(), this.f8596t, this.f8597u);
        Collections.addAll(arrayList, aVar.a());
        this.f8598v = (com.anythink.expressad.exoplayer.b.f[]) arrayList.toArray(new com.anythink.expressad.exoplayer.b.f[arrayList.size()]);
        this.f8599w = new com.anythink.expressad.exoplayer.b.f[]{new n()};
        this.ac = 1.0f;
        this.aa = 0;
        this.J = com.anythink.expressad.exoplayer.b.b.a;
        this.am = 0;
        this.O = v.a;
        this.aj = -1;
        this.ad = new com.anythink.expressad.exoplayer.b.f[0];
        this.ae = new ByteBuffer[0];
        this.f8602z = new ArrayDeque<>();
    }

    private long d(long j2) {
        return (j2 * 1000000) / ((long) this.F);
    }

    private long e(long j2) {
        return (j2 * 1000000) / ((long) this.G);
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean a(int i2) {
        if (af.b(i2)) {
            return i2 != 4 || af.a >= 21;
        }
        com.anythink.expressad.exoplayer.b.c cVar = this.f8593q;
        return cVar != null && cVar.a(i2);
    }

    private void b(ByteBuffer byteBuffer, long j2) throws h.d {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.ag;
            int iWrite = 0;
            if (byteBuffer2 != null) {
                com.anythink.expressad.exoplayer.k.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.ag = byteBuffer;
                if (af.a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.ah;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.ah = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.ah, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.ai = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (af.a < 21) {
                int iB = this.f8601y.b(this.X);
                if (iB > 0) {
                    iWrite = this.C.write(this.ah, this.ai, Math.min(iRemaining2, iB));
                    if (iWrite > 0) {
                        this.ai += iWrite;
                        byteBuffer.position(byteBuffer.position() + iWrite);
                    }
                }
            } else if (this.an) {
                com.anythink.expressad.exoplayer.k.a.b(j2 != com.anythink.expressad.exoplayer.b.b);
                iWrite = a(this.C, byteBuffer, iRemaining2, j2);
            } else {
                iWrite = this.C.write(byteBuffer, iRemaining2, 1);
            }
            this.ao = SystemClock.elapsedRealtime();
            if (iWrite >= 0) {
                if (this.D) {
                    this.X += (long) iWrite;
                }
                if (iWrite == iRemaining2) {
                    if (!this.D) {
                        this.Y += (long) this.Z;
                    }
                    this.ag = null;
                    return;
                }
                return;
            }
            throw new h.d(iWrite);
        }
    }

    private static AudioTrack d(int i2) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i2);
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final long a(boolean z2) {
        long j2;
        long jA;
        long j3;
        if (!q() || this.aa == 0) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.f8601y.a(z2), e(s()));
        long j4 = this.ab;
        d dVarRemove = null;
        while (!this.f8602z.isEmpty() && jMin >= this.f8602z.getFirst().f8604c) {
            dVarRemove = this.f8602z.remove();
        }
        if (dVarRemove != null) {
            this.O = dVarRemove.a;
            this.Q = dVarRemove.f8604c;
            this.P = dVarRemove.b - this.ab;
        }
        if (this.O.b == 1.0f) {
            j3 = (jMin + this.P) - this.Q;
        } else {
            if (this.f8602z.isEmpty()) {
                j2 = this.P;
                jA = this.f8594r.a(jMin - this.Q);
            } else {
                j2 = this.P;
                jA = af.a(jMin - this.Q, this.O.b);
            }
            j3 = jA + j2;
        }
        return j4 + j3 + e(this.f8594r.b());
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void c(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(af.a >= 21);
        if (this.an && this.am == i2) {
            return;
        }
        this.an = true;
        this.am = i2;
        i();
    }

    private long c(long j2) {
        return j2 + e(this.f8594r.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00d0  */
    @Override // com.anythink.expressad.exoplayer.b.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r9, int r10, int r11, @androidx.annotation.Nullable int[] r12, int r13, int r14) throws com.anythink.expressad.exoplayer.b.h.a {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.l.a(int, int, int, int[], int, int):void");
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void b(int i2) {
        if (this.am != i2) {
            this.am = i2;
            i();
        }
    }

    private long b(long j2) {
        long j3;
        long jA;
        d dVarRemove = null;
        while (!this.f8602z.isEmpty() && j2 >= this.f8602z.getFirst().f8604c) {
            dVarRemove = this.f8602z.remove();
        }
        if (dVarRemove != null) {
            this.O = dVarRemove.a;
            this.Q = dVarRemove.f8604c;
            this.P = dVarRemove.b - this.ab;
        }
        if (this.O.b == 1.0f) {
            return (j2 + this.P) - this.Q;
        }
        if (this.f8602z.isEmpty()) {
            j3 = this.P;
            jA = this.f8594r.a(j2 - this.Q);
        } else {
            j3 = this.P;
            jA = af.a(j2 - this.Q, this.O.b);
        }
        return j3 + jA;
    }

    private static void b(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a() {
        this.al = true;
        if (q()) {
            this.f8601y.a();
            this.C.play();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean a(ByteBuffer byteBuffer, long j2) throws h.d {
        int iA;
        v vVarA;
        ByteBuffer byteBuffer2 = this.af;
        com.anythink.expressad.exoplayer.k.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!q()) {
            this.f8600x.block();
            this.C = t();
            int audioSessionId = this.C.getAudioSessionId();
            if (b && af.a < 21) {
                AudioTrack audioTrack = this.B;
                if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                    p();
                }
                if (this.B == null) {
                    this.B = new AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
                }
            }
            if (this.am != audioSessionId) {
                this.am = audioSessionId;
                h.c cVar = this.A;
                if (cVar != null) {
                    cVar.a(audioSessionId);
                }
            }
            if (this.L) {
                vVarA = this.f8594r.a(this.O);
            } else {
                vVarA = v.a;
            }
            this.O = vVarA;
            k();
            this.f8601y.a(this.C, this.I, this.W, this.M);
            o();
            if (this.al) {
                a();
            }
        }
        if (!this.f8601y.a(s())) {
            return false;
        }
        if (this.af == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.D && this.Z == 0) {
                int i2 = this.I;
                if (i2 == 7 || i2 == 8) {
                    iA = m.a(byteBuffer);
                } else if (i2 == 5) {
                    iA = com.anythink.expressad.exoplayer.b.a.a();
                } else if (i2 == 6) {
                    iA = com.anythink.expressad.exoplayer.b.a.a(byteBuffer);
                } else if (i2 == 14) {
                    int iB = com.anythink.expressad.exoplayer.b.a.b(byteBuffer);
                    iA = iB == -1 ? 0 : com.anythink.expressad.exoplayer.b.a.a(byteBuffer, iB) * 16;
                } else {
                    throw new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(i2)));
                }
                this.Z = iA;
                if (this.Z == 0) {
                    return true;
                }
            }
            if (this.N != null) {
                if (!n()) {
                    return false;
                }
                v vVar = this.N;
                this.N = null;
                this.f8602z.add(new d(this.f8594r.a(vVar), Math.max(0L, j2), e(s()), (byte) 0));
                k();
            }
            if (this.aa == 0) {
                this.ab = Math.max(0L, j2);
                this.aa = 1;
            } else {
                long jR = this.ab + ((r() * 1000000) / ((long) this.F));
                if (this.aa == 1 && Math.abs(jR - j2) > 200000) {
                    String str = "Discontinuity detected [expected " + jR + ", got " + j2 + "]";
                    this.aa = 2;
                }
                if (this.aa == 2) {
                    this.ab += j2 - jR;
                    this.aa = 1;
                    h.c cVar2 = this.A;
                    if (cVar2 != null) {
                        cVar2.a();
                    }
                }
            }
            if (this.D) {
                this.U += (long) byteBuffer.remaining();
            } else {
                this.V += (long) this.Z;
            }
            this.af = byteBuffer;
        }
        if (this.K) {
            a(j2);
        } else {
            b(this.af, j2);
        }
        if (!this.af.hasRemaining()) {
            this.af = null;
            return true;
        }
        if (!this.f8601y.c(s())) {
            return false;
        }
        i();
        return true;
    }

    private void a(long j2) throws h.d {
        ByteBuffer byteBuffer;
        int length = this.ad.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.ae[i2 - 1];
            } else {
                byteBuffer = this.af;
                if (byteBuffer == null) {
                    byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j2);
            } else {
                com.anythink.expressad.exoplayer.b.f fVar = this.ad[i2];
                fVar.a(byteBuffer);
                ByteBuffer byteBufferF = fVar.f();
                this.ae[i2] = byteBufferF;
                if (byteBufferF.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final v a(v vVar) {
        if (q() && !this.L) {
            this.O = v.a;
            return this.O;
        }
        v vVar2 = this.N;
        if (vVar2 == null) {
            if (!this.f8602z.isEmpty()) {
                vVar2 = this.f8602z.getLast().a;
            } else {
                vVar2 = this.O;
            }
        }
        if (!vVar.equals(vVar2)) {
            if (q()) {
                this.N = vVar;
            } else {
                this.O = this.f8594r.a(vVar);
            }
        }
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(com.anythink.expressad.exoplayer.b.b bVar) {
        if (this.J.equals(bVar)) {
            return;
        }
        this.J = bVar;
        if (this.an) {
            return;
        }
        i();
        this.am = 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(float f2) {
        if (this.ac != f2) {
            this.ac = f2;
            o();
        }
    }

    private static int a(int i2, ByteBuffer byteBuffer) {
        if (i2 == 7 || i2 == 8) {
            return m.a(byteBuffer);
        }
        if (i2 == 5) {
            return com.anythink.expressad.exoplayer.b.a.a();
        }
        if (i2 == 6) {
            return com.anythink.expressad.exoplayer.b.a.a(byteBuffer);
        }
        if (i2 == 14) {
            int iB = com.anythink.expressad.exoplayer.b.a.b(byteBuffer);
            if (iB == -1) {
                return 0;
            }
            return com.anythink.expressad.exoplayer.b.a.a(byteBuffer, iB) * 16;
        }
        throw new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(i2)));
    }

    @TargetApi(21)
    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @TargetApi(21)
    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.R == null) {
            this.R = ByteBuffer.allocate(16);
            this.R.order(ByteOrder.BIG_ENDIAN);
            this.R.putInt(1431633921);
        }
        if (this.S == 0) {
            this.R.putInt(4, i2);
            this.R.putLong(8, j2 * 1000);
            this.R.position(0);
            this.S = i2;
        }
        int iRemaining = this.R.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.R, iRemaining, 1);
            if (iWrite < 0) {
                this.S = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iWrite2 = audioTrack.write(byteBuffer, i2, 1);
        if (iWrite2 < 0) {
            this.S = 0;
            return iWrite2;
        }
        this.S -= iWrite2;
        return iWrite2;
    }

    @TargetApi(21)
    private static void a(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }
}
