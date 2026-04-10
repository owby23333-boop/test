package net.oauth;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class OAuthConsumer implements Serializable {
    public static final String ACCEPT_ENCODING = "HTTP.header.Accept-Encoding";
    public static final String ACCESSOR_SECRET = "oauth_accessor_secret";
    private static final long serialVersionUID = -2258581186977818580L;
    public final String callbackURL;
    public final String consumerKey;
    public final String consumerSecret;
    private final Map<String, Object> properties = new HashMap();
    public final OAuthServiceProvider serviceProvider;

    public OAuthConsumer(String str, String str2, String str3, OAuthServiceProvider oAuthServiceProvider) {
        this.callbackURL = str;
        this.consumerKey = str2;
        this.consumerSecret = str3;
        this.serviceProvider = oAuthServiceProvider;
    }

    public Object getProperty(String str) {
        return this.properties.get(str);
    }

    public void setProperty(String str, Object obj) {
        this.properties.put(str, obj);
    }
}
