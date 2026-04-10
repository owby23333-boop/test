package com.iflytek.aikit.plugin.player;

import com.iflytek.aikit.plugin.EventType;

/* JADX INFO: loaded from: classes7.dex */
public interface PlayerCallBack {
    void onError(int i, String str);

    void onEvent(EventType eventType, String str);

    void onPlayProcess(float f);

    void onPlayTextProcess(long j, long j2);
}
