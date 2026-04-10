package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: loaded from: classes2.dex */
class cs implements IOAdEventListener {
    final /* synthetic */ cq a;

    cs(cq cqVar) {
        this.a = cqVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.h();
        }
    }
}
