package com.kwad.sdk.commercial.b;

import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String avN;
    public String avU;
    public String avV;
    public int avW;
    public int avX;
    public int status;
    public String url;

    public static b DU() {
        return new b();
    }

    public final b cy(int i) {
        this.status = i;
        return this;
    }

    public final b cH(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.avN = url.getHost();
            this.avU = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cz(int i) {
        this.avW = i;
        return this;
    }

    public final b cA(int i) {
        this.avX = i;
        return this;
    }

    public final b cI(String str) {
        this.avV = str;
        return this;
    }
}
