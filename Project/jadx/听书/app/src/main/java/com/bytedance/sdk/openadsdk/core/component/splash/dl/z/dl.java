package com.bytedance.sdk.openadsdk.core.component.splash.dl.z;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gz f1002a;
    private String e;
    private int fo;
    private m gc;
    private int gz = 1;
    private boolean kb;
    private Context m;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g uy;

    public dl(Context context, String str, m mVar, gz gzVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.m = context;
        this.e = str;
        this.gc = mVar;
        this.kb = mVar.gc();
        this.g = mVar.g();
        this.f1002a = gzVar;
        this.uy = gVar;
    }

    public m a() {
        return this.gc;
    }

    public gz gc() {
        return this.f1002a;
    }

    public Context getContext() {
        return this.m;
    }

    public String m() {
        return this.e;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.dl.g e() {
        return this.uy;
    }

    public int gz() {
        return this.fo;
    }

    public boolean fo() {
        return this.kb;
    }
}
