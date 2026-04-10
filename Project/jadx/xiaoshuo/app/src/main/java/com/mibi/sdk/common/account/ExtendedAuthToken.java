package com.mibi.sdk.common.account;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public class ExtendedAuthToken {
    private static final String SP = ",";
    public final String authToken;
    public final String security;

    private ExtendedAuthToken(String str, String str2) {
        this.authToken = str;
        this.security = str2;
    }

    public static ExtendedAuthToken build(String str, String str2) {
        return new ExtendedAuthToken(str, str2);
    }

    public static ExtendedAuthToken parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length != 2 || TextUtils.isEmpty(strArrSplit[0]) || TextUtils.isEmpty(strArrSplit[1])) {
            return null;
        }
        return new ExtendedAuthToken(strArrSplit[0], strArrSplit[1]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExtendedAuthToken extendedAuthToken = (ExtendedAuthToken) obj;
            String str = this.authToken;
            if (str != null) {
                if (!str.equals(extendedAuthToken.authToken)) {
                    return false;
                }
            } else if (extendedAuthToken.authToken != null) {
                return false;
            }
            String str2 = this.security;
            if (str2 != null) {
                if (str2.equals(extendedAuthToken.security)) {
                    return true;
                }
            } else if (extendedAuthToken.security == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.authToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.security;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toPlain() {
        return this.authToken + "," + this.security;
    }
}
