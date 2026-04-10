package me.jessyan.art.a.b;

import androidx.annotation.Nullable;
import me.jessyan.art.a.b.b;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideGsonConfigurationFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements dagger.internal.b<b.a> {
    private final o a;

    public v(o oVar) {
        this.a = oVar;
    }

    public static v a(o oVar) {
        return new v(oVar);
    }

    @Nullable
    public static b.a b(o oVar) {
        return c(oVar);
    }

    @Nullable
    public static b.a c(o oVar) {
        return oVar.e();
    }

    @Override // javax.inject.a, dagger.a
    @Nullable
    public b.a get() {
        return b(this.a);
    }
}
