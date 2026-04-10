package com.bytedance.sdk.openadsdk.wp.z;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Exception {
    long dl;
    boolean g;
    boolean z;

    public a(boolean z) {
        this.z = z;
    }

    public a(boolean z, boolean z2, long j) {
        this.z = z;
        this.g = z2;
        this.dl = j;
    }

    public a(boolean z, long j) {
        this.z = z;
        this.dl = j;
    }
}
