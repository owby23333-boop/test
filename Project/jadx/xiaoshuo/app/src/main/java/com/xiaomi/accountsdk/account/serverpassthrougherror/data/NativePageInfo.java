package com.xiaomi.accountsdk.account.serverpassthrougherror.data;

import com.xiaomi.accountsdk.account.serverpassthrougherror.base.CustomJumpIntentInterface;

/* JADX INFO: loaded from: classes5.dex */
public class NativePageInfo {
    public final CustomJumpIntentInterface customJumpIntentInterface;
    public final Class<?> pageClass;

    public NativePageInfo(Class<?> cls) {
        this(cls, null);
    }

    public String toString() {
        return "NativePageInfo{pageClass=" + this.pageClass + '}';
    }

    public NativePageInfo(Class<?> cls, CustomJumpIntentInterface customJumpIntentInterface) {
        this.pageClass = cls;
        this.customJumpIntentInterface = customJumpIntentInterface;
    }
}
