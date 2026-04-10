package com.xiaomi.verificationsdk.internal;

/* JADX INFO: loaded from: classes8.dex */
public class VerifyResult {
    private String scoreData;
    private String token;

    public static class Builder {
        private String scoreData;
        private String token;

        public VerifyResult build() {
            return new VerifyResult(this);
        }

        public Builder scoreData(String str) {
            this.scoreData = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }
    }

    public String getScoreData() {
        return this.scoreData;
    }

    public String getToken() {
        return this.token;
    }

    private VerifyResult(Builder builder) {
        this.token = builder.token;
        this.scoreData = builder.scoreData;
    }
}
