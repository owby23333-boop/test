package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class cw implements IOAdEventListener {
    final /* synthetic */ cv a;

    cw(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
