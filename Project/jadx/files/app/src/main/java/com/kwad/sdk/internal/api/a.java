package com.kwad.sdk.internal.api;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public int aaB;
    public int aaC;
    public String aaD;
    public String aaE;
    public String aaF;
    public String aaG;
    public String aaH;
    public long aaI;

    public final boolean AL() {
        return this.aaB == 0 && this.aaC == 0 && TextUtils.isEmpty(this.aaD);
    }

    public final boolean AM() {
        return TextUtils.isEmpty(this.aaE) && TextUtils.isEmpty(this.aaF) && TextUtils.isEmpty(this.aaH) && TextUtils.isEmpty(this.aaG);
    }
}
