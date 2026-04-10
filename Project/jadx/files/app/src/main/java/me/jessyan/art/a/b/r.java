package me.jessyan.art.a.b;

import android.app.Application;
import java.io.File;

/* JADX INFO: compiled from: GlobalConfigModule_ProvideCacheFileFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements dagger.internal.b<File> {
    private final o a;
    private final javax.inject.a<Application> b;

    public r(o oVar, javax.inject.a<Application> aVar) {
        this.a = oVar;
        this.b = aVar;
    }

    public static r a(o oVar, javax.inject.a<Application> aVar) {
        return new r(oVar, aVar);
    }

    public static File b(o oVar, javax.inject.a<Application> aVar) {
        return a(oVar, aVar.get());
    }

    public static File a(o oVar, Application application) {
        File fileB = oVar.b(application);
        dagger.internal.d.a(fileB, "Cannot return null from a non-@Nullable @Provides method");
        return fileB;
    }

    @Override // javax.inject.a, dagger.a
    public File get() {
        return b(this.a, this.b);
    }
}
