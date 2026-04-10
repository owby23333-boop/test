package com.anythink.expressad.exoplayer.a;

import android.net.NetworkInfo;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.a.b;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.b.g;
import com.anythink.expressad.exoplayer.g.f;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.j.d;
import com.anythink.expressad.exoplayer.l.h;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.v;
import com.anythink.expressad.exoplayer.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements g, com.anythink.expressad.exoplayer.d.c, f, t, d.a, h, w.c {
    private final com.anythink.expressad.exoplayer.k.c b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private w f8450e;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.a.b> a = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f8449d = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ae.b f8448c = new ae.b();

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.a.a$a, reason: collision with other inner class name */
    public static class C0180a {
        public static a a(@Nullable w wVar, com.anythink.expressad.exoplayer.k.c cVar) {
            return new a(wVar, cVar);
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private c f8451c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f8452d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f8454f;
        private final ArrayList<c> a = new ArrayList<>();
        private final ae.a b = new ae.a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ae f8453e = ae.a;

        private void i() {
            if (this.a.isEmpty()) {
                return;
            }
            this.f8451c = this.a.get(0);
        }

        @Nullable
        public final c b() {
            return this.f8451c;
        }

        @Nullable
        public final c c() {
            return this.f8452d;
        }

        @Nullable
        public final c d() {
            if (this.a.isEmpty()) {
                return null;
            }
            return this.a.get(r0.size() - 1);
        }

        public final boolean e() {
            return this.f8454f;
        }

        public final void f() {
            i();
        }

        public final void g() {
            this.f8454f = true;
        }

        public final void h() {
            this.f8454f = false;
            i();
        }

        @Nullable
        public final c a() {
            if (this.a.isEmpty() || this.f8453e.a() || this.f8454f) {
                return null;
            }
            return this.a.get(0);
        }

        public final void b(int i2, s.a aVar) {
            c cVar = new c(i2, aVar);
            this.a.remove(cVar);
            if (cVar.equals(this.f8452d)) {
                this.f8452d = this.a.isEmpty() ? null : this.a.get(0);
            }
        }

        public final void c(int i2, s.a aVar) {
            this.f8452d = new c(i2, aVar);
        }

        @Nullable
        public final s.a a(int i2) {
            ae aeVar = this.f8453e;
            if (aeVar == null) {
                return null;
            }
            int iC = aeVar.c();
            s.a aVar = null;
            for (int i3 = 0; i3 < this.a.size(); i3++) {
                c cVar = this.a.get(i3);
                int i4 = cVar.b.a;
                if (i4 < iC && this.f8453e.a(i4, this.b, false).f8469c == i2) {
                    if (aVar != null) {
                        return null;
                    }
                    aVar = cVar.b;
                }
            }
            return aVar;
        }

        public final void a(ae aeVar) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                ArrayList<c> arrayList = this.a;
                arrayList.set(i2, a(arrayList.get(i2), aeVar));
            }
            c cVar = this.f8452d;
            if (cVar != null) {
                this.f8452d = a(cVar, aeVar);
            }
            this.f8453e = aeVar;
            i();
        }

        public final void a(int i2, s.a aVar) {
            this.a.add(new c(i2, aVar));
            if (this.a.size() != 1 || this.f8453e.a()) {
                return;
            }
            i();
        }

        private c a(c cVar, ae aeVar) {
            int iA;
            return (aeVar.a() || this.f8453e.a() || (iA = aeVar.a(this.f8453e.a(cVar.b.a, this.b, true).b)) == -1) ? cVar : new c(aeVar.a(iA, this.b, false).f8469c, cVar.b.a(iA));
        }
    }

    private static final class c {
        public final int a;
        public final s.a b;

        public c(int i2, s.a aVar) {
            this.a = i2;
            this.b = aVar;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.a == cVar.a && this.b.equals(cVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }
    }

    protected a(@Nullable w wVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.f8450e = wVar;
        this.b = (com.anythink.expressad.exoplayer.k.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
    }

    private Set<com.anythink.expressad.exoplayer.a.b> g() {
        return Collections.unmodifiableSet(this.a);
    }

    private b.a h() {
        return a(this.f8449d.b());
    }

    private b.a i() {
        return a(this.f8449d.a());
    }

    private b.a j() {
        return a(this.f8449d.c());
    }

    private b.a k() {
        return a(this.f8449d.d());
    }

    public final void a(com.anythink.expressad.exoplayer.a.b bVar) {
        this.a.add(bVar);
    }

    public final void b(com.anythink.expressad.exoplayer.a.b bVar) {
        this.a.remove(bVar);
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void c(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(aVarI, 1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void d(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a aVarH = h();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(aVarH, 1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void e() {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().g(aVarJ);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void f() {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().h(aVarJ);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onLoadingChanged(boolean z2) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarI, z2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlaybackParametersChanged(v vVar) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, vVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, gVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlayerStateChanged(boolean z2, int i2) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, z2, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPositionDiscontinuity(int i2) {
        this.f8449d.f();
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarI, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onRepeatModeChanged(int i2) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(aVarI, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onSeekProcessed() {
        if (this.f8449d.e()) {
            this.f8449d.h();
            b.a aVarI = i();
            Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b(aVarI);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onShuffleModeEnabledChanged(boolean z2) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, z2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onTimelineChanged(ae aeVar, @Nullable Object obj, int i2) {
        this.f8449d.a(aeVar);
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onTracksChanged(af afVar, com.anythink.expressad.exoplayer.i.g gVar) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, gVar);
        }
    }

    private void a(w wVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.f8450e == null);
        this.f8450e = (w) com.anythink.expressad.exoplayer.k.a.a(wVar);
    }

    public final void b() {
        for (c cVar : new ArrayList(this.f8449d.a)) {
            b(cVar.a, cVar.b);
        }
    }

    public final void a() {
        if (this.f8449d.e()) {
            return;
        }
        b.a aVarI = i();
        this.f8449d.g();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void c(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar) {
        d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void d() {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(aVarJ);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void b(String str, long j2, long j3) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 1, str);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void c(int i2, s.a aVar) {
        this.f8449d.c(i2, aVar);
        b.a aVarD = d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(aVarD);
        }
    }

    private b.a d(int i2, @Nullable s.a aVar) {
        long jA;
        long j2;
        com.anythink.expressad.exoplayer.k.a.a(this.f8450e);
        long jA2 = this.b.a();
        ae aeVarF = this.f8450e.F();
        long jT = 0;
        if (i2 == this.f8450e.p()) {
            if (aVar != null && aVar.a()) {
                if (this.f8450e.z() == aVar.b && this.f8450e.A() == aVar.f9418c) {
                    jT = this.f8450e.t();
                }
                j2 = jT;
            } else {
                jA = this.f8450e.B();
                j2 = jA;
            }
        } else {
            if (i2 < aeVarF.b() && (aVar == null || !aVar.a())) {
                jA = com.anythink.expressad.exoplayer.b.a(aeVarF.a(i2, this.f8448c, false).f8478h);
                j2 = jA;
            }
            j2 = jT;
        }
        return new b.a(jA2, aeVarF, i2, aVar, j2, this.f8450e.t(), this.f8450e.u() - this.f8450e.B());
    }

    private void a(int i2, int i3) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, i2, i3);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void b(m mVar) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 1, mVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.d.a
    public final void c() {
        a(this.f8449d.d());
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void a(@Nullable NetworkInfo networkInfo) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, networkInfo);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a aVarH = h();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(aVarH, 2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.g.f
    public final void a(com.anythink.expressad.exoplayer.g.a aVar) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarI, aVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i2, s.a aVar) {
        this.f8449d.b(i2, aVar);
        b.a aVarD = d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(aVarD);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void a(int i2) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(aVarJ, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar) {
        d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void a(int i2, long j2, long j3) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, i2, j2, j3);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i2, @Nullable s.a aVar, t.c cVar) {
        b.a aVarD = d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarD, cVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
        b.a aVarI = i();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(aVarI, 2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(String str, long j2, long j3) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 2, str);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(m mVar) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, 2, mVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(int i2, long j2) {
        b.a aVarH = h();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().g(aVarH, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(int i2, int i3, int i4, float f2) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarJ, i2, i3);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(Surface surface) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, surface);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i2, s.a aVar) {
        this.f8449d.a(i2, aVar);
        b.a aVarD = d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(aVarD);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar) {
        d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z2) {
        b.a aVarD = d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarD, iOException);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i2, @Nullable s.a aVar, t.c cVar) {
        b.a aVarD = d(i2, aVar);
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(aVarD, cVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void a(Exception exc) {
        b.a aVarJ = j();
        Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(aVarJ, exc);
        }
    }

    private b.a a(@Nullable c cVar) {
        if (cVar == null) {
            int iP = ((w) com.anythink.expressad.exoplayer.k.a.a(this.f8450e)).p();
            return d(iP, this.f8449d.a(iP));
        }
        return d(cVar.a, cVar.b);
    }
}
