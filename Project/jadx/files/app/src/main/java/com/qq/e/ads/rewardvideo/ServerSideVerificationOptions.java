package com.qq.e.ads.rewardvideo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f17779c;

    public static class Builder {
        private String a;
        private String b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }

        public Builder setCustomData(String str) {
            this.a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(Builder builder) {
        this.f17779c = new JSONObject();
        this.a = builder.a;
        this.b = builder.b;
    }

    public String getCustomData() {
        return this.a;
    }

    public JSONObject getOptions() {
        return this.f17779c;
    }

    public String getUserId() {
        return this.b;
    }
}
