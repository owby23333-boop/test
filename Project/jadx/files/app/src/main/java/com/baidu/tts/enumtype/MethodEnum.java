package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum MethodEnum {
    SYNTHESIZE,
    SPEAK;

    public static boolean isSpeak(MethodEnum methodEnum) {
        return SPEAK.equals(methodEnum);
    }
}
