package com.kwad.sdk.i;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.umeng.umcrash.UMCrash;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int aTe;

    public interface a {
        void onSuccess();
    }

    l() {
    }

    public static void a(List<k> list, a aVar) {
        if (aTe > 10) {
            j.ak("LogReportUtil", "request error");
            return;
        }
        g gVarNh = h.Nd().Nh();
        Map<String, String> requestHeader = gVarNh.getRequestHeader();
        JSONObject jSONObjectNc = gVarNh.Nc();
        c.putValue(jSONObjectNc, "actionList", list);
        c.putValue(jSONObjectNc, UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis());
        a(gVarNh.Nb(), requestHeader, a(requestHeader, jSONObjectNc), aVar);
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.Nd().Nh().Na()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static String c(Map<String, String> map, String str) {
        g gVarNh = h.Nd().Nh();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, "version", gVarNh.getSdkVersion());
        c.putValue(jSONObject, "appId", gVarNh.getAppId());
        c.putValue(jSONObject, "message", com.kwad.sdk.i.a.as(str));
        com.kwad.sdk.i.a.a(gVarNh.Nb(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) throws Throwable {
        Closeable closeable;
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                httpURLConnection2.setUseCaches(false);
                setConnectionHeader(httpURLConnection2, map);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.flush();
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    String strInputStream2String = inputStream2String(httpURLConnection2.getInputStream());
                    j.No();
                    if (!TextUtils.isEmpty(strInputStream2String) && new JSONObject(strInputStream2String).optInt("result") == 1) {
                        aTe = 0;
                        aVar.onSuccess();
                    } else {
                        aTe++;
                        j.No();
                    }
                } else {
                    aTe++;
                    j.No();
                }
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(outputStream);
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                closeable = null;
                try {
                    aTe++;
                    j.Nn();
                    j.closeQuietly(httpURLConnection);
                    j.closeQuietly(closeable);
                } catch (Throwable th) {
                    th = th;
                    j.closeQuietly(httpURLConnection);
                    j.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                closeable = null;
                j.closeQuietly(httpURLConnection);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception unused2) {
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static String c(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String strA = a(bufferedReader);
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            return strA;
        } catch (Throwable th4) {
            th = th4;
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    private static String a(Reader reader) throws Throwable {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th2) {
            stringWriter = stringWriter2;
            th = th2;
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                int i = reader.read(cArr);
                if (i != -1) {
                    stringWriter.write(cArr, 0, i);
                } else {
                    String string = stringWriter.toString();
                    j.closeQuietly(reader);
                    j.closeQuietly(stringWriter);
                    return string;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            j.closeQuietly(reader);
            j.closeQuietly(stringWriter);
            throw th;
        }
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            try {
                return c(inputStream);
            } catch (IOException unused) {
                j.Nn();
                j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            j.closeQuietly(inputStream);
        }
    }
}
