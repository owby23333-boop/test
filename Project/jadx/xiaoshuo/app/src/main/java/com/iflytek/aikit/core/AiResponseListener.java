package com.iflytek.aikit.core;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface AiResponseListener {
    void onError(String str, int i, int i2, String str2, Object obj);

    void onEvent(String str, int i, int i2, List<AiResponse> list, Object obj);

    void onResult(String str, int i, List<AiResponse> list, Object obj);
}
