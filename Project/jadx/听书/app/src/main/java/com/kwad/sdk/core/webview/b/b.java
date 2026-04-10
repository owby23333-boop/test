package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.google.common.net.HttpHeaders;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aNr = new ConcurrentHashMap();
    private static final Map<String, String> aNs = new ConcurrentHashMap();

    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z) throws Throwable {
        com.kwad.sdk.core.webview.b.a.b bVarA;
        try {
            bVarA = a(context, bVar, str, aVar);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e);
            bVarA = null;
        }
        if (bVarA == null) {
            b(z, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVarA.aNz)) {
            b(z, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.fg(bVarA.aNv)) {
            b(z, "mimetype为: " + bVarA.aNv + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVarA.aNv + "不在拦截范围的文件";
            return null;
        }
        BufferedInputStream bufferedInputStreamGP = w.gP(bVarA.aNz);
        if (bufferedInputStreamGP == null) {
            b(z, "getResource [" + str + "] inputStream is null");
            aVar.msg = "inputStream is null,本地加载路径：" + bVarA.aNz;
            return null;
        }
        return a(bufferedInputStreamGP, bVarA);
    }

    private static void b(boolean z, String str) {
        if (z) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aNv;
        HashMap map = new HashMap();
        map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, bVar.aNy.aNt);
        map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        map.put(HttpHeaders.TIMING_ALLOW_ORIGIN, bVar.aNy.aNu);
        map.put("content-type", str);
        map.put(HttpHeaders.DATE, bVar.aNy.aNw);
        map.put("union-cache ", "1");
        return new WebResourceResponse(bVar.aNv, "", bVar.status, "OK", map, inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) throws Throwable {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String strEZ = eZ(bVar.aRp);
            com.kwad.sdk.core.webview.b.a.b bVarEY = !TextUtils.isEmpty(strEZ) ? eY(ac(strEZ, str)) : null;
            if (bVarEY != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return bVarEY;
            }
            String strK = com.kwad.sdk.core.webview.b.c.a.K(context, bVar.aRq);
            if (strK == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(strK);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + strK;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
                try {
                    String strB = h.b(inputStreamReader);
                    if (TextUtils.isEmpty(strB)) {
                        aVar.msg = "获取配置文件失败 mainfest文件不存在";
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(strB);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                        com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                        bVar2.parseJson(jSONObject2);
                        String host = Uri.parse("https://" + next).getHost();
                        bVar2.aNA = host;
                        bVar2.aNz = com.kwad.sdk.core.webview.b.c.a.J(context, bVar.aRq) + "/" + next;
                        if (TextUtils.isEmpty(bVar2.aNv)) {
                            bVar2.aNv = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aNz);
                        }
                        a(next, bVar2);
                        strEZ = host;
                    }
                    ad(bVar.aRp, strEZ);
                    com.kwad.sdk.core.webview.b.a.b bVarEY2 = eY(ac(strEZ, str));
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return bVarEY2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aNr.put(String.valueOf(str.hashCode()), bVar);
    }

    private static com.kwad.sdk.core.webview.b.a.b eY(String str) {
        return aNr.get(String.valueOf(str.hashCode()));
    }

    private static String ac(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void ad(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        aNs.put(str, str2);
    }

    private static String eZ(String str) {
        return aNs.get(str);
    }
}
