package me.jessyan.art.a.b;

import java.io.File;

/* JADX INFO: compiled from: ClientModule_ProvideRxCacheDirectoryFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements dagger.internal.b<File> {
    private final javax.inject.a<File> a;

    public m(javax.inject.a<File> aVar) {
        this.a = aVar;
    }

    public static m a(javax.inject.a<File> aVar) {
        return new m(aVar);
    }

    public static File b(javax.inject.a<File> aVar) {
        return a(aVar.get());
    }

    public static File a(File file) {
        File fileA = g.a(file);
        dagger.internal.d.a(fileA, "Cannot return null from a non-@Nullable @Provides method");
        return fileA;
    }

    @Override // javax.inject.a, dagger.a
    public File get() {
        return b(this.a);
    }
}
