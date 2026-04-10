package com.kwad.sdk.core.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.x;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    private static String agH = "";
    private static String agI = "";

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", wt());
        httpURLConnection.setRequestProperty("SystemUa", ws());
    }

    public static String getDefaultUserAgent() {
        return ws() + "-ksad-android-3.3.38";
    }

    public static String getUserAgent() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).getUserAgent();
    }

    public static String ws() {
        if (!TextUtils.isEmpty(agH)) {
            return agH;
        }
        String property = System.getProperty("http.agent");
        agH = property;
        if (TextUtils.isEmpty(property)) {
            return agH;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = agH.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = agH.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        String string = stringBuffer.toString();
        agH = string;
        return string;
    }

    public static String wt() {
        String strCj;
        if (!TextUtils.isEmpty(agI)) {
            return agI;
        }
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            strCj = x.cj(context);
            agI = strCj;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(strCj)) {
            return agI;
        }
        agI = Build.VERSION.SDK_INT >= 17 ? WebSettings.getDefaultUserAgent(context) : System.getProperty("http.agent");
        agI = URLEncoder.encode(agI, "UTF-8");
        x.Z(context, agI);
        return agI;
    }
}
