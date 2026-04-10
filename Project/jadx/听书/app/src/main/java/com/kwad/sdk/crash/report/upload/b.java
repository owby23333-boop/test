package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.funny.audio.core.utils.FileUtils;
import com.google.common.net.HttpHeaders;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static void a(File file, String str, String str2, Map<String, String> map, a aVar) throws Throwable {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        byte[] bytes;
        byte[] bArr;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String string = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.HF().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("connection", HttpHeaders.KEEP_ALIVE);
                httpURLConnection.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + string);
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_MD5, Base64.encodeToString(com.kwad.sdk.utils.a.gN(file.getPath()), 2));
                httpURLConnection.setRequestProperty("file-type", FileUtils.FILE_EXTENSION_SEPARATOR + w.getExtension(file.getName()));
                httpURLConnection.setRequestProperty("origin-name", name);
                httpURLConnection.setRequestProperty(HttpHeaders.COOKIE, "did=" + str);
                httpURLConnection.connect();
                outputStream = httpURLConnection.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), string));
                    }
                    bytes = ("\r\n--" + string + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(string);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        bArr = new byte[1024];
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection2 = httpURLConnection;
                        try {
                            e eVar = e.aQJ;
                            e.getCause();
                            aVar.LX();
                            com.kwad.sdk.core.network.idc.a aVarHF = com.kwad.sdk.core.network.idc.a.HF();
                            if (cVar.code != 0) {
                                i = cVar.code;
                            }
                            aVarHF.a(str3, i, e);
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        while (true) {
            int i2 = dataInputStream.read(bArr);
            if (i2 == -1) {
                break;
            } else {
                outputStream.write(bArr, 0, i2);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
        }
        outputStream.write("\r\n".getBytes());
        outputStream.write(bytes);
        outputStream.flush();
        int responseCode = httpURLConnection.getResponseCode();
        cVar.code = responseCode;
        cVar.aEi = responseCode;
        if (responseCode == 200) {
            cVar.aEk = h.inputStream2String(httpURLConnection.getInputStream());
            try {
                if (new JSONObject(cVar.aEk).optInt("result", -1) == 1) {
                    aVar.LY();
                } else {
                    e eVar2 = e.aQK;
                    aVar.LX();
                }
            } catch (JSONException unused) {
                e eVar3 = e.aQL;
                e eVar4 = e.aQL;
                aVar.LX();
            }
            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.aEk);
        } else {
            e eVar5 = e.aQJ;
            new StringBuilder().append(e.aQJ.zb());
            aVar.LX();
            com.kwad.sdk.core.network.idc.a.HF().a(str3, cVar.code == 0 ? -1 : cVar.code, (Throwable) null);
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap map = new HashMap();
        if (fVar == null) {
            return map;
        }
        if (!TextUtils.isEmpty(fVar.aQU)) {
            map.put("uploadToken", fVar.aQU);
        }
        if (!TextUtils.isEmpty(fVar.aQR)) {
            map.put(NotificationCompat.CATEGORY_SYSTEM, fVar.aQR);
        }
        if (!TextUtils.isEmpty(fVar.aQQ)) {
            map.put("did", fVar.aQQ);
        }
        if (!TextUtils.isEmpty(fVar.aQP)) {
            map.put(CmcdConfiguration.KEY_SESSION_ID, fVar.aQP);
        }
        if (!TextUtils.isEmpty(fVar.aPl)) {
            map.put("appver", fVar.aPl);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            map.put("taskId", fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.mToken)) {
            map.put("token", fVar.mToken);
        }
        if (!TextUtils.isEmpty(fVar.aQO)) {
            map.put("uid", fVar.aQO);
        }
        if (!TextUtils.isEmpty(fVar.aQS)) {
            map.put(MediationConstant.KEY_EXTRA_INFO, fVar.aQS);
        }
        return map;
    }

    public static void a(File file, f fVar, a aVar) throws Throwable {
        a(file, fVar.aQQ, fVar.mToken, a(fVar), aVar);
    }
}
