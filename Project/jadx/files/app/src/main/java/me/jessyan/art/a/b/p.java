package me.jessyan.art.a.b;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideBaseUrlFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements dagger.internal.b<HttpUrl> {
    private final o a;

    public p(o oVar) {
        this.a = oVar;
    }

    public static p a(o oVar) {
        return new p(oVar);
    }

    public static HttpUrl b(o oVar) {
        return c(oVar);
    }

    public static HttpUrl c(o oVar) {
        HttpUrl httpUrlA = oVar.a();
        dagger.internal.d.a(httpUrlA, "Cannot return null from a non-@Nullable @Provides method");
        return httpUrlA;
    }

    @Override // javax.inject.a, dagger.a
    public HttpUrl get() {
        return b(this.a);
    }
}
