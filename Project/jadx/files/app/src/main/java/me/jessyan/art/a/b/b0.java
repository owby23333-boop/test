package me.jessyan.art.a.b;

import androidx.annotation.Nullable;
import me.jessyan.art.a.b.g;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideRetrofitConfigurationFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements dagger.internal.b<g.b> {
    private final o a;

    public b0(o oVar) {
        this.a = oVar;
    }

    public static b0 a(o oVar) {
        return new b0(oVar);
    }

    @Nullable
    public static g.b b(o oVar) {
        return c(oVar);
    }

    @Nullable
    public static g.b c(o oVar) {
        return oVar.k();
    }

    @Override // javax.inject.a, dagger.a
    @Nullable
    public g.b get() {
        return b(this.a);
    }
}
