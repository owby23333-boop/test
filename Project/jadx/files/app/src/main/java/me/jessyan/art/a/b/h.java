package me.jessyan.art.a.b;

import android.app.Application;

/* JADX INFO: compiled from: ClientModule_ProRxErrorHandlerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements dagger.internal.b<me.jessyan.art.e.c> {
    private final javax.inject.a<Application> a;
    private final javax.inject.a<me.jessyan.art.e.b> b;

    public h(javax.inject.a<Application> aVar, javax.inject.a<me.jessyan.art.e.b> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public static h a(javax.inject.a<Application> aVar, javax.inject.a<me.jessyan.art.e.b> aVar2) {
        return new h(aVar, aVar2);
    }

    public static me.jessyan.art.e.c b(javax.inject.a<Application> aVar, javax.inject.a<me.jessyan.art.e.b> aVar2) {
        return a(aVar.get(), aVar2.get());
    }

    public static me.jessyan.art.e.c a(Application application, me.jessyan.art.e.b bVar) {
        me.jessyan.art.e.c cVarA = g.a(application, bVar);
        dagger.internal.d.a(cVarA, "Cannot return null from a non-@Nullable @Provides method");
        return cVarA;
    }

    @Override // javax.inject.a, dagger.a
    public me.jessyan.art.e.c get() {
        return b(this.a, this.b);
    }
}
