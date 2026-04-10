package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.z;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean WV = true;
    ImpInfo Rw;
    private int WU;

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    private a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, null);
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.Rw, aVar.Xe, aVar.Xf, aVar.Xh);
        this.WU = aVar.Xg ? 1 : 0;
    }

    public a(ImpInfo impInfo, List<String> list, boolean z, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.Rw = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.II(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i = this.WU;
        if (i > 0) {
            putBody("calledUnionType", i);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String strEi = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)).Ei() : "";
        if (!TextUtils.isEmpty(strEi)) {
            putBody("universeDebugParam", strEi);
        }
        String strD = d(impInfo);
        if (!TextUtils.isEmpty(strD)) {
            putBody("sdkDebugReqInfo", strD);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z);
        }
        putBody("appTag", ag.Qy());
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.Rw.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g gVarIP = com.kwad.sdk.core.request.model.g.IP();
        if (rewardCallbackExtraByKey != null) {
            gVarIP.ex(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(gVarIP, adLabelFromAdScene);
        }
        putBody("userInfo", gVarIP);
        if (com.kwad.components.ad.f.a.oy.booleanValue()) {
            try {
                com.kwad.sdk.components.a aVar = (com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
                if (aVar != null) {
                    putBody("adBrowseParam", aVar.Eh());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        if (adLabelImpl.thirdAge != 0) {
            gVar.thirdAge = adLabelImpl.thirdAge;
        }
        if (adLabelImpl.thirdGender != 0) {
            gVar.thirdGender = adLabelImpl.thirdGender;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        gVar.thirdInterest = adLabelImpl.thirdInterest;
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            aa.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            aa.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            aa.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            aa.putValue(jSONObject2, "channel", adLabelImpl.channel);
        }
        aa.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }

    private static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void aU(int i) {
        this.WU = i;
    }

    public final int getAdNum() {
        return this.Rw.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        if (com.kwad.components.ad.f.a.oy.booleanValue()) {
            try {
                if (((com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class)) != null) {
                    return com.kwad.sdk.h.AZ();
                }
            } catch (Throwable unused) {
            }
        }
        return com.kwad.sdk.h.AL();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.Rw;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    private static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (WV && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) z.callMethodOrThrow(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                WV = false;
            }
        }
        return "";
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        s.cb(true);
        b.sj().sk();
        super.onCreate();
    }
}
