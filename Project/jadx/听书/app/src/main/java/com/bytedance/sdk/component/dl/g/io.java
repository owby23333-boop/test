package com.bytedance.sdk.component.dl.g;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum io {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String gc;

    io(String str) {
        this.gc = str;
    }

    public static io z(String str) throws IOException {
        io ioVar = HTTP_1_0;
        if (str.equals(ioVar.gc)) {
            return ioVar;
        }
        io ioVar2 = HTTP_1_1;
        if (str.equals(ioVar2.gc)) {
            return ioVar2;
        }
        io ioVar3 = HTTP_2;
        if (str.equals(ioVar3.gc)) {
            return ioVar3;
        }
        io ioVar4 = SPDY_3;
        if (str.equals(ioVar4.gc)) {
            return ioVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.gc;
    }
}
