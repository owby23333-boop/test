package me.jessyan.art.a.b;

import androidx.annotation.Nullable;
import java.util.List;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideInterceptorsFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements dagger.internal.b<List<Interceptor>> {
    private final o a;

    public x(o oVar) {
        this.a = oVar;
    }

    public static x a(o oVar) {
        return new x(oVar);
    }

    @Nullable
    public static List<Interceptor> b(o oVar) {
        return c(oVar);
    }

    @Nullable
    public static List<Interceptor> c(o oVar) {
        return oVar.g();
    }

    @Override // javax.inject.a, dagger.a
    @Nullable
    public List<Interceptor> get() {
        return b(this.a);
    }
}
