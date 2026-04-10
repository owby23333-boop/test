package com.xiaomi.accountsdk.guestaccount;

import com.google.common.net.HttpHeaders;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.accountsdk.guestaccount.GuestAccountHttpRequester;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class GuestAccountHttpRequesterImplDefault implements GuestAccountHttpRequester {
    private static final String BODY_STRING_SPLIT = "&";
    private static final String COOKIE_STRING_SPLIT = "; ";
    private static final int DEFAULT_CONNECT_TIME_OUT = 15000;
    private static final int DEFAULT_READ_TIME_OUT = 15000;

    public static String joinMap(Map<String, String> map, String str) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(str);
                }
                sb.append(key);
                sb.append(MscKeys.KEY_VAL_SEP);
                sb.append(value);
            }
        }
        return sb.toString();
    }

    @Override // com.xiaomi.accountsdk.guestaccount.GuestAccountHttpRequester
    public GuestAccountHttpRequester.Response get(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("url == null");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader = null;
            if (responseCode != 200) {
                return new GuestAccountHttpRequester.Response(responseCode, null, null, null);
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()), 1024);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    HashMap map = new HashMap();
                    CookieManager cookieManager = new CookieManager();
                    URI uriCreate = URI.create(str);
                    cookieManager.put(uriCreate, httpURLConnection.getHeaderFields());
                    for (HttpCookie httpCookie : cookieManager.getCookieStore().get(uriCreate)) {
                        map.put(httpCookie.getName(), httpCookie.getValue());
                    }
                    GuestAccountHttpRequester.Response response = new GuestAccountHttpRequester.Response(responseCode, sb.toString(), httpURLConnection.getHeaderField(GuestAccountHttpRequester.HEADER_KEY_EXTENSION_PRAGMA), map);
                    bufferedReader2.close();
                    return response;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.xiaomi.accountsdk.guestaccount.GuestAccountHttpRequester
    public GuestAccountHttpRequester.Response post(String str, Map<String, String> map, Map<String, String> map2) throws IOException {
        BufferedReader bufferedReader;
        if (str == null) {
            throw new IllegalArgumentException("url == null");
        }
        if (map == null) {
            throw new IllegalArgumentException("params == null");
        }
        if (map2 == null) {
            throw new IllegalArgumentException("cookies == null");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HttpHeaders.COOKIE, joinMap(map2, COOKIE_STRING_SPLIT));
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(joinMap(map, "&"));
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader2 = null;
            if (responseCode != 200) {
                return new GuestAccountHttpRequester.Response(responseCode, null, null, map2);
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()), 1024);
            } catch (Throwable th) {
                th = th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        GuestAccountHttpRequester.Response response = new GuestAccountHttpRequester.Response(responseCode, sb.toString(), httpURLConnection.getHeaderField(GuestAccountHttpRequester.HEADER_KEY_EXTENSION_PRAGMA), map2);
                        bufferedReader.close();
                        return response;
                    }
                    sb.append(line);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }
}
