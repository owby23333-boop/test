package me.jessyan.art.c.e;

/* JADX INFO: compiled from: ImageLoader_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements dagger.internal.b<c> {
    private final javax.inject.a<a> a;

    public d(javax.inject.a<a> aVar) {
        this.a = aVar;
    }

    public static d a(javax.inject.a<a> aVar) {
        return new d(aVar);
    }

    public static c b(javax.inject.a<a> aVar) {
        c cVar = new c();
        e.a(cVar, aVar.get());
        return cVar;
    }

    @Override // javax.inject.a, dagger.a
    public c get() {
        return b(this.a);
    }
}
