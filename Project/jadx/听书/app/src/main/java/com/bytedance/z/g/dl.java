package com.bytedance.z.g;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes2.dex */
public enum dl {
    LAUNCH("launch"),
    JAVA(LogType.JAVA_TYPE),
    NATIVE("native"),
    ANR(LogType.ANR_TYPE),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL(TtmlNode.COMBINE_ALL);

    private String uy;

    dl(String str) {
        this.uy = str;
    }

    public String z() {
        return this.uy;
    }
}
