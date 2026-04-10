package com.iflytek.aikit.plugin;

/* JADX INFO: loaded from: classes7.dex */
public enum ChannelConfig {
    ChannelDefault(4),
    ChannelMono(4),
    ChannelStereo(12);

    private final int value;

    ChannelConfig(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
