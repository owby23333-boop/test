package com.bytedance.msdk.api;

import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class TTAdConfig {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f14115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f14118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f14119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f14120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Map<String, String> f14121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f14122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f14123p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Set<String> f14124q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, Map<String, String>> f14125r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map<String, Map<String, String>> f14126s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private UserInfoForSegment f14127t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private GMPrivacyConfig f14129v;

    public static class Builder {

        @Deprecated
        private String a;

        @Deprecated
        private String b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Deprecated
        private int[] f14135h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Deprecated
        private String[] f14137j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Deprecated
        private String f14138k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @Deprecated
        private boolean f14140m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Deprecated
        private String f14141n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @Deprecated
        private String f14143p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Set<String> f14144q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Map<String, Map<String, String>> f14145r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Map<String, Map<String, String>> f14146s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Deprecated
        private UserInfoForSegment f14147t;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private GMPrivacyConfig f14149v;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        private boolean f14130c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        private boolean f14131d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        private int f14132e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        private boolean f14133f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        private boolean f14134g = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        private boolean f14136i = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Deprecated
        private boolean f14139l = true;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @Deprecated
        private Map<String, String> f14142o = new HashMap();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Deprecated
        private int f14148u = 2;

        @Deprecated
        public Builder allowPangleShowNotify(boolean z2) {
            this.f14133f = z2;
            return this;
        }

        @Deprecated
        public Builder allowPangleShowPageWhenScreenLock(boolean z2) {
            this.f14134g = z2;
            return this;
        }

        @Deprecated
        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        @Deprecated
        public Builder appName(String str) {
            this.b = str;
            return this;
        }

        @Deprecated
        public TTAdConfig build() {
            return new TTAdConfig(this);
        }

        @Deprecated
        public Builder data(String str) {
            this.f14141n = str;
            return this;
        }

        @Deprecated
        public Builder data(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f14142o.put(str, str2);
            }
            return this;
        }

        @Deprecated
        public Builder dataMap(Map<String, String> map) {
            if (map != null && map.size() > 0) {
                this.f14142o.putAll(map);
            }
            return this;
        }

        @Deprecated
        public Builder isPanglePaid(boolean z2) {
            this.f14131d = z2;
            return this;
        }

        @Deprecated
        public Builder needPangleClearTaskReset(String... strArr) {
            this.f14137j = strArr;
            return this;
        }

        @Deprecated
        public Builder openAdnTest(boolean z2) {
            this.f14140m = z2;
            return this;
        }

        @Deprecated
        public Builder openDebugLog(boolean z2) {
            this.f14130c = z2;
            return this;
        }

        public Builder setBaiduSdkReadDeviceId(boolean z2) {
            this.f14139l = z2;
            return this;
        }

        @Deprecated
        public Builder setKeywords(String str) {
            this.f14143p = str;
            return this;
        }

        @Deprecated
        public Builder setPangleDirectDownloadNetworkType(int... iArr) {
            this.f14135h = iArr;
            return this;
        }

        @Deprecated
        public Builder setPangleTitleBarTheme(int i2) {
            this.f14132e = i2;
            return this;
        }

        public Builder setPrivacyConfig(GMPrivacyConfig gMPrivacyConfig) {
            this.f14149v = gMPrivacyConfig;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.f14138k = str;
            return this;
        }

        @Deprecated
        public Builder setUserInfoForSegment(UserInfoForSegment userInfoForSegment) {
            this.f14147t = userInfoForSegment;
            return this;
        }

        @Deprecated
        public Builder usePangleTextureView(boolean z2) {
            this.f14136i = z2;
            return this;
        }
    }

    private TTAdConfig(Builder builder) {
        this.f14110c = false;
        this.f14111d = false;
        this.f14112e = null;
        this.f14114g = 0;
        this.f14116i = true;
        this.f14117j = false;
        this.f14119l = false;
        this.f14122o = true;
        this.f14128u = 2;
        this.a = builder.a;
        this.b = builder.b;
        this.f14110c = builder.f14130c;
        this.f14111d = builder.f14131d;
        this.f14112e = builder.f14138k;
        this.f14113f = builder.f14140m;
        this.f14114g = builder.f14132e;
        this.f14115h = builder.f14137j;
        this.f14116i = builder.f14133f;
        this.f14117j = builder.f14134g;
        this.f14118k = builder.f14135h;
        this.f14119l = builder.f14136i;
        this.f14120m = builder.f14141n;
        this.f14121n = builder.f14142o;
        this.f14123p = builder.f14143p;
        this.f14124q = builder.f14144q;
        this.f14125r = builder.f14145r;
        this.f14126s = builder.f14146s;
        this.f14122o = builder.f14139l;
        this.f14127t = builder.f14147t;
        this.f14128u = builder.f14148u;
        this.f14129v = builder.f14149v;
    }

    public boolean allowBaiduSdkReadDeviceId() {
        return this.f14122o;
    }

    public Set<String> getAdapterConfigurationClasses() {
        Set<String> set = this.f14124q;
        if (set != null) {
            return Collections.unmodifiableSet(set);
        }
        return null;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppName() {
        return this.b;
    }

    public Map<String, String> getExtraData() {
        return this.f14121n;
    }

    public Map<String, Map<String, String>> getMediatedNetworkConfigurations() {
        Map<String, Map<String, String>> map = this.f14125r;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    @Deprecated
    public String getPangleData() {
        return this.f14120m;
    }

    public int[] getPangleDirectDownloadNetworkType() {
        return this.f14118k;
    }

    public String getPangleKeywords() {
        return this.f14123p;
    }

    public String[] getPangleNeedClearTaskReset() {
        return this.f14115h;
    }

    public int getPanglePluginUpdateConfig() {
        return this.f14128u;
    }

    public int getPangleTitleBarTheme() {
        return this.f14114g;
    }

    public GMPrivacyConfig getPrivacyConfig() {
        return this.f14129v;
    }

    public String getPublisherDid() {
        return this.f14112e;
    }

    public Map<String, Map<String, String>> getRequestOptions() {
        Map<String, Map<String, String>> map = this.f14126s;
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }

    public UserInfoForSegment getUserInfoForSegment() {
        return this.f14127t;
    }

    public boolean isDebug() {
        return this.f14110c;
    }

    public boolean isOpenAdnTest() {
        return this.f14113f;
    }

    public boolean isPangleAllowShowNotify() {
        return this.f14116i;
    }

    public boolean isPangleAllowShowPageWhenScreenLock() {
        return this.f14117j;
    }

    public boolean isPanglePaid() {
        return this.f14111d;
    }

    public boolean isPangleUseTextureView() {
        return this.f14119l;
    }
}
