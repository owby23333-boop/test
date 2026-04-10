package com.kwad.sdk.api.proxy;

import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* JADX INFO: loaded from: classes4.dex */
@KsAdSdkDynamicApi
public abstract class IFragmentActivityProxy extends IActivityProxy {
    private BaseProxyFragmentActivity mProxyFragmentActivity;

    public void onAttachFragment(KsFragment ksFragment) {
    }

    void setProxyFragmentActivity(BaseProxyFragmentActivity baseProxyFragmentActivity) {
        this.mProxyFragmentActivity = baseProxyFragmentActivity;
    }

    @KsAdSdkDynamicApi
    public final KsFragmentManager getSupportFragmentManager() {
        return this.mProxyFragmentActivity.getSupportFragmentManager2();
    }
}
