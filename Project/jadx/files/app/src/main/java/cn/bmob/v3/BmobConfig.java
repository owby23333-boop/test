package cn.bmob.v3;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class BmobConfig {
    public String applicationId;
    public long connectTimeout;
    public Context context;
    public long fileExpiration;
    public int uploadBlockSize;

    public static final class Builder {
        private String applicationId;
        private long connectTimeout;
        private Context context;
        private long fileExpiration;
        private int uploadBlockSize;

        public Builder(Context context) {
            this.context = context;
        }

        public BmobConfig build() {
            return new BmobConfig(this);
        }

        public Builder setApplicationId(String str) {
            this.applicationId = str;
            return this;
        }

        public Builder setConnectTimeout(long j2) {
            this.connectTimeout = j2;
            return this;
        }

        public Builder setFileExpiration(long j2) {
            this.fileExpiration = j2;
            return this;
        }

        public Builder setUploadBlockSize(int i2) {
            this.uploadBlockSize = i2;
            return this;
        }
    }

    private BmobConfig(Builder builder) {
        this.context = builder.context;
        this.applicationId = builder.applicationId;
        this.connectTimeout = builder.connectTimeout;
        this.uploadBlockSize = builder.uploadBlockSize;
        this.fileExpiration = builder.fileExpiration;
    }
}
