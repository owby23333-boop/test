package com.ss.android.socialbase.downloader.network;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadHttpConnection implements IDownloadHttpConnection {
    public String getHostIp() {
        return "";
    }

    public String getRequestLog() {
        return "";
    }

    public void monitorNetworkInfo(JSONObject jSONObject, boolean z2) {
    }

    public void onThrowable(Throwable th) {
    }

    public void setThrottleNetSpeedWhenRunning(long j2) {
    }
}
