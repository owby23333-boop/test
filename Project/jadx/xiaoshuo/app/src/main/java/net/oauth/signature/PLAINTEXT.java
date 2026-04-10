package net.oauth.signature;

import kotlin.text.Typography;
import net.oauth.OAuth;
import net.oauth.OAuthException;

/* JADX INFO: loaded from: classes9.dex */
class PLAINTEXT extends OAuthSignatureMethod {
    private String signature = null;

    @Override // net.oauth.signature.OAuthSignatureMethod
    public String getSignature(String str) {
        return getSignature();
    }

    @Override // net.oauth.signature.OAuthSignatureMethod
    public boolean isValid(String str, String str2) throws OAuthException {
        return OAuthSignatureMethod.equals(getSignature(), str);
    }

    @Override // net.oauth.signature.OAuthSignatureMethod
    public void setConsumerSecret(String str) {
        synchronized (this) {
            this.signature = null;
        }
        super.setConsumerSecret(str);
    }

    @Override // net.oauth.signature.OAuthSignatureMethod
    public void setTokenSecret(String str) {
        synchronized (this) {
            this.signature = null;
        }
        super.setTokenSecret(str);
    }

    private synchronized String getSignature() {
        if (this.signature == null) {
            this.signature = String.valueOf(OAuth.percentEncode(getConsumerSecret())) + Typography.amp + OAuth.percentEncode(getTokenSecret());
        }
        return this.signature;
    }
}
