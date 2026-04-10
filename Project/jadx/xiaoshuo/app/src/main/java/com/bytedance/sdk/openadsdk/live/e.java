package com.bytedance.sdk.openadsdk.live;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class e extends com.bytedance.sdk.openadsdk.downloadnew.e implements Serializable {
    private static final e e = new e();

    private e() {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.e, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i, Map<String, Object> map) {
        return (T) super.callMethod(cls, i, map);
    }

    public void e(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.e, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i, Map<String, Object> map) {
        return (T) super.getObj(cls, i, map);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.e, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.e, com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(TTAdEvent tTAdEvent) {
    }

    public static e e() {
        return e;
    }
}
