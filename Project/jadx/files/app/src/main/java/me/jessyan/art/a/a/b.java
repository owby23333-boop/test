package me.jessyan.art.a.a;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import io.rx_cache2.internal.RxCache;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import me.jessyan.art.a.a.a;
import me.jessyan.art.a.b.a0;
import me.jessyan.art.a.b.b;
import me.jessyan.art.a.b.b0;
import me.jessyan.art.a.b.c0;
import me.jessyan.art.a.b.e;
import me.jessyan.art.a.b.g;
import me.jessyan.art.a.b.h;
import me.jessyan.art.a.b.i;
import me.jessyan.art.a.b.j;
import me.jessyan.art.a.b.k;
import me.jessyan.art.a.b.l;
import me.jessyan.art.a.b.m;
import me.jessyan.art.a.b.n;
import me.jessyan.art.a.b.o;
import me.jessyan.art.a.b.p;
import me.jessyan.art.a.b.q;
import me.jessyan.art.a.b.r;
import me.jessyan.art.a.b.s;
import me.jessyan.art.a.b.t;
import me.jessyan.art.a.b.u;
import me.jessyan.art.a.b.v;
import me.jessyan.art.a.b.w;
import me.jessyan.art.a.b.x;
import me.jessyan.art.a.b.y;
import me.jessyan.art.a.b.z;
import me.jessyan.art.c.e.c;
import me.jessyan.art.d.d;
import me.jessyan.art.d.g;
import me.jessyan.art.d.j.a;
import me.jessyan.art.http.log.RequestInterceptor;
import me.jessyan.art.mvp.f;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: DaggerAppComponent.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements me.jessyan.art.a.a.a {
    private javax.inject.a<c> A;
    private javax.inject.a<me.jessyan.art.d.j.a<String, Object>> B;
    private javax.inject.a<g> C;
    private javax.inject.a<List<FragmentManager.FragmentLifecycleCallbacks>> D;
    private javax.inject.a<me.jessyan.art.d.a> E;
    private javax.inject.a<Application> a;
    private javax.inject.a<d> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private javax.inject.a<g.b> f21075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private javax.inject.a<Retrofit.Builder> f21076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private javax.inject.a<g.a> f21077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private javax.inject.a<OkHttpClient.Builder> f21078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private javax.inject.a<me.jessyan.art.c.b> f21079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private javax.inject.a<me.jessyan.art.http.log.b> f21080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private javax.inject.a<RequestInterceptor.Level> f21081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private javax.inject.a<RequestInterceptor> f21082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private javax.inject.a<List<Interceptor>> f21083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private javax.inject.a<ExecutorService> f21084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private javax.inject.a<OkHttpClient> f21085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private javax.inject.a<HttpUrl> f21086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private javax.inject.a<b.a> f21087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private javax.inject.a<Gson> f21088p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private javax.inject.a<Retrofit> f21089q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private javax.inject.a<g.c> f21090r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private javax.inject.a<File> f21091s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private javax.inject.a<File> f21092t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private javax.inject.a<RxCache> f21093u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private javax.inject.a<a.InterfaceC0579a> f21094v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private javax.inject.a<f> f21095w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private javax.inject.a<me.jessyan.art.e.b> f21096x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private javax.inject.a<me.jessyan.art.e.c> f21097y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private javax.inject.a<me.jessyan.art.c.e.a> f21098z;

    /* JADX INFO: renamed from: me.jessyan.art.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DaggerAppComponent.java */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class C0578b implements a.InterfaceC0577a {
        private o a;
        private Application b;

        private C0578b() {
        }

        @Override // me.jessyan.art.a.a.a.InterfaceC0577a
        public me.jessyan.art.a.a.a build() {
            if (this.a == null) {
                throw new IllegalStateException(o.class.getCanonicalName() + " must be set");
            }
            if (this.b != null) {
                return new b(this);
            }
            throw new IllegalStateException(Application.class.getCanonicalName() + " must be set");
        }

        @Override // me.jessyan.art.a.a.a.InterfaceC0577a
        public /* bridge */ /* synthetic */ a.InterfaceC0577a a(Application application) {
            a(application);
            return this;
        }

        @Override // me.jessyan.art.a.a.a.InterfaceC0577a
        public /* bridge */ /* synthetic */ a.InterfaceC0577a a(o oVar) {
            a(oVar);
            return this;
        }

        @Override // me.jessyan.art.a.a.a.InterfaceC0577a
        public C0578b a(Application application) {
            dagger.internal.d.a(application);
            this.b = application;
            return this;
        }

        @Override // me.jessyan.art.a.a.a.InterfaceC0577a
        public C0578b a(o oVar) {
            dagger.internal.d.a(oVar);
            this.a = oVar;
            return this;
        }
    }

    private void a(C0578b c0578b) {
        Application unused = c0578b.b;
        this.a = dagger.internal.c.a(c0578b.b);
        this.b = dagger.internal.a.b(me.jessyan.art.a.b.c.a(this.a));
        this.f21075c = dagger.internal.a.b(b0.a(c0578b.a));
        this.f21076d = dagger.internal.a.b(k.a());
        this.f21077e = dagger.internal.a.b(y.a(c0578b.a));
        this.f21078f = dagger.internal.a.b(i.a());
        this.f21079g = dagger.internal.a.b(u.a(c0578b.a));
        this.f21080h = dagger.internal.a.b(t.a(c0578b.a));
        this.f21081i = dagger.internal.a.b(z.a(c0578b.a));
        this.f21082j = dagger.internal.a.b(me.jessyan.art.http.log.c.a(this.f21079g, this.f21080h, this.f21081i));
        this.f21083k = dagger.internal.a.b(x.a(c0578b.a));
        this.f21084l = dagger.internal.a.b(s.a(c0578b.a));
        this.f21085m = dagger.internal.a.b(j.a(this.a, this.f21077e, this.f21078f, this.f21082j, this.f21083k, this.f21079g, this.f21084l));
        this.f21086n = dagger.internal.a.b(p.a(c0578b.a));
        this.f21087o = dagger.internal.a.b(v.a(c0578b.a));
        this.f21088p = dagger.internal.a.b(me.jessyan.art.a.b.f.a(this.a, this.f21087o));
        this.f21089q = dagger.internal.a.b(l.a(this.a, this.f21075c, this.f21076d, this.f21085m, this.f21086n, this.f21088p));
        this.f21090r = dagger.internal.a.b(c0.a(c0578b.a));
        this.f21091s = dagger.internal.a.b(r.a(c0578b.a, this.a));
        this.f21092t = dagger.internal.a.b(m.a(this.f21091s));
        this.f21093u = dagger.internal.a.b(n.a(this.a, this.f21090r, this.f21092t, this.f21088p));
        this.f21094v = dagger.internal.a.b(q.a(c0578b.a, this.a));
        this.f21095w = dagger.internal.a.b(me.jessyan.art.mvp.g.a(this.f21089q, this.f21093u, this.a, this.f21094v));
        this.f21096x = dagger.internal.a.b(a0.a(c0578b.a));
        this.f21097y = dagger.internal.a.b(h.a(this.a, this.f21096x));
        this.f21098z = dagger.internal.a.b(w.a(c0578b.a));
        this.A = dagger.internal.a.b(me.jessyan.art.c.e.d.a(this.f21098z));
        this.B = dagger.internal.a.b(me.jessyan.art.a.b.d.a(this.f21094v));
        this.C = dagger.internal.a.b(me.jessyan.art.d.h.a());
        this.D = dagger.internal.a.b(e.a());
        this.E = dagger.internal.a.b(me.jessyan.art.d.b.a(this.b, this.a, this.B, this.C, this.D));
    }

    public static a.InterfaceC0577a f() {
        return new C0578b();
    }

    @Override // me.jessyan.art.a.a.a
    public me.jessyan.art.e.c b() {
        return this.f21097y.get();
    }

    @Override // me.jessyan.art.a.a.a
    public File c() {
        return this.f21091s.get();
    }

    @Override // me.jessyan.art.a.a.a
    public me.jessyan.art.mvp.d d() {
        return this.f21095w.get();
    }

    @Override // me.jessyan.art.a.a.a
    public me.jessyan.art.d.j.a<String, Object> e() {
        return this.B.get();
    }

    @Override // me.jessyan.art.a.a.a
    public c imageLoader() {
        return this.A.get();
    }

    private b(C0578b c0578b) {
        a(c0578b);
    }

    private me.jessyan.art.base.f.c b(me.jessyan.art.base.f.c cVar) {
        me.jessyan.art.base.f.d.a(cVar, this.E.get());
        return cVar;
    }

    @Override // me.jessyan.art.a.a.a
    public a.InterfaceC0579a a() {
        return this.f21094v.get();
    }

    @Override // me.jessyan.art.a.a.a
    public void a(me.jessyan.art.base.f.c cVar) {
        b(cVar);
    }
}
