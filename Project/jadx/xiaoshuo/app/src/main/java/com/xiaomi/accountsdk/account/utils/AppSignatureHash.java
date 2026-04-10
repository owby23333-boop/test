package com.xiaomi.accountsdk.account.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class AppSignatureHash {

    @SerializedName("md5")
    @Expose
    public final String md5;

    @SerializedName("sha1")
    @Expose
    public final String sha1;

    public static final class Builder {
        private String md5;
        private String sha1;

        public AppSignatureHash build() {
            return new AppSignatureHash(this);
        }

        public Builder md5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder sha1(String str) {
            this.sha1 = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSignatureHash)) {
            return false;
        }
        AppSignatureHash appSignatureHash = (AppSignatureHash) obj;
        String str = this.sha1;
        if (str == null ? appSignatureHash.sha1 != null : !str.equals(appSignatureHash.sha1)) {
            return false;
        }
        String str2 = this.md5;
        String str3 = appSignatureHash.md5;
        if (str2 != null) {
            if (str2.equals(str3)) {
                return true;
            }
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.sha1;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.md5;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AppSignatureHash{");
        stringBuffer.append("sha1='");
        stringBuffer.append(this.sha1);
        stringBuffer.append('\'');
        stringBuffer.append(", md5='");
        stringBuffer.append(this.md5);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    private AppSignatureHash(Builder builder) {
        this.sha1 = builder.sha1;
        this.md5 = builder.md5;
    }
}
