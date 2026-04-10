package net.oauth;

/* JADX INFO: loaded from: classes9.dex */
public class OAuthException extends Exception {
    private static final long serialVersionUID = 1;

    public OAuthException() {
    }

    public OAuthException(String str) {
        super(str);
    }

    public OAuthException(Throwable th) {
        super(th);
    }

    public OAuthException(String str, Throwable th) {
        super(str, th);
    }
}
