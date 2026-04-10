package me.jessyan.art.mvp;

import android.app.Application;
import io.rx_cache2.internal.RxCache;
import me.jessyan.art.d.j.a;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: RepositoryManager_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements dagger.internal.b<f> {
    private final javax.inject.a<Retrofit> a;
    private final javax.inject.a<RxCache> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final javax.inject.a<Application> f21213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final javax.inject.a<a.InterfaceC0579a> f21214d;

    public g(javax.inject.a<Retrofit> aVar, javax.inject.a<RxCache> aVar2, javax.inject.a<Application> aVar3, javax.inject.a<a.InterfaceC0579a> aVar4) {
        this.a = aVar;
        this.b = aVar2;
        this.f21213c = aVar3;
        this.f21214d = aVar4;
    }

    public static g a(javax.inject.a<Retrofit> aVar, javax.inject.a<RxCache> aVar2, javax.inject.a<Application> aVar3, javax.inject.a<a.InterfaceC0579a> aVar4) {
        return new g(aVar, aVar2, aVar3, aVar4);
    }

    public static f b(javax.inject.a<Retrofit> aVar, javax.inject.a<RxCache> aVar2, javax.inject.a<Application> aVar3, javax.inject.a<a.InterfaceC0579a> aVar4) {
        f fVar = new f();
        h.a(fVar, (dagger.a<Retrofit>) dagger.internal.a.a(aVar));
        h.b(fVar, dagger.internal.a.a(aVar2));
        h.a(fVar, aVar3.get());
        h.a(fVar, aVar4.get());
        return fVar;
    }

    @Override // javax.inject.a, dagger.a
    public f get() {
        return b(this.a, this.b, this.f21213c, this.f21214d);
    }
}
