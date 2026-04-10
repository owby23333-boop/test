package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import anet.channel.util.HttpConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.p;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
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

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static Map<String, String> a(f fVar) {
        HashMap map = new HashMap();
        if (fVar == null) {
            return map;
        }
        if (!TextUtils.isEmpty(fVar.asv)) {
            map.put("uploadToken", fVar.asv);
        }
        if (!TextUtils.isEmpty(fVar.ass)) {
            map.put(NotificationCompat.CATEGORY_SYSTEM, fVar.ass);
        }
        if (!TextUtils.isEmpty(fVar.asr)) {
            map.put("did", fVar.asr);
        }
        if (!TextUtils.isEmpty(fVar.asp)) {
            map.put("sid", fVar.asp);
        }
        if (!TextUtils.isEmpty(fVar.aqU)) {
            map.put("appver", fVar.aqU);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            map.put(DBDefinition.TASK_ID, fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.asq)) {
            map.put("token", fVar.asq);
        }
        if (!TextUtils.isEmpty(fVar.aso)) {
            map.put("uid", fVar.aso);
        }
        if (!TextUtils.isEmpty(fVar.ast)) {
            map.put(RewardItem.KEY_EXTRA_INFO, fVar.ast);
        }
        return map;
    }

    public static void a(File file, f fVar, a aVar) throws Throwable {
        a(file, fVar.asr, fVar.asq, a(fVar), aVar);
    }

    private static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        DataInputStream dataInputStream;
        byte[] bytes;
        byte[] bArr;
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String string = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.wy().C(INet.HostType.ULOG, "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i2 = -1;
        DataInputStream dataInputStream2 = null;
        dataInputStream2 = null;
        dataInputStream2 = null;
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
                httpURLConnection.setRequestProperty("connection", com.anythink.expressad.foundation.g.f.g.c.f10570c);
                httpURLConnection.setRequestProperty("User-Agent", q.getUserAgent());
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + string);
                httpURLConnection.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.ea(file.getPath()), 2));
                httpURLConnection.setRequestProperty("file-type", "." + p.getExtension(file.getName()));
                httpURLConnection.setRequestProperty("origin-name", name);
                httpURLConnection.setRequestProperty(HttpConstant.COOKIE, "did=" + str);
                httpURLConnection.connect();
                outputStream = httpURLConnection.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(d(str4, map.get(str4), string));
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
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
                try {
                    bArr = new byte[1024];
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection2 = httpURLConnection;
                    try {
                        e eVar = e.asj;
                        e.getCause();
                        aVar.Aq();
                        com.kwad.sdk.core.network.idc.a aVarWy = com.kwad.sdk.core.network.idc.a.wy();
                        if (cVar.code != 0) {
                            i2 = cVar.code;
                        }
                        aVarWy.a(str3, i2, e);
                        com.kwad.sdk.core.d.b.printStackTrace(e);
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        dataInputStream2 = dataInputStream;
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream2 = dataInputStream;
                    com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                    com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                outputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            outputStream = null;
        }
        while (true) {
            int i3 = dataInputStream.read(bArr);
            if (i3 == -1) {
                break;
            } else {
                outputStream.write(bArr, 0, i3);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
        }
        outputStream.write("\r\n".getBytes());
        outputStream.write(bytes);
        outputStream.flush();
        int responseCode = httpURLConnection.getResponseCode();
        cVar.code = responseCode;
        cVar.afI = responseCode;
        if (responseCode == 200) {
            cVar.afK = h.a(httpURLConnection.getInputStream());
            try {
                int iOptInt = new JSONObject(cVar.afK).optInt("result", -1);
                if (iOptInt == 1) {
                    aVar.Ar();
                } else {
                    e eVar2 = e.ask;
                    new StringBuilder("result is ").append(iOptInt);
                    aVar.Aq();
                }
            } catch (JSONException unused) {
                e eVar3 = e.asl;
                e eVar4 = e.asl;
                aVar.Aq();
            }
            com.kwad.sdk.core.d.b.d("ExceptionCollector", "response.body= " + cVar.afK);
        } else {
            e eVar5 = e.asj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e.asj.At());
            sb2.append(responseCode);
            aVar.Aq();
            com.kwad.sdk.core.network.idc.a.wy().a(str3, cVar.code == 0 ? -1 : cVar.code, (Throwable) null);
        }
        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] d(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }
}
