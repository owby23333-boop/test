package com.bytedance.msdk.gc;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f470a;
    public final String dl;
    public final int g;
    public final boolean z;

    public gc(boolean z, int i, String str, boolean z2) {
        this.z = z;
        this.g = i;
        this.dl = str;
        this.f470a = z2;
    }

    public String toString() {
        return "AdEventUploadResult{mSuccess=" + this.z + ", mStatusCode=" + this.g + ", mMsg='" + this.dl + "', mIsDataError=" + this.f470a + '}';
    }
}
