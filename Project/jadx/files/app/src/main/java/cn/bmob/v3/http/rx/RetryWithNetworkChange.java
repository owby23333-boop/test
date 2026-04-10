package cn.bmob.v3.http.rx;

import android.content.Context;
import cn.bmob.v3.exception.BmobException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class RetryWithNetworkChange implements Function<Observable<? extends Throwable>, Observable<?>> {
    private final Observable<Boolean> isConnected;
    private final int maxTimeout;
    private final int startTimeOut;
    private int timeout;

    public RetryWithNetworkChange(Context context, int i2, int i3) {
        this.startTimeOut = i2;
        this.maxTimeout = i3;
        this.timeout = i2;
        this.isConnected = getConnectedObservable(context);
    }

    private ObservableTransformer<Boolean, Boolean> attachTimeout() {
        return new ObservableTransformer<Boolean, Boolean>() { // from class: cn.bmob.v3.http.rx.RetryWithNetworkChange.2
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<Boolean> apply(Observable<Boolean> observable) {
                return observable.timeout(RetryWithNetworkChange.this.timeout, TimeUnit.SECONDS).doOnError(new Consumer<Throwable>() { // from class: cn.bmob.v3.http.rx.RetryWithNetworkChange.2.1
                    @Override // io.reactivex.functions.Consumer
                    public void accept(Throwable th) {
                        if (th instanceof BmobException) {
                            RetryWithNetworkChange retryWithNetworkChange = RetryWithNetworkChange.this;
                            retryWithNetworkChange.timeout = retryWithNetworkChange.timeout > RetryWithNetworkChange.this.maxTimeout ? RetryWithNetworkChange.this.maxTimeout : RetryWithNetworkChange.this.timeout + RetryWithNetworkChange.this.startTimeOut;
                        }
                    }
                });
            }
        };
    }

    private Observable<Boolean> getConnectedObservable(Context context) {
        return BroadcastObservable.fromConnectivityManager(context).distinctUntilChanged().filter(new Predicate<Boolean>() { // from class: cn.bmob.v3.http.rx.RetryWithNetworkChange.3
            @Override // io.reactivex.functions.Predicate
            public boolean test(Boolean bool) throws Exception {
                return bool.booleanValue();
            }
        });
    }

    @Override // io.reactivex.functions.Function
    public Observable<?> apply(Observable<? extends Throwable> observable) {
        return observable.flatMap(new Function<Throwable, Observable<Boolean>>() { // from class: cn.bmob.v3.http.rx.RetryWithNetworkChange.1
            @Override // io.reactivex.functions.Function
            public Observable<Boolean> apply(Throwable th) {
                return ((th instanceof BmobException) && ((BmobException) th).getErrorCode() == 9016) ? RetryWithNetworkChange.this.isConnected : Observable.error(th);
            }
        }).compose(attachTimeout());
    }
}
