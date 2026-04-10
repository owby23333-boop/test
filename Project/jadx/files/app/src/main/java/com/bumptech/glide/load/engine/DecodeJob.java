package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.util.m.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class DecodeJob<R> implements e.a, Runnable, Comparable<DecodeJob<?>>, a.f {
    private com.bumptech.glide.load.c A;
    private Priority B;
    private l C;
    private int D;
    private int E;
    private h F;
    private com.bumptech.glide.load.f G;
    private b<R> H;
    private int I;
    private Stage J;
    private RunReason K;
    private long L;
    private boolean M;
    private Object N;
    private Thread O;
    private com.bumptech.glide.load.c P;
    private com.bumptech.glide.load.c Q;
    private Object R;
    private DataSource S;
    private com.bumptech.glide.load.data.d<?> T;
    private volatile com.bumptech.glide.load.engine.e U;
    private volatile boolean V;
    private volatile boolean W;
    private boolean X;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final e f13470v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Pools.Pool<DecodeJob<?>> f13471w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.bumptech.glide.e f13474z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.f<R> f13467s = new com.bumptech.glide.load.engine.f<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<Throwable> f13468t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final com.bumptech.glide.util.m.c f13469u = com.bumptech.glide.util.m.c.b();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final d<?> f13472x = new d<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final f f13473y = new f();

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f13486c = new int[EncodeStrategy.values().length];

        static {
            try {
                f13486c[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13486c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            b = new int[Stage.values().length];
            try {
                b[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            a = new int[RunReason.values().length];
            try {
                a[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    interface b<R> {
        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);

        void a(s<R> sVar, DataSource dataSource, boolean z2);
    }

    private final class c<Z> implements g.a<Z> {
        private final DataSource a;

        c(DataSource dataSource) {
            this.a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.g.a
        @NonNull
        public s<Z> a(@NonNull s<Z> sVar) {
            return DecodeJob.this.a(this.a, sVar);
        }
    }

    interface e {
        com.bumptech.glide.load.engine.y.a a();
    }

    DecodeJob(e eVar, Pools.Pool<DecodeJob<?>> pool) {
        this.f13470v = eVar;
        this.f13471w = pool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(s<R> sVar, DataSource dataSource, boolean z2) {
        com.bumptech.glide.util.m.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (sVar instanceof o) {
                ((o) sVar).b();
            }
            r rVar = 0;
            if (this.f13472x.b()) {
                sVar = r.b(sVar);
                rVar = sVar;
            }
            a(sVar, dataSource, z2);
            this.J = Stage.ENCODE;
            try {
                if (this.f13472x.b()) {
                    this.f13472x.a(this.f13470v, this.G);
                }
                g();
            } finally {
                if (rVar != 0) {
                    rVar.c();
                }
            }
        } finally {
            com.bumptech.glide.util.m.b.a();
        }
    }

    private void d() {
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.L, "data: " + this.R + ", cache key: " + this.P + ", fetcher: " + this.T);
        }
        s<R> sVarA = null;
        try {
            sVarA = a(this.T, this.R, this.S);
        } catch (GlideException e2) {
            e2.a(this.Q, this.S);
            this.f13468t.add(e2);
        }
        if (sVarA != null) {
            b(sVarA, this.S, this.X);
        } else {
            j();
        }
    }

    private com.bumptech.glide.load.engine.e e() {
        int i2 = a.b[this.J.ordinal()];
        if (i2 == 1) {
            return new t(this.f13467s, this);
        }
        if (i2 == 2) {
            return new com.bumptech.glide.load.engine.b(this.f13467s, this);
        }
        if (i2 == 3) {
            return new w(this.f13467s, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.J);
    }

    private void f() {
        l();
        this.H.a(new GlideException("Failed to load resource", new ArrayList(this.f13468t)));
        h();
    }

    private void g() {
        if (this.f13473y.a()) {
            i();
        }
    }

    private int getPriority() {
        return this.B.ordinal();
    }

    private void h() {
        if (this.f13473y.b()) {
            i();
        }
    }

    private void i() {
        this.f13473y.c();
        this.f13472x.a();
        this.f13467s.a();
        this.V = false;
        this.f13474z = null;
        this.A = null;
        this.G = null;
        this.B = null;
        this.C = null;
        this.H = null;
        this.J = null;
        this.U = null;
        this.O = null;
        this.P = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.L = 0L;
        this.W = false;
        this.N = null;
        this.f13468t.clear();
        this.f13471w.release(this);
    }

    private void j() {
        this.O = Thread.currentThread();
        this.L = com.bumptech.glide.util.g.a();
        boolean zA = false;
        while (!this.W && this.U != null && !(zA = this.U.a())) {
            this.J = a(this.J);
            this.U = e();
            if (this.J == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.J == Stage.FINISHED || this.W) && !zA) {
            f();
        }
    }

    private void k() {
        int i2 = a.a[this.K.ordinal()];
        if (i2 == 1) {
            this.J = a(Stage.INITIALIZE);
            this.U = e();
            j();
        } else if (i2 == 2) {
            j();
        } else {
            if (i2 == 3) {
                d();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.K);
        }
    }

    private void l() {
        Throwable th;
        this.f13469u.a();
        if (!this.V) {
            this.V = true;
            return;
        }
        if (this.f13468t.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f13468t;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, l lVar, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z2, boolean z3, boolean z4, com.bumptech.glide.load.f fVar, b<R> bVar, int i4) {
        this.f13467s.a(eVar, obj, cVar, i2, i3, hVar, cls, cls2, priority, fVar, map, z2, z3, this.f13470v);
        this.f13474z = eVar;
        this.A = cVar;
        this.B = priority;
        this.C = lVar;
        this.D = i2;
        this.E = i3;
        this.F = hVar;
        this.M = z4;
        this.G = fVar;
        this.H = bVar;
        this.I = i4;
        this.K = RunReason.INITIALIZE;
        this.N = obj;
        return this;
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c() {
        this.K = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.H.a((DecodeJob<?>) this);
    }

    public void cancel() {
        this.W = true;
        com.bumptech.glide.load.engine.e eVar = this.U;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.m.b.a("DecodeJob#run(reason=%s, model=%s)", this.K, this.N);
        com.bumptech.glide.load.data.d<?> dVar = this.T;
        try {
            try {
                try {
                    if (this.W) {
                        f();
                        if (dVar != null) {
                            dVar.b();
                        }
                        com.bumptech.glide.util.m.b.a();
                        return;
                    }
                    k();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.bumptech.glide.util.m.b.a();
                } catch (Throwable th) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        String str = "DecodeJob threw unexpectedly, isCancelled: " + this.W + ", stage: " + this.J;
                    }
                    if (this.J != Stage.ENCODE) {
                        this.f13468t.add(th);
                        f();
                    }
                    if (!this.W) {
                        throw th;
                    }
                    throw th;
                }
            } catch (CallbackException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.util.m.b.a();
            throw th2;
        }
    }

    private static class f {
        private boolean a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13488c;

        f() {
        }

        synchronized boolean a(boolean z2) {
            this.a = true;
            return b(z2);
        }

        synchronized boolean b() {
            this.f13488c = true;
            return b(false);
        }

        synchronized void c() {
            this.b = false;
            this.a = false;
            this.f13488c = false;
        }

        private boolean b(boolean z2) {
            return (this.f13488c || z2 || this.b) && this.a;
        }

        synchronized boolean a() {
            this.b = true;
            return b(false);
        }
    }

    private static class d<Z> {
        private com.bumptech.glide.load.c a;
        private com.bumptech.glide.load.h<Z> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private r<Z> f13487c;

        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.h<X> hVar, r<X> rVar) {
            this.a = cVar;
            this.b = hVar;
            this.f13487c = rVar;
        }

        boolean b() {
            return this.f13487c != null;
        }

        void a(e eVar, com.bumptech.glide.load.f fVar) {
            com.bumptech.glide.util.m.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.a, new com.bumptech.glide.load.engine.d(this.b, this.f13487c, fVar));
            } finally {
                this.f13487c.c();
                com.bumptech.glide.util.m.b.a();
            }
        }

        void a() {
            this.a = null;
            this.b = null;
            this.f13487c = null;
        }
    }

    boolean a() {
        Stage stageA = a(Stage.INITIALIZE);
        return stageA == Stage.RESOURCE_CACHE || stageA == Stage.DATA_CACHE;
    }

    @Override // com.bumptech.glide.util.m.a.f
    @NonNull
    public com.bumptech.glide.util.m.c b() {
        return this.f13469u;
    }

    void a(boolean z2) {
        if (this.f13473y.a(z2)) {
            i();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        return priority == 0 ? this.I - decodeJob.I : priority;
    }

    private void a(s<R> sVar, DataSource dataSource, boolean z2) {
        l();
        this.H.a(sVar, dataSource, z2);
    }

    private Stage a(Stage stage) {
        int i2 = a.b[stage.ordinal()];
        if (i2 == 1) {
            if (this.F.a()) {
                return Stage.DATA_CACHE;
            }
            return a(Stage.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.M ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return Stage.FINISHED;
        }
        if (i2 == 5) {
            if (this.F.b()) {
                return Stage.RESOURCE_CACHE;
            }
            return a(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.P = cVar;
        this.R = obj;
        this.T = dVar;
        this.S = dataSource;
        this.Q = cVar2;
        this.X = cVar != this.f13467s.c().get(0);
        if (Thread.currentThread() != this.O) {
            this.K = RunReason.DECODE_DATA;
            this.H.a((DecodeJob<?>) this);
        } else {
            com.bumptech.glide.util.m.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                d();
            } finally {
                com.bumptech.glide.util.m.b.a();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.a(cVar, dataSource, dVar.a());
        this.f13468t.add(glideException);
        if (Thread.currentThread() != this.O) {
            this.K = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.H.a((DecodeJob<?>) this);
        } else {
            j();
        }
    }

    private <Data> s<R> a(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long jA = com.bumptech.glide.util.g.a();
            s<R> sVarA = a(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + sVarA, jA);
            }
            return sVarA;
        } finally {
            dVar.b();
        }
    }

    private <Data> s<R> a(Data data, DataSource dataSource) throws GlideException {
        return a(data, dataSource, this.f13467s.a((Class) data.getClass()));
    }

    @NonNull
    private com.bumptech.glide.load.f a(DataSource dataSource) {
        com.bumptech.glide.load.f fVar = this.G;
        if (Build.VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z2 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f13467s.o();
        Boolean bool = (Boolean) fVar.a(com.bumptech.glide.load.resource.bitmap.l.f13776i);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return fVar;
        }
        com.bumptech.glide.load.f fVar2 = new com.bumptech.glide.load.f();
        fVar2.a(this.G);
        fVar2.a(com.bumptech.glide.load.resource.bitmap.l.f13776i, Boolean.valueOf(z2));
        return fVar2;
    }

    private <Data, ResourceType> s<R> a(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) throws GlideException {
        com.bumptech.glide.load.f fVarA = a(dataSource);
        com.bumptech.glide.load.data.e<Data> eVarB = this.f13474z.g().b(data);
        try {
            return qVar.a(eVarB, fVarA, this.D, this.E, new c(dataSource));
        } finally {
            eVarB.b();
        }
    }

    private void a(String str, long j2) {
        a(str, j2, (String) null);
    }

    private void a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.util.g.a(j2));
        sb.append(", load key: ");
        sb.append(this.C);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.toString();
    }

    @NonNull
    <Z> s<Z> a(DataSource dataSource, @NonNull s<Z> sVar) {
        s<Z> sVarTransform;
        com.bumptech.glide.load.i<Z> iVar;
        EncodeStrategy encodeStrategyA;
        com.bumptech.glide.load.c cVar;
        Class<?> cls = sVar.get().getClass();
        com.bumptech.glide.load.h<Z> hVarA = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.i<Z> iVarB = this.f13467s.b((Class) cls);
            iVar = iVarB;
            sVarTransform = iVarB.transform(this.f13474z, sVar, this.D, this.E);
        } else {
            sVarTransform = sVar;
            iVar = null;
        }
        if (!sVar.equals(sVarTransform)) {
            sVar.recycle();
        }
        if (this.f13467s.b((s<?>) sVarTransform)) {
            hVarA = this.f13467s.a((s) sVarTransform);
            encodeStrategyA = hVarA.a(this.G);
        } else {
            encodeStrategyA = EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.h hVar = hVarA;
        if (!this.F.a(!this.f13467s.a(this.P), dataSource, encodeStrategyA)) {
            return sVarTransform;
        }
        if (hVar != null) {
            int i2 = a.f13486c[encodeStrategyA.ordinal()];
            if (i2 == 1) {
                cVar = new com.bumptech.glide.load.engine.c(this.P, this.A);
            } else if (i2 == 2) {
                cVar = new u(this.f13467s.b(), this.P, this.A, this.D, this.E, iVar, cls, this.G);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyA);
            }
            r rVarB = r.b(sVarTransform);
            this.f13472x.a(cVar, hVar, rVarB);
            return rVarB;
        }
        throw new Registry.NoResultEncoderAvailableException(sVarTransform.get().getClass());
    }
}
