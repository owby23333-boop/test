package com.kwad.sdk.commercial.smallApp;

import java.net.URL;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String avN;
    public String avU;
    public String aws;
    public String awt;
    public String awu;
    public int status;
    public String url;

    public static b a(JumpFrom jumpFrom) {
        return new b(jumpFrom);
    }

    private b(JumpFrom jumpFrom) {
        if (jumpFrom != null) {
            this.awu = jumpFrom.getValue();
        }
    }

    public final b cF(int i) {
        this.status = i;
        return this;
    }

    public final b cX(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.avN = url.getHost();
            this.avU = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cY(String str) {
        this.aws = str;
        return this;
    }

    public final b cZ(String str) {
        this.awt = str;
        return this;
    }
}
