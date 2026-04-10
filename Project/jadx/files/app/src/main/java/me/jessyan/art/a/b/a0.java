package me.jessyan.art.a.b;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideResponseErrorListenerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements dagger.internal.b<me.jessyan.art.e.b> {
    private final o a;

    public a0(o oVar) {
        this.a = oVar;
    }

    public static a0 a(o oVar) {
        return new a0(oVar);
    }

    public static me.jessyan.art.e.b b(o oVar) {
        return c(oVar);
    }

    public static me.jessyan.art.e.b c(o oVar) {
        me.jessyan.art.e.b bVarJ = oVar.j();
        dagger.internal.d.a(bVarJ, "Cannot return null from a non-@Nullable @Provides method");
        return bVarJ;
    }

    @Override // javax.inject.a, dagger.a
    public me.jessyan.art.e.b get() {
        return b(this.a);
    }
}
