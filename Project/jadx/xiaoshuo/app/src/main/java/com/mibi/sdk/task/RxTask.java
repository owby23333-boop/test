package com.mibi.sdk.task;

import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.rx.Emitter;
import com.mibi.sdk.rx.Observable;
import com.mibi.sdk.rx.OnSubscribe;

/* JADX INFO: loaded from: classes16.dex */
public abstract class RxTask<R> implements OnSubscribe<R> {
    private Class<R> mResultClazz;

    public RxTask(Class<R> cls) {
        this.mResultClazz = cls;
        if (cls != null && Void.class.equals(cls)) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mibi.sdk.rx.OnSubscribe
    public void call(Emitter<? super R> emitter) {
        try {
            R rNewInstance = this.mResultClazz.newInstance();
            doLoad(rNewInstance);
            emitter.onSuccess(rNewInstance);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (Exception e3) {
            emitter.onError(e3);
        }
    }

    public abstract void doLoad(R r) throws PaymentException;

    public Observable<R> getObservable() {
        return Observable.create(this);
    }
}
