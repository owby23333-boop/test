package me.jessyan.art.a.b;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideImageLoaderStrategyFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements dagger.internal.b<me.jessyan.art.c.e.a> {
    private final o a;

    public w(o oVar) {
        this.a = oVar;
    }

    public static w a(o oVar) {
        return new w(oVar);
    }

    @Nullable
    public static me.jessyan.art.c.e.a b(o oVar) {
        return c(oVar);
    }

    @Nullable
    public static me.jessyan.art.c.e.a c(o oVar) {
        return oVar.f();
    }

    @Override // javax.inject.a, dagger.a
    @Nullable
    public me.jessyan.art.c.e.a get() {
        return b(this.a);
    }
}
