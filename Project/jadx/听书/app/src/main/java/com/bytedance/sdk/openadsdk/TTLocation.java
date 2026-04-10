package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes2.dex */
public class TTLocation implements LocationProvider {
    private double g;
    private double z;

    public TTLocation(double d, double d2) {
        this.z = d;
        this.g = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.z;
    }

    public void setLatitude(double d) {
        this.z = d;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.g;
    }

    public void setLongitude(double d) {
        this.g = d;
    }
}
