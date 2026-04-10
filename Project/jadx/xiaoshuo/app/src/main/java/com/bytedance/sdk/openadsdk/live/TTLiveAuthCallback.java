package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public interface TTLiveAuthCallback extends Serializable {
    void onAuth(TTLiveToken tTLiveToken);

    void onFailed(Throwable th);
}
