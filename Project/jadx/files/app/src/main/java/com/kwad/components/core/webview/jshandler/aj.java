package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class aj implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int TZ;

        public a(int i2) {
            this.TZ = i2;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
    }

    public final void ai(boolean z2) {
        if (this.RZ != null) {
            this.RZ.a(new a(z2 ? 1 : 0));
        } else {
            com.kwad.sdk.core.d.b.d("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z2 ? 1 : 0));
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
