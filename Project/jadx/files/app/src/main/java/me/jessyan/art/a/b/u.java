package me.jessyan.art.a.b;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideGlobalHttpHandlerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements dagger.internal.b<me.jessyan.art.c.b> {
    private final o a;

    public u(o oVar) {
        this.a = oVar;
    }

    public static u a(o oVar) {
        return new u(oVar);
    }

    @Nullable
    public static me.jessyan.art.c.b b(o oVar) {
        return c(oVar);
    }

    @Nullable
    public static me.jessyan.art.c.b c(o oVar) {
        return oVar.d();
    }

    @Override // javax.inject.a, dagger.a
    @Nullable
    public me.jessyan.art.c.b get() {
        return b(this.a);
    }
}
