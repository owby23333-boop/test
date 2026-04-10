package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import cn.bmob.v3.datatype.up.ParallelUploader;
import com.anythink.expressad.foundation.g.f.g.c;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static class mb {
        public int b;
        public HttpURLConnection hj;
        public InputStream mb;
        public Map<String, String> ox;

        public mb(InputStream inputStream, Map<String, String> map, int i2, HttpURLConnection httpURLConnection) {
            this.mb = inputStream;
            this.ox = map;
            this.b = i2;
            this.hj = httpURLConnection;
        }
    }

    public static HttpURLConnection mb(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty(ParallelUploader.Params.ACCEPT, "*/*");
                httpURLConnection.setRequestProperty("connection", c.f10570c);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? mb(httpURLConnection.getHeaderField("Location"), map) : httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Map<String, String> mb(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i2 = 0; i2 < size; i2++) {
            map.put(httpURLConnection.getHeaderFieldKey(i2), httpURLConnection.getHeaderField(i2));
        }
        return map;
    }

    public static mb mb(String str, List<HttpHeader> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (HttpHeader httpHeader : list) {
                map.put(httpHeader.getName(), httpHeader.getValue());
            }
        }
        HttpURLConnection httpURLConnectionMb = mb(str, map);
        if (httpURLConnectionMb == null || (responseCode = httpURLConnectionMb.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapMb = mb(httpURLConnectionMb);
        InputStream inputStream = httpURLConnectionMb.getInputStream();
        String contentEncoding = httpURLConnectionMb.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new mb(inputStream, mapMb, responseCode, httpURLConnectionMb);
    }
}
