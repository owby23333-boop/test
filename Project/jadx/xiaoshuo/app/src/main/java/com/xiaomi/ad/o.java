package com.xiaomi.ad;

import android.text.TextUtils;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.common.util.TimeUtils;
import com.xiaomi.ad.i;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public class o implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7281a = TimeUtils.ONE_SECOND_IN_MS * 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7282b = o.class.getSimpleName();

    @Override // com.xiaomi.ad.h
    public j a(i iVar) {
        return a(iVar, f7281a);
    }

    public j a(i iVar, int i) throws Throwable {
        try {
            HttpURLConnection httpURLConnectionA = a(iVar.a());
            if (httpURLConnectionA == null) {
                MLog.w(f7282b, "HttpUrlConnection is null");
                return null;
            }
            List<k> listB = iVar.b();
            if (listB != null) {
                for (k kVar : listB) {
                    httpURLConnectionA.setRequestProperty(kVar.a(), kVar.b());
                }
            }
            httpURLConnectionA.setRequestMethod(iVar.d() == i.a.GET ? "GET" : "POST");
            if (iVar.d() == i.a.POST) {
                a(httpURLConnectionA, iVar);
            }
            httpURLConnectionA.setConnectTimeout(i);
            httpURLConnectionA.setReadTimeout(i);
            httpURLConnectionA.connect();
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode != 200) {
                return new j(responseCode, 0L, null);
            }
            InputStream inputStream = httpURLConnectionA.getInputStream();
            if (!TextUtils.isEmpty(httpURLConnectionA.getContentEncoding())) {
                String lowerCase = httpURLConnectionA.getContentEncoding().toLowerCase(Locale.getDefault());
                if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains("gzip")) {
                    inputStream = new GZIPInputStream(httpURLConnectionA.getInputStream());
                }
            }
            return new j(responseCode, httpURLConnectionA.getContentLength(), inputStream);
        } catch (Exception e) {
            MLog.e(f7282b, "performRequest", e);
            return null;
        }
    }

    private HttpURLConnection a(String str) {
        try {
            return str.startsWith("https") ? (HttpsURLConnection) new URL(str).openConnection() : (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection, i iVar) throws Throwable {
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                httpURLConnection.setDoOutput(true);
                List<k> listF = iVar.f();
                if (listF != null && listF.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < listF.size(); i++) {
                        k kVar = listF.get(i);
                        if (kVar != null && !TextUtils.isEmpty(kVar.a()) && !TextUtils.isEmpty(kVar.b())) {
                            sb.append(URLEncoder.encode(kVar.a(), "UTF8"));
                            sb.append(MscKeys.KEY_VAL_SEP);
                            sb.append(URLEncoder.encode(kVar.b(), "UTF8"));
                            sb.append(com.alipay.sdk.m.w.a.p);
                        }
                    }
                    if (sb.length() > 0) {
                        sb = sb.deleteCharAt(sb.length() - 1);
                    }
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(httpURLConnection.getOutputStream());
                    try {
                        outputStreamWriter2.write(sb.toString());
                        outputStreamWriter2.flush();
                        outputStreamWriter = outputStreamWriter2;
                    } catch (Exception e) {
                        e = e;
                        outputStreamWriter = outputStreamWriter2;
                        MLog.e(f7282b, "post", e);
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        f.a(outputStreamWriter);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        f.a(outputStreamWriter);
    }
}
