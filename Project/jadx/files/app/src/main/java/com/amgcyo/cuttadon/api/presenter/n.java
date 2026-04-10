package com.amgcyo.cuttadon.api.presenter;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Consumer {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final /* synthetic */ BookPresenter f3413s;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.f3413s.a((Disposable) obj);
    }
}
