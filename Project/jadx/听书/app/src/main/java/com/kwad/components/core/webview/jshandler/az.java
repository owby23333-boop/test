package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class az extends com.kwad.components.core.webview.tachikoma.b.w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void uF() {
        aY("showStart");
    }

    public final void uG() {
        aY("showEnd");
    }

    public final void uH() {
        aY("hideStart");
    }

    public final void uI() {
        aY("hideEnd");
    }

    public final void uJ() {
        aY("pageVisiable");
    }

    public final void uK() {
        aY("pageInvisiable");
    }

    private void aY(String str) {
        a aVar = new a();
        aVar.aeh = str;
        b(aVar);
    }

    public static final class a implements com.kwad.sdk.core.b {
        private String aeh;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "lifeStatus", this.aeh);
            return jSONObject;
        }
    }
}
