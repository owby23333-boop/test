package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    private final int bf;
    private final String d;
    private final int e;
    private final String ga;
    private final String tg;
    private Bitmap vn;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public zk(int i, int i2, String str, String str2, String str3) {
        this.e = i;
        this.bf = i2;
        this.d = str;
        this.tg = str2;
        this.ga = str3;
    }

    public int bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public Bitmap ga() {
        return this.vn;
    }

    public String tg() {
        return this.tg;
    }

    public void e(Bitmap bitmap) {
        this.vn = bitmap;
    }
}
