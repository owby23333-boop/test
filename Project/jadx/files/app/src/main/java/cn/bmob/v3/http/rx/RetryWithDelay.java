package cn.bmob.v3.http.rx;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class RetryWithDelay implements Function<Observable<? extends Throwable>, Observable<?>> {
    private final int maxRetries;
    private int retryCount;
    private final int retryDelayMillis;

    public RetryWithDelay(int i2, int i3) {
        this.maxRetries = i2;
        this.retryDelayMillis = i3;
    }

    static /* synthetic */ int access$004(RetryWithDelay retryWithDelay) {
        int i2 = retryWithDelay.retryCount + 1;
        retryWithDelay.retryCount = i2;
        return i2;
    }

    @Override // io.reactivex.functions.Function
    public Observable<?> apply(Observable<? extends Throwable> observable) {
        return observable.flatMap(new Function<Throwable, Observable<?>>() { // from class: cn.bmob.v3.http.rx.RetryWithDelay.1
            @Override // io.reactivex.functions.Function
            public Observable<?> apply(Throwable th) {
                return RetryWithDelay.access$004(RetryWithDelay.this) <= RetryWithDelay.this.maxRetries ? Observable.timer(RetryWithDelay.this.retryDelayMillis, TimeUnit.MILLISECONDS) : Observable.error(th);
            }
        });
    }
}
