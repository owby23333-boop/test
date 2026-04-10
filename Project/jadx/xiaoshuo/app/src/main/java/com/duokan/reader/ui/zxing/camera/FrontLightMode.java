package com.duokan.reader.ui.zxing.camera;

/* JADX INFO: loaded from: classes5.dex */
public enum FrontLightMode {
    ON,
    AUTO,
    OFF;

    private static FrontLightMode parse(String str) {
        return str == null ? OFF : valueOf(str);
    }

    public static FrontLightMode readPref() {
        return parse(OFF.toString());
    }
}
