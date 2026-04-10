package com.kwad.components.core.webview.tachikoma.b;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends w {
    private final b agv;

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        int km();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public e(b bVar) {
        this.agv = bVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.agv;
        if (bVar != null) {
            aVar.height = bVar.km();
            cVar.a(aVar);
        }
    }

    static class a implements com.kwad.sdk.core.b {
        public int height;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, this.height);
            return jSONObject;
        }
    }
}
