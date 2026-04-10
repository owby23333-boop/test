package com.baidu.tts.network;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpCallbackListener {
    void onError(int i2, Map<String, List<String>> map, String str, Exception exc);

    void onFinish(int i2, Map<String, List<String>> map, String str, byte[] bArr);
}
