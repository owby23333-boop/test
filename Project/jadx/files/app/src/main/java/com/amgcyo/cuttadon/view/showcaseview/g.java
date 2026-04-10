package com.amgcyo.cuttadon.view.showcaseview;

import android.content.Context;

/* JADX INFO: compiled from: PrefsManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f5490c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f5491d = -1;
    private String a;
    private Context b;

    public g(Context context, String str) {
        this.a = null;
        this.b = context;
        this.a = str;
    }

    void a(int i2) {
        this.b.getSharedPreferences("material_showcaseview_prefs", 0).edit().putInt("status_" + this.a, i2).apply();
    }

    int b() {
        return this.b.getSharedPreferences("material_showcaseview_prefs", 0).getInt("status_" + this.a, f5490c);
    }

    boolean c() {
        return b() == f5491d;
    }

    public void d() {
        a(this.b, this.a);
    }

    void e() {
        a(f5491d);
    }

    static void a(Context context, String str) {
        context.getSharedPreferences("material_showcaseview_prefs", 0).edit().putInt("status_" + str, f5490c).apply();
    }

    public void a() {
        this.b = null;
    }
}
