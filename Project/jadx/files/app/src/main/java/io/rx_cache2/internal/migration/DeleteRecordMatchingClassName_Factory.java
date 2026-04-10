package io.rx_cache2.internal.migration;

import dagger.internal.b;
import io.rx_cache2.internal.Persistence;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class DeleteRecordMatchingClassName_Factory implements b<DeleteRecordMatchingClassName> {
    private final a<String> encryptKeyProvider;
    private final a<Persistence> persistenceProvider;

    public DeleteRecordMatchingClassName_Factory(a<Persistence> aVar, a<String> aVar2) {
        this.persistenceProvider = aVar;
        this.encryptKeyProvider = aVar2;
    }

    public static DeleteRecordMatchingClassName_Factory create(a<Persistence> aVar, a<String> aVar2) {
        return new DeleteRecordMatchingClassName_Factory(aVar, aVar2);
    }

    @Override // javax.inject.a, dagger.a
    public DeleteRecordMatchingClassName get() {
        return new DeleteRecordMatchingClassName(this.persistenceProvider.get(), this.encryptKeyProvider.get());
    }
}
