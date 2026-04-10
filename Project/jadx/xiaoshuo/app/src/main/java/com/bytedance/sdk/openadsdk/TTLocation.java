package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes10.dex */
public class TTLocation implements LocationProvider {
    private double bf;
    private double e;

    public TTLocation(double d, double d2) {
        this.e = d;
        this.bf = d2;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.bf;
    }

    public void setLatitude(double d) {
        this.e = d;
    }

    public void setLongitude(double d) {
        this.bf = d;
    }
}
