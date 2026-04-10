package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.components.core.playable.PlayableSource;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.webview.b.a {
    private com.kwad.sdk.core.webview.b.c RZ;
    private c Sa;

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String Sb;

        public final String getTarget() {
            return this.Sb;
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.b$b, reason: collision with other inner class name */
    public static class C0414b extends com.kwad.sdk.core.response.kwai.a {
        public int JR;
        public int Sc;
        public int Sd;
        public int Se;
    }

    public b(c cVar) {
        this.Sa = cVar;
    }

    public final void a(com.kwad.sdk.core.response.kwai.a aVar) {
        com.kwad.sdk.core.webview.b.c cVar = this.RZ;
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.RZ = cVar;
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            String target = aVar.getTarget();
            if (this.Sa != null) {
                this.Sa.a(this, target);
            }
        } catch (Exception unused) {
        }
    }

    public final void aK(int i2) {
        C0414b c0414b = new C0414b();
        c0414b.JR = i2;
        a(c0414b);
    }

    public final void f(PlayableSource playableSource) {
        if (playableSource == null) {
            return;
        }
        C0414b c0414b = new C0414b();
        c0414b.Sc = playableSource.getCode();
        a(c0414b);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getNativeData";
    }

    public final void h(boolean z2, boolean z3) {
        C0414b c0414b = new C0414b();
        c0414b.Sd = z2 ? 1 : 0;
        c0414b.Se = z3 ? 1 : 0;
        a(c0414b);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.RZ = null;
    }
}
