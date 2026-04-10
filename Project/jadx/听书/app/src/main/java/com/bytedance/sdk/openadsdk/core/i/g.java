package com.bytedance.sdk.openadsdk.core.i;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.openadsdk.core.sy.g {
    private static g z;

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String g() {
        return "AdEventCollector";
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String z(String str) {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public void z(String str, String str2) {
    }

    private g() {
    }

    public static synchronized g z() {
        if (z == null) {
            z = new g();
        }
        return z;
    }
}
