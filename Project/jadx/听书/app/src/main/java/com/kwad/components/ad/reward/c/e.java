package com.kwad.components.ad.reward.c;

import android.text.TextUtils;
import com.bytedance.android.live.base.api.push.ILivePush;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private String TAG;
    private com.kwad.sdk.core.webview.c.c qn;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String uo;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.d.c.d(str, "create: ");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d(this.TAG, "handleJsCall: " + cVar);
        this.qn = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.d.c.d(this.TAG, "onDestroy: ");
        this.qn = null;
    }

    public final void ia() {
        com.kwad.sdk.core.d.c.d(this.TAG, "notifyDialogClose: ");
        L(ILivePush.ClickType.CLOSE);
    }

    private void L(String str) {
        if (TextUtils.isEmpty(str) || this.qn == null) {
            return;
        }
        a aVar = new a();
        aVar.uo = str;
        this.qn.a(aVar);
    }
}
