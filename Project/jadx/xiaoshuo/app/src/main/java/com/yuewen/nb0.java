package com.yuewen;

/* JADX INFO: loaded from: classes2.dex */
public abstract class nb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14805a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14806b;

    public nb0(String str) {
        this.f14806b = str;
    }

    public final void a() {
        if (this.f14805a) {
            return;
        }
        this.f14805a = true;
        b();
        this.f14806b = null;
    }

    public abstract void b();
}
