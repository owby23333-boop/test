package io.rx_cache2.internal.cache;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.internal.Locale;
import io.rx_cache2.internal.Memory;
import io.rx_cache2.internal.Persistence;
import io.rx_cache2.internal.Record;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes3.dex */
@Singleton
public final class EvictExpirableRecordsPersistence extends Action {
    private static final float PERCENTAGE_MEMORY_STORED_TO_START = 0.95f;
    public static final float PERCENTAGE_MEMORY_STORED_TO_STOP = 0.7f;
    private boolean couldBeExpirableRecords;
    private final String encryptKey;
    private boolean isEncrypted;
    private final Integer maxMgPersistenceCache;
    private final Observable<String> oEvictingTask;

    @Inject
    public EvictExpirableRecordsPersistence(Memory memory, Persistence persistence, Integer num, String str) {
        super(memory, persistence);
        this.maxMgPersistenceCache = num;
        this.encryptKey = str;
        this.couldBeExpirableRecords = true;
        this.oEvictingTask = oEvictingTask();
    }

    private Observable<String> oEvictingTask() {
        return Observable.create(new ObservableOnSubscribe<String>() { // from class: io.rx_cache2.internal.cache.EvictExpirableRecordsPersistence.2
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                if (!EvictExpirableRecordsPersistence.this.couldBeExpirableRecords) {
                    observableEmitter.onNext(Locale.RECORD_CAN_NOT_BE_EVICTED_BECAUSE_NO_ONE_IS_EXPIRABLE);
                    observableEmitter.onComplete();
                    return;
                }
                int iStoredMB = EvictExpirableRecordsPersistence.this.persistence.storedMB();
                if (!EvictExpirableRecordsPersistence.this.reachedPercentageMemoryToStart(iStoredMB)) {
                    observableEmitter.onComplete();
                    return;
                }
                float sizeOnMb = 0.0f;
                for (String str : EvictExpirableRecordsPersistence.this.persistence.allKeys()) {
                    if (EvictExpirableRecordsPersistence.this.reachedPercentageMemoryToStop(iStoredMB, sizeOnMb)) {
                        break;
                    }
                    EvictExpirableRecordsPersistence evictExpirableRecordsPersistence = EvictExpirableRecordsPersistence.this;
                    Record recordRetrieveRecord = evictExpirableRecordsPersistence.persistence.retrieveRecord(str, evictExpirableRecordsPersistence.isEncrypted, EvictExpirableRecordsPersistence.this.encryptKey);
                    if (recordRetrieveRecord != null && recordRetrieveRecord.getExpirable().booleanValue()) {
                        EvictExpirableRecordsPersistence.this.persistence.evict(str);
                        observableEmitter.onNext(str);
                        sizeOnMb += recordRetrieveRecord.getSizeOnMb();
                    }
                }
                EvictExpirableRecordsPersistence evictExpirableRecordsPersistence2 = EvictExpirableRecordsPersistence.this;
                evictExpirableRecordsPersistence2.couldBeExpirableRecords = evictExpirableRecordsPersistence2.reachedPercentageMemoryToStop(iStoredMB, sizeOnMb);
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).doOnError(new Consumer<Throwable>() { // from class: io.rx_cache2.internal.cache.EvictExpirableRecordsPersistence.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
                th.printStackTrace();
            }
        }).share();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reachedPercentageMemoryToStart(int i2) {
        return i2 >= ((int) (((float) this.maxMgPersistenceCache.intValue()) * PERCENTAGE_MEMORY_STORED_TO_START));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean reachedPercentageMemoryToStop(int i2, float f2) {
        return ((float) i2) - f2 <= ((float) this.maxMgPersistenceCache.intValue()) * 0.7f;
    }

    Observable<String> startTaskIfNeeded(boolean z2) {
        this.isEncrypted = z2;
        this.oEvictingTask.subscribe();
        return this.oEvictingTask;
    }
}
