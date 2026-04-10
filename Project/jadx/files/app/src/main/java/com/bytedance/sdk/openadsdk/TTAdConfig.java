package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TTAdConfig implements AdConfig {
    private boolean b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f14690e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14691h;
    private String hj;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private int f14692io;
    private boolean jb;
    private boolean je;
    private boolean ko;
    private TTCustomController lc;
    private boolean lz;
    private String mb;
    private int nk;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Map<String, Object> f14693o;
    private String ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14694u;
    private boolean ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int[] f14695x;

    public static class Builder {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f14697h;
        private String hj;

        /* JADX INFO: renamed from: io, reason: collision with root package name */
        private int f14698io;
        private TTCustomController lc;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private ITTLiveTokenInjectionAuth f14700m;
        private String mb;
        private String[] nk;
        private String ox;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int[] f14703x;
        private boolean b = false;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f14702u = 0;
        private boolean ko = true;
        private boolean ww = false;
        private boolean lz = false;
        private boolean jb = true;
        private boolean je = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f14701o = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14696e = 2;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f14699l = 0;

        public Builder allowShowNotify(boolean z2) {
            this.ko = z2;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z2) {
            this.lz = z2;
            return this;
        }

        public Builder appId(String str) {
            this.mb = str;
            return this;
        }

        public Builder appName(String str) {
            this.ox = str;
            return this;
        }

        public Builder asyncInit(boolean z2) {
            this.f14701o = z2;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.mb);
            tTAdConfig.setAppName(this.ox);
            tTAdConfig.setPaid(this.b);
            tTAdConfig.setKeywords(this.hj);
            tTAdConfig.setData(this.f14697h);
            tTAdConfig.setTitleBarTheme(this.f14702u);
            tTAdConfig.setAllowShowNotify(this.ko);
            tTAdConfig.setDebug(this.ww);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.lz);
            tTAdConfig.setDirectDownloadNetworkType(this.f14703x);
            tTAdConfig.setUseTextureView(this.jb);
            tTAdConfig.setSupportMultiProcess(this.je);
            tTAdConfig.setNeedClearTaskReset(this.nk);
            tTAdConfig.setAsyncInit(this.f14701o);
            tTAdConfig.setCustomController(this.lc);
            tTAdConfig.setThemeStatus(this.f14698io);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.f14696e));
            tTAdConfig.setExtra(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(this.f14699l));
            tTAdConfig.setInjectionAuth(this.f14700m);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.lc = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.f14697h = str;
            return this;
        }

        public Builder debug(boolean z2) {
            this.ww = z2;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f14703x = iArr;
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.f14700m = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.hj = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.nk = strArr;
            return this;
        }

        public Builder paid(boolean z2) {
            this.b = z2;
            return this;
        }

        public Builder setAgeGroup(int i2) {
            this.f14699l = i2;
            return this;
        }

        public Builder setPluginUpdateConfig(int i2) {
            this.f14696e = i2;
            return this;
        }

        public Builder supportMultiProcess(boolean z2) {
            this.je = z2;
            return this;
        }

        public Builder themeStatus(int i2) {
            this.f14698io = i2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f14702u = i2;
            return this;
        }

        public Builder useTextureView(boolean z2) {
            this.jb = z2;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.ox;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.lc;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f14691h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f14695x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.f14693o.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.f14690e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.hj;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public String[] getNeedClearTaskReset() {
        return new String[0];
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public AdConfig.SdkInfo getSdkInfo() {
        return new AdConfig.SdkInfo() { // from class: com.bytedance.sdk.openadsdk.TTAdConfig.1
            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public boolean isPlugin() {
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String pluginName() {
                return "com.byted.pangle";
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public int sdkVersionCode() {
                return 5102;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "5.1.0.2";
            }
        };
    }

    public int getThemeStatus() {
        return this.f14692io;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f14694u;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.ko;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.lz;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public boolean isAsyncInit() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.ww;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.je;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.jb;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.f14693o.remove(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public void setAgeGroup(int i2) {
        this.f14693o.put(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(i2));
    }

    public void setAllowShowNotify(boolean z2) {
        this.ko = z2;
    }

    public void setAllowShowPageWhenScreenLock(boolean z2) {
        this.lz = z2;
    }

    public void setAppId(String str) {
        this.mb = str;
    }

    public void setAppName(String str) {
        this.ox = str;
    }

    @Deprecated
    public void setAsyncInit(boolean z2) {
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.lc = tTCustomController;
    }

    public void setData(String str) {
        this.f14691h = str;
    }

    public void setDebug(boolean z2) {
        this.ww = z2;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f14695x = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.f14693o.put(str, obj);
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f14690e = iTTLiveTokenInjectionAuth;
    }

    public void setKeywords(String str) {
        this.hj = str;
    }

    @Deprecated
    public void setNeedClearTaskReset(String... strArr) {
    }

    public void setPaid(boolean z2) {
        this.b = z2;
    }

    public void setSupportMultiProcess(boolean z2) {
        this.je = z2;
    }

    public void setThemeStatus(int i2) {
        this.f14692io = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.f14694u = i2;
    }

    public void setUseTextureView(boolean z2) {
        this.jb = z2;
    }

    private TTAdConfig() {
        this.b = false;
        this.f14694u = 0;
        this.ko = true;
        this.ww = false;
        this.lz = false;
        this.jb = true;
        this.je = false;
        this.nk = 0;
        this.f14693o = new HashMap();
        this.f14693o.put("_sdk_is_p_", true);
        this.f14693o.put("_sdk_v_c_", 5102);
        this.f14693o.put("_sdk_v_n_", "5.1.0.2");
        this.f14693o.put("_sdk_p_n_", "com.byted.pangle");
    }
}
