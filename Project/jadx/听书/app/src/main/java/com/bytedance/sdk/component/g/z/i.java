package com.bytedance.sdk.component.g.z;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String gc;

    i(String str) {
        this.gc = str;
    }

    public static i z(String str) throws IOException {
        i iVar = HTTP_1_0;
        if (str.equals(iVar.gc)) {
            return iVar;
        }
        i iVar2 = HTTP_1_1;
        if (str.equals(iVar2.gc)) {
            return iVar2;
        }
        i iVar3 = HTTP_2;
        if (str.equals(iVar3.gc)) {
            return iVar3;
        }
        i iVar4 = SPDY_3;
        if (str.equals(iVar4.gc)) {
            return iVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.gc;
    }
}
