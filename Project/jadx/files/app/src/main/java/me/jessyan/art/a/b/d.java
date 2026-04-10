package me.jessyan.art.a.b;

import me.jessyan.art.d.j.a;

/* JADX INFO: compiled from: AppModule_ProvideExtrasFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements dagger.internal.b<me.jessyan.art.d.j.a<String, Object>> {
    private final javax.inject.a<a.InterfaceC0579a> a;

    public d(javax.inject.a<a.InterfaceC0579a> aVar) {
        this.a = aVar;
    }

    public static d a(javax.inject.a<a.InterfaceC0579a> aVar) {
        return new d(aVar);
    }

    public static me.jessyan.art.d.j.a<String, Object> b(javax.inject.a<a.InterfaceC0579a> aVar) {
        return a(aVar.get());
    }

    public static me.jessyan.art.d.j.a<String, Object> a(a.InterfaceC0579a interfaceC0579a) {
        me.jessyan.art.d.j.a<String, Object> aVarA = b.a(interfaceC0579a);
        dagger.internal.d.a(aVarA, "Cannot return null from a non-@Nullable @Provides method");
        return aVarA;
    }

    @Override // javax.inject.a, dagger.a
    public me.jessyan.art.d.j.a<String, Object> get() {
        return b(this.a);
    }
}
