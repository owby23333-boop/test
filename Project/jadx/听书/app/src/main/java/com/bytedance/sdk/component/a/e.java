package com.bytedance.sdk.component.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    void onExceptionEvent(String str, JSONObject jSONObject, Throwable th);

    void onStatsEvent(String str, JSONObject jSONObject);
}
