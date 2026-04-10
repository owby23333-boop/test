package com.bytedance.sdk.openadsdk.core.kb.a;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public static HttpURLConnection z(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("connection", HttpHeaders.KEEP_ALIVE);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? z(httpURLConnection2.getHeaderField(HttpHeaders.LOCATION), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> z(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            map.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return map;
    }

    public static z z(String str, List<com.ss.android.socialbase.downloader.e.gc> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.e.gc gcVar : list) {
                map.put(gcVar.z(), gcVar.g());
            }
        }
        HttpURLConnection httpURLConnectionZ = z(str, map);
        if (httpURLConnectionZ == null || (responseCode = httpURLConnectionZ.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapZ = z(httpURLConnectionZ);
        InputStream inputStream = httpURLConnectionZ.getInputStream();
        String contentEncoding = httpURLConnectionZ.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains(Constants.CP_GZIP)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new z(inputStream, mapZ, responseCode, httpURLConnectionZ);
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpURLConnection f1215a;
        public int dl;
        public Map<String, String> g;
        public InputStream z;

        public z(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.z = inputStream;
            this.g = map;
            this.dl = i;
            this.f1215a = httpURLConnection;
        }
    }
}
