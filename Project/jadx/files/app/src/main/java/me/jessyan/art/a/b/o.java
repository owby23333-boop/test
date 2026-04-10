package me.jessyan.art.a.b;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import me.jessyan.art.a.b.b;
import me.jessyan.art.a.b.g;
import me.jessyan.art.d.j.a;
import me.jessyan.art.http.log.RequestInterceptor;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: GlobalConfigModule.java */
/* JADX INFO: loaded from: classes.dex */
@Module
public class o {
    private HttpUrl a;
    private me.jessyan.art.c.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private me.jessyan.art.c.e.a f21110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private me.jessyan.art.c.b f21111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Interceptor> f21112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private me.jessyan.art.e.b f21113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private File f21114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g.b f21115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private g.a f21116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g.c f21117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private b.a f21118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RequestInterceptor.Level f21119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private me.jessyan.art.http.log.b f21120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a.InterfaceC0579a f21121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ExecutorService f21122o;

    /* JADX INFO: compiled from: GlobalConfigModule.java */
    /* JADX INFO: loaded from: classes3.dex */
    class a implements a.InterfaceC0579a {
        final /* synthetic */ Application a;

        a(o oVar, Application application) {
            this.a = application;
        }

        @Override // me.jessyan.art.d.j.a.InterfaceC0579a
        @NonNull
        public me.jessyan.art.d.j.a a(me.jessyan.art.d.j.b bVar) {
            int iA = bVar.a();
            return (iA == 3 || iA == 4 || iA == 5) ? new me.jessyan.art.d.j.c(bVar.a(this.a)) : new me.jessyan.art.d.j.d(bVar.a(this.a));
        }
    }

    /* JADX INFO: compiled from: GlobalConfigModule.java */
    public static final class b {
        private HttpUrl a;
        private me.jessyan.art.c.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private me.jessyan.art.c.e.a f21123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private me.jessyan.art.c.b f21124d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<Interceptor> f21125e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private me.jessyan.art.e.b f21126f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private File f21127g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private g.b f21128h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private g.a f21129i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private g.c f21130j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private b.a f21131k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private RequestInterceptor.Level f21132l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private me.jessyan.art.http.log.b f21133m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private a.InterfaceC0579a f21134n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private ExecutorService f21135o;

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
        }

        public b a(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("BaseUrl can not be empty");
            }
            this.a = HttpUrl.parse(str);
            return this;
        }

        public b a(me.jessyan.art.c.e.a aVar) {
            this.f21123c = aVar;
            return this;
        }

        public b a(me.jessyan.art.c.b bVar) {
            this.f21124d = bVar;
            return this;
        }

        public b a(me.jessyan.art.e.b bVar) {
            this.f21126f = bVar;
            return this;
        }

        public b a(g.b bVar) {
            this.f21128h = bVar;
            return this;
        }

        public b a(g.a aVar) {
            this.f21129i = aVar;
            return this;
        }

        public b a(g.c cVar) {
            this.f21130j = cVar;
            return this;
        }

        public b a(b.a aVar) {
            this.f21131k = aVar;
            return this;
        }

        public b a(RequestInterceptor.Level level) {
            me.jessyan.art.f.g.a(level, "The printHttpLogLevel can not be null, use RequestInterceptor.Level.NONE instead.");
            this.f21132l = level;
            return this;
        }

        public o a() {
            return new o(this, null);
        }
    }

    /* synthetic */ o(b bVar, a aVar) {
        this(bVar);
    }

    public static b m() {
        return new b(null);
    }

    @Provides
    @Singleton
    HttpUrl a() {
        HttpUrl httpUrlA;
        me.jessyan.art.c.a aVar = this.b;
        if (aVar != null && (httpUrlA = aVar.a()) != null) {
            return httpUrlA;
        }
        HttpUrl httpUrl = this.a;
        return httpUrl == null ? HttpUrl.parse("https://api.github.com/") : httpUrl;
    }

    @Provides
    @Singleton
    File b(Application application) {
        File file = this.f21114g;
        return file == null ? me.jessyan.art.f.c.a(application) : file;
    }

    @Provides
    @Singleton
    me.jessyan.art.http.log.b c() {
        me.jessyan.art.http.log.b bVar = this.f21120m;
        return bVar == null ? new me.jessyan.art.http.log.a() : bVar;
    }

    @Nullable
    @Provides
    @Singleton
    me.jessyan.art.c.b d() {
        return this.f21111d;
    }

    @Nullable
    @Provides
    @Singleton
    b.a e() {
        return this.f21118k;
    }

    @Nullable
    @Provides
    @Singleton
    me.jessyan.art.c.e.a f() {
        return this.f21110c;
    }

    @Nullable
    @Provides
    @Singleton
    List<Interceptor> g() {
        return this.f21112e;
    }

    @Nullable
    @Provides
    @Singleton
    g.a h() {
        return this.f21116i;
    }

    @Provides
    @Singleton
    RequestInterceptor.Level i() {
        RequestInterceptor.Level level = this.f21119l;
        return level == null ? RequestInterceptor.Level.ALL : level;
    }

    @Provides
    @Singleton
    me.jessyan.art.e.b j() {
        me.jessyan.art.e.b bVar = this.f21113f;
        return bVar == null ? me.jessyan.art.e.b.a : bVar;
    }

    @Nullable
    @Provides
    @Singleton
    g.b k() {
        return this.f21115h;
    }

    @Nullable
    @Provides
    @Singleton
    g.c l() {
        return this.f21117j;
    }

    private o(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.f21110c = bVar.f21123c;
        this.f21111d = bVar.f21124d;
        this.f21112e = bVar.f21125e;
        this.f21113f = bVar.f21126f;
        this.f21114g = bVar.f21127g;
        this.f21115h = bVar.f21128h;
        this.f21116i = bVar.f21129i;
        this.f21117j = bVar.f21130j;
        this.f21118k = bVar.f21131k;
        this.f21119l = bVar.f21132l;
        this.f21120m = bVar.f21133m;
        this.f21121n = bVar.f21134n;
        this.f21122o = bVar.f21135o;
    }

    @Provides
    @Singleton
    ExecutorService b() {
        ExecutorService executorService = this.f21122o;
        return executorService == null ? new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("Art Executor", false)) : executorService;
    }

    @Provides
    @Singleton
    a.InterfaceC0579a a(Application application) {
        a.InterfaceC0579a interfaceC0579a = this.f21121n;
        return interfaceC0579a == null ? new a(this, application) : interfaceC0579a;
    }
}
