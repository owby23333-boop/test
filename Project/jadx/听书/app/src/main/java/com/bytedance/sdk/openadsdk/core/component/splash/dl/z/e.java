package com.bytedance.sdk.openadsdk.core.component.splash.dl.z;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class e extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1003a;
    private int e;
    private com.bytedance.sdk.openadsdk.ls.dl.g.g fo;
    private String gc;
    private boolean gz;
    private int kb;
    private boolean m;
    private long uy;

    public e() {
        this.f1003a = -1;
        this.gc = "unknown";
        this.m = false;
        this.gz = false;
        this.kb = -1;
    }

    public e(int i, String str, boolean z) {
        this.m = false;
        this.kb = -1;
        this.f1003a = i;
        this.gc = str;
        this.gz = z;
    }

    public int a() {
        return this.f1003a;
    }

    public void g(int i) {
        this.f1003a = i;
    }

    public void dl(int i) {
        this.kb = i;
    }

    public String gc() {
        return TextUtils.isEmpty(this.gc) ? "unknown" : this.gc;
    }

    public void z(String str) {
        this.gc = str;
    }

    public boolean m() {
        return this.m;
    }

    public void z(boolean z) {
        this.m = z;
    }

    public int e() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public boolean gz() {
        return this.gz;
    }

    public void g(boolean z) {
        this.gz = z;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.g fo() {
        return this.fo;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        this.fo = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.z.z
    public long dl() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.dl.z.z
    public void z(long j) {
        this.uy = j;
    }
}
