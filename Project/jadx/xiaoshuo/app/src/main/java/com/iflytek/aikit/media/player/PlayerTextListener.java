package com.iflytek.aikit.media.player;

import com.iflytek.aikit.plugin.EventType;

/* JADX INFO: loaded from: classes7.dex */
public interface PlayerTextListener {
    void onPlayEvent(EventType eventType, String str);

    void onSentenceProcess(long j, long j2);
}
