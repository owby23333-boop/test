package com.amgcyo.cuttadon.api.repository;

import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import io.reactivex.functions.Function;
import me.jessyan.art.entity.BaseModel;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v3 implements Function {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ v3 f3560s = new v3();

    private /* synthetic */ v3() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return (SitePathReload) ((BaseModel) obj).getData();
    }
}
