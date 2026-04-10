package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String a;

    w(String str) {
        this.a = str;
    }

    public static w a(String str) throws IOException {
        if (str.equals(HTTP_1_0.a)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.a)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.a)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.a)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
