package com.bytedance.adsdk.lottie.d;

/* JADX INFO: loaded from: classes.dex */
public class v {
    public final float bf;
    private final String d;
    public final float e;

    public v(String str, float f, float f2) {
        this.d = str;
        this.bf = f2;
        this.e = f;
    }

    public boolean e(String str) {
        if (this.d.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.d.endsWith("\r")) {
            String str2 = this.d;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
