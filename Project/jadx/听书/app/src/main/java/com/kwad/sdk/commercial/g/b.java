package com.kwad.sdk.commercial.g;

import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int To;
    public String avN;
    public String avU;
    public int status;
    public String url;

    public static b DZ() {
        return new b();
    }

    public final b cD(int i) {
        this.status = i;
        return this;
    }

    public final b cE(int i) {
        this.To = i;
        return this;
    }

    public final b cR(String str) {
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
