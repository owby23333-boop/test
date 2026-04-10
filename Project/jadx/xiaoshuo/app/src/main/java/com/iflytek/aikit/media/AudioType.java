package com.iflytek.aikit.media;

import com.iflytek.aikit.core.ConstStr;

/* JADX INFO: loaded from: classes7.dex */
public enum AudioType implements ConstStr {
    MP3("mp3"),
    WAV("wav"),
    AAC("aac"),
    PCM("pcm");

    private final String value;

    AudioType(String str) {
        this.value = str;
    }

    @Override // com.iflytek.aikit.core.ConstStr
    public String getValue() {
        return this.value;
    }
}
