package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.msdk.adapter.config.IGMInitAdnResult;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.Preconditions;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMLiveAuthCallback;
import com.bytedance.msdk.api.v2.GMLiveToken;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.bytedance.msdk.api.v2.IGMLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTLocation;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.tencent.smtt.sdk.TbsListener;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PangleAdapterConfiguration extends TTBaseAdapterConfiguration {
    public static final int ADN_INIT_ERROR_NO_APPID = 1;
    public static final String AD_PLACEMENT_ID_EXTRA_KEY = "ad_placement_id";
    public static final String APP_ID_EXTRA_KEY = "app_id";
    public static final int TT_THEME_STATUS_DAY = 0;
    public static final int TT_THEME_STATUS_NIGHT = 1;
    private boolean a;
    private boolean b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IGMLiveTokenInjectionAuth f13952e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<InitCallback> f13950c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GMPrivacyConfig f13951d = new GMPrivacyConfig();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TTCustomController f13953f = new TTCustomController() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.3
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            return PangleAdapterConfiguration.this.f13951d.appList();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevImei() {
            return PangleAdapterConfiguration.this.f13951d.getDevImei();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            return PangleAdapterConfiguration.this.f13951d.getDevOaid();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getMacAddress() {
            return PangleAdapterConfiguration.this.f13951d.getMacAddress();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public LocationProvider getTTLocation() {
            if (PangleAdapterConfiguration.this.f13951d.getTTLocation() != null) {
                return new TTLocation(PangleAdapterConfiguration.this.f13951d.getTTLocation().getLatitude(), PangleAdapterConfiguration.this.f13951d.getTTLocation().getLongitude());
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseAndroidId() {
            Logger.d("TMe", "--==-- 穿山甲获取的isCanUseAndroidId: " + PangleAdapterConfiguration.this.f13951d.isCanUseAndroidId());
            return PangleAdapterConfiguration.this.f13951d.isCanUseAndroidId();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            return PangleAdapterConfiguration.this.f13951d.isCanUseLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            return PangleAdapterConfiguration.this.f13951d.isCanUsePhoneState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            return PangleAdapterConfiguration.this.f13951d.isCanUseWifiState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            return PangleAdapterConfiguration.this.f13951d.isCanUseWriteExternal();
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TTAdSdk.InitCallback f13954g = new TTAdSdk.InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.4
        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            PangleAdapterConfiguration.this.a(i2, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            PangleAdapterConfiguration.this.a();
        }
    };

    /* JADX INFO: renamed from: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a = new int[GMAdConstant.ADULT_STATE.values().length];

        static {
            try {
                a[GMAdConstant.ADULT_STATE.AGE_15.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GMAdConstant.ADULT_STATE.AGE_18.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GMAdConstant.ADULT_STATE.AGE_ADULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface InitCallback {
        void fail(int i2, String str);

        void success();
    }

    private TTAdConfig a(Context context, String str, Map<String, Object> map) {
        Boolean bool = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_USE_TEXTURE_VIEW);
        boolean z2 = bool != null && bool.booleanValue();
        String str2 = (String) map.get(TTBaseAdapterConfiguration.PANGLE_APP_NAME);
        Boolean bool2 = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_PAID);
        boolean z3 = bool2 != null && bool2.booleanValue();
        Integer num = (Integer) map.get(TTBaseAdapterConfiguration.PANGLE_TITLE_BAR_THEME);
        Boolean bool3 = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_NOTIFY);
        boolean z4 = bool3 != null && bool3.booleanValue();
        Boolean bool4 = (Boolean) map.get(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_PAGE_WHEN_SCREEN_LOCK);
        boolean z5 = bool4 != null && bool4.booleanValue();
        int[] iArr = (int[]) map.get(TTBaseAdapterConfiguration.PANGLE_DIRECT_DOWNLOAD_NETWORKTYPE);
        c();
        String[] strArr = (String[]) map.get(TTBaseAdapterConfiguration.PANGLE_NEED_CLEAR_TASK_RESET);
        String str3 = (String) map.get(TTBaseAdapterConfiguration.PANGLE_KEYWORDS);
        Integer num2 = (Integer) map.get(TTBaseAdapterConfiguration.PANGLE_PLUGIN_UPDATE_CONFIG);
        TTAdConfig.Builder builderDebug = new TTAdConfig.Builder().appId(str).useTextureView(z2).appName(str2).paid(z3).titleBarTheme(num == null ? 0 : num.intValue()).allowShowNotify(z4).allowShowPageWhenScreenLock(z5).debug(Logger.isDebug());
        if (iArr == null) {
            iArr = new int[0];
        }
        TTAdConfig.Builder builderData = builderDebug.directDownloadNetworkType(iArr).supportMultiProcess(false).data(PangleAdapterUtils.getPangleDataAndExtraData().toString());
        if (strArr == null) {
            strArr = new String[0];
        }
        TTAdConfig.Builder builderCustomController = builderData.needClearTaskReset(strArr).customController(this.f13953f);
        if (str3 == null) {
            str3 = "";
        }
        TTAdConfig.Builder ageGroup = builderCustomController.keywords(str3).setPluginUpdateConfig(num2 == null ? 2 : num2.intValue()).setAgeGroup(b());
        a(ageGroup);
        return ageGroup.build();
    }

    private String a(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (TextUtils.isEmpty(str)) {
                    jSONArray = new JSONArray();
                } else {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                }
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString("name"))) {
                            jSONObjectOptJSONObject.put("value", str3);
                            z2 = true;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (!z2) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", str2);
                    jSONObject.put("value", str3);
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        for (InitCallback initCallback : this.f13950c) {
            if (initCallback != null) {
                initCallback.success();
            }
        }
        this.f13950c.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        for (InitCallback initCallback : this.f13950c) {
            if (initCallback != null) {
                initCallback.fail(i2, str);
            }
        }
        this.f13950c.clear();
        this.b = true;
        this.a = false;
    }

    private void a(Context context, String str, Map<String, Object> map, InitCallback initCallback) {
        this.f13950c.add(initCallback);
        try {
            a(context, map, str);
        } catch (Throwable th) {
            synchronized (PangleAdapterConfiguration.class) {
                this.a = false;
                this.b = false;
                th.printStackTrace();
            }
        }
    }

    private void a(Context context, Map<String, Object> map, final IGMInitAdnResult iGMInitAdnResult, String str) {
        b(context, str, map, new InitCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.1
            @Override // com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.InitCallback
            public void fail(int i2, String str2) {
                PangleAdapterConfiguration.this.setInitedSuccess(false);
                IGMInitAdnResult iGMInitAdnResult2 = iGMInitAdnResult;
                if (iGMInitAdnResult2 != null) {
                    iGMInitAdnResult2.fail(new AdError(i2, str2));
                }
            }

            @Override // com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.InitCallback
            public void success() {
                PangleAdapterConfiguration.this.setInitedSuccess(true);
                IGMInitAdnResult iGMInitAdnResult2 = iGMInitAdnResult;
                if (iGMInitAdnResult2 != null) {
                    iGMInitAdnResult2.success();
                }
            }
        });
    }

    private void a(Context context, Map<String, Object> map, String str) {
        synchronized (PangleAdapterConfiguration.class) {
            if (this.a) {
                if (TTAdSdk.isInitSuccess()) {
                    a();
                } else if (this.b) {
                    a(AdError.ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, "pangle");
                }
            } else {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a = true;
                TTAdSdk.init(context, a(context, str, map), this.f13954g);
            }
        }
    }

    private void a(TTAdConfig.Builder builder) {
        try {
            if (this.f13952e != null) {
                builder.injectionAuth(new ITTLiveTokenInjectionAuth() { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.2
                    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
                    public TTLiveToken getTokenInfo() {
                        GMLiveToken tokenInfo;
                        if (PangleAdapterConfiguration.this.f13952e == null || (tokenInfo = PangleAdapterConfiguration.this.f13952e.getTokenInfo()) == null) {
                            return null;
                        }
                        return new TTLiveToken(tokenInfo.name, tokenInfo.accessToken, tokenInfo.openId, tokenInfo.expireAt, tokenInfo.refreshToken);
                    }

                    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
                    public boolean isLogin() {
                        if (PangleAdapterConfiguration.this.f13952e != null) {
                            return PangleAdapterConfiguration.this.f13952e.isLogin();
                        }
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth
                    public void onTokenInvalid(TTLiveToken tTLiveToken, final TTLiveAuthCallback tTLiveAuthCallback, Activity activity, Map<String, String> map) {
                        if (PangleAdapterConfiguration.this.f13952e != null) {
                            PangleAdapterConfiguration.this.f13952e.onTokenInvalid(tTLiveToken != null ? new GMLiveToken(tTLiveToken.name, tTLiveToken.accessToken, tTLiveToken.openId, tTLiveToken.expireAt, tTLiveToken.refreshToken) : null, tTLiveAuthCallback != null ? new GMLiveAuthCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.2.1
                                @Override // com.bytedance.msdk.api.v2.GMLiveAuthCallback
                                public void onAuth(GMLiveToken gMLiveToken) {
                                    if (gMLiveToken != null) {
                                        tTLiveAuthCallback.onAuth(new TTLiveToken(gMLiveToken.name, gMLiveToken.accessToken, gMLiveToken.openId, gMLiveToken.expireAt, gMLiveToken.refreshToken));
                                    }
                                }

                                @Override // com.bytedance.msdk.api.v2.GMLiveAuthCallback
                                public void onFailed(Throwable th) {
                                    tTLiveAuthCallback.onFailed(th);
                                }
                            } : null, activity, map);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private int[] a(int i2, AdSlot adSlot) {
        switch (i2) {
            case 1:
                return new int[]{TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, 50};
            case 2:
                return new int[]{TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, 100};
            case 3:
                return new int[]{300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION};
            case 4:
                return new int[]{468, 60};
            case 5:
                return new int[]{728, 90};
            case 6:
                if (adSlot.getImgAcceptedWidth() > 0 && adSlot.getImgAcceptedHeight() > 0) {
                    return new int[]{adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()};
                }
                if (adSlot.getImgAcceptedWidth() > 0 && adSlot.getImgAcceptedHeight() < 0) {
                    return new int[]{adSlot.getImgAcceptedWidth(), 0};
                }
                break;
        }
        return new int[]{TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, 50};
    }

    private int b() {
        GMPrivacyConfig gMPrivacyConfig = this.f13951d;
        if (gMPrivacyConfig != null) {
            int i2 = AnonymousClass5.a[gMPrivacyConfig.getAgeGroup().ordinal()];
            if (i2 == 1) {
                return 2;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 0;
            }
        }
        return 0;
    }

    private void b(Context context, String str, Map<String, Object> map, InitCallback initCallback) {
        if (!TextUtils.isEmpty(str) && context != null) {
            a(context, str, map, initCallback);
        } else if (initCallback != null) {
            initCallback.fail(1, "Invalid Pangle app ID");
        }
    }

    private void c() {
        PangleAdapterUtils.setPangleData(a(PangleAdapterUtils.getPangleData(), "personal_ads_type", this.f13951d.isLimitPersonalAds() ? "0" : "1"));
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdNetworkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getAdapterVersion() {
        return "5.0.0.4.0";
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01b4, code lost:
    
        if (r2.getImgAcceptedHeight() > 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01b6, code lost:
    
        r0 = r2.getImgAcceptedWidth();
        r6 = r2.getImgAcceptedHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0122, code lost:
    
        if (r2.getImgAcceptedHeight() > 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x014d, code lost:
    
        if (r2.getImgAcceptedHeight() > 0) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getBiddingToken(android.content.Context r17, java.util.Map<java.lang.String, java.lang.Object> r18) {
        /*
            Method dump skipped, instruction units count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleAdapterConfiguration.getBiddingToken(android.content.Context, java.util.Map):java.lang.String");
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public Map<String, Object> getBiddingTokenMap(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getGroMoreSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getNetworkSdkPluginVersion() {
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return "";
        }
        try {
            return adManager.getPluginVersion();
        } catch (Throwable unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public String getNetworkSdkVersion() {
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return "";
        }
        try {
            return adManager.getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    @Override // com.bytedance.msdk.adapter.config.IGMInitAdn
    public void initAdn(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull IGMInitAdnResult iGMInitAdnResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(iGMInitAdnResult);
        synchronized (PangleAdapterConfiguration.class) {
            if (isInitedSuccess() && iGMInitAdnResult != null) {
                iGMInitAdnResult.success();
                return;
            }
            if (!isInitedSuccess() && map != null && !map.isEmpty()) {
                try {
                    String str = (String) map.get("app_id");
                    Logger.i("TTMediationSDK_SDK_Init", "init Pangle SDK start......appId:" + str);
                    a(context, map, iGMInitAdnResult, str);
                } catch (Exception unused) {
                    if (iGMInitAdnResult != null) {
                        iGMInitAdnResult.fail(new AdError("configuration is empty"));
                    }
                }
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public boolean isNewInitFunction() {
        return true;
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setInjectionAuth(IGMLiveTokenInjectionAuth iGMLiveTokenInjectionAuth) {
        this.f13952e = iGMLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
        if (gMPrivacyConfig != null) {
            this.f13951d = gMPrivacyConfig;
            c();
        }
    }

    @Override // com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration, com.bytedance.msdk.adapter.config.ITTAdapterConfiguration
    public void setThemeStatus(Map<String, Object> map) {
        super.setThemeStatus(map);
        if (map == null) {
            return;
        }
        Object obj = map.get(TTBaseAdapterConfiguration.TT_MSDK_THEME_STATUS);
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (iIntValue == 0 || iIntValue == 1) {
            TTAdSdk.getAdManager().setThemeStatus(iIntValue);
        }
    }
}
