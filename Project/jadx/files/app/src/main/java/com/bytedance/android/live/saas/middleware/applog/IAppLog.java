package com.bytedance.android.live.saas.middleware.applog;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppLog {
    String addCommonParams(String str, boolean z2);

    void addCustomHeader(String str, String str2);

    String getAbSdkVersion();

    String getDid();

    String getInstallId();

    boolean isTob();

    void log(String str, Map<String, String> map);

    void observeIdChanged(IdChangedCallback idChangedCallback);

    void onEventV3(String str, JSONObject jSONObject);

    void putCommonParams(Map<String, String> map, boolean z2);

    void tryWaitDeviceInit();
}
