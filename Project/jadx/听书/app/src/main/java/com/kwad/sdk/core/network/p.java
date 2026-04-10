package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class p {
    private static String aFj = "";
    private static String aFk = "";

    public static String Hz() {
        try {
            if (!TextUtils.isEmpty(aFj)) {
                return aFj;
            }
            String property = System.getProperty("http.agent");
            aFj = property;
            if (TextUtils.isEmpty(property)) {
                return aFj;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = aFj.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = aFj.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    stringBuffer.append(cCharAt);
                }
            }
            String string = stringBuffer.toString();
            aFj = string;
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String getDefaultUserAgent() {
        return Hz() + "-ksad-android-4.6.30.1";
    }

    public static String getUserAgent() {
        String userAgent = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
        return TextUtils.isEmpty(userAgent) ? getDefaultUserAgent() : userAgent;
    }

    public static String HA() {
        String strDa;
        if (!TextUtils.isEmpty(aFk)) {
            return aFk;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            strDa = ag.da(context);
            aFk = strDa;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strDa)) {
            return aFk;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        aFk = defaultUserAgent;
        String strEncode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        aFk = strEncode;
        ag.al(context, strEncode);
        return aFk;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", HA());
        httpURLConnection.setRequestProperty("SystemUa", Hz());
    }
}
