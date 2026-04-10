package com.airbnb.lottie.network;

import com.kuaishou.weapon.p0.d;

/* JADX INFO: loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(d.b);

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
