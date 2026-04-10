package com.kwad.components.core.webview.a.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class w extends com.kwad.sdk.core.response.kwai.a {
    public String Vg;
    public int errorCode;
    public String errorReason;
    public int nW;

    public final boolean isFailed() {
        return TextUtils.equals("failed", this.Vg);
    }

    public final int rA() {
        String str = this.errorReason;
        if (str != null) {
            return (int) Long.parseLong(str);
        }
        return 0;
    }

    public final boolean ry() {
        return TextUtils.equals(com.anythink.expressad.foundation.d.c.bT, this.Vg);
    }

    public final boolean rz() {
        return TextUtils.equals("end", this.Vg);
    }
}
