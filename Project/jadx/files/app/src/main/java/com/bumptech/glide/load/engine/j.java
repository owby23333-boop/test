package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.util.m.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: EngineJob.java */
/* JADX INFO: loaded from: classes2.dex */
class j<R> implements DecodeJob.b<R>, a.f {
    private static final c R = new c();
    private final com.bumptech.glide.load.engine.z.a A;
    private final com.bumptech.glide.load.engine.z.a B;
    private final AtomicInteger C;
    private com.bumptech.glide.load.c D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private s<?> I;
    DataSource J;
    private boolean K;
    GlideException L;
    private boolean M;
    n<?> N;
    private DecodeJob<R> O;
    private volatile boolean P;
    private boolean Q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final e f13551s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.bumptech.glide.util.m.c f13552t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final n.a f13553u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Pools.Pool<j<?>> f13554v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final c f13555w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final k f13556x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.a f13557y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.a f13558z;

    /* JADX INFO: compiled from: EngineJob.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final com.bumptech.glide.request.i f13559s;

        a(com.bumptech.glide.request.i iVar) {
            this.f13559s = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f13559s.d()) {
                synchronized (j.this) {
                    if (j.this.f13551s.a(this.f13559s)) {
                        j.this.a(this.f13559s);
                    }
                    j.this.c();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    private class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final com.bumptech.glide.request.i f13561s;

        b(com.bumptech.glide.request.i iVar) {
            this.f13561s = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f13561s.d()) {
                synchronized (j.this) {
                    if (j.this.f13551s.a(this.f13561s)) {
                        j.this.N.b();
                        j.this.b(this.f13561s);
                        j.this.c(this.f13561s);
                    }
                    j.this.c();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    @VisibleForTesting
    static class c {
        c() {
        }

        public <R> n<R> a(s<R> sVar, boolean z2, com.bumptech.glide.load.c cVar, n.a aVar) {
            return new n<>(sVar, z2, true, cVar, aVar);
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class d {
        final com.bumptech.glide.request.i a;
        final Executor b;

        d(com.bumptech.glide.request.i iVar, Executor executor) {
            this.a = iVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class e implements Iterable<d> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final List<d> f13563s;

        e() {
            this(new ArrayList(2));
        }

        private static d c(com.bumptech.glide.request.i iVar) {
            return new d(iVar, com.bumptech.glide.util.e.a());
        }

        void a(com.bumptech.glide.request.i iVar, Executor executor) {
            this.f13563s.add(new d(iVar, executor));
        }

        void b(com.bumptech.glide.request.i iVar) {
            this.f13563s.remove(c(iVar));
        }

        void clear() {
            this.f13563s.clear();
        }

        boolean isEmpty() {
            return this.f13563s.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f13563s.iterator();
        }

        int size() {
            return this.f13563s.size();
        }

        e(List<d> list) {
            this.f13563s = list;
        }

        boolean a(com.bumptech.glide.request.i iVar) {
            return this.f13563s.contains(c(iVar));
        }

        e a() {
            return new e(new ArrayList(this.f13563s));
        }
    }

    j(com.bumptech.glide.load.engine.z.a aVar, com.bumptech.glide.load.engine.z.a aVar2, com.bumptech.glide.load.engine.z.a aVar3, com.bumptech.glide.load.engine.z.a aVar4, k kVar, n.a aVar5, Pools.Pool<j<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, kVar, aVar5, pool, R);
    }

    private com.bumptech.glide.load.engine.z.a g() {
        return this.F ? this.A : this.G ? this.B : this.f13558z;
    }

    private boolean h() {
        return this.M || this.K || this.P;
    }

    private synchronized void i() {
        if (this.D == null) {
            throw new IllegalArgumentException();
        }
        this.f13551s.clear();
        this.D = null;
        this.N = null;
        this.I = null;
        this.M = false;
        this.P = false;
        this.K = false;
        this.Q = false;
        this.O.a(false);
        this.O = null;
        this.L = null;
        this.J = null;
        this.f13554v.release(this);
    }

    @VisibleForTesting
    synchronized j<R> a(com.bumptech.glide.load.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.D = cVar;
        this.E = z2;
        this.F = z3;
        this.G = z4;
        this.H = z5;
        return this;
    }

    public synchronized void b(DecodeJob<R> decodeJob) {
        this.O = decodeJob;
        (decodeJob.a() ? this.f13557y : g()).execute(decodeJob);
    }

    synchronized void c(com.bumptech.glide.request.i iVar) {
        this.f13552t.a();
        this.f13551s.b(iVar);
        if (this.f13551s.isEmpty()) {
            a();
            if ((this.K || this.M) && this.C.get() == 0) {
                i();
            }
        }
    }

    void d() {
        synchronized (this) {
            this.f13552t.a();
            if (this.P) {
                i();
                return;
            }
            if (this.f13551s.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.M) {
                throw new IllegalStateException("Already failed once");
            }
            this.M = true;
            com.bumptech.glide.load.c cVar = this.D;
            e eVarA = this.f13551s.a();
            a(eVarA.size() + 1);
            this.f13556x.a(this, cVar, null);
            for (d dVar : eVarA) {
                dVar.b.execute(new a(dVar.a));
            }
            c();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void e() {
        synchronized (this) {
            this.f13552t.a();
            if (this.P) {
                this.I.recycle();
                i();
                return;
            }
            if (this.f13551s.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.K) {
                throw new IllegalStateException("Already have resource");
            }
            this.N = this.f13555w.a(this.I, this.E, this.D, this.f13553u);
            this.K = true;
            e eVarA = this.f13551s.a();
            a(eVarA.size() + 1);
            this.f13556x.a(this, this.D, this.N);
            for (d dVar : eVarA) {
                dVar.b.execute(new b(dVar.a));
            }
            c();
        }
    }

    boolean f() {
        return this.H;
    }

    @VisibleForTesting
    j(com.bumptech.glide.load.engine.z.a aVar, com.bumptech.glide.load.engine.z.a aVar2, com.bumptech.glide.load.engine.z.a aVar3, com.bumptech.glide.load.engine.z.a aVar4, k kVar, n.a aVar5, Pools.Pool<j<?>> pool, c cVar) {
        this.f13551s = new e();
        this.f13552t = com.bumptech.glide.util.m.c.b();
        this.C = new AtomicInteger();
        this.f13557y = aVar;
        this.f13558z = aVar2;
        this.A = aVar3;
        this.B = aVar4;
        this.f13556x = kVar;
        this.f13553u = aVar5;
        this.f13554v = pool;
        this.f13555w = cVar;
    }

    @GuardedBy("this")
    void b(com.bumptech.glide.request.i iVar) {
        try {
            iVar.a(this.N, this.J, this.Q);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    synchronized void a(com.bumptech.glide.request.i iVar, Executor executor) {
        this.f13552t.a();
        this.f13551s.a(iVar, executor);
        boolean z2 = true;
        if (this.K) {
            a(1);
            executor.execute(new b(iVar));
        } else if (this.M) {
            a(1);
            executor.execute(new a(iVar));
        } else {
            if (this.P) {
                z2 = false;
            }
            com.bumptech.glide.util.k.a(z2, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @Override // com.bumptech.glide.util.m.a.f
    @NonNull
    public com.bumptech.glide.util.m.c b() {
        return this.f13552t;
    }

    void c() {
        n<?> nVar;
        synchronized (this) {
            this.f13552t.a();
            com.bumptech.glide.util.k.a(h(), "Not yet complete!");
            int iDecrementAndGet = this.C.decrementAndGet();
            com.bumptech.glide.util.k.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                nVar = this.N;
                i();
            } else {
                nVar = null;
            }
        }
        if (nVar != null) {
            nVar.e();
        }
    }

    @GuardedBy("this")
    void a(com.bumptech.glide.request.i iVar) {
        try {
            iVar.a(this.L);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void a() {
        if (h()) {
            return;
        }
        this.P = true;
        this.O.cancel();
        this.f13556x.a(this, this.D);
    }

    synchronized void a(int i2) {
        com.bumptech.glide.util.k.a(h(), "Not yet complete!");
        if (this.C.getAndAdd(i2) == 0 && this.N != null) {
            this.N.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void a(s<R> sVar, DataSource dataSource, boolean z2) {
        synchronized (this) {
            this.I = sVar;
            this.J = dataSource;
            this.Q = z2;
        }
        e();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.L = glideException;
        }
        d();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void a(DecodeJob<?> decodeJob) {
        g().execute(decodeJob);
    }
}
