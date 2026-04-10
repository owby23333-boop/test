package com.iflytek.aikit.plugin;

/* JADX INFO: loaded from: classes7.dex */
public enum AudioSourceType {
    MIC(1),
    DEFAULT(0),
    CAMCORDER(5),
    REMOTE_SUBMIX(8),
    VOICE_CALL(4),
    VOICE_COMMUNICATION(7),
    VOICE_PERFORMANCE(10),
    VOICE_DOWNLINK(3),
    VOICE_RECOGNITION(6),
    VOICE_UPLINK(2),
    UNPROCESSED(9);

    private final int value;

    AudioSourceType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
