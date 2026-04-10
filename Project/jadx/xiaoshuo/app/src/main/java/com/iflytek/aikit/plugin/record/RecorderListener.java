package com.iflytek.aikit.plugin.record;

/* JADX INFO: loaded from: classes7.dex */
public interface RecorderListener {
    void onData(byte[] bArr);

    void onError(int i, String str);

    void onEvent(int i, String str);
}
