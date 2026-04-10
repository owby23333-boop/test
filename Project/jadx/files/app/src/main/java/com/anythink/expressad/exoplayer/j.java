package com.anythink.expressad.exoplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.w;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
final class j implements h {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f9570w = "ExoPlayerImpl";
    private final Handler A;
    private final k B;
    private final Handler C;
    private final CopyOnWriteArraySet<w.c> D;
    private final ae.b E;
    private final ae.a F;
    private final ArrayDeque<a> G;
    private boolean H;
    private int I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private v N;

    @Nullable
    private g O;
    private u P;
    private int Q;
    private int R;
    private long S;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final y[] f9571x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.i.h f9572y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.i.i f9573z;

    private static final class a {
        private final u a;
        private final Set<w.c> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.i.h f9574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f9575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f9576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f9577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f9578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f9579h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f9580i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f9581j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f9582k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final boolean f9583l;

        public a(u uVar, u uVar2, Set<w.c> set, com.anythink.expressad.exoplayer.i.h hVar, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5) {
            this.a = uVar;
            this.b = set;
            this.f9574c = hVar;
            this.f9575d = z2;
            this.f9576e = i2;
            this.f9577f = i3;
            this.f9578g = z3;
            this.f9579h = z4;
            this.f9580i = z5 || uVar2.f10063f != uVar.f10063f;
            this.f9581j = (uVar2.a == uVar.a && uVar2.b == uVar.b) ? false : true;
            this.f9582k = uVar2.f10064g != uVar.f10064g;
            this.f9583l = uVar2.f10066i != uVar.f10066i;
        }

        public final void a() {
            if (this.f9581j || this.f9577f == 0) {
                for (w.c cVar : this.b) {
                    u uVar = this.a;
                    cVar.onTimelineChanged(uVar.a, uVar.b, this.f9577f);
                }
            }
            if (this.f9575d) {
                Iterator<w.c> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().onPositionDiscontinuity(this.f9576e);
                }
            }
            if (this.f9583l) {
                this.f9574c.a(this.a.f10066i.f9569d);
                for (w.c cVar2 : this.b) {
                    u uVar2 = this.a;
                    cVar2.onTracksChanged(uVar2.f10065h, uVar2.f10066i.f9568c);
                }
            }
            if (this.f9582k) {
                Iterator<w.c> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    it2.next().onLoadingChanged(this.a.f10064g);
                }
            }
            if (this.f9580i) {
                Iterator<w.c> it3 = this.b.iterator();
                while (it3.hasNext()) {
                    it3.next().onPlayerStateChanged(this.f9579h, this.a.f10063f);
                }
            }
            if (this.f9578g) {
                Iterator<w.c> it4 = this.b.iterator();
                while (it4.hasNext()) {
                    it4.next().onSeekProcessed();
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public j(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, p pVar, com.anythink.expressad.exoplayer.k.c cVar) {
        String str = "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.8.4] [" + af.f9817e + "]";
        com.anythink.expressad.exoplayer.k.a.b(yVarArr.length > 0);
        this.f9571x = (y[]) com.anythink.expressad.exoplayer.k.a.a(yVarArr);
        this.f9572y = (com.anythink.expressad.exoplayer.i.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.H = false;
        this.I = 0;
        this.J = false;
        this.D = new CopyOnWriteArraySet<>();
        this.f9573z = new com.anythink.expressad.exoplayer.i.i(new aa[yVarArr.length], new com.anythink.expressad.exoplayer.i.f[yVarArr.length], null);
        this.E = new ae.b();
        this.F = new ae.a();
        this.N = v.a;
        this.A = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.anythink.expressad.exoplayer.j.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                j.this.a(message);
            }
        };
        this.P = new u(ae.a, 0L, com.anythink.expressad.exoplayer.h.af.a, this.f9573z);
        this.G = new ArrayDeque<>();
        this.B = new k(yVarArr, hVar, this.f9573z, pVar, this.H, this.I, this.J, this.A, this, cVar);
        this.C = new Handler(this.B.b());
    }

    private boolean H() {
        return this.P.a.a() || this.K > 0;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int A() {
        if (y()) {
            return this.P.f10060c.f9418c;
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long B() {
        if (!y()) {
            return t();
        }
        u uVar = this.P;
        uVar.a.a(uVar.f10060c.a, this.F, false);
        return this.F.a() + b.a(this.P.f10062e);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int C() {
        return this.f9571x.length;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.h.af D() {
        return this.P.f10065h;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.i.g E() {
        return this.P.f10066i.f9568c;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final ae F() {
        return this.P.a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final Object G() {
        return this.P.b;
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final Looper a() {
        return this.B.b();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.g b() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(w.c cVar) {
        this.D.remove(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.e c() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void c(boolean z2) {
        if (z2) {
            this.O = null;
        }
        u uVarA = a(z2, z2, 1);
        this.K++;
        this.B.c(z2);
        a(uVarA, false, 4, 1, false, false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int d() {
        return this.P.f10063f;
    }

    @Override // com.anythink.expressad.exoplayer.w
    @Nullable
    public final g e() {
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean f() {
        return this.H;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int g() {
        return this.I;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean h() {
        return this.J;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean i() {
        return this.P.f10064g;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void j() {
        b(p());
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final v k() {
        return this.N;
    }

    @Override // com.anythink.expressad.exoplayer.w
    @Nullable
    public final Object l() {
        int iP = p();
        if (iP > this.P.a.b()) {
            return null;
        }
        return this.P.a.a(iP, this.E, true).a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void m() {
        c(false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void n() {
        String str = "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.8.4] [" + af.f9817e + "] [" + l.a() + "]";
        this.B.a();
        this.A.removeCallbacksAndMessages(null);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int o() {
        return H() ? this.R : this.P.f10060c.a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int p() {
        if (H()) {
            return this.Q;
        }
        u uVar = this.P;
        return uVar.a.a(uVar.f10060c.a, this.F, false).f8469c;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int q() {
        ae aeVar = this.P.a;
        if (aeVar.a()) {
            return -1;
        }
        return aeVar.a(p(), this.I, this.J);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int r() {
        ae aeVar = this.P.a;
        if (aeVar.a()) {
            return -1;
        }
        return aeVar.b(p(), this.I, this.J);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long s() {
        ae aeVar = this.P.a;
        if (aeVar.a()) {
            return b.b;
        }
        if (!y()) {
            return b.a(aeVar.a(p(), this.E, false).f8479i);
        }
        s.a aVar = this.P.f10060c;
        aeVar.a(aVar.a, this.F, false);
        return b.a(this.F.c(aVar.b, aVar.f9418c));
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long t() {
        return H() ? this.S : b(this.P.f10067j);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long u() {
        return H() ? this.S : b(this.P.f10068k);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int v() {
        long jU = u();
        long jS = s();
        if (jU == b.b || jS == b.b) {
            return 0;
        }
        if (jS == 0) {
            return 100;
        }
        return af.a((int) ((jU * 100) / jS), 0, 100);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean w() {
        ae aeVar = this.P.a;
        return !aeVar.a() && aeVar.a(p(), this.E, false).f8475e;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean x() {
        ae aeVar = this.P.a;
        return !aeVar.a() && aeVar.a(p(), this.E, false).f8474d;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean y() {
        return !H() && this.P.f10060c.a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int z() {
        if (y()) {
            return this.P.f10060c.b;
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(w.c cVar) {
        this.D.add(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(boolean z2) {
        if (this.J != z2) {
            this.J = z2;
            this.B.b(z2);
            Iterator<w.c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z2);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar) {
        a(sVar, true, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z2, boolean z3) {
        this.O = null;
        u uVarA = a(z2, z3, 2);
        this.L = true;
        this.K++;
        this.B.a(sVar, z2, z3);
        a(uVarA, false, 4, 1, false, false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int c(int i2) {
        return this.f9571x[i2].a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(int i2) {
        a(i2, b.b);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void b(h.c... cVarArr) {
        ArrayList<x> arrayList = new ArrayList();
        for (h.c cVar : cVarArr) {
            arrayList.add(a(cVar.a).a(cVar.b).a(cVar.f9161c).i());
        }
        boolean z2 = false;
        for (x xVar : arrayList) {
            boolean z3 = z2;
            boolean z4 = true;
            while (z4) {
                try {
                    xVar.k();
                    z4 = false;
                } catch (InterruptedException unused) {
                    z3 = true;
                } catch (TimeoutException e2) {
                    com.anythink.expressad.foundation.h.o.d(f9570w, e2.getMessage());
                }
            }
            z2 = z3;
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(boolean z2) {
        if (this.H != z2) {
            this.H = z2;
            this.B.a(z2);
            a(this.P, false, 4, 1, false, true);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i2) {
        if (this.I != i2) {
            this.I = i2;
            this.B.a(i2);
            Iterator<w.c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i2);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(long j2) {
        a(p(), j2);
    }

    private long b(long j2) {
        long jA = b.a(j2);
        if (this.P.f10060c.a()) {
            return jA;
        }
        u uVar = this.P;
        uVar.a.a(uVar.f10060c.a, this.F, false);
        return jA + this.F.a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i2, long j2) {
        long jB;
        ae aeVar = this.P.a;
        if (i2 >= 0 && (aeVar.a() || i2 < aeVar.b())) {
            this.M = true;
            this.K++;
            if (y()) {
                this.A.obtainMessage(0, 1, -1, this.P).sendToTarget();
                return;
            }
            this.Q = i2;
            if (aeVar.a()) {
                this.S = j2 == b.b ? 0L : j2;
                this.R = 0;
            } else {
                if (j2 == b.b) {
                    jB = aeVar.a(i2, this.E, false).f8478h;
                } else {
                    jB = b.b(j2);
                }
                long j3 = jB;
                Pair<Integer, Long> pairA = aeVar.a(this.E, this.F, i2, j3);
                this.S = b.a(j3);
                this.R = ((Integer) pairA.first).intValue();
            }
            this.B.a(aeVar, i2, b.b(j2));
            Iterator<w.c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onPositionDiscontinuity(1);
            }
            return;
        }
        throw new o(aeVar, i2, j2);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(@Nullable v vVar) {
        if (vVar == null) {
            vVar = v.a;
        }
        this.B.b(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(@Nullable ac acVar) {
        if (acVar == null) {
            acVar = ac.f8462e;
        }
        this.B.a(acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(h.c... cVarArr) {
        for (h.c cVar : cVarArr) {
            a(cVar.a).a(cVar.b).a(cVar.f9161c).i();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final x a(x.b bVar) {
        return new x(this.B, bVar, this.P.a, p(), this.C);
    }

    final void a(Message message) {
        int i2 = message.what;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    g gVar = (g) message.obj;
                    this.O = gVar;
                    Iterator<w.c> it = this.D.iterator();
                    while (it.hasNext()) {
                        it.next().onPlayerError(gVar);
                    }
                    return;
                }
                throw new IllegalStateException();
            }
            v vVar = (v) message.obj;
            if (this.N.equals(vVar)) {
                return;
            }
            this.N = vVar;
            Iterator<w.c> it2 = this.D.iterator();
            while (it2.hasNext()) {
                it2.next().onPlaybackParametersChanged(vVar);
            }
            return;
        }
        u uVar = (u) message.obj;
        int i3 = message.arg1;
        boolean z2 = message.arg2 != -1;
        int i4 = message.arg2;
        this.K -= i3;
        if (this.K == 0) {
            u uVarA = uVar.f10061d == b.b ? uVar.a(uVar.f10060c, 0L, uVar.f10062e) : uVar;
            if ((!this.P.a.a() || this.L) && uVarA.a.a()) {
                this.R = 0;
                this.Q = 0;
                this.S = 0L;
            }
            int i5 = this.L ? 0 : 2;
            boolean z3 = this.M;
            this.L = false;
            this.M = false;
            a(uVarA, z2, i4, i5, z3, false);
        }
    }

    private void a(u uVar, int i2, boolean z2, int i3) {
        this.K -= i2;
        if (this.K == 0) {
            if (uVar.f10061d == b.b) {
                uVar = uVar.a(uVar.f10060c, 0L, uVar.f10062e);
            }
            u uVar2 = uVar;
            if ((!this.P.a.a() || this.L) && uVar2.a.a()) {
                this.R = 0;
                this.Q = 0;
                this.S = 0L;
            }
            int i4 = this.L ? 0 : 2;
            boolean z3 = this.M;
            this.L = false;
            this.M = false;
            a(uVar2, z2, i3, i4, z3, false);
        }
    }

    private u a(boolean z2, boolean z3, int i2) {
        if (z2) {
            this.Q = 0;
            this.R = 0;
            this.S = 0L;
        } else {
            this.Q = p();
            this.R = o();
            this.S = t();
        }
        ae aeVar = z3 ? ae.a : this.P.a;
        Object obj = z3 ? null : this.P.b;
        u uVar = this.P;
        return new u(aeVar, obj, uVar.f10060c, uVar.f10061d, uVar.f10062e, i2, false, z3 ? com.anythink.expressad.exoplayer.h.af.a : uVar.f10065h, z3 ? this.f9573z : this.P.f10066i);
    }

    private void a(u uVar, boolean z2, int i2, int i3, boolean z3, boolean z4) {
        boolean z5 = !this.G.isEmpty();
        this.G.addLast(new a(uVar, this.P, this.D, this.f9572y, z2, i2, i3, z3, this.H, z4));
        this.P = uVar;
        if (z5) {
            return;
        }
        while (!this.G.isEmpty()) {
            this.G.peekFirst().a();
            this.G.removeFirst();
        }
    }
}
