package me.jessyan.art.a.b;

import android.app.Application;
import com.google.gson.Gson;
import io.rx_cache2.internal.RxCache;
import java.io.File;
import me.jessyan.art.a.b.g;

/* JADX INFO: compiled from: ClientModule_ProvideRxCacheFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements dagger.internal.b<RxCache> {
    private final javax.inject.a<Application> a;
    private final javax.inject.a<g.c> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final javax.inject.a<File> f21108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final javax.inject.a<Gson> f21109d;

    public n(javax.inject.a<Application> aVar, javax.inject.a<g.c> aVar2, javax.inject.a<File> aVar3, javax.inject.a<Gson> aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.f21108c = aVar3;
        this.f21109d = aVar4;
    }

    public static n a(javax.inject.a<Application> aVar, javax.inject.a<g.c> aVar2, javax.inject.a<File> aVar3, javax.inject.a<Gson> aVar4) {
        return new n(aVar, aVar2, aVar3, aVar4);
    }

    public static RxCache b(javax.inject.a<Application> aVar, javax.inject.a<g.c> aVar2, javax.inject.a<File> aVar3, javax.inject.a<Gson> aVar4) {
        return a(aVar.get(), aVar2.get(), aVar3.get(), aVar4.get());
    }

    public static RxCache a(Application application, g.c cVar, File file, Gson gson) {
        RxCache rxCacheA = g.a(application, cVar, file, gson);
        dagger.internal.d.a(rxCacheA, "Cannot return null from a non-@Nullable @Provides method");
        return rxCacheA;
    }

    @Override // javax.inject.a, dagger.a
    public RxCache get() {
        return b(this.a, this.b, this.f21108c, this.f21109d);
    }
}
