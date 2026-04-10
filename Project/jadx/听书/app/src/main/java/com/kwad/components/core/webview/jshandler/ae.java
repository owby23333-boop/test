package com.kwad.components.core.webview.jshandler;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ae implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b acw;
    protected b adb;

    public interface b {
        void c(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ae(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    public final void a(b bVar) {
        this.adb = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        b bVar = this.adb;
        if (bVar != null) {
            bVar.c(aVar);
        } else {
            aVar.width = this.acw.TG.getWidth();
            aVar.height = this.acw.TG.getHeight();
        }
        cVar.a(aVar);
    }

    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_WIDTH, this.width);
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, this.height);
            return jSONObject;
        }
    }
}
