package com.bytedance.msdk.api.v2.ad.custom.init;

import android.content.Context;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GMCustomAdapterConfiguration {
    private static final AtomicBoolean b;
    private GMCustomInitConfig a;

    static {
        String str = "TTMediationSDK_" + GMCustomAdapterConfiguration.class.getSimpleName();
        b = new AtomicBoolean(false);
    }

    public final void callInitSuccess() {
        b.set(true);
    }

    public abstract String getAdapterSdkVersion();

    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    public final String getCustomADNName() {
        return this.a.getADNName();
    }

    public abstract String getNetworkSdkVersion();

    public String getSdkInfo(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract void initializeADN(Context context, GMCustomInitConfig gMCustomInitConfig, Map<String, Object> map);

    public final void initializeInnerADN(Context context, GMCustomInitConfig gMCustomInitConfig, Map<String, Object> map) {
        b.set(false);
        this.a = gMCustomInitConfig;
        initializeADN(context, this.a, map);
    }

    public final boolean isInit() {
        return b.get();
    }
}
