package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum WidgetType implements Const {
    NONE_WIDGET(-1),
    AUDIO_PLAYER(0),
    AUDIO_RECORDER(1);

    private final int value;

    WidgetType(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static WidgetType valueOf(int i) {
        return i == 0 ? AUDIO_PLAYER : i == 1 ? AUDIO_RECORDER : NONE_WIDGET;
    }
}
