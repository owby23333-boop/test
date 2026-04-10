package com.iflytek.aikit.plugin;

/* JADX INFO: loaded from: classes7.dex */
public enum EventType {
    DEFAULT(-1),
    INIT(0),
    STARTED(1),
    PLAYING(2),
    RESUMED(3),
    PAUSED(4),
    STOPPED(5),
    RELEASED(6),
    COMPLETED(7);

    private final int value;

    EventType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
