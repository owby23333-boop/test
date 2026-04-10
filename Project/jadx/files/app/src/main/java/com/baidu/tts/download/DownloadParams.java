package com.baidu.tts.download;

import com.baidu.tts.client.model.OnDownloadListener;
import com.baidu.tts.tools.StringTool;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadParams {
    private OnDownloadListener mDownloadListener;
    private String mModelId;

    public OnDownloadListener getDownloadListener() {
        return this.mDownloadListener;
    }

    public String getModelId() {
        return this.mModelId;
    }

    public boolean isParamsValid() {
        return !StringTool.isEmpty(this.mModelId);
    }

    public void setDownloadListener(OnDownloadListener onDownloadListener) {
        this.mDownloadListener = onDownloadListener;
    }

    public void setModelId(String str) {
        this.mModelId = str;
    }
}
