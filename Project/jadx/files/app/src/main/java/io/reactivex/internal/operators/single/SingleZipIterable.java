package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleZipArray;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class SingleZipIterable<T, R> extends Single<R> {
    final Iterable<? extends SingleSource<? extends T>> sources;
    final Function<? super Object[], ? extends R> zipper;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.functions.Function
        public R apply(T t2) throws Exception {
            return (R) ObjectHelper.requireNonNull(SingleZipIterable.this.zipper.apply(new Object[]{t2}), "The zipper returned a null value");
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.sources = iterable;
        this.zipper = function;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            SingleSource[] singleSourceArr2 = singleSourceArr;
            int i2 = 0;
            for (SingleSource<? extends T> singleSource : this.sources) {
                if (singleSource == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i2 == singleSourceArr2.length) {
                    singleSourceArr2 = (SingleSource[]) Arrays.copyOf(singleSourceArr2, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                singleSourceArr2[i2] = singleSource;
                i2 = i3;
            }
            if (i2 == 0) {
                EmptyDisposable.error(new NoSuchElementException(), singleObserver);
                return;
            }
            if (i2 == 1) {
                singleSourceArr2[0].subscribe(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
                return;
            }
            SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(singleObserver, i2, this.zipper);
            singleObserver.onSubscribe(zipCoordinator);
            for (int i4 = 0; i4 < i2 && !zipCoordinator.isDisposed(); i4++) {
                singleSourceArr2[i4].subscribe(zipCoordinator.observers[i4]);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
