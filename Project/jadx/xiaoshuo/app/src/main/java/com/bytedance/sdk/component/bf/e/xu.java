package com.bytedance.sdk.component.bf.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public enum xu {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String ga;

    xu(String str) {
        this.ga = str;
    }

    public static xu e(String str) throws IOException {
        xu xuVar = HTTP_1_0;
        if (str.equals(xuVar.ga)) {
            return xuVar;
        }
        xu xuVar2 = HTTP_1_1;
        if (str.equals(xuVar2.ga)) {
            return xuVar2;
        }
        xu xuVar3 = HTTP_2;
        if (str.equals(xuVar3.ga)) {
            return xuVar3;
        }
        xu xuVar4 = SPDY_3;
        if (str.equals(xuVar4.ga)) {
            return xuVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ga;
    }
}
