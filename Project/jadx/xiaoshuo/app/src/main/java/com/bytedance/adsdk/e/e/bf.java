package com.bytedance.adsdk.e.e;

/* JADX INFO: loaded from: classes.dex */
public class bf extends RuntimeException {
    public bf(String str, Throwable th) {
        super("无法解析表达式:" + str, th);
    }
}
