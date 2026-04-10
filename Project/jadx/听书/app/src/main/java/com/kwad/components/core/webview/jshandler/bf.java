package com.kwad.components.core.webview.jshandler;

/* JADX INFO: loaded from: classes4.dex */
public final class bf implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ack;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.ack = cVar;
    }

    public final void ai(boolean z) {
        if (this.ack == null) {
            com.kwad.sdk.core.d.c.d("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z ? 1 : 0));
        } else {
            this.ack.a(new a(z ? 1 : 0));
        }
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int aet;

        public a(int i) {
            this.aet = i;
        }
    }
}
