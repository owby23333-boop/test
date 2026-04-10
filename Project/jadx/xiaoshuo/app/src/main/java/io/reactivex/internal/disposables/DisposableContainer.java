package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes8.dex */
public interface DisposableContainer {
    boolean add(Disposable disposable);

    boolean delete(Disposable disposable);

    boolean remove(Disposable disposable);
}
