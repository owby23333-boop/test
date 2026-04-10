package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.load.engine.y.a;
import com.bumptech.glide.load.engine.y.h;
import com.bumptech.glide.util.m.a;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements k, h.a, n.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f13537i = Log.isLoggable("Engine", 2);
    private final p a;
    private final m b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.y.h f13538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f13539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v f13540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f13541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f13542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a f13543h;

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    static class a {
        final DecodeJob.e a;
        final Pools.Pool<DecodeJob<?>> b = com.bumptech.glide.util.m.a.a(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO, new C0260a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13544c;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Engine.java */
        class C0260a implements a.d<DecodeJob<?>> {
            C0260a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.m.a.d
            public DecodeJob<?> create() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.a, aVar.b);
            }
        }

        a(DecodeJob.e eVar) {
            this.a = eVar;
        }

        <R> DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, l lVar, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, boolean z4, com.bumptech.glide.load.f fVar, DecodeJob.b<R> bVar) {
            DecodeJob decodeJobAcquire = this.b.acquire();
            com.bumptech.glide.util.k.a(decodeJobAcquire);
            DecodeJob decodeJob = decodeJobAcquire;
            int i4 = this.f13544c;
            this.f13544c = i4 + 1;
            decodeJob.a(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z2, z3, z4, fVar, bVar, i4);
            return decodeJob;
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    private static class c implements DecodeJob.e {
        private final a.InterfaceC0261a a;
        private volatile com.bumptech.glide.load.engine.y.a b;

        c(a.InterfaceC0261a interfaceC0261a) {
            this.a = interfaceC0261a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.e
        public com.bumptech.glide.load.engine.y.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.build();
                    }
                    if (this.b == null) {
                        this.b = new com.bumptech.glide.load.engine.y.b();
                    }
                }
            }
            return this.b;
        }

        @VisibleForTesting
        synchronized void b() {
            if (this.b == null) {
                return;
            }
            this.b.clear();
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    public class d {
        private final j<?> a;
        private final com.bumptech.glide.request.i b;

        d(com.bumptech.glide.request.i iVar, j<?> jVar) {
            this.b = iVar;
            this.a = jVar;
        }

        public void a() {
            synchronized (i.this) {
                this.a.c(this.b);
            }
        }
    }

    public i(com.bumptech.glide.load.engine.y.h hVar, a.InterfaceC0261a interfaceC0261a, com.bumptech.glide.load.engine.z.a aVar, com.bumptech.glide.load.engine.z.a aVar2, com.bumptech.glide.load.engine.z.a aVar3, com.bumptech.glide.load.engine.z.a aVar4, boolean z2) {
        this(hVar, interfaceC0261a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z2);
    }

    @Nullable
    private n<?> b(com.bumptech.glide.load.c cVar) {
        n<?> nVarB = this.f13543h.b(cVar);
        if (nVarB != null) {
            nVarB.b();
        }
        return nVarB;
    }

    private n<?> c(com.bumptech.glide.load.c cVar) {
        n<?> nVarA = a(cVar);
        if (nVarA != null) {
            nVarA.b();
            this.f13543h.a(cVar, nVarA);
        }
        return nVarA;
    }

    public <R> d a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, com.bumptech.glide.load.f fVar, boolean z4, boolean z5, boolean z6, boolean z7, com.bumptech.glide.request.i iVar, Executor executor) {
        long jA = f13537i ? com.bumptech.glide.util.g.a() : 0L;
        l lVarA = this.b.a(obj, cVar, i2, i3, map, cls, cls2, fVar);
        synchronized (this) {
            n<?> nVarA = a(lVarA, z4, jA);
            if (nVarA == null) {
                return a(eVar, obj, cVar, i2, i3, cls, cls2, priority, hVar, map, z2, z3, fVar, z4, z5, z6, z7, iVar, executor, lVarA, jA);
            }
            iVar.a(nVarA, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    @VisibleForTesting
    i(com.bumptech.glide.load.engine.y.h hVar, a.InterfaceC0261a interfaceC0261a, com.bumptech.glide.load.engine.z.a aVar, com.bumptech.glide.load.engine.z.a aVar2, com.bumptech.glide.load.engine.z.a aVar3, com.bumptech.glide.load.engine.z.a aVar4, p pVar, m mVar, com.bumptech.glide.load.engine.a aVar5, b bVar, a aVar6, v vVar, boolean z2) {
        this.f13538c = hVar;
        this.f13541f = new c(interfaceC0261a);
        com.bumptech.glide.load.engine.a aVar7 = aVar5 == null ? new com.bumptech.glide.load.engine.a(z2) : aVar5;
        this.f13543h = aVar7;
        aVar7.a(this);
        this.b = mVar == null ? new m() : mVar;
        this.a = pVar == null ? new p() : pVar;
        this.f13539d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f13542g = aVar6 == null ? new a(this.f13541f) : aVar6;
        this.f13540e = vVar == null ? new v() : vVar;
        hVar.a(this);
    }

    public void b(s<?> sVar) {
        if (sVar instanceof n) {
            ((n) sVar).e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    static class b {
        final com.bumptech.glide.load.engine.z.a a;
        final com.bumptech.glide.load.engine.z.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.engine.z.a f13545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.bumptech.glide.load.engine.z.a f13546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final k f13547e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final n.a f13548f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Pools.Pool<j<?>> f13549g = com.bumptech.glide.util.m.a.a(TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO, new a());

        /* JADX INFO: compiled from: Engine.java */
        class a implements a.d<j<?>> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.m.a.d
            public j<?> create() {
                b bVar = b.this;
                return new j<>(bVar.a, bVar.b, bVar.f13545c, bVar.f13546d, bVar.f13547e, bVar.f13548f, bVar.f13549g);
            }
        }

        b(com.bumptech.glide.load.engine.z.a aVar, com.bumptech.glide.load.engine.z.a aVar2, com.bumptech.glide.load.engine.z.a aVar3, com.bumptech.glide.load.engine.z.a aVar4, k kVar, n.a aVar5) {
            this.a = aVar;
            this.b = aVar2;
            this.f13545c = aVar3;
            this.f13546d = aVar4;
            this.f13547e = kVar;
            this.f13548f = aVar5;
        }

        @VisibleForTesting
        void a() {
            com.bumptech.glide.util.e.a(this.a);
            com.bumptech.glide.util.e.a(this.b);
            com.bumptech.glide.util.e.a(this.f13545c);
            com.bumptech.glide.util.e.a(this.f13546d);
        }

        <R> j<R> a(com.bumptech.glide.load.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
            j jVarAcquire = this.f13549g.acquire();
            com.bumptech.glide.util.k.a(jVarAcquire);
            j jVar = jVarAcquire;
            jVar.a(cVar, z2, z3, z4, z5);
            return jVar;
        }
    }

    @VisibleForTesting
    public void b() {
        this.f13539d.a();
        this.f13541f.b();
        this.f13543h.b();
    }

    private <R> d a(com.bumptech.glide.e eVar, Object obj, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, com.bumptech.glide.load.f fVar, boolean z4, boolean z5, boolean z6, boolean z7, com.bumptech.glide.request.i iVar, Executor executor, l lVar, long j2) {
        j<?> jVarA = this.a.a(lVar, z7);
        if (jVarA != null) {
            jVarA.a(iVar, executor);
            if (f13537i) {
                a("Added to existing load", j2, lVar);
            }
            return new d(iVar, jVarA);
        }
        j<R> jVarA2 = this.f13539d.a(lVar, z4, z5, z6, z7);
        DecodeJob<R> decodeJobA = this.f13542g.a(eVar, obj, lVar, cVar, i2, i3, cls, cls2, priority, hVar, map, z2, z3, z7, fVar, jVarA2);
        this.a.a((com.bumptech.glide.load.c) lVar, (j<?>) jVarA2);
        jVarA2.a(iVar, executor);
        jVarA2.b(decodeJobA);
        if (f13537i) {
            a("Started new load", j2, lVar);
        }
        return new d(iVar, jVarA2);
    }

    @Nullable
    private n<?> a(l lVar, boolean z2, long j2) {
        if (!z2) {
            return null;
        }
        n<?> nVarB = b(lVar);
        if (nVarB != null) {
            if (f13537i) {
                a("Loaded resource from active resources", j2, lVar);
            }
            return nVarB;
        }
        n<?> nVarC = c(lVar);
        if (nVarC == null) {
            return null;
        }
        if (f13537i) {
            a("Loaded resource from cache", j2, lVar);
        }
        return nVarC;
    }

    private static void a(String str, long j2, com.bumptech.glide.load.c cVar) {
        String str2 = str + " in " + com.bumptech.glide.util.g.a(j2) + "ms, key: " + cVar;
    }

    private n<?> a(com.bumptech.glide.load.c cVar) {
        s<?> sVarA = this.f13538c.a(cVar);
        if (sVarA == null) {
            return null;
        }
        if (sVarA instanceof n) {
            return (n) sVarA;
        }
        return new n<>(sVarA, true, true, cVar, this);
    }

    @Override // com.bumptech.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.bumptech.glide.load.c cVar, n<?> nVar) {
        if (nVar != null) {
            if (nVar.d()) {
                this.f13543h.a(cVar, nVar);
            }
            this.a.b(cVar, jVar);
        } else {
            this.a.b(cVar, jVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.k
    public synchronized void a(j<?> jVar, com.bumptech.glide.load.c cVar) {
        this.a.b(cVar, jVar);
    }

    @Override // com.bumptech.glide.load.engine.y.h.a
    public void a(@NonNull s<?> sVar) {
        this.f13540e.a(sVar, true);
    }

    @Override // com.bumptech.glide.load.engine.n.a
    public void a(com.bumptech.glide.load.c cVar, n<?> nVar) {
        this.f13543h.a(cVar);
        if (nVar.d()) {
            this.f13538c.a(cVar, nVar);
        } else {
            this.f13540e.a(nVar, false);
        }
    }

    public void a() {
        this.f13541f.a().clear();
    }
}
