package com.xiaomi.ad.mediation.internal;

/* JADX INFO: loaded from: classes5.dex */
public class DspWeight {
    public String dsp;
    public String placementId;
    public int weight;

    public DspWeight(String str, int i) {
        this.dsp = str;
        this.weight = i;
    }

    public String getDsp() {
        return this.dsp;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setDsp(String str) {
        this.dsp = str;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setWeight(int i) {
        this.weight = i;
    }
}
