package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class TTAdConfig implements AdConfig {
    private String bf;
    private int bh;
    private boolean d;
    private String e;
    private String ga;
    private ITTLiveTokenInjectionAuth l;
    private int[] m;
    private boolean p;
    private TTCustomController s;
    private Map<String, Object> t;
    private String tg;
    private boolean v;
    private int vn;
    private int w;
    private boolean wu;
    private boolean xu;
    private boolean zk;

    public static class Builder {
        private String bf;
        private String[] bh;
        private String e;
        private String ga;
        private ITTLiveTokenInjectionAuth k;
        private int[] m;
        private TTCustomController s;
        private String tg;
        private int w;
        private boolean d = false;
        private int vn = 0;
        private boolean p = true;
        private boolean v = false;
        private boolean zk = false;
        private boolean wu = true;
        private boolean xu = false;
        private boolean t = false;
        private int l = 2;
        private int f = 0;

        public Builder allowShowNotify(boolean z) {
            this.p = z;
            return this;
        }

        @Deprecated
        public Builder allowShowPageWhenScreenLock(boolean z) {
            this.zk = z;
            return this;
        }

        public Builder appId(String str) {
            this.e = str;
            return this;
        }

        public Builder appName(String str) {
            this.bf = str;
            return this;
        }

        public Builder asyncInit(boolean z) {
            this.t = z;
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig();
            tTAdConfig.setAppId(this.e);
            tTAdConfig.setAppName(this.bf);
            tTAdConfig.setPaid(this.d);
            tTAdConfig.setKeywords(this.tg);
            tTAdConfig.setData(this.ga);
            tTAdConfig.setTitleBarTheme(this.vn);
            tTAdConfig.setAllowShowNotify(this.p);
            tTAdConfig.setDebug(this.v);
            tTAdConfig.setAllowShowPageWhenScreenLock(this.zk);
            tTAdConfig.setDirectDownloadNetworkType(this.m);
            tTAdConfig.setUseTextureView(this.wu);
            tTAdConfig.setSupportMultiProcess(this.xu);
            tTAdConfig.setNeedClearTaskReset(this.bh);
            tTAdConfig.setAsyncInit(this.t);
            tTAdConfig.setCustomController(this.s);
            tTAdConfig.setThemeStatus(this.w);
            tTAdConfig.setExtra("plugin_update_conf", Integer.valueOf(this.l));
            tTAdConfig.setExtra(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(this.f));
            tTAdConfig.setInjectionAuth(this.k);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.s = tTCustomController;
            return this;
        }

        public Builder data(String str) {
            this.ga = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.v = z;
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.m = iArr;
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.k = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.tg = str;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.bh = strArr;
            return this;
        }

        public Builder paid(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.f = i;
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.l = i;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.xu = z;
            return this;
        }

        public Builder themeStatus(int i) {
            this.w = i;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.vn = i;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.wu = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.ga;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return this.t.get(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.tg;
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
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String pluginName() {
                return "com.byted.pangle";
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public int sdkVersionCode() {
                return 5438;
            }

            @Override // com.bytedance.sdk.openadsdk.AdConfig.SdkInfo
            public String sdkVersionName() {
                return "5.4.3.8";
            }
        };
    }

    public int getThemeStatus() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.vn;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowPageWhenScreenLock() {
        return this.zk;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public boolean isAsyncInit() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.xu;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.wu;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object removeExtra(String str) {
        return this.t.remove(str);
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public void setAgeGroup(int i) {
        this.t.put(TTAdConstant.KEY_AGE_GROUP, Integer.valueOf(i));
    }

    public void setAllowShowNotify(boolean z) {
        this.p = z;
    }

    public void setAllowShowPageWhenScreenLock(boolean z) {
        this.zk = z;
    }

    public void setAppId(String str) {
        this.e = str;
    }

    public void setAppName(String str) {
        this.bf = str;
    }

    @Deprecated
    public void setAsyncInit(boolean z) {
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.s = tTCustomController;
    }

    public void setData(String str) {
        this.ga = str;
    }

    public void setDebug(boolean z) {
        this.v = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.m = iArr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public void setExtra(String str, Object obj) {
        this.t.put(str, obj);
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.l = iTTLiveTokenInjectionAuth;
    }

    public void setKeywords(String str) {
        this.tg = str;
    }

    @Deprecated
    public void setNeedClearTaskReset(String... strArr) {
    }

    public void setPaid(boolean z) {
        this.d = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.xu = z;
    }

    public void setThemeStatus(int i) {
        this.w = i;
    }

    public void setTitleBarTheme(int i) {
        this.vn = i;
    }

    public void setUseTextureView(boolean z) {
        this.wu = z;
    }

    private TTAdConfig() {
        this.d = false;
        this.vn = 0;
        this.p = true;
        this.v = false;
        this.zk = false;
        this.wu = true;
        this.xu = false;
        this.bh = 0;
        HashMap map = new HashMap();
        this.t = map;
        map.put("_sdk_is_p_", Boolean.FALSE);
        this.t.put("_sdk_v_c_", 5438);
        this.t.put("_sdk_v_n_", "5.4.3.8");
        this.t.put("_sdk_p_n_", "com.byted.pangle");
    }
}
