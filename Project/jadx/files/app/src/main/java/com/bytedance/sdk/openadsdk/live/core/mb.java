package com.bytedance.sdk.openadsdk.live.core;

import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class mb implements ILiveHostActionParam {
    private ITTLiveHostAction mb;

    public mb(ITTLiveHostAction iTTLiveHostAction) {
        this.mb = iTTLiveHostAction;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z2, String str, String str2, Map<String, String> map) {
        ITTLiveHostAction iTTLiveHostAction = this.mb;
        if (iTTLiveHostAction != null) {
            iTTLiveHostAction.logEvent(z2, str, str2, map);
        }
    }
}
