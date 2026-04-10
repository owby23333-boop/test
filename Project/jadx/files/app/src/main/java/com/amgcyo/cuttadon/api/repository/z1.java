package com.amgcyo.cuttadon.api.repository;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z1 implements Function {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ z1 f3579s = new z1();

    private /* synthetic */ z1() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return Observable.fromIterable((List) obj);
    }
}
