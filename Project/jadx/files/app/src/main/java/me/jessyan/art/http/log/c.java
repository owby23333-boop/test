package me.jessyan.art.http.log;

import me.jessyan.art.http.log.RequestInterceptor;

/* JADX INFO: compiled from: RequestInterceptor_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements dagger.internal.b<RequestInterceptor> {
    private final javax.inject.a<me.jessyan.art.c.b> a;
    private final javax.inject.a<b> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final javax.inject.a<RequestInterceptor.Level> f21194c;

    public c(javax.inject.a<me.jessyan.art.c.b> aVar, javax.inject.a<b> aVar2, javax.inject.a<RequestInterceptor.Level> aVar3) {
        this.a = aVar;
        this.b = aVar2;
        this.f21194c = aVar3;
    }

    public static c a(javax.inject.a<me.jessyan.art.c.b> aVar, javax.inject.a<b> aVar2, javax.inject.a<RequestInterceptor.Level> aVar3) {
        return new c(aVar, aVar2, aVar3);
    }

    public static RequestInterceptor b(javax.inject.a<me.jessyan.art.c.b> aVar, javax.inject.a<b> aVar2, javax.inject.a<RequestInterceptor.Level> aVar3) {
        RequestInterceptor requestInterceptor = new RequestInterceptor();
        d.a(requestInterceptor, aVar.get());
        d.a(requestInterceptor, aVar2.get());
        d.a(requestInterceptor, aVar3.get());
        return requestInterceptor;
    }

    @Override // javax.inject.a, dagger.a
    public RequestInterceptor get() {
        return b(this.a, this.b, this.f21194c);
    }
}
