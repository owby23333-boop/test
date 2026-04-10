package me.jessyan.art.a.b;

import android.app.Application;
import java.util.List;
import java.util.concurrent.ExecutorService;
import me.jessyan.art.a.b.g;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: ClientModule_ProvideClientFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements dagger.internal.b<OkHttpClient> {
    private final javax.inject.a<Application> a;
    private final javax.inject.a<g.a> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final javax.inject.a<OkHttpClient.Builder> f21099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final javax.inject.a<Interceptor> f21100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final javax.inject.a<List<Interceptor>> f21101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final javax.inject.a<me.jessyan.art.c.b> f21102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final javax.inject.a<ExecutorService> f21103g;

    public j(javax.inject.a<Application> aVar, javax.inject.a<g.a> aVar2, javax.inject.a<OkHttpClient.Builder> aVar3, javax.inject.a<Interceptor> aVar4, javax.inject.a<List<Interceptor>> aVar5, javax.inject.a<me.jessyan.art.c.b> aVar6, javax.inject.a<ExecutorService> aVar7) {
        this.a = aVar;
        this.b = aVar2;
        this.f21099c = aVar3;
        this.f21100d = aVar4;
        this.f21101e = aVar5;
        this.f21102f = aVar6;
        this.f21103g = aVar7;
    }

    public static j a(javax.inject.a<Application> aVar, javax.inject.a<g.a> aVar2, javax.inject.a<OkHttpClient.Builder> aVar3, javax.inject.a<Interceptor> aVar4, javax.inject.a<List<Interceptor>> aVar5, javax.inject.a<me.jessyan.art.c.b> aVar6, javax.inject.a<ExecutorService> aVar7) {
        return new j(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static OkHttpClient b(javax.inject.a<Application> aVar, javax.inject.a<g.a> aVar2, javax.inject.a<OkHttpClient.Builder> aVar3, javax.inject.a<Interceptor> aVar4, javax.inject.a<List<Interceptor>> aVar5, javax.inject.a<me.jessyan.art.c.b> aVar6, javax.inject.a<ExecutorService> aVar7) {
        return a(aVar.get(), aVar2.get(), aVar3.get(), aVar4.get(), aVar5.get(), aVar6.get(), aVar7.get());
    }

    public static OkHttpClient a(Application application, g.a aVar, OkHttpClient.Builder builder, Interceptor interceptor, List<Interceptor> list, me.jessyan.art.c.b bVar, ExecutorService executorService) {
        OkHttpClient okHttpClientA = g.a(application, aVar, builder, interceptor, list, bVar, executorService);
        dagger.internal.d.a(okHttpClientA, "Cannot return null from a non-@Nullable @Provides method");
        return okHttpClientA;
    }

    @Override // javax.inject.a, dagger.a
    public OkHttpClient get() {
        return b(this.a, this.b, this.f21099c, this.f21100d, this.f21101e, this.f21102f, this.f21103g);
    }
}
