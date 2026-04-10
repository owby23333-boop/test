package com.kwad.sdk.api.proxy;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* JADX INFO: loaded from: classes4.dex */
@KsAdSdkDynamicApi
public interface IReceiverProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    void onReceive(Context context, Intent intent);
}
