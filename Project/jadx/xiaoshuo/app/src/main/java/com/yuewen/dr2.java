package com.yuewen;

/* JADX INFO: loaded from: classes10.dex */
public class dr2 implements xt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cr2 f10326a;

    public dr2(cr2 cr2Var) {
        this.f10326a = cr2Var;
    }

    @Override // com.yuewen.xt1
    public void c(bi biVar, String str) {
        this.f10326a.onQueryAccountError(biVar, str);
    }

    @Override // com.yuewen.xt1
    public void e(bi biVar) {
        this.f10326a.onQueryAccountOk(biVar);
    }
}
