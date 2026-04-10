package retrofit2.adapter.rxjava2;

import com.google.gson.JsonParseException;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.net.UnknownHostException;
import java.text.ParseException;
import me.jessyan.art.base.convert.ApiException;
import org.json.JSONException;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
final class BodyObservable<T> extends Observable<T> {
    private final Call call;
    private final Observable<Response<T>> upstream;

    private static class BodyObserver<R> implements Observer<Response<R>> {
        private Call call;
        private final Observer<? super R> observer;
        private boolean terminated;

        BodyObserver(Observer<? super R> observer, Call call) {
            this.observer = observer;
            this.call = call;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.terminated) {
                return;
            }
            this.observer.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.terminated) {
                AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
                assertionError.initCause(th);
                RxJavaPlugins.onError(assertionError);
            } else if ((th instanceof ApiException) || (th instanceof UnknownHostException) || (th instanceof HttpException) || (th instanceof JsonParseException) || (th instanceof ParseException) || (th instanceof JSONException)) {
                this.observer.onError(th);
            } else {
                this.observer.onError(new CustomTimeoutThrowable(th, this.call));
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        @Override // io.reactivex.Observer
        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(httpException, th));
            }
        }
    }

    BodyObservable(Observable<Response<T>> observable, Call call) {
        this.upstream = observable;
        this.call = call;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.upstream.subscribe(new BodyObserver(observer, this.call));
    }
}
