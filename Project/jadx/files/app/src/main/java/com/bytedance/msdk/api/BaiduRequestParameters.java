package com.bytedance.msdk.api;

import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    private final String a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f14073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14076f;

    public static class Builder {
        private String a;
        private Map<String, String> b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14077c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f14078d = 640;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14079e = 480;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f14080f = 1;

        public final Builder addExtra(String str, String str2) {
            if (ArticleInfo.PAGE_TITLE.equals(str)) {
                this.b.put(IAdInterListener.AdReqParam.MPT, String.valueOf(1));
            }
            this.b.put(str, str2);
            return this;
        }

        public final BaiduRequestParameters build() {
            return new BaiduRequestParameters(this);
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z2) {
            downloadAppConfirmPolicy(z2 ? 2 : 3);
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i2) {
            this.f14080f = i2;
            return this;
        }

        public final Builder setHeight(int i2) {
            this.f14079e = i2;
            return this;
        }

        public final Builder setKeywords(String str) {
            this.a = str;
            return this;
        }

        public final Builder setWidth(int i2) {
            this.f14078d = i2;
            return this;
        }
    }

    private BaiduRequestParameters(Builder builder) {
        this.f14074d = 0;
        this.f14075e = 0;
        this.a = builder.a;
        this.f14074d = builder.f14078d;
        this.f14075e = builder.f14079e;
        this.b = builder.f14077c;
        this.f14076f = builder.f14080f;
        setExtras(builder.b);
    }

    public int getAPPConfirmPolicy() {
        return this.f14076f;
    }

    public Map<String, String> getExtras() {
        return this.f14073c;
    }

    public int getHeight() {
        return this.f14075e;
    }

    public final String getKeywords() {
        return this.a;
    }

    public int getWidth() {
        return this.f14074d;
    }

    public boolean isConfirmDownloading() {
        return this.b;
    }

    public void setExtras(Map<String, String> map) {
        this.f14073c = map;
    }

    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("mKeywords", this.a);
        map.put("confirmDownloading", Boolean.valueOf(this.b));
        HashMap map2 = new HashMap();
        Map<String, String> map3 = this.f14073c;
        if (map3 != null) {
            for (Map.Entry<String, String> entry : map3.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        map.put("extras", map2);
        return map;
    }
}
