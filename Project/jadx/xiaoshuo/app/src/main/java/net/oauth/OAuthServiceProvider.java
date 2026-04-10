package net.oauth;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class OAuthServiceProvider implements Serializable {
    private static final long serialVersionUID = 3306534392621038574L;
    public final String accessTokenURL;
    public final String requestTokenURL;
    public final String userAuthorizationURL;

    public OAuthServiceProvider(String str, String str2, String str3) {
        this.requestTokenURL = str;
        this.userAuthorizationURL = str2;
        this.accessTokenURL = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OAuthServiceProvider oAuthServiceProvider = (OAuthServiceProvider) obj;
        String str = this.accessTokenURL;
        if (str == null) {
            if (oAuthServiceProvider.accessTokenURL != null) {
                return false;
            }
        } else if (!str.equals(oAuthServiceProvider.accessTokenURL)) {
            return false;
        }
        String str2 = this.requestTokenURL;
        if (str2 == null) {
            if (oAuthServiceProvider.requestTokenURL != null) {
                return false;
            }
        } else if (!str2.equals(oAuthServiceProvider.requestTokenURL)) {
            return false;
        }
        String str3 = this.userAuthorizationURL;
        if (str3 == null) {
            if (oAuthServiceProvider.userAuthorizationURL != null) {
                return false;
            }
        } else if (!str3.equals(oAuthServiceProvider.userAuthorizationURL)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.accessTokenURL;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.requestTokenURL;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userAuthorizationURL;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
