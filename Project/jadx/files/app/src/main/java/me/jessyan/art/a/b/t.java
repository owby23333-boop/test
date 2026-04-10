package me.jessyan.art.a.b;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideFormatPrinterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements dagger.internal.b<me.jessyan.art.http.log.b> {
    private final o a;

    public t(o oVar) {
        this.a = oVar;
    }

    public static t a(o oVar) {
        return new t(oVar);
    }

    public static me.jessyan.art.http.log.b b(o oVar) {
        return c(oVar);
    }

    public static me.jessyan.art.http.log.b c(o oVar) {
        me.jessyan.art.http.log.b bVarC = oVar.c();
        dagger.internal.d.a(bVarC, "Cannot return null from a non-@Nullable @Provides method");
        return bVarC;
    }

    @Override // javax.inject.a, dagger.a
    public me.jessyan.art.http.log.b get() {
        return b(this.a);
    }
}
