package com.baidu.tts.client.model;

/* JADX INFO: loaded from: classes2.dex */
public interface OnDownloadListener {
    void onFinish(String str, int i2);

    void onProgress(String str, long j2, long j3);

    void onStart(String str);
}
