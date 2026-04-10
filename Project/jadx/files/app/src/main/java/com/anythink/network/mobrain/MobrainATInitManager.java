package com.anythink.network.mobrain;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.MediationInitCallback;
import com.bytedance.msdk.api.v2.GMAdConfig;
import com.bytedance.msdk.api.v2.GMLocation;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.GMPangleOption;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.bytedance.msdk.api.v2.GMSettingConfigCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATInitManager extends ATInitMediation {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12541g = "MobrainATInitManager";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile MobrainATInitManager f12542k;
    boolean a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    GMAdConfig.Builder f12543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    GMPrivacyConfig f12544d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12547h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12548i;
    GMAdConfig.Builder b = new GMAdConfig.Builder();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12546f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Handler f12545e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f12549j = new a(this, 0);

    public interface InitCallback {
        void onError(String str);

        void onSuccess();
    }

    private MobrainATInitManager() {
    }

    public static MobrainATInitManager getInstance() {
        if (f12542k == null) {
            synchronized (MobrainATInitManager.class) {
                if (f12542k == null) {
                    f12542k = new MobrainATInitManager();
                }
            }
        }
        return f12542k;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkName() {
        return "Gromore";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkSDKClass() {
        return "com.bytedance.msdk.api.v2.GMMediationAdSdk";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public String getNetworkVersion() {
        return GMMediationAdSdk.getSdkVersion();
    }

    @Override // com.anythink.core.api.ATInitMediation
    public synchronized void initSDK(Context context, Map<String, Object> map, final MediationInitCallback mediationInitCallback) {
        boolean z2;
        final String str = (String) map.get("app_id");
        final Context applicationContext = context.getApplicationContext();
        try {
            z2 = this.f12546f != ATSDK.getPersionalizedAdStatus();
            try {
                this.f12546f = ATSDK.getPersionalizedAdStatus();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z2 = true;
        }
        if (this.a && !TextUtils.isEmpty(this.f12547h) && TextUtils.equals(this.f12547h, str)) {
            if (GMMediationAdSdk.configLoadSuccess()) {
                if (z2) {
                    GMPrivacyConfig gMPrivacyConfigB = b();
                    GMMediationAdSdk.updatePrivacyConfig(gMPrivacyConfigB);
                    if (ATSDK.isNetworkLogDebug()) {
                        String str2 = "GMPrivacyConfig.isLimitPersonalAds:" + gMPrivacyConfigB.isLimitPersonalAds();
                    }
                } else if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb = new StringBuilder("GMPrivacyConfig.isLimitPersonalAds:");
                    sb.append(this.f12546f == 2);
                    sb.toString();
                }
                if (mediationInitCallback != null) {
                    mediationInitCallback.onSuccess();
                    return;
                }
            } else {
                if (z2) {
                    GMPrivacyConfig gMPrivacyConfigB2 = b();
                    GMMediationAdSdk.updatePrivacyConfig(gMPrivacyConfigB2);
                    if (ATSDK.isNetworkLogDebug()) {
                        String str3 = "GMPrivacyConfig.isLimitPersonalAds:" + gMPrivacyConfigB2.isLimitPersonalAds();
                    }
                } else if (ATSDK.isNetworkLogDebug()) {
                    StringBuilder sb2 = new StringBuilder("GMPrivacyConfig.isLimitPersonalAds:");
                    sb2.append(this.f12546f == 2);
                    sb2.toString();
                }
                this.f12549j.addListener(mediationInitCallback);
                if (!this.f12548i) {
                    this.f12548i = true;
                    GMMediationAdSdk.registerConfigCallback(this.f12549j);
                }
            }
            return;
        }
        try {
            this.a = true;
            final int[] iArr = {1, 2, 3, 4, 5};
            this.f12545e.post(new Runnable() { // from class: com.anythink.network.mobrain.MobrainATInitManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    GMPrivacyConfig gMPrivacyConfigB3 = MobrainATInitManager.this.b();
                    GMAdConfig.Builder builder = MobrainATInitManager.this.f12543c;
                    if (builder != null) {
                        builder.setAppId(str);
                        MobrainATInitManager.this.f12543c.setPrivacyConfig(gMPrivacyConfigB3);
                    }
                    MobrainATInitManager.this.b.setAppId(str).setAppName(applicationContext.getPackageManager().getApplicationLabel(applicationContext.getApplicationInfo()).toString()).setDebug(ATSDK.isNetworkLogDebug()).setPrivacyConfig(gMPrivacyConfigB3).setPangleOption(new GMPangleOption.Builder().setTitleBarTheme(1).setDirectDownloadNetworkType(iArr).setIsUseTextureView(true).setAllowShowNotify(true).setAllowShowPageWhenScreenLock(true).build());
                    if (ATSDK.isNetworkLogDebug()) {
                        String unused3 = MobrainATInitManager.f12541g;
                        String str4 = "GMPrivacyConfig.isLimitPersonalAds:" + gMPrivacyConfigB3.isLimitPersonalAds();
                    }
                    MobrainATInitManager.this.f12549j.addListener(mediationInitCallback);
                    GMMediationAdSdk.registerConfigCallback(MobrainATInitManager.this.f12549j);
                    MobrainATInitManager.this.f12547h = str;
                    MobrainATInitManager.this.f12548i = true;
                    Context context2 = applicationContext;
                    MobrainATInitManager mobrainATInitManager = MobrainATInitManager.this;
                    GMAdConfig.Builder builder2 = mobrainATInitManager.f12543c;
                    GMMediationAdSdk.initialize(context2, builder2 != null ? builder2.build() : mobrainATInitManager.b.build());
                }
            });
        } catch (Throwable th) {
            if (mediationInitCallback != null) {
                mediationInitCallback.onFail(th.getMessage());
            }
        }
    }

    public void setCustomBuilder(GMAdConfig.Builder builder) {
        this.f12543c = builder;
    }

    public void setGMPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
        this.f12544d = gMPrivacyConfig;
    }

    private class a implements GMSettingConfigCallback {
        private List<MediationInitCallback> b;

        private a() {
            this.b = new ArrayList(5);
        }

        public final void addListener(MediationInitCallback mediationInitCallback) {
            synchronized (MobrainATInitManager.this) {
                if (this.b != null) {
                    this.b.add(mediationInitCallback);
                }
            }
        }

        @Override // com.bytedance.msdk.api.v2.GMSettingConfigCallback
        public final void configLoad() {
            try {
                synchronized (MobrainATInitManager.this) {
                    if (this.b != null) {
                        int size = this.b.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            MediationInitCallback mediationInitCallback = this.b.get(i2);
                            if (mediationInitCallback != null) {
                                mediationInitCallback.onSuccess();
                            }
                        }
                        MobrainATInitManager.this.f12548i = false;
                        this.b.clear();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* synthetic */ a(MobrainATInitManager mobrainATInitManager, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GMPrivacyConfig b() {
        return new GMPrivacyConfig() { // from class: com.anythink.network.mobrain.MobrainATInitManager.2
            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final boolean appList() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.appList() : super.appList();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final String getDevImei() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.getDevImei() : super.getDevImei();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final String getDevOaid() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.getDevOaid() : super.getDevOaid();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final String getMacAddress() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.getMacAddress() : super.getMacAddress();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final GMLocation getTTLocation() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.getTTLocation() : super.getTTLocation();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final boolean isCanUseLocation() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.isCanUseLocation() : super.isCanUseLocation();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final boolean isCanUsePhoneState() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.isCanUsePhoneState() : super.isCanUsePhoneState();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final boolean isCanUseWifiState() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.isCanUseWifiState() : super.isCanUseWifiState();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final boolean isCanUseWriteExternal() {
                GMPrivacyConfig gMPrivacyConfig = MobrainATInitManager.this.f12544d;
                return gMPrivacyConfig != null ? gMPrivacyConfig.isCanUseWriteExternal() : super.isCanUseWriteExternal();
            }

            @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
            public final boolean isLimitPersonalAds() {
                return MobrainATInitManager.this.f12546f == 2;
            }
        };
    }
}
