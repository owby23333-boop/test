package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.kwai.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SdkConfigData extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final int DEFAULT_CAN_USE_THRESHOLD = 300;
    public static final int DEFAULT_GOOD_IDC_THRESHOLD = 200;
    public static final int DEFAULT_REQUEST_INTERVAL = 3600;
    private static final long serialVersionUID = -7796837168148055391L;
    private JSONObject abConfig;
    private JSONObject adxConfig;
    private JSONObject appConfig;
    private JSONObject mDataJsonObj;
    public long requestInterval = com.anythink.expressad.d.a.b.P;
    public List<com.kwad.sdk.e.kwai.a> h5PreloadConfigs = new ArrayList();
    public TemplateConfig templateConfig = new TemplateConfig();
    public TemplateConfigMap templateConfigMap = new TemplateConfigMap();
    public CouponActiveConfig couponActiveConfig = new CouponActiveConfig();
    public HttpDnsInfo httpDnsInfo = new HttpDnsInfo();
    public int goodIdcThresholdMs = 200;
    public int canUseThresholdMs = 300;

    public static class CouponActiveConfig extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 6375241669684789095L;
        public ActivityInfo activityInfo;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public int popUpShowTimeSeconds;
        public int videoSeconds;
        public int videoThreshold;
        public String title = "抽红包兑奖";
        public String secondTitle = "累计到100元可兑换京东卡";
        public String bottomTitle = "刷满5个视频抽红包，每个视频观看>5秒";
    }

    public static class TemplateConfigMap extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6512236636350788192L;
        public TemplateConfig couponInfoConfig;
        public TemplateConfig couponOpenConfig;
        public TemplateConfig rewardReflowConfig;
    }

    public <T> T getAppConfigData(T t2, com.kwad.sdk.d.b<JSONObject, T> bVar) {
        JSONObject jSONObject = this.appConfig;
        return jSONObject != null ? bVar.apply(jSONObject) : t2;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.mDataJsonObj = new JSONObject(d.getResponseData(jSONObject.optString("data")));
            this.requestInterval = this.mDataJsonObj.optLong("requestInterval");
            this.goodIdcThresholdMs = this.mDataJsonObj.optInt("goodIdcThresholdMs", 200);
            this.canUseThresholdMs = this.mDataJsonObj.optInt("canUseThresholdMs", 300);
            com.kwad.sdk.core.config.b.e(this.mDataJsonObj);
            this.abConfig = this.mDataJsonObj.optJSONObject("abConfig");
            com.kwad.sdk.core.config.b.e(this.abConfig);
            this.adxConfig = this.mDataJsonObj.optJSONObject("adxConfig");
            com.kwad.sdk.core.config.b.e(this.adxConfig);
            this.appConfig = this.mDataJsonObj.optJSONObject("appConfig");
            this.h5PreloadConfigs = s.a(this.mDataJsonObj.optString("h5PreloadConfigs"), new c<com.kwad.sdk.e.kwai.a>() { // from class: com.kwad.sdk.core.response.model.SdkConfigData.1
                private static com.kwad.sdk.e.kwai.a xO() {
                    return new com.kwad.sdk.e.kwai.a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ com.kwad.sdk.core.b uf() {
                    return xO();
                }
            });
            com.kwad.sdk.core.config.b.e(this.appConfig);
            this.templateConfig.parseJson(this.mDataJsonObj.optJSONObject("templateConfig"));
            this.templateConfigMap.parseJson(this.mDataJsonObj.optJSONObject("templateConfigMap"));
            this.couponActiveConfig.parseJson(this.mDataJsonObj.optJSONObject("couponActiveConfig"));
            this.httpDnsInfo.parseJson(this.mDataJsonObj.optJSONObject("httpDnsInfo"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return this.mDataJsonObj;
    }
}
