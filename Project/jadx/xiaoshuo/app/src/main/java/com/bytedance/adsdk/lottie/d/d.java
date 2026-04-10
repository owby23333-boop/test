package com.bytedance.adsdk.lottie.d;

import android.graphics.Typeface;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class d {
    private final String bf;
    private final String d;
    private final String e;
    private Typeface ga;
    private final float tg;

    public d(String str, String str2, String str3, float f) {
        this.e = str;
        this.bf = str2;
        this.d = str3;
        this.tg = f;
    }

    public String bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public Typeface tg() {
        return this.ga;
    }

    public void e(Typeface typeface) {
        this.ga = typeface;
    }
}
