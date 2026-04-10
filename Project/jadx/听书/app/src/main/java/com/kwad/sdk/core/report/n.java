package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class n extends e {
    public String Ne;
    public String Nf;
    public long Nh;
    public String Pj;
    public String WH;
    public long WO;
    public long WP;
    public long WQ;
    public long XI;
    public long aDb;
    public long aGE;
    public JSONObject aGF;
    public JSONObject aGG;
    public long aGH;
    public long aGI;
    public long aGJ;
    public long aGK;
    public long aGL;
    public long aGN;
    public URLPackage aGO;
    public String aGP;
    public JSONArray aGQ;
    public JSONArray aGR;
    public a aGS;
    public int aGT;
    public int aGU;
    public int aGV;
    public int aGW;
    public String aGX;
    public int aGY;
    public int aGZ;
    public String aHA;
    public String aHB;
    public String aHC;
    public String aHD;
    public String aHF;
    public String aHG;
    public int aHH;
    public long aHK;
    public long aHL;
    public String aHM;
    public String aHa;
    public JSONObject aHb;
    public JSONArray aHc;
    public int aHd;
    public int aHe;
    public int aHf;
    public JSONArray aHh;
    public boolean aHi;
    public String aHj;
    public long aHm;
    public int aHn;
    public String aHo;
    public long aHp;
    public long aHq;
    public long aHr;
    public long aHs;
    public String aHt;
    public int aHu;
    public JSONArray aHv;
    public long aHw;
    public long aHx;
    public JSONArray aHy;
    public String aHz;
    public long aci;
    public long actionType;
    public int adE;
    public transient SceneImpl adScene;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public long llsid;
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sdkApiVersion;
    public int sdkType;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long aGM = -1;
    public int aye = 0;
    public long aHg = 0;
    public int aHk = 0;
    public int aHl = -1;
    public int aHE = 0;
    public int aHI = BuildConfig.VERSION_CODE;
    public String sdkVersion = BuildConfig.VERSION_NAME;
    public String aHJ = BuildConfig.VERSION_NAME;

    public static class b {
        public static int aHN;
        public static int aHO;
    }

    public n(long j) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aHM = "";
        this.actionType = j;
    }

    public n(long j, AdTemplate adTemplate) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aHM = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
    }

    public n(long j, AdTemplate adTemplate, String str) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aHM = "";
        this.actionType = j;
        this.mAdTemplate = adTemplate;
        this.Pj = str;
    }

    public n(String str, String str2, boolean z) {
        this.sdkApiVersion = ServiceProvider.get(com.kwad.sdk.service.a.f.class) == null ? "" : ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion();
        this.sdkType = 1;
        this.aHM = "";
        this.actionId = str;
        this.aHM = str2;
    }

    public final n Iv() {
        ck(this.mAdTemplate);
        return this;
    }

    public final void Iw() {
        com.kwad.sdk.service.a.j jVar = (com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class);
        this.aHd = jVar.sz() ? 1 : 0;
        this.aHe = jVar.sA();
        this.aHf = jVar.sB();
    }

    private void ck(AdTemplate adTemplate) {
        try {
            this.aGU = 3;
            s sVar = (s) ServiceProvider.get(s.class);
            if (sVar != null) {
                this.aHk = sVar.wm();
            }
            this.actionId = UUID.randomUUID().toString();
            this.timestamp = System.currentTimeMillis();
            this.sessionId = t.IC();
            try {
                this.Nh = t.ID();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            this.aGE = t.IE();
            SceneImpl sceneImpl = this.adScene;
            if (sceneImpl != null) {
                this.posId = sceneImpl.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            } else if (adTemplate != null && adTemplate.mAdScene != null) {
                SceneImpl sceneImpl2 = adTemplate.mAdScene;
                this.adScene = sceneImpl2;
                this.posId = sceneImpl2.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
                this.adStyle = this.adScene.getAdStyle();
            }
            if (adTemplate != null) {
                this.position = adTemplate.getShowPosition() + 1;
                this.aGH = adTemplate.getServerPosition() + 1;
                this.llsid = com.kwad.sdk.core.response.b.e.ei(adTemplate);
                String strEj = com.kwad.sdk.core.response.b.e.ej(adTemplate);
                if (!TextUtils.isEmpty(strEj)) {
                    try {
                        this.aGF = new JSONObject(strEj);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                    }
                }
                String strEk = com.kwad.sdk.core.response.b.e.ek(adTemplate);
                if (!TextUtils.isEmpty(strEk)) {
                    try {
                        this.aGG = new JSONObject(strEk);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e3);
                    }
                }
                this.posId = com.kwad.sdk.core.response.b.e.ee(adTemplate);
                this.contentType = com.kwad.sdk.core.response.b.e.eh(adTemplate);
                this.realShowType = adTemplate.realShowType;
                this.photoId = com.kwad.sdk.core.response.b.e.er(adTemplate);
                if (this.realShowType == 2) {
                    AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
                    this.creativeId = adInfoEl.adBaseInfo.creativeId;
                    this.aGI = com.kwad.sdk.core.response.b.a.L(adInfoEl) * 1000;
                    this.XI = adInfoEl.advertiserInfo.userId;
                }
                this.aGT = adTemplate.mMediaPlayerType;
                this.aGV = adTemplate.mIsLeftSlipStatus;
                this.aGW = adTemplate.mPhotoResponseType;
                if (adTemplate.mPageInfo != null) {
                    this.pageType = adTemplate.mPageInfo.pageType;
                }
                this.contentSourceType = com.kwad.sdk.core.response.b.e.es(adTemplate);
            }
            this.aGS = a.Ix();
            if (this.adScene == null && adTemplate != null) {
                this.adScene = adTemplate.mAdScene;
            }
            SceneImpl sceneImpl3 = this.adScene;
            if (sceneImpl3 != null) {
                this.posId = sceneImpl3.getPosId();
                this.urlPackage = this.adScene.getUrlPackage();
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e4);
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aGU = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.aGZ = jSONObject.optInt("num");
        this.aGY = jSONObject.optInt("state");
        this.aHg = jSONObject.optLong("timeSpend");
        this.aHw = jSONObject.optLong("loadingDuration");
        this.aHx = jSONObject.optLong("loadingDurationLimt");
        this.aHl = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.e, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        aa.putValue(jSONObject, "actionId", this.actionId);
        int i = this.adStyle;
        if (i > 0) {
            aa.putValue(jSONObject, "adStyle", i);
        }
        int i2 = this.aGZ;
        if (i2 > 0) {
            aa.putValue(jSONObject, "num", i2);
        }
        int i3 = this.aGY;
        if (i3 != 0) {
            aa.putValue(jSONObject, "state", i3);
        }
        long j = this.aHg;
        if (j > 0) {
            aa.putValue(jSONObject, "timeSpend", j);
        }
        long j2 = this.aHw;
        if (j2 > 0) {
            aa.putValue(jSONObject, "loadingDuration", j2);
        }
        long j3 = this.aHx;
        if (j3 > 0) {
            aa.putValue(jSONObject, "loadingDurationLimt", j3);
        }
        aa.putValue(jSONObject, "playerTypeInfo", this.aHl);
    }

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int aHN;
        public int aHO;

        public static a Ix() {
            a aVar = new a();
            aVar.aHN = b.aHN;
            aVar.aHO = b.aHO;
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        if (TextUtils.isEmpty(this.aHM)) {
            return super.toString();
        }
        return "ReportAction{actionJSONString=" + this.aHM + '}';
    }
}
