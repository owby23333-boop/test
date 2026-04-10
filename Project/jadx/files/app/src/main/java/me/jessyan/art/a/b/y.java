package me.jessyan.art.a.b;

import androidx.annotation.Nullable;
import me.jessyan.art.a.b.g;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideOkhttpConfigurationFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements dagger.internal.b<g.a> {
    private final o a;

    public y(o oVar) {
        this.a = oVar;
    }

    public static y a(o oVar) {
        return new y(oVar);
    }

    @Nullable
    public static g.a b(o oVar) {
        return c(oVar);
    }

    @Nullable
    public static g.a c(o oVar) {
        return oVar.h();
    }

    @Override // javax.inject.a, dagger.a
    @Nullable
    public g.a get() {
        return b(this.a);
    }
}
