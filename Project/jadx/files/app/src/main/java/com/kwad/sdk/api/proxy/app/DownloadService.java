package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DownloadService extends BaseProxyService {
    @Override // com.kwad.sdk.api.proxy.BaseProxyService
    @NonNull
    public IServiceProxy getDelegate(Context context) {
        return (IServiceProxy) Loader.get().newComponentProxy(context, DownloadService.class, this);
    }
}
