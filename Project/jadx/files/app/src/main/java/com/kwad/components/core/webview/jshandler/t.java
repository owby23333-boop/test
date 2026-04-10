package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class t implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b Sk;
    private int Tm = 0;
    private a ko;

    public interface a {
        void onAdShow();
    }

    public static final class b implements com.kwad.sdk.core.b {
        private int Tn;
        private String To;
        private int Tp;
        private AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.Tn = jSONObject.optInt("actionType");
            this.Tp = jSONObject.optInt("refreshType");
            this.To = jSONObject.optString("payload");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.s.putValue(jSONObject, "actionType", this.Tn);
            com.kwad.sdk.utils.s.putValue(jSONObject, "payload", this.To);
            com.kwad.sdk.utils.s.putValue(jSONObject, "refreshType", this.Tp);
            com.kwad.sdk.utils.s.a(jSONObject, "adTemplate", this.adTemplate);
            return jSONObject;
        }
    }

    public t(com.kwad.sdk.core.webview.b bVar) {
        this.Sk = bVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull b bVar) {
        com.kwad.sdk.core.d.b.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.Tn);
        if (bVar.Tn == 1) {
            com.kwad.sdk.core.report.i iVarCi = new com.kwad.sdk.core.report.i().ci(bVar.To);
            a aVar = this.ko;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate == null) {
                com.kwad.components.core.r.c.qa().a(this.Sk.getAdTemplate(), null, iVarCi);
                return;
            } else {
                iVarCi.bi(this.Tm);
                com.kwad.components.core.r.c.qa().a(bVar.adTemplate, null, iVarCi);
                return;
            }
        }
        if (bVar.Tn != 2) {
            if (bVar.Tn == 12006) {
                com.kwad.components.core.m.a.pr().a(b(bVar), bVar.Tp, this.Tm);
                return;
            } else {
                com.kwad.sdk.core.report.a.a(b(bVar), bVar.Tn, this.Sk.mReportExtData, bVar.To);
                return;
            }
        }
        com.kwad.sdk.widget.e eVar = this.Sk.aoM;
        com.kwad.sdk.core.report.i iVarCi2 = new com.kwad.sdk.core.report.i().bi(this.Tm).ci(bVar.To);
        if (eVar != null) {
            iVarCi2.c(eVar.getTouchCoords());
        }
        a(iVarCi2);
        com.kwad.sdk.core.report.a.a(b(bVar), iVarCi2, this.Sk.mReportExtData);
    }

    private AdTemplate b(@NonNull b bVar) {
        return bVar.adTemplate != null ? bVar.adTemplate : this.Sk.getAdTemplate();
    }

    public final void a(a aVar) {
        this.ko = aVar;
    }

    protected void a(com.kwad.sdk.core.report.i iVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.Sk.zf()) {
            cVar.onError(-1, "native adTemplate is null");
        }
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            a(bVar);
            cVar.a(null);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            cVar.onError(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
