package com.anythink.core.b.b;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingListener;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements ATBiddingListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ATBaseAdAdapter f6525c;

    public b(ATBaseAdAdapter aTBaseAdAdapter) {
        this.f6525c = aTBaseAdAdapter;
    }

    private void a() {
        this.f6525c = null;
    }
}
