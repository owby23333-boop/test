package com.bytedance.e.e;

import com.xiaomi.onetrack.CrashAnalysis;
import com.yuewen.am;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    LAUNCH(am.b1),
    JAVA("java"),
    NATIVE("native"),
    ANR(CrashAnalysis.ANR_CRASH),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    CUSTOM_JAVA("custom_java"),
    ALL("all");

    private String m;

    d(String str) {
        this.m = str;
    }

    public String e() {
        return this.m;
    }
}
