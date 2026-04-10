package com.bytedance.adsdk.lottie.d;

import com.bytedance.adsdk.lottie.d.bf.w;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class tg {
    private final char bf;
    private final double d;
    private final List<w> e;
    private final String ga;
    private final double tg;
    private final String vn;

    public tg(List<w> list, char c, double d, double d2, String str, String str2) {
        this.e = list;
        this.bf = c;
        this.d = d;
        this.tg = d2;
        this.ga = str;
        this.vn = str2;
    }

    public static int e(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public double bf() {
        return this.tg;
    }

    public int hashCode() {
        return e(this.bf, this.vn, this.ga);
    }

    public List<w> e() {
        return this.e;
    }
}
