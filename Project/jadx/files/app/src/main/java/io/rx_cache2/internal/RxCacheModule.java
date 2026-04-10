package io.rx_cache2.internal;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.MigrationCache;
import io.rx_cache2.internal.cache.memory.ReferenceMapMemory;
import io.rx_cache2.internal.encrypt.BuiltInEncryptor;
import io.rx_cache2.internal.encrypt.Encryptor;
import io.victoralbertos.jolyglot.JolyglotGenerics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes3.dex */
@Module
public final class RxCacheModule {
    private final File cacheDirectory;
    private final String encryptKey;
    private final JolyglotGenerics jolyglot;
    private final Integer maxMgPersistenceCache;
    private final List<MigrationCache> migrations;
    private final boolean useExpiredDataIfLoaderNotAvailable;

    public RxCacheModule(File file, Boolean bool, Integer num, String str, List<MigrationCache> list, JolyglotGenerics jolyglotGenerics) {
        this.cacheDirectory = file;
        this.useExpiredDataIfLoaderNotAvailable = bool.booleanValue();
        this.maxMgPersistenceCache = num;
        this.encryptKey = str;
        this.migrations = list;
        this.jolyglot = jolyglotGenerics;
    }

    @Provides
    @Singleton
    Integer maxMbPersistenceCache() {
        Integer num = this.maxMgPersistenceCache;
        return Integer.valueOf(num != null ? num.intValue() : 100);
    }

    @Provides
    @Singleton
    File provideCacheDirectory() {
        return this.cacheDirectory;
    }

    @Provides
    @Singleton
    String provideEncryptKey() {
        String str = this.encryptKey;
        return str != null ? str : "";
    }

    @Provides
    @Singleton
    Encryptor provideEncryptor() {
        return new BuiltInEncryptor();
    }

    @Provides
    @Singleton
    JolyglotGenerics provideJolyglot() {
        return this.jolyglot;
    }

    @Provides
    @Singleton
    Memory provideMemory() {
        return new ReferenceMapMemory();
    }

    @Provides
    @Singleton
    List<MigrationCache> provideMigrations() {
        List<MigrationCache> list = this.migrations;
        return list != null ? list : new ArrayList();
    }

    @Provides
    @Singleton
    Persistence providePersistence(Disk disk) {
        return disk;
    }

    @Provides
    ProcessorProviders provideProcessorProviders(ProcessorProvidersBehaviour processorProvidersBehaviour) {
        return processorProvidersBehaviour;
    }

    @Provides
    @Singleton
    Boolean useExpiredDataIfLoaderNotAvailable() {
        return Boolean.valueOf(this.useExpiredDataIfLoaderNotAvailable);
    }
}
