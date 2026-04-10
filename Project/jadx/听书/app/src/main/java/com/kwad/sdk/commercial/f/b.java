package com.kwad.sdk.commercial.f;

import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String avN;
    public String avU;
    public int status;
    public String url;

    public static b DY() {
        return new b();
    }

    public final b cC(int i) {
        this.status = i;
        return this;
    }

    public final b cQ(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.avN = url.getHost();
            this.avU = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }
}
