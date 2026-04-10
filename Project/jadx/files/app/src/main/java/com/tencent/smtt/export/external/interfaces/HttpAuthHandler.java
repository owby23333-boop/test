package com.tencent.smtt.export.external.interfaces;

/* JADX INFO: loaded from: classes3.dex */
public interface HttpAuthHandler {
    void cancel();

    void proceed(String str, String str2);

    boolean useHttpAuthUsernamePassword();
}
