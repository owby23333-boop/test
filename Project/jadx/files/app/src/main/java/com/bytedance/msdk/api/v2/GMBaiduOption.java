package com.bytedance.msdk.api.v2;

/* JADX INFO: loaded from: classes2.dex */
public class GMBaiduOption {
    private String a;

    public static class Builder {
        private String a;

        public GMBaiduOption build() {
            return new GMBaiduOption(this);
        }

        public Builder setWxAppId(String str) {
            this.a = str;
            return this;
        }
    }

    private GMBaiduOption(Builder builder) {
        this.a = builder.a;
    }

    public String getWxAppId() {
        return this.a;
    }
}
