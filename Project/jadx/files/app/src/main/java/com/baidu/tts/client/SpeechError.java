package com.baidu.tts.client;

import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes2.dex */
public class SpeechError {
    public int code;
    public String description;

    public String toString() {
        return ad.f20405r + this.code + ad.f20406s + this.description;
    }
}
