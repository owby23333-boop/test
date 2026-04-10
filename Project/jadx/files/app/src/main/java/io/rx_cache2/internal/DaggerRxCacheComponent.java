package io.rx_cache2.internal;

import dagger.internal.d;
import io.rx_cache2.MigrationCache;
import io.rx_cache2.internal.cache.EvictExpirableRecordsPersistence;
import io.rx_cache2.internal.cache.EvictExpirableRecordsPersistence_Factory;
import io.rx_cache2.internal.cache.EvictExpiredRecordsPersistence;
import io.rx_cache2.internal.cache.EvictExpiredRecordsPersistence_Factory;
import io.rx_cache2.internal.cache.EvictRecord_Factory;
import io.rx_cache2.internal.cache.GetDeepCopy;
import io.rx_cache2.internal.cache.HasRecordExpired_Factory;
import io.rx_cache2.internal.cache.RetrieveRecord_Factory;
import io.rx_cache2.internal.cache.SaveRecord_Factory;
import io.rx_cache2.internal.cache.TwoLayersCache;
import io.rx_cache2.internal.cache.TwoLayersCache_Factory;
import io.rx_cache2.internal.encrypt.Encryptor;
import io.rx_cache2.internal.encrypt.FileEncryptor_Factory;
import io.rx_cache2.internal.migration.DoMigrations;
import io.victoralbertos.jolyglot.JolyglotGenerics;
import java.io.File;
import java.util.List;
import javax.inject.a;

/* JADX INFO: loaded from: classes3.dex */
public final class DaggerRxCacheComponent implements RxCacheComponent {
    private Disk_Factory diskProvider;
    private a<EvictExpirableRecordsPersistence> evictExpirableRecordsPersistenceProvider;
    private a<EvictExpiredRecordsPersistence> evictExpiredRecordsPersistenceProvider;
    private EvictRecord_Factory evictRecordProvider;
    private FileEncryptor_Factory fileEncryptorProvider;
    private a<Integer> maxMbPersistenceCacheProvider;
    private a<File> provideCacheDirectoryProvider;
    private a<String> provideEncryptKeyProvider;
    private a<Encryptor> provideEncryptorProvider;
    private a<JolyglotGenerics> provideJolyglotProvider;
    private a<Memory> provideMemoryProvider;
    private a<List<MigrationCache>> provideMigrationsProvider;
    private a<Persistence> providePersistenceProvider;
    private RetrieveRecord_Factory retrieveRecordProvider;
    private RxCacheModule rxCacheModule;
    private SaveRecord_Factory saveRecordProvider;
    private a<TwoLayersCache> twoLayersCacheProvider;
    private a<Boolean> useExpiredDataIfLoaderNotAvailableProvider;

    public static final class Builder {
        private RxCacheModule rxCacheModule;

        public RxCacheComponent build() {
            if (this.rxCacheModule != null) {
                return new DaggerRxCacheComponent(this);
            }
            throw new IllegalStateException(RxCacheModule.class.getCanonicalName() + " must be set");
        }

        public Builder rxCacheModule(RxCacheModule rxCacheModule) {
            d.a(rxCacheModule);
            this.rxCacheModule = rxCacheModule;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private DoMigrations getDoMigrations() {
        return new DoMigrations(this.providePersistenceProvider.get(), this.provideMigrationsProvider.get(), this.provideEncryptKeyProvider.get());
    }

    private GetDeepCopy getGetDeepCopy() {
        return new GetDeepCopy(this.provideMemoryProvider.get(), this.providePersistenceProvider.get(), this.provideJolyglotProvider.get());
    }

    private ProcessorProvidersBehaviour getProcessorProvidersBehaviour() {
        return new ProcessorProvidersBehaviour(this.twoLayersCacheProvider.get(), this.useExpiredDataIfLoaderNotAvailableProvider.get(), this.evictExpiredRecordsPersistenceProvider.get(), getGetDeepCopy(), getDoMigrations());
    }

    private void initialize(Builder builder) {
        this.rxCacheModule = builder.rxCacheModule;
        this.provideMemoryProvider = dagger.internal.a.b(RxCacheModule_ProvideMemoryFactory.create(builder.rxCacheModule));
        this.provideCacheDirectoryProvider = dagger.internal.a.b(RxCacheModule_ProvideCacheDirectoryFactory.create(builder.rxCacheModule));
        this.provideEncryptorProvider = dagger.internal.a.b(RxCacheModule_ProvideEncryptorFactory.create(builder.rxCacheModule));
        this.fileEncryptorProvider = FileEncryptor_Factory.create(this.provideEncryptorProvider);
        this.provideJolyglotProvider = dagger.internal.a.b(RxCacheModule_ProvideJolyglotFactory.create(builder.rxCacheModule));
        this.diskProvider = Disk_Factory.create(this.provideCacheDirectoryProvider, this.fileEncryptorProvider, this.provideJolyglotProvider);
        this.providePersistenceProvider = dagger.internal.a.b(RxCacheModule_ProvidePersistenceFactory.create(builder.rxCacheModule, this.diskProvider));
        this.evictRecordProvider = EvictRecord_Factory.create(this.provideMemoryProvider, this.providePersistenceProvider);
        this.provideEncryptKeyProvider = dagger.internal.a.b(RxCacheModule_ProvideEncryptKeyFactory.create(builder.rxCacheModule));
        this.retrieveRecordProvider = RetrieveRecord_Factory.create(this.provideMemoryProvider, this.providePersistenceProvider, this.evictRecordProvider, HasRecordExpired_Factory.create(), this.provideEncryptKeyProvider);
        this.maxMbPersistenceCacheProvider = dagger.internal.a.b(RxCacheModule_MaxMbPersistenceCacheFactory.create(builder.rxCacheModule));
        this.evictExpirableRecordsPersistenceProvider = dagger.internal.a.b(EvictExpirableRecordsPersistence_Factory.create(this.provideMemoryProvider, this.providePersistenceProvider, this.maxMbPersistenceCacheProvider, this.provideEncryptKeyProvider));
        this.saveRecordProvider = SaveRecord_Factory.create(this.provideMemoryProvider, this.providePersistenceProvider, this.maxMbPersistenceCacheProvider, this.evictExpirableRecordsPersistenceProvider, this.provideEncryptKeyProvider);
        this.twoLayersCacheProvider = dagger.internal.a.b(TwoLayersCache_Factory.create(this.evictRecordProvider, this.retrieveRecordProvider, this.saveRecordProvider));
        this.useExpiredDataIfLoaderNotAvailableProvider = dagger.internal.a.b(RxCacheModule_UseExpiredDataIfLoaderNotAvailableFactory.create(builder.rxCacheModule));
        this.evictExpiredRecordsPersistenceProvider = dagger.internal.a.b(EvictExpiredRecordsPersistence_Factory.create(this.provideMemoryProvider, this.providePersistenceProvider, HasRecordExpired_Factory.create(), this.provideEncryptKeyProvider));
        this.provideMigrationsProvider = dagger.internal.a.b(RxCacheModule_ProvideMigrationsFactory.create(builder.rxCacheModule));
    }

    @Override // io.rx_cache2.internal.RxCacheComponent
    public ProcessorProviders providers() {
        return RxCacheModule_ProvideProcessorProvidersFactory.proxyProvideProcessorProviders(this.rxCacheModule, getProcessorProvidersBehaviour());
    }

    private DaggerRxCacheComponent(Builder builder) {
        initialize(builder);
    }
}
