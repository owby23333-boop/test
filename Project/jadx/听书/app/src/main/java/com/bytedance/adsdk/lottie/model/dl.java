package com.bytedance.adsdk.lottie.model;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f162a;
    private final String dl;
    private final String g;
    private Typeface gc;
    private final String z;

    public dl(String str, String str2, String str3, float f) {
        this.z = str;
        this.g = str2;
        this.dl = str3;
        this.f162a = f;
    }

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public Typeface a() {
        return this.gc;
    }

    public void z(Typeface typeface) {
        this.gc = typeface;
    }
}
