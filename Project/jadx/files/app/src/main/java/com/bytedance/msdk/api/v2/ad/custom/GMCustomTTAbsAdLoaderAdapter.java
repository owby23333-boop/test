package com.bytedance.msdk.api.v2.ad.custom;

import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMCustomTTAbsAdLoaderAdapter extends TTAbsAdLoaderAdapter {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected String f14230z;

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        return this.f14230z;
    }
}
