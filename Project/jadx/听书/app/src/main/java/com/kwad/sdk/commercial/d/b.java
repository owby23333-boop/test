package com.kwad.sdk.commercial.d;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public String adSource;
    public boolean awd;
    public boolean awe;
    public String awf;
    public String methodName;

    public static b DV() {
        return new b();
    }

    public final b cJ(String str) {
        this.methodName = str;
        return this;
    }

    public final b bn(boolean z) {
        this.awd = z;
        return this;
    }

    public final b cB(int i) {
        this.adNum = i;
        return this;
    }

    public final b cK(String str) {
        this.awf = str;
        return this;
    }

    public final b cL(String str) {
        this.adSource = str;
        return this;
    }
}
