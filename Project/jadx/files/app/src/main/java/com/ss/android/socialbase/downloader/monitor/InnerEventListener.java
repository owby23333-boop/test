package com.ss.android.socialbase.downloader.monitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface InnerEventListener {
    void onEvent(int i2, String str, JSONObject jSONObject);

    void onUnityEvent(int i2, String str, JSONObject jSONObject);
}
