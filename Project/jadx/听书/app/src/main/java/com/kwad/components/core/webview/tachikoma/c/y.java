package com.kwad.components.core.webview.tachikoma.c;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes4.dex */
public class y extends com.kwad.sdk.core.response.a.a {
    public String ahn;
    public int errorCode;
    public String errorReason;
    public int qz;

    public final boolean vz() {
        return TextUtils.equals(TtmlNode.START, this.ahn);
    }

    public final boolean vA() {
        return TextUtils.equals(TtmlNode.END, this.ahn);
    }

    public final boolean isFailed() {
        return TextUtils.equals("failed", this.ahn);
    }

    public final boolean vB() {
        return TextUtils.equals("progress", this.ahn);
    }

    public final boolean vC() {
        return TextUtils.equals("pause", this.ahn);
    }

    public final boolean vD() {
        return TextUtils.equals("resume", this.ahn);
    }

    public final int vE() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
