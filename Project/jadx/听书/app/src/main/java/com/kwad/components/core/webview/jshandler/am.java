package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class am implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b acw;
    private int adC = 0;
    private a adD;

    /* JADX INFO: loaded from: classes4.dex */
    public interface a {
        void onAdShow();
    }

    protected void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public am(com.kwad.sdk.core.webview.b bVar) {
        this.acw = bVar;
    }

    public final void a(a aVar) {
        this.adD = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    protected void b(boolean z, AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.t.b.sY().a(adTemplate, null, bVar);
    }

    protected void a(b bVar) {
        com.kwad.sdk.core.d.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b bVarDs = new com.kwad.sdk.core.adlog.c.b().ds(bVar.Pj);
            a aVar = this.adD;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                bVarDs.dh(this.adC);
                b(true, bVar.adTemplate, null, bVarDs);
                return;
            }
            if (bp.isNullString(bVar.os())) {
                b(true, this.acw.getAdTemplate(), null, bVarDs);
                return;
            }
            if (this.acw.KI() != null) {
                for (AdTemplate adTemplate : this.acw.KI()) {
                    if (bp.isEquals(bVar.os(), String.valueOf(com.kwad.sdk.core.response.b.e.ev(adTemplate)))) {
                        b(false, adTemplate, null, bVarDs);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (bVar.actionType == 2) {
            com.kwad.sdk.widget.g gVar = this.acw.aMN;
            com.kwad.sdk.core.adlog.c.b bVarDs2 = new com.kwad.sdk.core.adlog.c.b().dh(this.adC).ds(bVar.Pj);
            if (gVar != null) {
                bVarDs2.f(gVar.getTouchCoords());
            }
            a(bVarDs2);
            com.kwad.sdk.core.adlog.c.a(c(bVar), bVarDs2, this.acw.mReportExtData);
            return;
        }
        if (bVar.actionType == 12006) {
            com.kwad.components.core.p.a.se().f(c(bVar), bVar.adE, this.adC);
            return;
        }
        if (bVar.actionType == 140) {
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.acw.mReportExtData, new com.kwad.sdk.core.adlog.c.b().ds(bVar.Pj));
        } else if (bVar.actionType == 141) {
            com.kwad.sdk.core.adlog.c.e(c(bVar), this.acw.mReportExtData, new com.kwad.sdk.core.adlog.c.b().ds(bVar.Pj));
        } else {
            com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.acw.mReportExtData, bVar.Pj);
            com.kwad.components.core.webview.tachikoma.e.a.vI().bi(bVar.Pj);
        }
    }

    private AdTemplate c(b bVar) {
        return bVar.adTemplate != null ? bVar.adTemplate : this.acw.dk(bVar.NN);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String NN;
        private String Pj;
        private int actionType;
        private int adE;
        private AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.adE = jSONObject.optInt("refreshType");
            this.Pj = jSONObject.optString("payload");
            this.NN = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.o.a.e.a.a.aI(jSONObject.optInt("adCacheId")), this.NN);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", this.Pj);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", this.adE);
            com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.NN);
            return jSONObject;
        }

        public final int getActionType() {
            return this.actionType;
        }

        public final String uD() {
            return this.Pj;
        }

        public final String os() {
            return this.NN;
        }
    }
}
