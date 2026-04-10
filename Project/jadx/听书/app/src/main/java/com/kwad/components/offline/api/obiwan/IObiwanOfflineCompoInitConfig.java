package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;

/* JADX INFO: loaded from: classes4.dex */
public interface IObiwanOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getLogDirPath();

    String getLogObiwanData();

    long getLogObiwanStorageQuota();

    boolean isLogObiwanEnableNow();

    boolean isLogObiwanRecordAll();
}
