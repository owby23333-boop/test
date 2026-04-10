package com.kwad.sdk.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.IKsAdLabel;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SceneImpl extends com.kwad.sdk.core.response.kwai.a implements KsScene, Serializable, Cloneable {
    private static final long serialVersionUID = 93865491903408451L;
    public int action;
    public int adStyle;
    public String backUrl;
    public String bidResponse;
    public String bidResponseV2;
    public long entryScene;
    public int height;
    public transient a mKsAdLabel;
    public NativeAdExtraDataImpl nativeAdExtraData;
    public long posId;
    public Map<String, String> rewardCallbackExtraData;
    public b splashExtraData;
    public URLPackage urlPackage;
    public int width;
    public int adNum = 1;
    public int screenOrientation = 0;
    public final EcAttribute mEcAttribute = new EcAttribute();

    public SceneImpl() {
    }

    public SceneImpl(long j2) {
        this.posId = j2;
        this.entryScene = j2;
        if (bd.getPosId() != 0) {
            this.posId = bd.getPosId();
        }
    }

    public static SceneImpl covert(KsScene ksScene) {
        if (ksScene instanceof SceneImpl) {
            return (SceneImpl) ksScene;
        }
        SceneImpl sceneImpl = new SceneImpl();
        sceneImpl.posId = ksScene.getPosId();
        sceneImpl.entryScene = ksScene.getPosId();
        sceneImpl.adNum = ksScene.getAdNum();
        sceneImpl.action = ksScene.getAction();
        sceneImpl.width = ksScene.getWidth();
        sceneImpl.height = ksScene.getHeight();
        sceneImpl.adStyle = ksScene.getAdStyle();
        sceneImpl.screenOrientation = getScreenOrientation(ksScene);
        sceneImpl.backUrl = getBackUrl(ksScene);
        sceneImpl.mEcAttribute.setPromoteId(getPromoteId(ksScene));
        sceneImpl.mEcAttribute.setComment(getComment(ksScene));
        sceneImpl.mEcAttribute.setUserCommRateBuying(getUserCommRateBuying(ksScene));
        sceneImpl.mEcAttribute.setUserCommRateSharing(getUserCommRateSharing(ksScene));
        if (bd.getPosId() != 0) {
            sceneImpl.posId = bd.getPosId();
        }
        return sceneImpl;
    }

    public static String getBackUrl(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getBackUrl();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String getComment(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getComment();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String getPromoteId(KsScene ksScene) {
        if (ksScene == null) {
            return "";
        }
        try {
            return ksScene.getPromoteId();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static int getScreenOrientation(KsScene ksScene) {
        try {
            return ksScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static long getUserCommRateBuying(KsScene ksScene) {
        if (ksScene == null) {
            return 0L;
        }
        try {
            return ksScene.getUserCommRateBuying();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long getUserCommRateSharing(KsScene ksScene) {
        if (ksScene == null) {
            return 0L;
        }
        try {
            return ksScene.getUserCommRateSharing();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void register() {
        com.kwad.sdk.service.a.b(KsScene.class, SceneImpl.class);
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.rewardCallbackExtraData = t.parseJSON2MapString(jSONObject.optString("extraData"));
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.putValue(jSONObject, "extraData", t.parseMap2JSON(this.rewardCallbackExtraData));
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SceneImpl m72clone() {
        String string = toJson().toString();
        try {
            SceneImpl sceneImpl = new SceneImpl();
            sceneImpl.parseJson(new JSONObject(string));
            return sceneImpl;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return new SceneImpl();
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAction() {
        return this.action;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdNum() {
        return this.adNum;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getAdStyle() {
        return this.adStyle;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBackUrl() {
        return this.backUrl;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBidResponse() {
        return this.bidResponse;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getBidResponseV2() {
        return this.bidResponseV2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getComment() {
        return this.mEcAttribute.getComment();
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getHeight() {
        return this.height;
    }

    public int getPageScene() {
        URLPackage uRLPackage = this.urlPackage;
        if (uRLPackage == null) {
            return 0;
        }
        return uRLPackage.page;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getPosId() {
        return this.posId;
    }

    @Override // com.kwad.sdk.api.KsScene
    public String getPromoteId() {
        return this.mEcAttribute.getPromoteId();
    }

    @Override // com.kwad.sdk.api.KsScene
    public Map<String, String> getRewardCallbackExtraData() {
        return this.rewardCallbackExtraData;
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getScreenOrientation() {
        return this.screenOrientation;
    }

    public URLPackage getUrlPackage() {
        return this.urlPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateBuying() {
        return this.mEcAttribute.getUserCommRateBuying();
    }

    @Override // com.kwad.sdk.api.KsScene
    public long getUserCommRateSharing() {
        return this.mEcAttribute.getUserCommRateSharing();
    }

    @Override // com.kwad.sdk.api.KsScene
    public int getWidth() {
        return this.width;
    }

    @Keep
    public void needShowMiniWindow(boolean z2) {
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAction(int i2) {
        this.action = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdNum(int i2) {
        this.adNum = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setAdStyle(int i2) {
        this.adStyle = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBackUrl(String str) {
        this.backUrl = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponse(String str) {
        this.bidResponse = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setBidResponseV2(String str) {
        this.bidResponseV2 = str;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setComment(String str) {
        this.mEcAttribute.setComment(str);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setHeight(int i2) {
        this.height = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setKsAdLabel(IKsAdLabel iKsAdLabel) {
        if (iKsAdLabel == null) {
            return;
        }
        this.mKsAdLabel = new a();
        this.mKsAdLabel.aaB = iKsAdLabel.getThirdAge();
        this.mKsAdLabel.aaC = iKsAdLabel.getThirdGender();
        this.mKsAdLabel.aaD = iKsAdLabel.getThirdInterest();
        this.mKsAdLabel.aaE = iKsAdLabel.getPrevTitle();
        this.mKsAdLabel.aaF = iKsAdLabel.getPostTitle();
        this.mKsAdLabel.aaG = iKsAdLabel.getHistoryTitle();
        this.mKsAdLabel.aaH = iKsAdLabel.getChannel();
        this.mKsAdLabel.aaI = iKsAdLabel.getCpmBidFloor();
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setNativeAdExtraData(NativeAdExtraData nativeAdExtraData) {
        if (nativeAdExtraData == null) {
            return;
        }
        this.nativeAdExtraData = new NativeAdExtraDataImpl();
        try {
            this.nativeAdExtraData.enableShake = nativeAdExtraData.isEnableShake();
            this.nativeAdExtraData.showLiveStyle = nativeAdExtraData.getShowLiveStyle();
            this.nativeAdExtraData.showLiveStatus = nativeAdExtraData.getShowLiveStatus();
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPosId(long j2) {
        this.posId = j2;
        this.entryScene = j2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setPromoteId(String str) {
        this.mEcAttribute.setPromoteId(str);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setRewardCallbackExtraData(Map<String, String> map) {
        this.rewardCallbackExtraData = map;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setScreenOrientation(int i2) {
        this.screenOrientation = i2;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setSplashExtraData(SplashAdExtraData splashAdExtraData) {
        if (splashAdExtraData == null) {
            return;
        }
        this.splashExtraData = new b();
        this.splashExtraData.disableShake = splashAdExtraData.getDisableShakeStatus();
        this.splashExtraData.disableSlide = splashAdExtraData.getDisableSlideStatus();
        this.splashExtraData.disableRotate = splashAdExtraData.getDisableRotateStatus();
    }

    public void setUrlPackage(URLPackage uRLPackage) {
        this.urlPackage = uRLPackage;
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateBuying(int i2) {
        this.mEcAttribute.setUserCommRateBuying(i2);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setUserCommRateSharing(int i2) {
        this.mEcAttribute.setUserCommRateSharing(i2);
    }

    @Override // com.kwad.sdk.api.KsScene
    public void setWidth(int i2) {
        this.width = i2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "posId", this.posId);
        t.putValue(jSONObject, "entryScene", this.entryScene);
        t.putValue(jSONObject, "adNum", this.adNum);
        t.putValue(jSONObject, NativeAdvancedJsUtils.f8246p, this.action);
        t.putValue(jSONObject, "width", this.width);
        t.putValue(jSONObject, "height", this.height);
        a aVar = this.mKsAdLabel;
        if (aVar != null) {
            long j2 = aVar.aaI;
            if (j2 != 0) {
                s.putValue(jSONObject, "cpmBidFloor", j2);
            }
        }
        t.putValue(jSONObject, "adStyle", this.adStyle);
        URLPackage uRLPackage = this.urlPackage;
        if (uRLPackage != null) {
            t.putValue(jSONObject, "urlPackage", uRLPackage.toJson());
        }
        t.putValue(jSONObject, "promoteId", this.mEcAttribute.getPromoteId());
        t.putValue(jSONObject, "comment", this.mEcAttribute.getComment());
        t.putValue(jSONObject, "backUrl", this.backUrl);
        t.putValue(jSONObject, "userCommRateBuying", this.mEcAttribute.getUserCommRateBuying());
        t.putValue(jSONObject, "userCommRateSharing", this.mEcAttribute.getUserCommRateSharing());
        t.putValue(jSONObject, "screenOrientation", this.screenOrientation);
        return jSONObject;
    }
}
