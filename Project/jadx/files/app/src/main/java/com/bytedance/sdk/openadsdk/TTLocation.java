package com.bytedance.sdk.openadsdk;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TTLocation implements LocationProvider {
    private double mb;
    private double ox;

    public TTLocation(double d2, double d3) {
        this.mb = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        this.ox = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        this.mb = d2;
        this.ox = d3;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.ox;
    }

    public void setLatitude(double d2) {
        this.mb = d2;
    }

    public void setLongitude(double d2) {
        this.ox = d2;
    }
}
