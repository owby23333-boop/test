package com.amgcyo.cuttadon.utils.otherutils;

import io.reactivex.functions.Consumer;

/* JADX INFO: compiled from: SimpleThrowableAction.java */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements Consumer<Throwable> {
    public n0(String str) {
    }

    @Override // io.reactivex.functions.Consumer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) throws Exception {
        th.printStackTrace();
    }
}
