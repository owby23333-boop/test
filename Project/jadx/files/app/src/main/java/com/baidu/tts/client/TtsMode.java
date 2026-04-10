package com.baidu.tts.client;

import com.baidu.tts.enumtype.TtsEnum;

/* JADX INFO: loaded from: classes2.dex */
public enum TtsMode {
    ONLINE(TtsEnum.ONLINE),
    OFFLINE(TtsEnum.OFFLINE),
    MIX(TtsEnum.MIX);

    private final TtsEnum mTtsEnum;

    TtsMode(TtsEnum ttsEnum) {
        this.mTtsEnum = ttsEnum;
    }

    public String getDescription() {
        return this.mTtsEnum.getDescription();
    }

    public int getMode() {
        return this.mTtsEnum.getMode();
    }

    public TtsEnum getTtsEnum() {
        return this.mTtsEnum;
    }
}
