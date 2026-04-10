package com.bytedance.sdk.openadsdk.core.un;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.sdk.component.a.z.dl {
    public final long dl;
    public final float g;
    public final float z;

    dl(float f, float f2, long j) {
        this.z = f;
        this.g = f2;
        this.dl = j;
    }

    @Override // com.bytedance.sdk.component.a.z.dl
    public float getLatitude() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.a.z.dl
    public float getLongitude() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.a.z.dl
    public long getLastTime() {
        return this.dl;
    }
}
