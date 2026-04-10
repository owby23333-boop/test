package fm.qingting.qtsdk.callbacks;

import fm.qingting.qtsdk.QTException;

/* JADX INFO: loaded from: classes8.dex */
public interface QTCallback<T> {
    void done(T result, QTException e);
}
