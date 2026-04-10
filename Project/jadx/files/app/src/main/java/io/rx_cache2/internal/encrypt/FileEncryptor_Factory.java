package io.rx_cache2.internal.encrypt;

import dagger.internal.b;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class FileEncryptor_Factory implements b<FileEncryptor> {
    private final a<Encryptor> encryptorProvider;

    public FileEncryptor_Factory(a<Encryptor> aVar) {
        this.encryptorProvider = aVar;
    }

    public static FileEncryptor_Factory create(a<Encryptor> aVar) {
        return new FileEncryptor_Factory(aVar);
    }

    @Override // javax.inject.a, dagger.a
    public FileEncryptor get() {
        return new FileEncryptor(this.encryptorProvider.get());
    }
}
