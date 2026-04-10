package me.jessyan.art.a.b;

import android.app.Application;
import me.jessyan.art.d.j.a;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideCacheFactoryFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements dagger.internal.b<a.InterfaceC0579a> {
    private final o a;
    private final javax.inject.a<Application> b;

    public q(o oVar, javax.inject.a<Application> aVar) {
        this.a = oVar;
        this.b = aVar;
    }

    public static q a(o oVar, javax.inject.a<Application> aVar) {
        return new q(oVar, aVar);
    }

    public static a.InterfaceC0579a b(o oVar, javax.inject.a<Application> aVar) {
        return a(oVar, aVar.get());
    }

    public static a.InterfaceC0579a a(o oVar, Application application) {
        a.InterfaceC0579a interfaceC0579aA = oVar.a(application);
        dagger.internal.d.a(interfaceC0579aA, "Cannot return null from a non-@Nullable @Provides method");
        return interfaceC0579aA;
    }

    @Override // javax.inject.a, dagger.a
    public a.InterfaceC0579a get() {
        return b(this.a, this.b);
    }
}
