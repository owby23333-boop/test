package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: loaded from: classes2.dex */
class m implements IOAdEventListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bf.a(new n(this, iOAdEvent));
    }
}
