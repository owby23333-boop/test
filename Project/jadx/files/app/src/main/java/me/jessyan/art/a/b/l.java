package me.jessyan.art.a.b;

import android.app.Application;
import com.google.gson.Gson;
import me.jessyan.art.a.b.g;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: ClientModule_ProvideRetrofitFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements dagger.internal.b<Retrofit> {
    private final javax.inject.a<Application> a;
    private final javax.inject.a<g.b> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final javax.inject.a<Retrofit.Builder> f21104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final javax.inject.a<OkHttpClient> f21105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final javax.inject.a<HttpUrl> f21106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final javax.inject.a<Gson> f21107f;

    public l(javax.inject.a<Application> aVar, javax.inject.a<g.b> aVar2, javax.inject.a<Retrofit.Builder> aVar3, javax.inject.a<OkHttpClient> aVar4, javax.inject.a<HttpUrl> aVar5, javax.inject.a<Gson> aVar6) {
        this.a = aVar;
        this.b = aVar2;
        this.f21104c = aVar3;
        this.f21105d = aVar4;
        this.f21106e = aVar5;
        this.f21107f = aVar6;
    }

    public static l a(javax.inject.a<Application> aVar, javax.inject.a<g.b> aVar2, javax.inject.a<Retrofit.Builder> aVar3, javax.inject.a<OkHttpClient> aVar4, javax.inject.a<HttpUrl> aVar5, javax.inject.a<Gson> aVar6) {
        return new l(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static Retrofit b(javax.inject.a<Application> aVar, javax.inject.a<g.b> aVar2, javax.inject.a<Retrofit.Builder> aVar3, javax.inject.a<OkHttpClient> aVar4, javax.inject.a<HttpUrl> aVar5, javax.inject.a<Gson> aVar6) {
        return a(aVar.get(), aVar2.get(), aVar3.get(), aVar4.get(), aVar5.get(), aVar6.get());
    }

    public static Retrofit a(Application application, g.b bVar, Retrofit.Builder builder, OkHttpClient okHttpClient, HttpUrl httpUrl, Gson gson) {
        Retrofit retrofitA = g.a(application, bVar, builder, okHttpClient, httpUrl, gson);
        dagger.internal.d.a(retrofitA, "Cannot return null from a non-@Nullable @Provides method");
        return retrofitA;
    }

    @Override // javax.inject.a, dagger.a
    public Retrofit get() {
        return b(this.a, this.b, this.f21104c, this.f21105d, this.f21106e, this.f21107f);
    }
}
