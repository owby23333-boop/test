package me.jessyan.art.a.b;

import android.app.Application;

/* JADX INFO: compiled from: AppModule_ProvideAppManagerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements dagger.internal.b<me.jessyan.art.d.d> {
    private final javax.inject.a<Application> a;

    public c(javax.inject.a<Application> aVar) {
        this.a = aVar;
    }

    public static c a(javax.inject.a<Application> aVar) {
        return new c(aVar);
    }

    public static me.jessyan.art.d.d b(javax.inject.a<Application> aVar) {
        return a(aVar.get());
    }

    public static me.jessyan.art.d.d a(Application application) {
        me.jessyan.art.d.d dVarA = b.a(application);
        dagger.internal.d.a(dVarA, "Cannot return null from a non-@Nullable @Provides method");
        return dVarA;
    }

    @Override // javax.inject.a, dagger.a
    public me.jessyan.art.d.d get() {
        return b(this.a);
    }
}
