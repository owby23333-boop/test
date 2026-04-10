package com.xiaomi.ad.mediation;

import com.xiaomi.ad.common.util.MLog;

/* JADX INFO: loaded from: classes5.dex */
public class MMAdSdkConfig {
    public boolean isDebug;
    public boolean isStaging;
    public String mChannelId;

    public String getChannelId() {
        return this.mChannelId;
    }

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
        if (z) {
            MLog.setDebugOn();
        } else {
            MLog.setDebugOff();
        }
    }

    public void setStaging(boolean z) {
        this.isStaging = z;
    }
}
