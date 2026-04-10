package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.model.g.ls;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f161a;
    private final double dl;
    private final char g;
    private final String gc;
    private final String m;
    private final List<ls> z;

    public static int z(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public a(List<ls> list, char c, double d, double d2, String str, String str2) {
        this.z = list;
        this.g = c;
        this.dl = d;
        this.f161a = d2;
        this.gc = str;
        this.m = str2;
    }

    public List<ls> z() {
        return this.z;
    }

    public double g() {
        return this.f161a;
    }

    public int hashCode() {
        return z(this.g, this.m, this.gc);
    }
}
