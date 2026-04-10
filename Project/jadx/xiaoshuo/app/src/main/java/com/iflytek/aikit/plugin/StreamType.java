package com.iflytek.aikit.plugin;

/* JADX INFO: loaded from: classes7.dex */
public enum StreamType {
    STREAM_VOICE_CALL(0),
    STREAM_SYSTEM(1),
    STREAM_RING(2),
    STREAM_MUSIC(3),
    STREAM_ALARM(4),
    STREAM_NOTIFICATION(5);

    private final int value;

    StreamType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
