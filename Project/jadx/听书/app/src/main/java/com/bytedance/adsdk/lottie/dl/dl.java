package com.bytedance.adsdk.lottie.dl;

/* JADX INFO: loaded from: classes2.dex */
public enum dl {
    JSON(".json"),
    ZIP(".zip");

    public final String dl;

    dl(String str) {
        this.dl = str;
    }

    public String z() {
        return ".temp" + this.dl;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.dl;
    }
}
