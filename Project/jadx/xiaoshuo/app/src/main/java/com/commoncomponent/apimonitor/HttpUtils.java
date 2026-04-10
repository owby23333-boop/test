package com.commoncomponent.apimonitor;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes10.dex */
public class HttpUtils {
    public static boolean checkConnect(String str) throws Throwable {
        int responseCode;
        boolean z;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
            z = true;
        } catch (Exception unused2) {
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            responseCode = -1;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        ApiMonitorManager.getInstance();
        if (ApiMonitorManager.showLog) {
            ApiMonitorManager.getInstance().printLogD("QA_EVENT_NET_MANAGER", "真实网络连通测试  域名:" + str + "  返回码:" + responseCode);
        }
        return z;
    }

    public static String getUrlHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            HttpUrl httpUrl = HttpUrl.get(str);
            if (httpUrl != null) {
                return httpUrl.host();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
