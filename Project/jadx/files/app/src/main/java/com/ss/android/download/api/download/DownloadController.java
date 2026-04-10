package com.ss.android.download.api.download;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface DownloadController {
    boolean enableAH();

    boolean enableAM();

    boolean enableNewActivity();

    boolean enableShowComplianceDialog();

    @Deprecated
    int getDowloadChunkCount();

    int getDownloadMode();

    Object getExtraClickOperation();

    JSONObject getExtraJson();

    Object getExtraObject();

    int getInterceptFlag();

    int getLinkMode();

    boolean isAddToDownloadManage();

    boolean isAutoDownloadOnCardShow();

    boolean isEnableBackDialog();

    @Deprecated
    boolean isEnableMultipleDownload();

    void setDownloadMode(int i2);

    void setEnableNewActivity(boolean z2);

    void setEnableShowComplianceDialog(boolean z2);

    void setLinkMode(int i2);

    boolean shouldUseNewWebView();
}
