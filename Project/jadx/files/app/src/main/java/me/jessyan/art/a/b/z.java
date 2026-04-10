package me.jessyan.art.a.b;

import me.jessyan.art.http.log.RequestInterceptor;

/* JADX INFO: compiled from: GlobalConfigModule_ProvidePrintHttpLogLevelFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements dagger.internal.b<RequestInterceptor.Level> {
    private final o a;

    public z(o oVar) {
        this.a = oVar;
    }

    public static z a(o oVar) {
        return new z(oVar);
    }

    public static RequestInterceptor.Level b(o oVar) {
        return c(oVar);
    }

    public static RequestInterceptor.Level c(o oVar) {
        RequestInterceptor.Level levelI = oVar.i();
        dagger.internal.d.a(levelI, "Cannot return null from a non-@Nullable @Provides method");
        return levelI;
    }

    @Override // javax.inject.a, dagger.a
    public RequestInterceptor.Level get() {
        return b(this.a);
    }
}
