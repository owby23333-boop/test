package com.amgcyo.cuttadon.api.repository;

import com.amgcyo.cuttadon.api.entity.fission5.Task5ResultBean;
import io.reactivex.functions.Function;
import me.jessyan.art.entity.BaseModel;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q3 implements Function {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ q3 f3531s = new q3();

    private /* synthetic */ q3() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return (Task5ResultBean) ((BaseModel) obj).getData();
    }
}
