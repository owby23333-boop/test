package com.anythink.expressad.exoplayer.k;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private String[] a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9856c;

    private l(String... strArr) {
        this.a = strArr;
    }

    private void a(String... strArr) {
        a.b(!this.b, "Cannot set libraries after loading");
        this.a = strArr;
    }

    private boolean a() {
        if (this.b) {
            return this.f9856c;
        }
        this.b = true;
        try {
            for (String str : this.a) {
                System.loadLibrary(str);
            }
            this.f9856c = true;
        } catch (UnsatisfiedLinkError unused) {
        }
        return this.f9856c;
    }
}
