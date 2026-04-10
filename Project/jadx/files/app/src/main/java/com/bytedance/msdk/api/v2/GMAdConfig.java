package com.bytedance.msdk.api.v2;

import androidx.annotation.NonNull;
import com.bytedance.msdk.api.v2.GMBaiduOption;
import com.bytedance.msdk.api.v2.GMGdtOption;
import com.bytedance.msdk.api.v2.GMPangleOption;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GMAdConfig {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GMPangleOption f14176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GMGdtOption f14177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GMBaiduOption f14178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GMConfigUserInfoForSegment f14179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private GMPrivacyConfig f14180j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, Object> f14181k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f14182l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14183m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private JSONObject f14184n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private IGMLiveTokenInjectionAuth f14185o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map<String, Object> f14186p;

    public static class Builder {
        private String a;
        private String b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private GMPangleOption f14190f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private GMGdtOption f14191g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private GMBaiduOption f14192h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private GMConfigUserInfoForSegment f14193i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private GMPrivacyConfig f14194j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Map<String, Object> f14195k;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private JSONObject f14198n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private IGMLiveTokenInjectionAuth f14199o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Map<String, Object> f14200p;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14187c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f14188d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f14189e = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f14196l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f14197m = false;

        public GMAdConfig build() {
            return new GMAdConfig(this);
        }

        public Builder injectionAuth(IGMLiveTokenInjectionAuth iGMLiveTokenInjectionAuth) {
            this.f14199o = iGMLiveTokenInjectionAuth;
            return this;
        }

        public Builder setAppId(String str) {
            this.a = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.b = str;
            return this;
        }

        public Builder setBaiduOption(@NonNull GMBaiduOption gMBaiduOption) {
            this.f14192h = gMBaiduOption;
            return this;
        }

        public Builder setConfigUserInfoForSegment(@NonNull GMConfigUserInfoForSegment gMConfigUserInfoForSegment) {
            this.f14193i = gMConfigUserInfoForSegment;
            return this;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.f14198n = jSONObject;
            return this;
        }

        public Builder setDebug(boolean z2) {
            this.f14187c = z2;
            return this;
        }

        public Builder setGdtOption(@NonNull GMGdtOption gMGdtOption) {
            this.f14191g = gMGdtOption;
            return this;
        }

        public Builder setGroMoreExtra(Map<String, Object> map) {
            this.f14200p = map;
            return this;
        }

        public Builder setHttps(boolean z2) {
            this.f14196l = z2;
            return this;
        }

        public Builder setIsOpenPangleCustom(boolean z2) {
            this.f14197m = z2;
            return this;
        }

        public Builder setLocalExtra(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                this.f14195k = new HashMap();
                this.f14195k.putAll(map);
            }
            return this;
        }

        public Builder setOpenAdnTest(boolean z2) {
            this.f14189e = z2;
            return this;
        }

        public Builder setPangleOption(@NonNull GMPangleOption gMPangleOption) {
            this.f14190f = gMPangleOption;
            return this;
        }

        public Builder setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
            this.f14194j = gMPrivacyConfig;
            return this;
        }

        public Builder setPublisherDid(@NonNull String str) {
            this.f14188d = str;
            return this;
        }
    }

    private GMAdConfig(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.f14173c = builder.f14187c;
        this.f14174d = builder.f14188d;
        this.f14175e = builder.f14189e;
        this.f14176f = builder.f14190f != null ? builder.f14190f : new GMPangleOption.Builder().build();
        this.f14177g = builder.f14191g != null ? builder.f14191g : new GMGdtOption.Builder().build();
        this.f14178h = builder.f14192h != null ? builder.f14192h : new GMBaiduOption.Builder().build();
        this.f14179i = builder.f14193i != null ? builder.f14193i : new GMConfigUserInfoForSegment();
        this.f14180j = builder.f14194j;
        this.f14181k = builder.f14195k;
        this.f14182l = builder.f14196l;
        this.f14183m = builder.f14197m;
        this.f14184n = builder.f14198n;
        this.f14185o = builder.f14199o;
        this.f14186p = builder.f14200p;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppName() {
        return this.b;
    }

    public JSONObject getCutstomLocalConfig() {
        return this.f14184n;
    }

    public GMBaiduOption getGMBaiduOption() {
        return this.f14178h;
    }

    @NonNull
    public GMConfigUserInfoForSegment getGMConfigUserInfoForSegment() {
        return this.f14179i;
    }

    @NonNull
    public GMGdtOption getGMGdtOption() {
        return this.f14177g;
    }

    @NonNull
    public GMPangleOption getGMPangleOption() {
        return this.f14176f;
    }

    public IGMLiveTokenInjectionAuth getGmLiveTokenInjectionAuth() {
        return this.f14185o;
    }

    public Map<String, Object> getGromoreExtra() {
        return this.f14186p;
    }

    public Map<String, Object> getLocalExtra() {
        return this.f14181k;
    }

    public GMPrivacyConfig getPrivacyConfig() {
        return this.f14180j;
    }

    public String getPublisherDid() {
        return this.f14174d;
    }

    public boolean isDebug() {
        return this.f14173c;
    }

    public boolean isHttps() {
        return this.f14182l;
    }

    public boolean isOpenAdnTest() {
        return this.f14175e;
    }

    public boolean isOpenPangleCustom() {
        return this.f14183m;
    }
}
