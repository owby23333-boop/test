package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class al implements com.kwad.sdk.core.webview.c.a {
    private final WebView Ta;
    private Handler acR;
    private com.kwad.sdk.core.webview.c.c acS;
    private boolean adz;
    private b eU;

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "initKsAdFrame";
    }

    public al(com.kwad.sdk.core.webview.b bVar, b bVar2) {
        this(bVar, bVar2, true);
    }

    private al(com.kwad.sdk.core.webview.b bVar, b bVar2, boolean z) {
        this.adz = true;
        this.acR = new Handler(Looper.getMainLooper());
        this.Ta = bVar.Ta;
        this.eU = bVar2;
        this.adz = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.acS = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.al.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (al.this.Ta != null && al.this.adz) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) al.this.Ta.getLayoutParams();
                        marginLayoutParams.width = -1;
                        marginLayoutParams.height = aVar.height;
                        marginLayoutParams.leftMargin = aVar.leftMargin;
                        marginLayoutParams.rightMargin = aVar.rightMargin;
                        marginLayoutParams.bottomMargin = aVar.bottomMargin;
                        al.this.Ta.setLayoutParams(marginLayoutParams);
                    }
                    if (al.this.eU != null) {
                        al.this.eU.a(aVar);
                    }
                }
            });
            this.acR.post(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.al.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (al.this.acS != null) {
                        al.this.acS.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.acS = null;
        this.eU = null;
        this.acR.removeCallbacksAndMessages(null);
    }

    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt(MediaFormat.KEY_HEIGHT);
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, MediaFormat.KEY_HEIGHT, this.height);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }
}
