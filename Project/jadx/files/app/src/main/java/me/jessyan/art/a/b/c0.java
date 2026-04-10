package me.jessyan.art.a.b;

import androidx.annotation.Nullable;
import me.jessyan.art.a.b.g;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideRxCacheConfigurationFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements dagger.internal.b<g.c> {
    private final o a;

    public c0(o oVar) {
        this.a = oVar;
    }

    public static c0 a(o oVar) {
        return new c0(oVar);
    }

    @Nullable
    public static g.c b(o oVar) {
        return c(oVar);
    }

    @Nullable
    public static g.c c(o oVar) {
        return oVar.l();
    }

    @Override // javax.inject.a, dagger.a
    @Nullable
    public g.c get() {
        return b(this.a);
    }
}
