package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdBridge;
import com.bytedance.sdk.openadsdk.downloadnew.h;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadBridgeFactory {
    public static final TTAdBridge getDownloadBridge(Context context) {
        return h.mb(context);
    }
}
