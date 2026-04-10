package com.amgcyo.cuttadon.api.repository;

import io.reactivex.functions.Function;
import java.util.List;
import me.jessyan.art.entity.BaseModel;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ b f3441s = new b();

    private /* synthetic */ b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return (List) ((BaseModel) obj).getData();
    }
}
