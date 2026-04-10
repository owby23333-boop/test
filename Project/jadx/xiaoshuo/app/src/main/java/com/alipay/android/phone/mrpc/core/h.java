package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class h extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1646a;

    public h(Context context) {
        this.f1646a = context;
    }

    private g a(ab abVar) {
        return new i(this, abVar);
    }

    @Override // com.alipay.android.phone.mrpc.core.x
    public <T> T a(Class<T> cls, ab abVar) {
        return (T) new y(a(abVar)).a(cls);
    }
}
