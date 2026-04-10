package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public class H5JavaScriptInterface {
    private static HashSet<Integer> a = new HashSet<>();
    private String b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread f18456c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18457d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f18458e = null;

    private H5JavaScriptInterface() {
    }

    private static bb a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bb bbVar = new bb();
                bbVar.a = jSONObject.getString("projectRoot");
                if (bbVar.a == null) {
                    return null;
                }
                bbVar.b = jSONObject.getString("context");
                if (bbVar.b == null) {
                    return null;
                }
                bbVar.f18645c = jSONObject.getString("url");
                if (bbVar.f18645c == null) {
                    return null;
                }
                bbVar.f18646d = jSONObject.getString(TTDownloadField.TT_USERAGENT);
                if (bbVar.f18646d == null) {
                    return null;
                }
                bbVar.f18647e = jSONObject.getString("language");
                if (bbVar.f18647e == null) {
                    return null;
                }
                bbVar.f18648f = jSONObject.getString("name");
                if (bbVar.f18648f == null || bbVar.f18648f.equals("null") || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int iIndexOf = string.indexOf("\n");
                if (iIndexOf < 0) {
                    al.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                bbVar.f18650h = string.substring(iIndexOf + 1);
                bbVar.f18649g = string.substring(0, iIndexOf);
                int iIndexOf2 = bbVar.f18649g.indexOf(":");
                if (iIndexOf2 > 0) {
                    bbVar.f18649g = bbVar.f18649g.substring(iIndexOf2 + 1);
                }
                bbVar.f18651i = jSONObject.getString(BmobDbOpenHelper.FILE);
                if (bbVar.f18648f == null) {
                    return null;
                }
                bbVar.f18652j = jSONObject.getLong("lineNumber");
                if (bbVar.f18652j < 0) {
                    return null;
                }
                bbVar.f18653k = jSONObject.getLong("columnNumber");
                if (bbVar.f18653k < 0) {
                    return null;
                }
                al.a("H5 crash information is following: ", new Object[0]);
                al.a("[projectRoot]: " + bbVar.a, new Object[0]);
                al.a("[context]: " + bbVar.b, new Object[0]);
                al.a("[url]: " + bbVar.f18645c, new Object[0]);
                al.a("[userAgent]: " + bbVar.f18646d, new Object[0]);
                al.a("[language]: " + bbVar.f18647e, new Object[0]);
                al.a("[name]: " + bbVar.f18648f, new Object[0]);
                al.a("[message]: " + bbVar.f18649g, new Object[0]);
                al.a("[stacktrace]: \n" + bbVar.f18650h, new Object[0]);
                al.a("[file]: " + bbVar.f18651i, new Object[0]);
                al.a("[lineNumber]: " + bbVar.f18652j, new Object[0]);
                al.a("[columnNumber]: " + bbVar.f18653k, new Object[0]);
                return bbVar;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.a aVar) {
        String string = null;
        if (aVar == null || a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        a.add(Integer.valueOf(aVar.hashCode()));
        h5JavaScriptInterface.f18456c = Thread.currentThread();
        Thread thread = h5JavaScriptInterface.f18456c;
        if (thread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            for (int i2 = 2; i2 < thread.getStackTrace().length; i2++) {
                StackTraceElement stackTraceElement = thread.getStackTrace()[i2];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
            string = sb.toString();
        }
        h5JavaScriptInterface.f18457d = string;
        HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) aVar.c());
        map.put("[WebView] ContentDescription", sb2.toString());
        h5JavaScriptInterface.f18458e = map;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        al.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            al.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String strC = ap.c(str.getBytes());
        String str2 = this.b;
        if (str2 != null && str2.equals(strC)) {
            al.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.b = strC;
        al.d("Handling JS exception ...", new Object[0]);
        bb bbVarA = a(str);
        if (bbVarA == null) {
            al.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = bbVarA.a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = bbVarA.b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = bbVarA.f18645c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = bbVarA.f18646d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = bbVarA.f18651i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j2 = bbVarA.f18652j;
        if (j2 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j2));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f18458e);
        linkedHashMap.put("Java Stack", this.f18457d);
        Thread thread = this.f18456c;
        if (bbVarA != null) {
            InnerApi.postH5CrashAsync(thread, bbVarA.f18648f, bbVarA.f18649g, bbVarA.f18650h, linkedHashMap);
        }
    }
}
