package com.kwad.components.core.proxy;

import android.os.Bundle;
import com.kwad.sdk.api.proxy.IActivityProxy;

/* JADX INFO: loaded from: classes4.dex */
public class d extends IActivityProxy {
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
