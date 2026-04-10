package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class q extends f {
    public String HD;
    public String HE;
    public long HG;
    public String NW;
    public long OX;
    public long Oc;
    public long Od;
    public long Oe;
    public transient SceneImpl Ot;
    public String SI;
    public int SK;
    public String To;
    public int Tp;
    public long Vc;
    public long aes;
    public int aiA;
    public int aiB;
    public int aiC;
    public int aiD;
    public int aiE;
    public String aiF;
    public JSONObject aiG;
    public JSONArray aiH;
    public int aiI;
    public int aiJ;
    public int aiK;
    public JSONArray aiM;
    public boolean aiN;
    public String aiO;
    public long aiR;
    public int aiS;
    public String aiT;
    public long aiU;
    public long aiV;
    public long aiW;
    public long aiX;
    public String aiY;
    public int aiZ;
    public long aii;
    public long aij;
    public JSONObject aik;
    public JSONObject ail;
    public long aim;
    public long ain;
    public long aio;
    public long aip;
    public long aiq;
    public long ais;
    public URLPackage aiu;
    public String aiv;
    public JSONArray aiw;
    public JSONArray aix;
    public a aiy;
    public int aiz;
    public JSONArray aja;
    public long ajb;
    public long ajc;
    public JSONArray ajd;
    public String aje;
    public String ajf;
    public String ajg;
    public String ajh;
    public String aji;
    public String ajk;
    public String ajl;
    public int ajm;
    public long ajo;
    public long ajp;
    public long blockDuration;
    public long clickTime;
    public int contentSourceType;
    public long creativeId;
    public long downloadDuration;
    public String entryPageSource;
    public int errorCode;
    public String errorMsg;
    public String failUrl;
    public long llsid;

    @Nullable
    public transient AdTemplate mAdTemplate;
    public int pageType;
    public long photoId;
    public long posId;
    public long position;
    public String sessionId;
    public long timestamp;
    public String trace;
    public URLPackage urlPackage;
    public int adStyle = -1;
    public int contentType = 0;
    public int realShowType = 0;
    public long air = -1;
    public int ait = 0;
    public long aiL = 0;
    public int aiP = 0;
    public int aiQ = -1;
    public int ajj = 0;
    public int ajn = 3033800;
    public String sdkVersion = "3.3.38";

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public int ajq;
        public int ajr;

        public static a xp() {
            a aVar = new a();
            aVar.ajq = b.ajq;
            aVar.ajr = b.ajr;
            return aVar;
        }
    }

    public static class b {
        public static int ajq;
        public static int ajr;
    }

    public q(long j2) {
        this.SI = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SK = 1;
        this.aij = j2;
    }

    public q(long j2, @NonNull AdTemplate adTemplate) {
        this.SI = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SK = 1;
        this.aij = j2;
        this.mAdTemplate = adTemplate;
    }

    public q(long j2, @NonNull AdTemplate adTemplate, String str) {
        this.SI = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SK = 1;
        this.aij = j2;
        this.mAdTemplate = adTemplate;
        this.To = str;
    }

    public q(String str) {
        this.SI = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SK = 1;
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    public q(JSONObject jSONObject) {
        this.SI = ServiceProvider.get(com.kwad.sdk.service.kwai.e.class) == null ? "" : ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
        this.SK = 1;
        parseJson(jSONObject);
    }

    private void aH(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        this.aiA = 3;
        v vVar = (v) ServiceProvider.get(v.class);
        if (vVar != null) {
            this.aiP = vVar.rY();
        }
        this.actionId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.sessionId = w.xu();
        try {
            this.HG = w.xv();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        this.aii = w.xw();
        SceneImpl sceneImpl2 = this.Ot;
        if (sceneImpl2 != null) {
            this.posId = sceneImpl2.getPosId();
            this.urlPackage = this.Ot.getUrlPackage();
            this.adStyle = this.Ot.getAdStyle();
        } else if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
            this.Ot = sceneImpl;
            sceneImpl2 = this.Ot;
            this.posId = sceneImpl2.getPosId();
            this.urlPackage = this.Ot.getUrlPackage();
            this.adStyle = this.Ot.getAdStyle();
        }
        if (adTemplate != null) {
            this.position = adTemplate.getShowPosition() + 1;
            this.aim = adTemplate.getServerPosition() + 1;
            this.llsid = com.kwad.sdk.core.response.a.d.bY(adTemplate);
            String strBZ = com.kwad.sdk.core.response.a.d.bZ(adTemplate);
            if (!TextUtils.isEmpty(strBZ)) {
                try {
                    this.aik = new JSONObject(strBZ);
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
                }
            }
            String strCa = com.kwad.sdk.core.response.a.d.ca(adTemplate);
            if (!TextUtils.isEmpty(strCa)) {
                try {
                    this.ail = new JSONObject(strCa);
                } catch (Exception e4) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e4);
                }
            }
            this.posId = com.kwad.sdk.core.response.a.d.bU(adTemplate);
            this.contentType = com.kwad.sdk.core.response.a.d.bX(adTemplate);
            this.realShowType = adTemplate.realShowType;
            this.photoId = com.kwad.sdk.core.response.a.d.cg(adTemplate);
            if (this.realShowType == 2) {
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                this.creativeId = adInfoCb.adBaseInfo.creativeId;
                this.ain = com.kwad.sdk.core.response.a.a.F(adInfoCb) * 1000;
                this.OX = adInfoCb.advertiserInfo.userId;
            }
            this.aiz = adTemplate.mMediaPlayerType;
            this.aiB = adTemplate.mIsLeftSlipStatus;
            this.aiC = adTemplate.mPhotoResponseType;
            PageInfo pageInfo = adTemplate.mPageInfo;
            if (pageInfo != null) {
                this.pageType = pageInfo.pageType;
            }
            this.contentSourceType = com.kwad.sdk.core.response.a.d.ch(adTemplate);
        }
        this.aiy = a.xp();
        if (this.Ot == null && adTemplate != null) {
            this.Ot = adTemplate.mAdScene;
        }
        SceneImpl sceneImpl3 = this.Ot;
        if (sceneImpl3 != null) {
            this.posId = sceneImpl3.getPosId();
            this.urlPackage = this.Ot.getUrlPackage();
        }
    }

    @Override // com.kwad.sdk.core.report.f, com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.aiA = 3;
        this.adStyle = jSONObject.optInt("adStyle", -1);
        this.aiE = jSONObject.optInt(com.anythink.expressad.foundation.d.l.f10300d);
        this.aiD = jSONObject.optInt(CallMraidJS.b);
        this.aiL = jSONObject.optLong("timeSpend");
        this.ajb = jSONObject.optLong("loadingDuration");
        this.ajc = jSONObject.optLong("loadingDurationLimt");
        this.aiQ = jSONObject.optInt("playerTypeInfo", -1);
        if (jSONObject.has("actionId")) {
            this.actionId = jSONObject.optString("actionId");
        }
    }

    @Override // com.kwad.sdk.core.report.f, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        com.kwad.sdk.utils.s.putValue(jSONObject, "actionId", this.actionId);
        int i2 = this.adStyle;
        if (i2 > 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "adStyle", i2);
        }
        int i3 = this.aiE;
        if (i3 > 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, com.anythink.expressad.foundation.d.l.f10300d, i3);
        }
        int i4 = this.aiD;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, CallMraidJS.b, i4);
        }
        long j2 = this.aiL;
        if (j2 > 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "timeSpend", j2);
        }
        long j3 = this.ajb;
        if (j3 > 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "loadingDuration", j3);
        }
        long j4 = this.ajc;
        if (j4 > 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "loadingDurationLimt", j4);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "playerTypeInfo", this.aiQ);
    }

    public final q xn() {
        aH(this.mAdTemplate);
        return this;
    }

    public final void xo() {
        com.kwad.sdk.service.kwai.h hVar = (com.kwad.sdk.service.kwai.h) ServiceProvider.get(com.kwad.sdk.service.kwai.h.class);
        this.aiI = hVar.pD() ? 1 : 0;
        this.aiJ = hVar.pE();
        this.aiK = hVar.pF();
    }
}
