package io.rx_cache2.internal;

import dagger.internal.b;
import io.rx_cache2.internal.encrypt.FileEncryptor;
import io.victoralbertos.jolyglot.JolyglotGenerics;
import java.io.File;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class Disk_Factory implements b<Disk> {
    private final a<File> cacheDirectoryProvider;
    private final a<FileEncryptor> fileEncryptorProvider;
    private final a<JolyglotGenerics> jolyglotProvider;

    public Disk_Factory(a<File> aVar, a<FileEncryptor> aVar2, a<JolyglotGenerics> aVar3) {
        this.cacheDirectoryProvider = aVar;
        this.fileEncryptorProvider = aVar2;
        this.jolyglotProvider = aVar3;
    }

    public static Disk_Factory create(a<File> aVar, a<FileEncryptor> aVar2, a<JolyglotGenerics> aVar3) {
        return new Disk_Factory(aVar, aVar2, aVar3);
    }

    @Override // javax.inject.a, dagger.a
    public Disk get() {
        return new Disk(this.cacheDirectoryProvider.get(), this.fileEncryptorProvider.get(), this.jolyglotProvider.get());
    }
}
