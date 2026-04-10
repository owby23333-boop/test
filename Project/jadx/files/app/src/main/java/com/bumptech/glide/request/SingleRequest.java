package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleRequest<R> implements e, com.bumptech.glide.request.k.i, i {
    private static final boolean E = Log.isLoggable("GlideRequest", 2);

    @GuardedBy("requestLock")
    private int A;

    @GuardedBy("requestLock")
    private int B;

    @GuardedBy("requestLock")
    private boolean C;

    @Nullable
    private RuntimeException D;
    private int a;

    @Nullable
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.util.m.c f13814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f13815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final g<R> f13816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RequestCoordinator f13817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f13818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.e f13819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private final Object f13820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Class<R> f13821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a<?> f13822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f13823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f13824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Priority f13825n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.bumptech.glide.request.k.j<R> f13826o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private final List<g<R>> f13827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final com.bumptech.glide.request.l.e<? super R> f13828q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Executor f13829r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @GuardedBy("requestLock")
    private s<R> f13830s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @GuardedBy("requestLock")
    private i.d f13831t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @GuardedBy("requestLock")
    private long f13832u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile com.bumptech.glide.load.engine.i f13833v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @GuardedBy("requestLock")
    private Status f13834w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f13835x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f13836y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f13837z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, com.bumptech.glide.e eVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, com.bumptech.glide.request.k.j<R> jVar, @Nullable g<R> gVar, @Nullable List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.i iVar, com.bumptech.glide.request.l.e<? super R> eVar2, Executor executor) {
        this.b = E ? String.valueOf(super.hashCode()) : null;
        this.f13814c = com.bumptech.glide.util.m.c.b();
        this.f13815d = obj;
        this.f13818g = context;
        this.f13819h = eVar;
        this.f13820i = obj2;
        this.f13821j = cls;
        this.f13822k = aVar;
        this.f13823l = i2;
        this.f13824m = i3;
        this.f13825n = priority;
        this.f13826o = jVar;
        this.f13816e = gVar;
        this.f13827p = list;
        this.f13817f = requestCoordinator;
        this.f13833v = iVar;
        this.f13828q = eVar2;
        this.f13829r = executor;
        this.f13834w = Status.PENDING;
        if (this.D == null && eVar.e().a(d.C0254d.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> SingleRequest<R> a(Context context, com.bumptech.glide.e eVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, com.bumptech.glide.request.k.j<R> jVar, g<R> gVar, @Nullable List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.i iVar, com.bumptech.glide.request.l.e<? super R> eVar2, Executor executor) {
        return new SingleRequest<>(context, eVar, obj, obj2, cls, aVar, i2, i3, priority, jVar, gVar, list, requestCoordinator, iVar, eVar2, executor);
    }

    @GuardedBy("requestLock")
    private void e() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean f() {
        RequestCoordinator requestCoordinator = this.f13817f;
        return requestCoordinator == null || requestCoordinator.f(this);
    }

    @GuardedBy("requestLock")
    private boolean g() {
        RequestCoordinator requestCoordinator = this.f13817f;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    @GuardedBy("requestLock")
    private boolean h() {
        RequestCoordinator requestCoordinator = this.f13817f;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private void i() {
        e();
        this.f13814c.a();
        this.f13826o.a((com.bumptech.glide.request.k.i) this);
        i.d dVar = this.f13831t;
        if (dVar != null) {
            dVar.a();
            this.f13831t = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable j() {
        if (this.f13835x == null) {
            this.f13835x = this.f13822k.getErrorPlaceholder();
            if (this.f13835x == null && this.f13822k.getErrorId() > 0) {
                this.f13835x = a(this.f13822k.getErrorId());
            }
        }
        return this.f13835x;
    }

    @GuardedBy("requestLock")
    private Drawable k() {
        if (this.f13837z == null) {
            this.f13837z = this.f13822k.getFallbackDrawable();
            if (this.f13837z == null && this.f13822k.getFallbackId() > 0) {
                this.f13837z = a(this.f13822k.getFallbackId());
            }
        }
        return this.f13837z;
    }

    @GuardedBy("requestLock")
    private Drawable l() {
        if (this.f13836y == null) {
            this.f13836y = this.f13822k.getPlaceholderDrawable();
            if (this.f13836y == null && this.f13822k.getPlaceholderId() > 0) {
                this.f13836y = a(this.f13822k.getPlaceholderId());
            }
        }
        return this.f13836y;
    }

    @GuardedBy("requestLock")
    private boolean m() {
        RequestCoordinator requestCoordinator = this.f13817f;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    @GuardedBy("requestLock")
    private void n() {
        RequestCoordinator requestCoordinator = this.f13817f;
        if (requestCoordinator != null) {
            requestCoordinator.d(this);
        }
    }

    @GuardedBy("requestLock")
    private void o() {
        RequestCoordinator requestCoordinator = this.f13817f;
        if (requestCoordinator != null) {
            requestCoordinator.e(this);
        }
    }

    @GuardedBy("requestLock")
    private void p() {
        if (g()) {
            Drawable drawableK = this.f13820i == null ? k() : null;
            if (drawableK == null) {
                drawableK = j();
            }
            if (drawableK == null) {
                drawableK = l();
            }
            this.f13826o.c(drawableK);
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean b() {
        boolean z2;
        synchronized (this.f13815d) {
            z2 = this.f13834w == Status.CLEARED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public void c() {
        synchronized (this.f13815d) {
            e();
            this.f13814c.a();
            this.f13832u = com.bumptech.glide.util.g.a();
            if (this.f13820i == null) {
                if (l.b(this.f13823l, this.f13824m)) {
                    this.A = this.f13823l;
                    this.B = this.f13824m;
                }
                a(new GlideException("Received null model"), k() == null ? 5 : 3);
                return;
            }
            if (this.f13834w == Status.RUNNING) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (this.f13834w == Status.COMPLETE) {
                a(this.f13830s, DataSource.MEMORY_CACHE, false);
                return;
            }
            a(this.f13820i);
            this.a = com.bumptech.glide.util.m.b.b("GlideRequest");
            this.f13834w = Status.WAITING_FOR_SIZE;
            if (l.b(this.f13823l, this.f13824m)) {
                a(this.f13823l, this.f13824m);
            } else {
                this.f13826o.b(this);
            }
            if ((this.f13834w == Status.RUNNING || this.f13834w == Status.WAITING_FOR_SIZE) && g()) {
                this.f13826o.a(l());
            }
            if (E) {
                a("finished run method in " + com.bumptech.glide.util.g.a(this.f13832u));
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        s<R> sVar;
        synchronized (this.f13815d) {
            e();
            this.f13814c.a();
            if (this.f13834w == Status.CLEARED) {
                return;
            }
            i();
            if (this.f13830s != null) {
                sVar = this.f13830s;
                this.f13830s = null;
            } else {
                sVar = null;
            }
            if (f()) {
                this.f13826o.b(l());
            }
            com.bumptech.glide.util.m.b.a("GlideRequest", this.a);
            this.f13834w = Status.CLEARED;
            if (sVar != null) {
                this.f13833v.b((s<?>) sVar);
            }
        }
    }

    @Override // com.bumptech.glide.request.i
    public Object d() {
        this.f13814c.a();
        return this.f13815d;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z2;
        synchronized (this.f13815d) {
            z2 = this.f13834w == Status.COMPLETE;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z2;
        synchronized (this.f13815d) {
            z2 = this.f13834w == Status.RUNNING || this.f13834w == Status.WAITING_FOR_SIZE;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.f13815d) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.f13815d) {
            obj = this.f13820i;
            cls = this.f13821j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    private void a(Object obj) {
        List<g<R>> list = this.f13827p;
        if (list == null) {
            return;
        }
        for (g<R> gVar : list) {
            if (gVar instanceof c) {
                ((c) gVar).a(obj);
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean a() {
        boolean z2;
        synchronized (this.f13815d) {
            z2 = this.f13834w == Status.COMPLETE;
        }
        return z2;
    }

    @GuardedBy("requestLock")
    private Drawable a(@DrawableRes int i2) {
        return com.bumptech.glide.load.k.e.b.a(this.f13819h, i2, this.f13822k.getTheme() != null ? this.f13822k.getTheme() : this.f13818g.getTheme());
    }

    @Override // com.bumptech.glide.request.k.i
    public void a(int i2, int i3) throws Throwable {
        Object obj;
        this.f13814c.a();
        Object obj2 = this.f13815d;
        synchronized (obj2) {
            try {
                try {
                    if (E) {
                        a("Got onSizeReady in " + com.bumptech.glide.util.g.a(this.f13832u));
                    }
                    if (this.f13834w == Status.WAITING_FOR_SIZE) {
                        this.f13834w = Status.RUNNING;
                        float sizeMultiplier = this.f13822k.getSizeMultiplier();
                        this.A = a(i2, sizeMultiplier);
                        this.B = a(i3, sizeMultiplier);
                        if (E) {
                            a("finished setup for calling load in " + com.bumptech.glide.util.g.a(this.f13832u));
                        }
                        obj = obj2;
                        try {
                            this.f13831t = this.f13833v.a(this.f13819h, this.f13820i, this.f13822k.getSignature(), this.A, this.B, this.f13822k.getResourceClass(), this.f13821j, this.f13825n, this.f13822k.getDiskCacheStrategy(), this.f13822k.getTransformations(), this.f13822k.isTransformationRequired(), this.f13822k.isScaleOnlyOrNoTransform(), this.f13822k.getOptions(), this.f13822k.isMemoryCacheable(), this.f13822k.getUseUnlimitedSourceGeneratorsPool(), this.f13822k.getUseAnimationPool(), this.f13822k.getOnlyRetrieveFromCache(), this, this.f13829r);
                            if (this.f13834w != Status.RUNNING) {
                                this.f13831t = null;
                            }
                            if (E) {
                                a("finished onSizeReady in " + com.bumptech.glide.util.g.a(this.f13832u));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        if (r6 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        r5.f13833v.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        if (r6 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
    
        r5.f13833v.b(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b8, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.bumptech.glide.load.engine.s<?> r6, com.bumptech.glide.load.DataSource r7, boolean r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.a(com.bumptech.glide.load.engine.s, com.bumptech.glide.load.DataSource, boolean):void");
    }

    @GuardedBy("requestLock")
    private void a(s<R> sVar, R r2, DataSource dataSource, boolean z2) {
        boolean zA;
        boolean zM = m();
        this.f13834w = Status.COMPLETE;
        this.f13830s = sVar;
        if (this.f13819h.f() <= 3) {
            String str = "Finished loading " + r2.getClass().getSimpleName() + " from " + dataSource + " for " + this.f13820i + " with size [" + this.A + "x" + this.B + "] in " + com.bumptech.glide.util.g.a(this.f13832u) + " ms";
        }
        boolean z3 = true;
        this.C = true;
        try {
            if (this.f13827p != null) {
                Iterator<g<R>> it = this.f13827p.iterator();
                zA = false;
                while (it.hasNext()) {
                    zA |= it.next().a(r2, this.f13820i, this.f13826o, dataSource, zM);
                }
            } else {
                zA = false;
            }
            if (this.f13816e == null || !this.f13816e.a(r2, this.f13820i, this.f13826o, dataSource, zM)) {
                z3 = false;
            }
            if (!(z3 | zA)) {
                this.f13826o.a(r2, this.f13828q.a(dataSource, zM));
            }
            this.C = false;
            o();
            com.bumptech.glide.util.m.b.a("GlideRequest", this.a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.i
    public void a(GlideException glideException) {
        a(glideException, 5);
    }

    private void a(GlideException glideException, int i2) {
        boolean zA;
        this.f13814c.a();
        synchronized (this.f13815d) {
            glideException.a(this.D);
            int iF = this.f13819h.f();
            if (iF <= i2) {
                String str = "Load failed for " + this.f13820i + " with size [" + this.A + "x" + this.B + "]";
                if (iF <= 4) {
                    glideException.a("Glide");
                }
            }
            this.f13831t = null;
            this.f13834w = Status.FAILED;
            boolean z2 = true;
            this.C = true;
            try {
                if (this.f13827p != null) {
                    Iterator<g<R>> it = this.f13827p.iterator();
                    zA = false;
                    while (it.hasNext()) {
                        zA |= it.next().a(glideException, this.f13820i, this.f13826o, m());
                    }
                } else {
                    zA = false;
                }
                if (this.f13816e == null || !this.f13816e.a(glideException, this.f13820i, this.f13826o, m())) {
                    z2 = false;
                }
                if (!(zA | z2)) {
                    p();
                }
                this.C = false;
                n();
                com.bumptech.glide.util.m.b.a("GlideRequest", this.a);
            } catch (Throwable th) {
                this.C = false;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean a(e eVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        Priority priority;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        Priority priority2;
        int size2;
        if (!(eVar instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f13815d) {
            i2 = this.f13823l;
            i3 = this.f13824m;
            obj = this.f13820i;
            cls = this.f13821j;
            aVar = this.f13822k;
            priority = this.f13825n;
            size = this.f13827p != null ? this.f13827p.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) eVar;
        synchronized (singleRequest.f13815d) {
            i4 = singleRequest.f13823l;
            i5 = singleRequest.f13824m;
            obj2 = singleRequest.f13820i;
            cls2 = singleRequest.f13821j;
            aVar2 = singleRequest.f13822k;
            priority2 = singleRequest.f13825n;
            size2 = singleRequest.f13827p != null ? singleRequest.f13827p.size() : 0;
        }
        return i2 == i4 && i3 == i5 && l.a(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
    }

    private void a(String str) {
        String str2 = str + " this: " + this.b;
    }
}
