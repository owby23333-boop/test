package me.jessyan.art.a.b;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideExecutorServiceFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements dagger.internal.b<ExecutorService> {
    private final o a;

    public s(o oVar) {
        this.a = oVar;
    }

    public static s a(o oVar) {
        return new s(oVar);
    }

    public static ExecutorService b(o oVar) {
        return c(oVar);
    }

    public static ExecutorService c(o oVar) {
        ExecutorService executorServiceB = oVar.b();
        dagger.internal.d.a(executorServiceB, "Cannot return null from a non-@Nullable @Provides method");
        return executorServiceB;
    }

    @Override // javax.inject.a, dagger.a
    public ExecutorService get() {
        return b(this.a);
    }
}
