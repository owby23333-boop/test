package com.bytedance.sdk.component.d.bf;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public enum wl {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String ga;

    wl(String str) {
        this.ga = str;
    }

    public static wl e(String str) throws IOException {
        wl wlVar = HTTP_1_0;
        if (str.equals(wlVar.ga)) {
            return wlVar;
        }
        wl wlVar2 = HTTP_1_1;
        if (str.equals(wlVar2.ga)) {
            return wlVar2;
        }
        wl wlVar3 = HTTP_2;
        if (str.equals(wlVar3.ga)) {
            return wlVar3;
        }
        wl wlVar4 = SPDY_3;
        if (str.equals(wlVar4.ga)) {
            return wlVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ga;
    }
}
