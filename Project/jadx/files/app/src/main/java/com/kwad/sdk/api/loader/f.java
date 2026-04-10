package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import com.taobao.accs.common.Constants;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final v Zm;
    private int Zn;
    private String Zo;
    private final String mUrl;

    public interface a {
        void a(a.b bVar);
    }

    f(v vVar) {
        this.Zm = vVar;
        this.mUrl = this.Zm.tK();
        this.Zo = this.mUrl;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.InputStream r5) throws java.lang.Throwable {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
        La:
            int r3 = r5.read(r0)     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L4c
            r4 = -1
            if (r3 == r4) goto L16
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L4c
            goto La
        L16:
            java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> L2d java.lang.Throwable -> L4c
            if (r5 == 0) goto L24
            r5.close()     // Catch: java.io.IOException -> L20
            goto L24
        L20:
            r5 = move-exception
            r5.printStackTrace()
        L24:
            r2.close()     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            r5 = move-exception
            r5.printStackTrace()
        L2c:
            return r0
        L2d:
            r0 = move-exception
            goto L34
        L2f:
            r0 = move-exception
            r2 = r1
            goto L4d
        L32:
            r0 = move-exception
            r2 = r1
        L34:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L41
            r5.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r5 = move-exception
            r5.printStackTrace()
        L41:
            if (r2 == 0) goto L4b
            r2.close()     // Catch: java.io.IOException -> L47
            goto L4b
        L47:
            r5 = move-exception
            r5.printStackTrace()
        L4b:
            return r1
        L4c:
            r0 = move-exception
        L4d:
            if (r5 == 0) goto L57
            r5.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r5 = move-exception
            r5.printStackTrace()
        L57:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.io.IOException -> L5d
            goto L61
        L5d:
            r5 = move-exception
            r5.printStackTrace()
        L61:
            goto L63
        L62:
            throw r0
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.f.a(java.io.InputStream):java.lang.String");
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static HttpURLConnection aR(String str) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    private String c(Map<String, String> map) {
        String strAy = g.ay(this.Zm.getContext());
        if (TextUtils.isEmpty(strAy)) {
            strAy = this.Zm.tL().getSDKVersion();
        }
        int sDKVersionCode = this.Zm.tL().getSDKVersionCode();
        JSONObject appInfo = this.Zm.tL().getAppInfo();
        JSONObject deviceInfo = this.Zm.tL().getDeviceInfo();
        JSONObject networkInfo = this.Zm.tL().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        l.putValue(jSONObject, "sdkApiVersion", "3.3.38");
        l.putValue(jSONObject, "sdkApiVersionCode", 3033800);
        l.putValue(jSONObject, Constants.KEY_SDK_VERSION, strAy);
        l.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        l.putValue(jSONObject, "sdkType", 1);
        l.putValue(jSONObject, "appInfo", appInfo);
        l.putValue(jSONObject, "deviceInfo", deviceInfo);
        l.putValue(jSONObject, "networkInfo", networkInfo);
        l.putValue(jSONObject, "sdkAbi", w.tM());
        String string = jSONObject.toString();
        this.Zm.tL().addHp(map);
        JSONObject jSONObject2 = new JSONObject();
        l.putValue(jSONObject2, "version", "3.3.38");
        l.putValue(jSONObject2, com.anythink.expressad.videocommon.e.b.f12231u, appInfo.optString(com.anythink.expressad.videocommon.e.b.f12231u));
        l.putValue(jSONObject2, "message", this.Zm.tL().getRM(string));
        this.Zm.tL().sR(this.mUrl, map, jSONObject2.toString());
        return jSONObject2.toString();
    }

    private static Map<String, String> tB() {
        HashMap map = new HashMap();
        map.put("Accept-Language", "zh-CN");
        map.put("Connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "application/json; charset=UTF-8");
        map.put("User-Agent", RequestParamsUtils.getUserAgent());
        return map;
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> mapTB = tB();
            String strC = c(mapTB);
            HttpURLConnection httpURLConnectionAR = aR(this.Zo);
            a(httpURLConnectionAR, mapTB);
            httpURLConnectionAR.connect();
            new DataOutputStream(httpURLConnectionAR.getOutputStream()).write(strC.getBytes());
            int responseCode = httpURLConnectionAR.getResponseCode();
            if (responseCode == 200) {
                String strA = a(httpURLConnectionAR.getInputStream());
                a.b bVar = new a.b();
                JSONObject jSONObject = new JSONObject(strA);
                String strOptString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(strOptString) && !"null".equals(strOptString)) {
                    jSONObject.put("data", new JSONObject(this.Zm.tL().getRD(strOptString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else {
                if (responseCode / 100 != 3) {
                    throw new RuntimeException("response code = " + responseCode);
                }
                if (this.Zn < 21) {
                    this.Zo = httpURLConnectionAR.getHeaderField("Location");
                    this.Zn++;
                    a(aVar);
                }
            }
            if (httpURLConnectionAR != null) {
                try {
                    httpURLConnectionAR.disconnect();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }
}
