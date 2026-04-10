package com.anythink.expressad.advanced.js;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.a;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.videocommon.b.i;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdvancedJsUtils {
    public static final String a = "onViewDisappeared";
    public static final String b = "onViewAppeared";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8233c = "onSystemDestory";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8234d = "setStyleList";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8235e = "params";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8236f = "showCloseButton";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f8237g = "hideCloseButton";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f8238h = "setVolume";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8239i = "mute";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f8240j = "setVideoPlayMode";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8241k = "autoPlay";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8242l = "onNetstatChanged";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8243m = "netstat";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8244n = "sq";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8245o = "thirdPartyCalled";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f8246p = "action";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f8247q = "params";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f8248r = "NativeAdvancedJsUtils";

    public static void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(f8248r, e2.getMessage());
        }
    }

    public static void fireOnJSBridgeConnected(WebView webView) {
        o.d(f8248r, "fireOnJSBridgeConnected");
        j.a();
        j.b(webView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v2, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, org.json.JSONObject] */
    public static void getFileInfo(Object obj, JSONObject jSONObject) {
        ?? r2;
        ?? jSONArray;
        String str;
        String str2;
        ?? r20;
        String strConcat;
        File file;
        String str3 = "";
        ?? jSONObject2 = new JSONObject();
        String str4 = "message";
        ?? r7 = "code";
        int i2 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e2) {
                o.a(f8248r, e2.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            jSONArray = jSONObject.getJSONArray("resource");
            try {
                if (jSONArray == 0) {
                    jSONArray = "code";
                    r2 = 1;
                    jSONObject2.put(jSONArray, 1);
                    jSONObject2.put("message", "resource is null");
                    j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                }
                try {
                    if (jSONArray.length() > 0) {
                        ?? jSONArray2 = new JSONArray();
                        int length = jSONArray.length();
                        int i3 = 0;
                        r7 = r7;
                        ?? r11 = jSONArray;
                        while (i3 < length) {
                            JSONObject jSONObject3 = r11.getJSONObject(i3);
                            String strOptString = jSONObject3.optString("ref", str3);
                            int i4 = jSONObject3.getInt("type");
                            ?? jSONObject4 = new JSONObject();
                            if (i4 != i2 || TextUtils.isEmpty(strOptString)) {
                                str = str3;
                                str2 = str4;
                                r20 = r11;
                                jSONArray = r7;
                                if (i4 == 2 && !TextUtils.isEmpty(strOptString)) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put("type", 2);
                                    jSONObject5.put("path", i.a().c(strOptString) == null ? str : i.a().c(strOptString));
                                    jSONObject4.put(strOptString, jSONObject5);
                                    jSONArray2.put(jSONObject4);
                                } else if (i4 == 3 && !TextUtils.isEmpty(strOptString)) {
                                    try {
                                        file = new File(strOptString);
                                    } catch (Throwable th) {
                                        if (a.a) {
                                            th.printStackTrace();
                                        }
                                    }
                                    if (file.exists() && file.isFile() && file.canRead()) {
                                        o.a(f8248r, "getFileInfo Mraid file ".concat(String.valueOf(strOptString)));
                                        strConcat = "file:////".concat(String.valueOf(strOptString));
                                    } else {
                                        strConcat = str;
                                    }
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("type", 3);
                                    jSONObject6.put("path", strConcat);
                                    jSONObject4.put(strOptString, jSONObject6);
                                    jSONArray2.put(jSONObject4);
                                } else if (i4 == 4 && !TextUtils.isEmpty(strOptString)) {
                                    JSONObject jSONObject7 = new JSONObject();
                                    jSONObject7.put("type", 4);
                                    jSONObject7.put("path", s.a(strOptString) == null ? str : s.a(strOptString));
                                    jSONObject4.put(strOptString, jSONObject7);
                                    jSONArray2.put(jSONObject4);
                                }
                            } else {
                                JSONObject jSONObject8 = new JSONObject();
                                com.anythink.expressad.videocommon.b.a.a();
                                com.anythink.core.common.a.i iVarB = com.anythink.expressad.videocommon.b.a.b(strOptString);
                                if (iVarB != null) {
                                    r20 = r11;
                                    o.a(f8248r, "VideoBean not null");
                                    jSONObject8.put("type", 1);
                                    str2 = str4;
                                    jSONArray = r7;
                                    jSONObject8.put("videoDataLength", iVarB.d());
                                    String strB = iVarB.b();
                                    if (TextUtils.isEmpty(strB)) {
                                        o.a(f8248r, "VideoPath null");
                                        jSONObject8.put("path", str3);
                                        jSONObject8.put("path4Web", str3);
                                        str = str3;
                                    } else {
                                        str = str3;
                                        o.a(f8248r, "VideoPath not null");
                                        jSONObject8.put("path", strB);
                                        jSONObject8.put("path4Web", strB);
                                    }
                                    if (iVarB.c() == 100) {
                                        jSONObject8.put("downloaded", 1);
                                    } else {
                                        jSONObject8.put("downloaded", 0);
                                    }
                                    jSONObject4.put(strOptString, jSONObject8);
                                    jSONArray2.put(jSONObject4);
                                } else {
                                    str = str3;
                                    str2 = str4;
                                    r20 = r11;
                                    jSONArray = r7;
                                    o.a(f8248r, "VideoBean null");
                                }
                            }
                            i3++;
                            r7 = jSONArray;
                            str4 = str2;
                            str3 = str;
                            i2 = 1;
                            r11 = r20;
                        }
                        jSONObject2.put("resource", jSONArray2);
                        j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    }
                    jSONArray = "code";
                    r2 = 1;
                    try {
                        try {
                            jSONObject2.put(jSONArray, 1);
                            try {
                                jSONObject2.put("message", "resource is null");
                                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                                return;
                            } catch (JSONException e3) {
                                e = e3;
                                o.a(f8248r, e.getMessage());
                                return;
                            }
                        } catch (JSONException e4) {
                            e = e4;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jSONArray = r7;
                    r2 = str4;
                }
            } catch (Throwable th4) {
                th = th4;
                r2 = str2;
            }
        } catch (Throwable th5) {
            th = th5;
            r2 = "message";
            jSONArray = "code";
        }
        try {
            jSONObject2.put(jSONArray, 1);
            jSONObject2.put(r2, th.getLocalizedMessage());
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e5) {
            o.a(f8248r, e5.getMessage());
        }
    }

    public static void sendEventToH5(WebView webView, String str, String str2) {
        j.a();
        j.a(webView, str, str2);
    }

    public static void sendThirdToH5(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f8244n, 1);
            jSONObject.put(f8246p, str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            j.a();
            j.a(webView, f8245o, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
