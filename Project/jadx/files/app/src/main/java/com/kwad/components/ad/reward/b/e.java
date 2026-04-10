package com.kwad.components.ad.reward.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.webview.b.a {
    private String TAG = "ExtraDialogListener" + hashCode();
    private com.kwad.sdk.core.webview.b.c nK;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String rT;
    }

    public e() {
        com.kwad.sdk.core.d.b.d(this.TAG, "create: ");
    }

    private void S(String str) {
        if (TextUtils.isEmpty(str) || this.nK == null) {
            return;
        }
        a aVar = new a();
        aVar.rT = str;
        this.nK.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.d.b.d(this.TAG, "handleJsCall: " + cVar);
        this.nK = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    public final void hn() {
        com.kwad.sdk.core.d.b.d(this.TAG, "notifyDialogClose: ");
        S(com.anythink.expressad.foundation.d.c.cf);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.core.d.b.d(this.TAG, "onDestroy: ");
        this.nK = null;
    }
}
