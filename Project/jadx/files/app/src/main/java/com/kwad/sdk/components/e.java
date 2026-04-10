package com.kwad.sdk.components;

import android.content.Context;
import anet.channel.util.ErrorConstant;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements DevelopMangerComponents {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return null;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return ErrorConstant.ERROR_REQUEST_FAIL;
    }

    @Override // com.kwad.sdk.components.DevelopMangerComponents
    public final String tZ() {
        return "";
    }
}
