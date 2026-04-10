package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;
    private int mL;
    private int mM;

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    public static class C0413a extends com.kwad.sdk.core.response.kwai.a {
        public int showLiveStatus;
        public int showLiveStyle;
    }

    public a(int i2, int i3) {
        this.mL = i2;
        this.mM = i3;
    }

    private void n(int i2, int i3) {
        if (this.RZ == null) {
            return;
        }
        C0413a c0413a = new C0413a();
        c0413a.showLiveStatus = i2;
        c0413a.showLiveStyle = i3;
        this.RZ.a(c0413a);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
        n(this.mL, this.mM);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getLiveInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }
}
