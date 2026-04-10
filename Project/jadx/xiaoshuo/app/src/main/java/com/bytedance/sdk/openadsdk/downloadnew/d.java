package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes10.dex */
public class d {

    public static class e {
        public Map<String, String> bf;
        public int d;
        public InputStream e;
        public HttpURLConnection tg;

        public e(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.e = inputStream;
            this.bf = map;
            this.d = i;
            this.tg = httpURLConnection;
        }
    }

    public static HttpURLConnection e(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? e(httpURLConnection2.getHeaderField("Location"), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> e(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            map.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return map;
    }

    public static e e(String str, List<com.ss.android.socialbase.downloader.model.d> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.d dVar : list) {
                map.put(dVar.e(), dVar.bf());
            }
        }
        HttpURLConnection httpURLConnectionE = e(str, map);
        if (httpURLConnectionE == null || (responseCode = httpURLConnectionE.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapE = e(httpURLConnectionE);
        InputStream inputStream = httpURLConnectionE.getInputStream();
        String contentEncoding = httpURLConnectionE.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new e(inputStream, mapE, responseCode, httpURLConnectionE);
    }
}
