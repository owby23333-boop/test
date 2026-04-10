package net.oauth;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class OAuthAccessor implements Cloneable, Serializable {
    private static final long serialVersionUID = 5590788443138352999L;
    public final OAuthConsumer consumer;
    private final Map<String, Object> properties = new HashMap();
    public String requestToken = null;
    public String accessToken = null;
    public String tokenSecret = null;

    public OAuthAccessor(OAuthConsumer oAuthConsumer) {
        this.consumer = oAuthConsumer;
    }

    public Object getProperty(String str) {
        return this.properties.get(str);
    }

    public OAuthMessage newRequestMessage(String str, String str2, Collection<? extends Map.Entry> collection, InputStream inputStream) throws OAuthException, URISyntaxException, IOException {
        if (str == null) {
            String str3 = (String) getProperty("httpMethod");
            if (str3 == null) {
                str = (String) this.consumer.getProperty("httpMethod");
                if (str == null) {
                    str = "GET";
                }
            } else {
                str = str3;
            }
        }
        OAuthMessage oAuthMessage = new OAuthMessage(str, str2, collection, inputStream);
        oAuthMessage.addRequiredParameters(this);
        return oAuthMessage;
    }

    public void setProperty(String str, Object obj) {
        this.properties.put(str, obj);
    }

    public OAuthAccessor clone() {
        try {
            return (OAuthAccessor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public OAuthMessage newRequestMessage(String str, String str2, Collection<? extends Map.Entry> collection) throws OAuthException, URISyntaxException, IOException {
        return newRequestMessage(str, str2, collection, null);
    }
}
