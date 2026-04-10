package com.bytedance.adsdk.lottie.model;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private final String dl;
    public final float g;
    public final float z;

    public m(String str, float f, float f2) {
        this.dl = str;
        this.g = f2;
        this.z = f;
    }

    public boolean z(String str) {
        if (this.dl.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.dl.endsWith("\r")) {
            String str2 = this.dl;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
