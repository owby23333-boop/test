package net.oauth.signature;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;
import net.oauth.OAuth;
import net.oauth.OAuthException;

/* JADX INFO: loaded from: classes9.dex */
class HMAC_SHA1 extends OAuthSignatureMethod {
    private static final String ENCODING = "UTF-8";
    private static final String MAC_NAME = "HmacSHA1";
    private SecretKey key = null;

    private byte[] computeSignature(String str) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKey secretKey;
        synchronized (this) {
            if (this.key == null) {
                this.key = new SecretKeySpec((String.valueOf(OAuth.percentEncode(getConsumerSecret())) + Typography.amp + OAuth.percentEncode(getTokenSecret())).getBytes("UTF-8"), MAC_NAME);
            }
            secretKey = this.key;
        }
        Mac mac = Mac.getInstance(MAC_NAME);
        mac.init(secretKey);
        return mac.doFinal(str.getBytes("UTF-8"));
    }

    @Override // net.oauth.signature.OAuthSignatureMethod
    public String getSignature(String str) throws OAuthException {
        try {
            return OAuthSignatureMethod.base64Encode(computeSignature(str));
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException(e);
        } catch (GeneralSecurityException e2) {
            throw new OAuthException(e2);
        }
    }

    @Override // net.oauth.signature.OAuthSignatureMethod
    public boolean isValid(String str, String str2) throws OAuthException {
        try {
            return OAuthSignatureMethod.equals(computeSignature(str2), OAuthSignatureMethod.decodeBase64(str));
        } catch (UnsupportedEncodingException e) {
            throw new OAuthException(e);
        } catch (GeneralSecurityException e2) {
            throw new OAuthException(e2);
        }
    }

    @Override // net.oauth.signature.OAuthSignatureMethod
    public void setConsumerSecret(String str) {
        synchronized (this) {
            this.key = null;
        }
        super.setConsumerSecret(str);
    }

    @Override // net.oauth.signature.OAuthSignatureMethod
    public void setTokenSecret(String str) {
        synchronized (this) {
            this.key = null;
        }
        super.setTokenSecret(str);
    }
}
