package com.bykv.vk.openvk.component.video.api.dl;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private String dl;
    private int g;
    private int z;

    public g(int i, int i2) {
        this.z = i;
        this.g = i2;
    }

    public g(int i, int i2, String str) {
        this.z = i;
        this.g = i2;
        this.dl = str;
    }

    public int z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public void z(String str) {
        this.dl = str;
    }
}
