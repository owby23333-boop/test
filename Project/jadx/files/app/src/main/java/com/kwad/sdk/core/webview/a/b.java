package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import cn.bmob.v3.datatype.up.Params;
import com.baidu.mobads.sdk.internal.bw;
import com.kwad.sdk.core.webview.a.b.b;
import com.kwad.sdk.core.webview.a.b.c;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.p;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.utils.HttpRequest;
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

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.a.kwai.b> apl = new ConcurrentHashMap();
    private static final Map<String, String> apm = new ConcurrentHashMap();

    private static String L(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void M(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        apm.put(str, str2);
    }

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.e.kwai.b bVar, b.a aVar, boolean z2) throws Throwable {
        com.kwad.sdk.core.webview.a.kwai.b bVarA;
        StringBuilder sb;
        String string;
        try {
            bVarA = a(context, bVar, str, aVar);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e2);
            bVarA = null;
        }
        if (bVarA == null) {
            b(z2, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVarA.apt)) {
            b(z2, "getResource [" + str + "] getFilePath from url fail");
            string = "getFilePath from url fail";
        } else {
            if (c.cW(bVarA.app)) {
                BufferedInputStream bufferedInputStreamEc = p.ec(bVarA.apt);
                if (bufferedInputStreamEc != null) {
                    return a(bufferedInputStreamEc, bVarA);
                }
                b(z2, "getResource [" + str + "] inputStream is null");
                sb = new StringBuilder("inputStream is null,本地加载路径：");
                sb.append(bVarA.apt);
            } else {
                b(z2, "mimetype为: " + bVarA.app + "不在拦截范围的文件");
                sb = new StringBuilder("mimetype为: ");
                sb.append(bVarA.app);
                sb.append("不在拦截范围的文件");
            }
            string = sb.toString();
        }
        aVar.msg = string;
        return null;
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.a.kwai.b bVar) {
        String str = bVar.app;
        if (Build.VERSION.SDK_INT < 21) {
            return new WebResourceResponse(str, "UTF-8", inputStream);
        }
        HashMap map = new HashMap();
        map.put("Access-Control-Allow-Origin", bVar.aps.apn);
        map.put("Access-Control-Allow-Credentials", ITagManager.STATUS_TRUE);
        map.put("Timing-Allow-Origin", bVar.aps.apo);
        map.put(Params.CONTENT_TYPE, str);
        map.put(HttpRequest.HEADER_DATE, bVar.aps.apq);
        map.put("union-cache ", "1");
        return new WebResourceResponse(bVar.app, "", bVar.status, bw.f12977k, map, inputStream);
    }

    private static com.kwad.sdk.core.webview.a.kwai.b a(Context context, com.kwad.sdk.e.kwai.b bVar, String str, b.a aVar) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        try {
            String strCP = cP(bVar.asH);
            com.kwad.sdk.core.webview.a.kwai.b bVarCO = !TextUtils.isEmpty(strCP) ? cO(L(strCP, str)) : null;
            if (bVarCO != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return bVarCO;
            }
            String strY = com.kwad.sdk.core.webview.a.b.a.y(context, bVar.asI);
            if (strY == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(strY);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + strY;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
            }
            try {
                String strB = h.b(inputStreamReader);
                if (TextUtils.isEmpty(strB)) {
                    aVar.msg = "获取配置文件失败 mainfest文件不存在";
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(strB);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    com.kwad.sdk.core.webview.a.kwai.b bVar2 = new com.kwad.sdk.core.webview.a.kwai.b();
                    bVar2.parseJson(jSONObject2);
                    String host = Uri.parse("https://" + next).getHost();
                    bVar2.apu = host;
                    bVar2.apt = com.kwad.sdk.core.webview.a.b.a.x(context, bVar.asI) + "/" + next;
                    if (TextUtils.isEmpty(bVar2.app)) {
                        bVar2.app = URLConnection.getFileNameMap().getContentTypeFor(bVar2.apt);
                    }
                    a(next, bVar2);
                    strCP = host;
                }
                M(bVar.asH, strCP);
                com.kwad.sdk.core.webview.a.kwai.b bVarCO2 = cO(L(strCP, str));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                return bVarCO2;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.a.kwai.b bVar) {
        apl.put(String.valueOf(str.hashCode()), bVar);
    }

    private static void b(boolean z2, String str) {
        if (z2) {
            return;
        }
        com.kwad.sdk.core.d.b.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.a.kwai.b cO(String str) {
        return apl.get(String.valueOf(str.hashCode()));
    }

    private static String cP(String str) {
        return apm.get(str);
    }
}
