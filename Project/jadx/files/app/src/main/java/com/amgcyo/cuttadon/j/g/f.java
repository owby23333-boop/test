package com.amgcyo.cuttadon.j.g;

import com.amgcyo.cuttadon.utils.rxjava.scheduler.SchedulerType;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.Executor;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: SchedulerTransformer.java */
/* JADX INFO: loaded from: classes.dex */
public class f<T> implements ObservableTransformer<T, T>, FlowableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {
    private SchedulerType a;
    private Executor b;

    /* JADX INFO: compiled from: SchedulerTransformer.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[SchedulerType.values().length];

        static {
            try {
                a[SchedulerType._main.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SchedulerType._io.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SchedulerType._io_main.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[SchedulerType._io_io.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(SchedulerType schedulerType) {
        this(schedulerType, c.b());
    }

    @Override // io.reactivex.ObservableTransformer
    public ObservableSource<T> apply(Observable<T> observable) {
        int i2 = a.a[this.a.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? observable : observable.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(c.a(this.b)) : observable.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(AndroidSchedulers.mainThread()) : observable.observeOn(c.a(this.b)) : observable.observeOn(AndroidSchedulers.mainThread());
    }

    public f(SchedulerType schedulerType, Executor executor) {
        this.a = schedulerType;
        this.b = executor;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<T> apply(Flowable<T> flowable) {
        int i2 = a.a[this.a.ordinal()];
        if (i2 == 1) {
            return flowable.observeOn(AndroidSchedulers.mainThread());
        }
        if (i2 == 2) {
            return flowable.observeOn(c.a(this.b));
        }
        if (i2 != 3) {
            return i2 != 4 ? flowable : flowable.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(c.a(this.b));
        }
        return flowable.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // io.reactivex.MaybeTransformer
    public MaybeSource<T> apply(Maybe<T> maybe) {
        int i2 = a.a[this.a.ordinal()];
        if (i2 == 1) {
            return maybe.observeOn(AndroidSchedulers.mainThread());
        }
        if (i2 == 2) {
            return maybe.observeOn(c.a(this.b));
        }
        if (i2 != 3) {
            return i2 != 4 ? maybe : maybe.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(c.a(this.b));
        }
        return maybe.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // io.reactivex.SingleTransformer
    public SingleSource<T> apply(Single<T> single) {
        int i2 = a.a[this.a.ordinal()];
        if (i2 == 1) {
            return single.observeOn(AndroidSchedulers.mainThread());
        }
        if (i2 == 2) {
            return single.observeOn(c.a(this.b));
        }
        if (i2 != 3) {
            return i2 != 4 ? single : single.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(c.a(this.b));
        }
        return single.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // io.reactivex.CompletableTransformer
    public CompletableSource apply(Completable completable) {
        int i2 = a.a[this.a.ordinal()];
        if (i2 == 1) {
            return completable.observeOn(AndroidSchedulers.mainThread());
        }
        if (i2 == 2) {
            return completable.observeOn(c.a(this.b));
        }
        if (i2 != 3) {
            return i2 != 4 ? completable : completable.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(c.a(this.b));
        }
        return completable.subscribeOn(c.a(this.b)).unsubscribeOn(c.a(this.b)).observeOn(AndroidSchedulers.mainThread());
    }
}
