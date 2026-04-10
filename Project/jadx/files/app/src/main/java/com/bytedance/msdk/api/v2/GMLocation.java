package com.bytedance.msdk.api.v2;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class GMLocation {
    private double a;
    private double b;

    public GMLocation(double d2, double d3) {
        this.a = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        this.b = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        this.a = d2;
        this.b = d3;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLatitude(double d2) {
        this.a = d2;
    }

    public void setLongitude(double d2) {
        this.b = d2;
    }
}
