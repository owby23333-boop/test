package com.bytedance.adsdk.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class g extends RuntimeException {
    public g(String str, Throwable th) {
        super("Unable to parse expression:".concat(String.valueOf(str)), th);
    }
}
