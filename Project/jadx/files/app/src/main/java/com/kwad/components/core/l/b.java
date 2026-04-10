package com.kwad.components.core.l;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.proxy.IActivityProxy;

/* JADX INFO: loaded from: classes3.dex */
public class b extends IActivityProxy {
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
