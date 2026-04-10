package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public enum AudioType {
    MP3("mp3"),
    WAV("wav"),
    AAC("aac"),
    PCM("pcm");

    private final String value;

    AudioType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
