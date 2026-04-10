package net.oauth;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes9.dex */
public class ConsumerProperties {
    private final Properties consumerProperties;
    private final Map<String, OAuthConsumer> pool;

    public ConsumerProperties(String str, ClassLoader classLoader) throws IOException {
        this(getProperties(getResource(str, classLoader)));
    }

    public static Properties getProperties(URL url) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            Properties properties = new Properties();
            properties.load(inputStreamOpenStream);
            return properties;
        } finally {
            inputStreamOpenStream.close();
        }
    }

    public static URL getResource(String str, ClassLoader classLoader) throws IOException {
        URL resource = classLoader.getResource(str);
        if (resource != null) {
            return resource;
        }
        throw new IOException("resource not found: " + str);
    }

    private String getURL(URL url, String str) throws MalformedURLException {
        String property = this.consumerProperties.getProperty(str);
        return url != null ? new URL(url, property).toExternalForm() : property;
    }

    public OAuthConsumer getConsumer(String str) throws MalformedURLException {
        OAuthConsumer oAuthConsumerNewConsumer;
        synchronized (this.pool) {
            oAuthConsumerNewConsumer = this.pool.get(str);
        }
        if (oAuthConsumerNewConsumer == null) {
            oAuthConsumerNewConsumer = newConsumer(str);
        }
        synchronized (this.pool) {
            OAuthConsumer oAuthConsumer = this.pool.get(str);
            if (oAuthConsumer == null) {
                this.pool.put(str, oAuthConsumerNewConsumer);
            } else {
                oAuthConsumerNewConsumer = oAuthConsumer;
            }
        }
        return oAuthConsumerNewConsumer;
    }

    public OAuthConsumer newConsumer(String str) throws MalformedURLException {
        String property = this.consumerProperties.getProperty(String.valueOf(str) + ".serviceProvider.baseURL");
        URL url = property == null ? null : new URL(property);
        OAuthServiceProvider oAuthServiceProvider = new OAuthServiceProvider(getURL(url, String.valueOf(str) + ".serviceProvider.requestTokenURL"), getURL(url, String.valueOf(str) + ".serviceProvider.userAuthorizationURL"), getURL(url, String.valueOf(str) + ".serviceProvider.accessTokenURL"));
        OAuthConsumer oAuthConsumer = new OAuthConsumer(this.consumerProperties.getProperty(String.valueOf(str) + ".callbackURL"), this.consumerProperties.getProperty(String.valueOf(str) + ".consumerKey"), this.consumerProperties.getProperty(String.valueOf(str) + ".consumerSecret"), oAuthServiceProvider);
        oAuthConsumer.setProperty("name", str);
        if (url != null) {
            oAuthConsumer.setProperty("serviceProvider.baseURL", url);
        }
        for (Map.Entry entry : this.consumerProperties.entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2.startsWith(String.valueOf(str) + ".consumer.")) {
                oAuthConsumer.setProperty(str2.substring(str.length() + 10), entry.getValue());
            }
        }
        return oAuthConsumer;
    }

    public ConsumerProperties(Properties properties) {
        this.pool = new HashMap();
        this.consumerProperties = properties;
    }
}
