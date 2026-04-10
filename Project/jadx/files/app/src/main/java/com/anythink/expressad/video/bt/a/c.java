package com.anythink.expressad.video.bt.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.h;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.ATTempContainer;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;
import com.anythink.expressad.video.bt.module.AnythinkBTLayout;
import com.anythink.expressad.video.bt.module.AnythinkBTNativeEC;
import com.anythink.expressad.video.bt.module.AnythinkBTVideoView;
import com.anythink.expressad.video.bt.module.AnythinkBTWebView;
import com.anythink.expressad.video.bt.module.BTBaseView;
import com.anythink.expressad.videocommon.b.i;
import com.anythink.expressad.videocommon.e.d;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final int a = -999;
    private static final String b = "OperateViews";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> f11457c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static LinkedHashMap<String, String> f11458d = new LinkedHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static LinkedHashMap<String, com.anythink.expressad.foundation.d.c> f11459e = new LinkedHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static LinkedHashMap<String, d> f11460f = new LinkedHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static LinkedHashMap<String, String> f11461g = new LinkedHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static LinkedHashMap<String, Integer> f11462h = new LinkedHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static LinkedHashMap<String, Activity> f11463i = new LinkedHashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile int f11464j = 10000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f11465k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f11466l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f11467m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f11468n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f11469o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f11470p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f11471q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static int f11472r;

    private static class a {
        private static c a = new c(0);

        private a() {
        }
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static void E(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void I(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void J(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                c(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void P(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String strConcat;
        File file;
        String str4 = "message";
        String str5 = "code";
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 1;
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    String strOptString = jSONObject3.optString("ref", "");
                    int i4 = jSONObject3.getInt("type");
                    JSONObject jSONObject4 = new JSONObject();
                    JSONArray jSONArray3 = jSONArray;
                    if (i4 != i2 || TextUtils.isEmpty(strOptString)) {
                        str2 = str4;
                        str3 = str5;
                        if (i4 == 2 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("type", 2);
                            jSONObject5.put("path", i.a().c(strOptString) == null ? "" : i.a().c(strOptString));
                            jSONObject4.put(strOptString, jSONObject5);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 3 && !TextUtils.isEmpty(strOptString)) {
                            try {
                                file = new File(strOptString);
                            } catch (Throwable th) {
                                if (com.anythink.expressad.a.a) {
                                    th.printStackTrace();
                                }
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                o.a(b, "getFileInfo Mraid file ".concat(String.valueOf(strOptString)));
                                strConcat = "file:////".concat(String.valueOf(strOptString));
                            } else {
                                strConcat = "";
                            }
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("type", 3);
                            jSONObject6.put("path", strConcat);
                            jSONObject4.put(strOptString, jSONObject6);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 4 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 4);
                            jSONObject7.put("path", s.a(strOptString) == null ? "" : s.a(strOptString));
                            jSONObject4.put(strOptString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        }
                    } else {
                        JSONObject jSONObject8 = new JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        com.anythink.core.common.a.i iVarB = com.anythink.expressad.videocommon.b.a.b(strOptString);
                        if (iVarB != null) {
                            o.a(b, "VideoBean not null");
                            jSONObject8.put("type", 1);
                            str2 = str4;
                            str3 = str5;
                            try {
                                jSONObject8.put("videoDataLength", iVarB.d());
                                String strB = iVarB.b();
                                if (TextUtils.isEmpty(strB)) {
                                    o.a(b, "VideoPath null");
                                    jSONObject8.put("path", "");
                                    jSONObject8.put("path4Web", "");
                                } else {
                                    o.a(b, "VideoPath not null");
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
                            } catch (Throwable th2) {
                                th = th2;
                                str4 = str2;
                                str = str3;
                            }
                        } else {
                            str2 = str4;
                            str3 = str5;
                            o.a(b, "VideoBean null");
                        }
                    }
                    i3++;
                    jSONArray = jSONArray3;
                    str4 = str2;
                    str5 = str3;
                    i2 = 1;
                }
                str2 = str4;
                str3 = str5;
                jSONObject2.put("resource", jSONArray2);
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str = "code";
            try {
                jSONObject2.put(str, 1);
                str4 = "message";
            } catch (JSONException e2) {
                e = e2;
                str4 = "message";
            } catch (Throwable th3) {
                th = th3;
                str4 = "message";
            }
            try {
                try {
                    jSONObject2.put(str4, "resource is null");
                    j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (JSONException e3) {
                e = e3;
                o.a(b, e.getMessage());
                return;
            }
        } catch (Throwable th5) {
            th = th5;
            str = str5;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(str4, th.getLocalizedMessage());
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e4) {
            o.a(b, e4.getMessage());
        }
    }

    public static c a() {
        return a.a;
    }

    public static String b() {
        int i2 = f11464j + 1;
        f11464j = i2;
        return String.valueOf(i2);
    }

    public static void d(String str) {
        f11463i.remove(str);
    }

    public static int e(String str) {
        if (f11462h.containsKey(str)) {
            return f11462h.get(str).intValue();
        }
        return 2;
    }

    public static void f(String str) {
        if (f11461g.containsKey(str)) {
            f11461g.remove(str);
        }
        if (f11460f.containsKey(str)) {
            f11460f.remove(str);
        }
        if (f11459e.containsKey(str)) {
            f11459e.remove(str);
        }
        if (f11458d.containsKey(str)) {
            f11458d.remove(str);
        }
    }

    public static void g(String str) {
        if (f11462h.containsKey(str)) {
            f11462h.remove(str);
        }
    }

    private static String h(String str) {
        return f11458d.containsKey(str) ? f11458d.get(str) : "";
    }

    private static Activity i(String str) {
        if (f11463i.containsKey(str)) {
            return f11463i.get(str);
        }
        return null;
    }

    public final void A(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerPlay failed instanceId not exit instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerPlay failed instanceId is not player instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                ((AnythinkBTVideoView) view).play();
                a(obj, strOptString2);
                o.a(b, "playerPlay success");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerPlay failed: " + th.getMessage());
        }
    }

    public final void B(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerPause failed instanceId not exit instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerPause failed instanceId is not player instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                ((AnythinkBTVideoView) view).pause();
                a(obj, strOptString2);
                o.a(b, "playerPause success");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerPause failed: " + th.getMessage());
        }
    }

    public final void C(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerResume failed instanceId not exit instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerResume failed instanceId is not player instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                ((AnythinkBTVideoView) view).resume();
                a(obj, strOptString2);
                o.a(b, "playerResume success");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerResume failed: " + th.getMessage());
        }
    }

    public final void D(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerStop failed instanceId not exit instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerStop failed instanceId is not player instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                ((AnythinkBTVideoView) view).stop();
                a(obj, strOptString2);
                o.a(b, "playerStop success");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerStop failed: " + th.getMessage());
        }
    }

    public final void F(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "playerMute failed: instanceId is not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerMute failed: instanceId is not player");
            } else if (((AnythinkBTVideoView) view).playMute()) {
                a(obj, strOptString2);
                o.a(b, "playerMute success");
            } else {
                c(obj, "set mute failed");
                o.a(b, "playerMute failed set mute failed");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerMute failed: " + th.getMessage());
        }
    }

    public final void G(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerUnmute failed: instanceId not exit");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerUnmute failed: instanceId is not player");
            } else if (!((AnythinkBTVideoView) view).playUnMute()) {
                a(obj, "set unmute failed");
                o.a(b, "playerUnmute failed: set unmute failed");
            } else {
                a(obj, strOptString2);
                a(obj, "onUnmute", strOptString2);
                o.a(b, "playerUnmute successed");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerUnmute failed: " + th.getMessage());
        }
    }

    public final void H(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "playerGetMuteState failed instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerGetMuteState failed instanceId is not player");
                return;
            }
            int mute = ((AnythinkBTVideoView) view).getMute();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f11465k);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", strOptString2);
            jSONObject3.put("mute", mute);
            jSONObject2.put("data", jSONObject3);
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            o.a(b, "playerGetMuteState successed mute = ".concat(String.valueOf(mute)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerGetMuteState failed: " + th.getMessage());
        }
    }

    public final void K(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof ATTempContainer)) {
                c(obj, "view not exist");
            } else {
                ((ATTempContainer) view).preload();
                a(obj, strOptString2);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "preloadSubPlayTemplateView failed: " + th.getMessage());
        }
    }

    public final void L(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            AnythinkBTContainer anythinkBTContainer = null;
            if (linkedHashMapB.size() <= 0) {
                c(obj, "unitId or instanceId not exist");
                o.a(b, "closeAd failed: unitId or instanceId not exist unitId = ".concat(String.valueOf(strOptString)));
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof AnythinkBTContainer) {
                    anythinkBTContainer = (AnythinkBTContainer) view;
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).onDestory();
                } else if (view instanceof AnythinkBTVideoView) {
                    String instanceId = ((AnythinkBTVideoView) view).getInstanceId();
                    com.anythink.expressad.video.bt.a.a.a();
                    com.anythink.expressad.video.bt.a.a.a(instanceId);
                    ((AnythinkBTVideoView) view).onDestory();
                } else if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).onDestroy();
                }
            }
            if (anythinkBTContainer == null) {
                c(obj, "not found AnythinkBTContainer");
                o.a(b, "closeAd successed");
                return;
            }
            anythinkBTContainer.onAdClose();
            f11457c.remove(linkedHashMapB);
            linkedHashMapB.clear();
            f11457c.remove(strOptString + "_" + strH);
            a(obj, strOptString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "closeAd failed: " + th.getMessage());
        }
    }

    public final void M(Object obj, JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            String rid = aVar.a != null ? aVar.a.getRid() : "";
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("eventName");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).broadcast(strOptString2, jSONObjectOptJSONObject);
                }
                if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).broadcast(strOptString2, jSONObjectOptJSONObject);
                }
            }
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "broadcast failed: " + th.getMessage());
        }
    }

    public final void N(Object obj, JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            String strOptString = "";
            String rid = aVar.a != null ? aVar.a.getRid() : "";
            String strOptString2 = jSONObject.optString("unitId");
            String strOptString3 = jSONObject.optString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            String strOptString4 = jSONObjectOptJSONObject.optString("userId");
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("expired");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward");
            String strOptString5 = jSONObjectOptJSONObject.optString("extra");
            com.anythink.expressad.videocommon.c.c cVar = null;
            if (jSONObjectOptJSONObject2 != null) {
                cVar = new com.anythink.expressad.videocommon.c.c(jSONObjectOptJSONObject2.optString("name"), jSONObjectOptJSONObject2.optInt("amount"));
                strOptString = jSONObjectOptJSONObject2.optString("id");
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString2, rid);
            if (linkedHashMapB.size() <= 0 || !f11461g.containsKey(strOptString3)) {
                c(obj, "unitId not exist");
                o.a(b, "setSubPlayTemplateInfo failed: unitId not exist instanceId = ".concat(String.valueOf(strOptString3)));
                return;
            }
            View view = linkedHashMapB.get(strOptString3);
            if (!(view instanceof ATTempContainer)) {
                c(obj, "instanceId not exist");
                o.a(b, "setSubPlayTemplateInfo failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString3)));
                return;
            }
            ATTempContainer aTTempContainer = (ATTempContainer) view;
            aTTempContainer.setReward(cVar);
            aTTempContainer.setUserId(strOptString4);
            aTTempContainer.setRewardId(strOptString);
            aTTempContainer.setCampaignExpired(zOptBoolean);
            if (!TextUtils.isEmpty(strOptString5)) {
                aTTempContainer.setDeveloperExtraData(strOptString5);
            }
            a(obj, strOptString3);
            o.a(b, "setSubPlayTemplateInfo success instanceId = ".concat(String.valueOf(strOptString3)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setSubPlayTemplateInfo failed: " + th.getMessage());
        }
    }

    public final void O(Object obj, JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            String rid = aVar.a != null ? aVar.a.getRid() : "";
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            String strOptString3 = jSONObjectOptJSONObject.optString("eventName");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("eventData");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
            if (linkedHashMapB.size() <= 0) {
                c(obj, "unitId not exist");
                o.a(b, "webviewFireEvent failed: unitId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof WindVaneWebView) {
                        j.a();
                        j.a((WebView) childAt, strOptString3, Base64.encodeToString(jSONObjectOptJSONObject2.toString().getBytes(), 2));
                        a(obj, strOptString2);
                        o.a(b, "webviewFireEvent instanceId = ".concat(String.valueOf(strOptString2)));
                        return;
                    }
                }
            }
            c(obj, "instanceId not exist");
            o.a(b, "webviewFireEvent failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewFireEvent failed: " + th.getMessage());
        }
    }

    public final void Q(Object obj, JSONObject jSONObject) {
        o.a(b, "createNativeEC:".concat(String.valueOf(jSONObject)));
        try {
            String strOptString = jSONObject.optString("unitId");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String rid = "";
                com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (cVarB != null && !TextUtils.isEmpty(strOptString)) {
                    cVarB.l(strOptString);
                    rid = cVarB.Z();
                }
                d dVarA = d.a(jSONObjectOptJSONObject.optJSONObject("unitSetting"));
                if (dVarA != null) {
                    dVarA.a(strOptString);
                }
                AnythinkBTNativeEC anythinkBTNativeEC = new AnythinkBTNativeEC(n.a().g());
                anythinkBTNativeEC.setCampaign(cVarB);
                com.anythink.expressad.video.signal.a.j jVar = new com.anythink.expressad.video.signal.a.j(null, cVarB);
                jVar.a(strOptString);
                anythinkBTNativeEC.setJSCommon(jVar);
                anythinkBTNativeEC.setUnitId(strOptString);
                anythinkBTNativeEC.setRewardUnitSetting(dVarA);
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    rid = windVaneWebView.getRid();
                    anythinkBTNativeEC.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strB = b();
                f11458d.put(strB, rid);
                anythinkBTNativeEC.setInstanceId(strB);
                linkedHashMapB.put(strB, anythinkBTNativeEC);
                anythinkBTNativeEC.preLoadData();
                if (cVarB == null) {
                    c(obj, "campaign is null");
                    o.a(b, "createNativeEC failed");
                    return;
                } else {
                    a(obj, strB);
                    o.a(b, "createNativeEC instanceId = ".concat(String.valueOf(strB)));
                    return;
                }
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createNativeEC failed：" + th.getMessage());
        }
    }

    public final void j(Object obj, JSONObject jSONObject) {
        int iOptInt;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String strOptString3 = jSONObjectOptJSONObject.optString("id");
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                    c(obj, "instanceId is not exist");
                    o.a(b, "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString3);
                View view = linkedHashMapB.get(strOptString2);
                u.a(view);
                if (viewGroup != null && view != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                    if (view instanceof ATTempContainer) {
                        Iterator<View> it = linkedHashMapB.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof AnythinkBTContainer) {
                                u.a(view);
                                ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, jSONObjectOptJSONObject2);
                                break;
                            }
                        }
                    } else {
                        Rect rect = null;
                        int iOptInt2 = 0;
                        if (jSONObjectOptJSONObject2 != null) {
                            Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                            iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                            iOptInt = jSONObjectOptJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            iOptInt2 = ((BTBaseView) view).getViewWidth();
                            iOptInt = ((BTBaseView) view).getViewHeight();
                        } else {
                            iOptInt = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt2, iOptInt);
                        u.a(view);
                        viewGroup.addView(view, layoutParamsA);
                    }
                    a(obj, strOptString2);
                    a(obj, "onAppendViewTo", strOptString2);
                    o.a(b, "appendViewTo parentId = " + strOptString3 + " childId = " + strOptString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void k(Object obj, JSONObject jSONObject) {
        int iOptInt;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("id");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString3) || !linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId is not exist");
                o.a(b, "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString2);
            View view = linkedHashMapB.get(strOptString3);
            if (viewGroup != null && view != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                int iOptInt2 = 0;
                if (view instanceof ATTempContainer) {
                    o.d(b, "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(f11468n), Integer.valueOf(f11469o), Integer.valueOf(f11470p), Integer.valueOf(f11471q), Integer.valueOf(f11472r)));
                    ((ATTempContainer) view).setNotchPadding(f11468n, f11469o, f11470p, f11471q, f11472r);
                    Iterator<View> it = linkedHashMapB.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View next = it.next();
                        if (next instanceof AnythinkBTContainer) {
                            u.a(view);
                            ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, jSONObjectOptJSONObject2);
                            break;
                        }
                    }
                } else {
                    Rect rect = null;
                    if (jSONObjectOptJSONObject2 != null) {
                        Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                        iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                        iOptInt = jSONObjectOptJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        iOptInt2 = ((BTBaseView) view).getViewWidth();
                        iOptInt = ((BTBaseView) view).getViewHeight();
                    } else {
                        iOptInt = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    viewGroup.addView(view, a(layoutParams, rect, iOptInt2, iOptInt));
                }
                a(obj, strOptString2);
                a(obj, "onAppendView", strOptString2);
                o.a(b, "appendSubView parentId = " + strOptString2 + " childId = " + strOptString3);
                return;
            }
            c(obj, "view is not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendSubView failed: " + th.getMessage());
        }
    }

    public final void l(Object obj, JSONObject jSONObject) {
        int iOptInt;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String strOptString3 = jSONObjectOptJSONObject.optString("id");
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                    c(obj, "instanceId is not exist");
                    o.a(b, "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString3);
                View view = linkedHashMapB.get(strOptString2);
                if (viewGroup != null && view != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                    if (view instanceof ATTempContainer) {
                        Iterator<View> it = linkedHashMapB.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof AnythinkBTContainer) {
                                u.a(view);
                                ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, jSONObjectOptJSONObject2);
                                break;
                            }
                        }
                    } else {
                        Rect rect = null;
                        int iOptInt2 = 0;
                        if (jSONObjectOptJSONObject2 != null) {
                            Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                            iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                            iOptInt = jSONObjectOptJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            iOptInt2 = ((BTBaseView) view).getViewWidth();
                            iOptInt = ((BTBaseView) view).getViewHeight();
                        } else {
                            iOptInt = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, iOptInt2, iOptInt));
                    }
                    a(obj, strOptString2);
                    a(obj, "onAppendViewTo", strOptString2);
                    o.a(b, "appendViewTo parentId = " + strOptString3 + " childId = " + strOptString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void m(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId is not exist");
                o.a(b, "bringViewToFront failed: instanceId is not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                o.a(b, "bringViewToFront failed: view is null");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                o.a(b, "bringViewToFront failed: parent is null");
            } else {
                viewGroup.bringChildToFront(view);
                a(obj, strOptString2);
                a(obj, "onBringViewToFront", strOptString2);
                o.a(b, "bringViewToFront instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "bringViewToFront failed: " + th.getMessage());
        }
    }

    public final void n(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "hideView failed: instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "hideView failed: view not exist");
            } else {
                view.setVisibility(8);
                a(obj, strOptString2);
                a(obj, "onHideView", strOptString2);
                o.a(b, "hideView instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "hideView failed: + " + th.getMessage());
        }
    }

    public final void o(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "showView failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "showView failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                view.setVisibility(0);
                a(obj, strOptString2);
                a(obj, "onShowView", strOptString2);
                o.a(b, "showView instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "showView failed: " + th.getMessage());
        }
    }

    public final void p(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString(com.anythink.expressad.foundation.h.i.f10646d);
            if (TextUtils.isEmpty(strOptString3)) {
                c(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "setViewBgColor failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "setViewBgColor failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                a(obj, strOptString2);
                view.setBackgroundColor(Color.parseColor(strOptString3));
                a(obj, "onViewBgColorChanged", strOptString2);
                o.a(b, "setViewBgColor instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewBgColor failed: " + th.getMessage());
        }
    }

    public final void q(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double dOptDouble = jSONObjectOptJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "setViewAlpha failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "setViewAlpha failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                view.setAlpha((float) dOptDouble);
                a(obj, strOptString2);
                a(obj, "onViewAlphaChanged", strOptString2);
                o.a(b, "setViewAlpha instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewAlpha failed: " + th.getMessage());
        }
    }

    public final void r(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double dOptDouble = jSONObjectOptJSONObject.optDouble("vertical", 1.0d);
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "setViewScale failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "setViewScale failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            view.setScaleX((float) dOptDouble2);
            view.setScaleY((float) dOptDouble);
            a(obj, strOptString2);
            a(obj, "onViewScaleChanged", strOptString2);
            o.a(b, "setViewScale instanceId = ".concat(String.valueOf(strOptString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewScale failed: " + th.getMessage());
        }
    }

    public final void s(Object obj, JSONObject jSONObject) {
        int iOptInt;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewAbove failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewAbove failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            int iOptInt2 = 0;
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt2 = ((BTBaseView) view).getViewWidth();
                iOptInt = ((BTBaseView) view).getViewHeight();
            } else {
                iOptInt = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt2, iOptInt);
            u.a(view);
            viewGroup.addView(view, iIndexOfChild + 1, layoutParamsA);
            a(obj, strOptString2);
            a(obj, "onInsertViewAbove", strOptString2);
            o.a(b, "insertViewAbove instanceId = " + strOptString2 + " brotherId = " + strOptString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewAbove failed: " + th.getMessage());
        }
    }

    public final void t(Object obj, JSONObject jSONObject) {
        int iOptInt;
        int viewWidth;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewBelow failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewBelow failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                int iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                viewWidth = iOptInt2;
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                viewWidth = ((BTBaseView) view).getViewWidth();
                iOptInt = ((BTBaseView) view).getViewHeight();
            } else {
                viewWidth = 0;
                iOptInt = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, viewWidth, iOptInt);
            u.a(view);
            int i2 = iIndexOfChild - 1;
            if (i2 < 0) {
                i2 = 0;
            }
            viewGroup.addView(view, i2, layoutParamsA);
            a(obj, strOptString2);
            a(obj, "onInsertViewBelow", strOptString2);
            o.a(b, "insertViewBelow instanceId = ".concat(String.valueOf(strOptString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewBelow failed: " + th.getMessage());
        }
    }

    public final void u(Object obj, JSONObject jSONObject) {
        int iOptInt;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewAbove failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewAbove failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            int iOptInt2 = 0;
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt2 = ((BTBaseView) view).getViewWidth();
                iOptInt = ((BTBaseView) view).getViewHeight();
            } else {
                iOptInt = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, iIndexOfChild + 1, a(layoutParams, rect, iOptInt2, iOptInt));
            a(obj, strOptString2);
            a(obj, "onInsertViewAbove", strOptString2);
            o.a(b, "insertViewAbove instanceId = " + strOptString2 + " brotherId = " + strOptString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewAbove failed: " + th.getMessage());
        }
    }

    public final void v(Object obj, JSONObject jSONObject) {
        int iOptInt;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewBelow failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewBelow failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            int iOptInt2 = 0;
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt2 = ((BTBaseView) view).getViewWidth();
                iOptInt = ((BTBaseView) view).getViewHeight();
            } else {
                iOptInt = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, iIndexOfChild, a(layoutParams, rect, iOptInt2, iOptInt));
            a(obj, strOptString2);
            a(obj, "onInsertViewBelow", strOptString2);
            o.a(b, "insertViewBelow instanceId = ".concat(String.valueOf(strOptString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewBelow failed: " + th.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.anythink.expressad.video.bt.module.AnythinkBTWebView, com.anythink.expressad.video.bt.module.BTBaseView] */
    public final void w(Object obj, JSONObject jSONObject) {
        ?? r2;
        String strOptString;
        String strOptString2;
        String strH;
        JSONObject jSONObjectOptJSONObject;
        String str;
        Rect rect;
        int iOptInt;
        try {
            strOptString = jSONObject.optString("unitId");
            strOptString2 = jSONObject.optString("id");
            strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        } catch (Throwable th) {
            th = th;
            r2 = b;
        }
        if (jSONObjectOptJSONObject == null) {
            c(obj, "data is empty");
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("content");
        if (jSONObjectOptJSONObject2 == null) {
            c(obj, "content is empty");
            return;
        }
        String strOptString3 = jSONObjectOptJSONObject2.optString("fileURL");
        String strOptString4 = jSONObjectOptJSONObject2.optString(TbsReaderView.KEY_FILE_PATH);
        String strOptString5 = jSONObjectOptJSONObject2.optString(com.baidu.mobads.sdk.internal.a.f12785f);
        if (TextUtils.isEmpty(strOptString3) && TextUtils.isEmpty(strOptString4) && TextUtils.isEmpty(strOptString5)) {
            c(obj, "url is empty");
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("campaigns");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(jSONArrayOptJSONArray.getJSONObject(i2));
                if (cVarB != null) {
                    cVarB.l(strOptString);
                    arrayList.add(cVarB);
                }
            }
        }
        String strOptString6 = jSONObjectOptJSONObject2.optString("unitId");
        d dVarA = d.a(jSONObjectOptJSONObject2.optJSONObject("unitSetting"));
        if (dVarA != null) {
            dVarA.a(strOptString6);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("rect");
        Rect rect2 = new Rect(a, a, a, a);
        if (jSONObjectOptJSONObject3 != null) {
            int iOptInt2 = jSONObjectOptJSONObject3.optInt("left", a);
            int iOptInt3 = jSONObjectOptJSONObject3.optInt("top", a);
            int iOptInt4 = jSONObjectOptJSONObject3.optInt("right", a);
            str = b;
            try {
                rect = new Rect(iOptInt2, iOptInt3, iOptInt4, jSONObjectOptJSONObject3.optInt("bottom", a));
                int iOptInt5 = jSONObjectOptJSONObject3.optInt("width");
                iOptInt = jSONObjectOptJSONObject3.optInt("height");
                r2 = iOptInt5;
            } catch (Throwable th2) {
                th = th2;
                r2 = str;
                c(obj, th.getMessage());
                o.a((String) r2, "webviewLoad failed: " + th.getMessage());
            }
        } else {
            str = b;
            rect = rect2;
            iOptInt = 0;
            r2 = 0;
        }
        int iOptInt6 = jSONObjectOptJSONObject2.optInt("refreshCache", 0);
        try {
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            try {
                if (!linkedHashMapB.containsKey(strOptString2)) {
                    c(obj, "instanceId not exist");
                    o.a(str, "webviewLoad failed: instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                    return;
                }
                View view = linkedHashMapB.get(strOptString2);
                if (!(view instanceof AnythinkBTWebView)) {
                    c(obj, "view not exist");
                    o.a(str, "webviewLoad failed: view not exist instanceId = ".concat(String.valueOf(strOptString2)));
                    return;
                }
                ?? r4 = (AnythinkBTWebView) view;
                r4.setHtml(strOptString5);
                r4.setFilePath(strOptString4);
                r4.setFileURL(strOptString3);
                r4.setRect(rect);
                r4.setLayout(r2, iOptInt);
                r4.setCampaigns(arrayList);
                r4.setRewardUnitSetting(dVarA);
                r4.webviewLoad(iOptInt6);
                a(obj, strOptString2);
                o.a(str, "webviewLoad instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            r2 = str;
        }
        c(obj, th.getMessage());
        o.a((String) r2, "webviewLoad failed: " + th.getMessage());
    }

    public final void x(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "webviewReload failed instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTWebView)) {
                c(obj, "view not exist");
                o.a(b, "webviewReload failed view not exist instanceId = ".concat(String.valueOf(strOptString2)));
            } else if (((AnythinkBTWebView) view).webviewReload()) {
                a(obj, strOptString2);
                o.a(b, "webviewReload instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                c(obj, "reload failed");
                o.a(b, "webviewReload failed reload failed instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewReload failed: " + th.getMessage());
        }
    }

    public final void y(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "webviewGoBack failed instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTWebView)) {
                c(obj, "view not exist");
                o.a(b, "webviewGoBack failed view not exist instanceId = ".concat(String.valueOf(strOptString2)));
            } else if (((AnythinkBTWebView) view).webviewGoBack()) {
                a(obj, strOptString2);
                o.a(b, "webviewGoBack instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                c(obj, "webviewGoBack failed");
                o.a(b, "webviewGoBack failed instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewGoBack failed: " + th.getMessage());
        }
    }

    public final void z(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "webviewGoForward failed instanceId not exist instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof AnythinkBTWebView)) {
                c(obj, "view not exist");
                o.a(b, "webviewGoForward failed view not exist instanceId = ".concat(String.valueOf(strOptString2)));
            } else if (((AnythinkBTWebView) view).webviewGoForward()) {
                a(obj, strOptString2);
                o.a(b, "webviewGoForward instanceId = ".concat(String.valueOf(strOptString2)));
            } else {
                c(obj, "webviewGoForward failed");
                o.a(b, "webviewGoForward failed instanceId = ".concat(String.valueOf(strOptString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewGoForward failed: " + th.getMessage());
        }
    }

    private c() {
    }

    public static com.anythink.expressad.foundation.d.c a(String str) {
        if (f11459e.containsKey(str)) {
            return f11459e.get(str);
        }
        return null;
    }

    public static String c(String str) {
        return f11461g.containsKey(str) ? f11461g.get(str) : "";
    }

    public final void d(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                int iOptInt = jSONObjectOptJSONObject.optInt("mute");
                String rid = "";
                com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (cVarB != null && !TextUtils.isEmpty(strOptString)) {
                    cVarB.l(strOptString);
                    rid = cVarB.Z();
                }
                d dVarA = d.a(jSONObjectOptJSONObject.optJSONObject("unitSetting"));
                if (dVarA != null) {
                    dVarA.a(strOptString);
                }
                String strOptString2 = jSONObjectOptJSONObject.optString("userId");
                if (TextUtils.isEmpty(rid)) {
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if (aVar.a != null) {
                        rid = aVar.a.getRid();
                    }
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strB = b();
                f11458d.put(strB, rid);
                ATTempContainer aTTempContainer = new ATTempContainer(n.a().g());
                aTTempContainer.setInstanceId(strB);
                aTTempContainer.setUnitId(strOptString);
                aTTempContainer.setCampaign(cVarB);
                aTTempContainer.setRewardUnitSetting(dVarA);
                aTTempContainer.setBigOffer(true);
                if (!TextUtils.isEmpty(strOptString2)) {
                    aTTempContainer.setUserId(strOptString2);
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward");
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString3 = jSONObjectOptJSONObject2.optString("id");
                    com.anythink.expressad.videocommon.c.c cVar = new com.anythink.expressad.videocommon.c.c(jSONObjectOptJSONObject2.optString("name"), jSONObjectOptJSONObject2.optInt("amount"));
                    if (!TextUtils.isEmpty(strOptString3)) {
                        aTTempContainer.setRewardId(strOptString3);
                    }
                    if (!TextUtils.isEmpty(cVar.a())) {
                        aTTempContainer.setReward(cVar);
                    }
                }
                String strOptString4 = jSONObjectOptJSONObject.optString("extra");
                if (!TextUtils.isEmpty(strOptString4)) {
                    aTTempContainer.setDeveloperExtraData(strOptString4);
                }
                aTTempContainer.setMute(iOptInt);
                linkedHashMapB.put(strB, aTTempContainer);
                f11461g.put(strB, strOptString);
                f11459e.put(strB, cVarB);
                f11460f.put(strB, dVarA);
                a(obj, strB);
                o.a(b, "createSubPlayTemplateView instanceId = ".concat(String.valueOf(strB)));
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createSubPlayTemplateView failed：" + th.getMessage());
        }
    }

    public static d b(String str) {
        if (f11460f.containsKey(str)) {
            return f11460f.get(str);
        }
        return null;
    }

    public final void e(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") != null && !TextUtils.isEmpty(strOptString)) {
                String strH = h(strOptString2);
                if (TextUtils.isEmpty(strH)) {
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if (aVar.a != null) {
                        strH = aVar.a.getRid();
                    }
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (linkedHashMapB != null && linkedHashMapB.containsKey(strOptString2)) {
                    View view = linkedHashMapB.get(strOptString2);
                    linkedHashMapB.remove(strOptString2);
                    if (view != null && view.getParent() != null) {
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(view);
                        }
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) view;
                            if (viewGroup2.getChildCount() > 0) {
                                int childCount = viewGroup2.getChildCount();
                                for (int i2 = 0; i2 < childCount; i2++) {
                                    View childAt = viewGroup2.getChildAt(i2);
                                    if (childAt instanceof AnythinkBTWebView) {
                                        linkedHashMapB.remove(((AnythinkBTWebView) childAt).getInstanceId());
                                        ((AnythinkBTWebView) childAt).onDestory();
                                    } else if (childAt instanceof AnythinkBTVideoView) {
                                        linkedHashMapB.remove(((AnythinkBTVideoView) childAt).getInstanceId());
                                        ((AnythinkBTVideoView) childAt).onDestory();
                                    } else if (childAt instanceof ATTempContainer) {
                                        linkedHashMapB.remove(((ATTempContainer) childAt).getInstanceId());
                                        ((ATTempContainer) childAt).onDestroy();
                                    }
                                }
                            }
                        }
                    }
                    if (view instanceof ATTempContainer) {
                        ((ATTempContainer) view).onDestroy();
                    }
                    if (view instanceof AnythinkBTWebView) {
                        ((AnythinkBTWebView) view).onDestory();
                    }
                    if (view instanceof AnythinkBTVideoView) {
                        ((AnythinkBTVideoView) view).onDestory();
                    }
                    a(obj, strOptString2);
                    a(obj, "onComponentDestroy", strOptString2);
                    o.a(b, "destroyComponent instanceId = ".concat(String.valueOf(strOptString2)));
                    return;
                }
                c(obj, "unitId or instanceId not exist");
                o.a(b, "destroyComponent failed");
                return;
            }
            c(obj, "unidId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "destroyComponent failed");
        }
    }

    public final void g(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            if (jSONObjectOptJSONObject2 == null) {
                c(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            Rect rect = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
            int iOptInt = jSONObjectOptJSONObject2.optInt("width");
            int iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
            if (linkedHashMapB.containsKey(strOptString2)) {
                View view = linkedHashMapB.get(strOptString2);
                if (view != null) {
                    if (view.getParent() != null) {
                        view.setLayoutParams(a(view.getLayoutParams(), rect, iOptInt, iOptInt2));
                        view.requestLayout();
                    } else {
                        if (view instanceof AnythinkBTWebView) {
                            ((AnythinkBTWebView) view).setRect(rect);
                            ((AnythinkBTWebView) view).setLayout(iOptInt, iOptInt2);
                        }
                        if (view instanceof AnythinkBTVideoView) {
                            ((AnythinkBTVideoView) view).setRect(rect);
                            ((AnythinkBTVideoView) view).setLayout(iOptInt, iOptInt2);
                        }
                    }
                    a(obj, strOptString2);
                    a(obj, "onViewRectChanged", strOptString2);
                    o.a(b, "setViewRect instanceId = ".concat(String.valueOf(strOptString2)));
                    return;
                }
                c(obj, "view is null");
                o.a(b, "setViewRect failed: view is null");
                return;
            }
            c(obj, "instanceId not exist");
            o.a(b, "setViewRect failed: instanceId not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewRect failed: " + th.getMessage());
        }
    }

    public final void h(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (linkedHashMapB.containsKey(strOptString2)) {
                View view = linkedHashMapB.get(strOptString2);
                if (view != null && view.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                        a(obj, strOptString2);
                        a(obj, "onRemoveFromView", strOptString2);
                        o.a(b, "removeFromSuperView instanceId = ".concat(String.valueOf(strOptString2)));
                        return;
                    }
                    c(obj, "parent is null");
                    o.a(b, "removeFromSuperView failed: parent is null instanceId = ".concat(String.valueOf(strOptString2)));
                    return;
                }
                c(obj, "view is null");
                o.a(b, "removeFromSuperView failed: view is null instanceId = ".concat(String.valueOf(strOptString2)));
                return;
            }
            c(obj, "params not enough");
            o.a(b, "removeFromSuperView failed: params not enough instanceId = ".concat(String.valueOf(strOptString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "removeFromSuperView failed: " + th.getMessage());
        }
    }

    public final void i(Object obj, JSONObject jSONObject) {
        int iOptInt;
        try {
            String strOptString = jSONObject.optString("unitId");
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    strH = aVar.a.getRid();
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("id");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (linkedHashMapB.containsKey(strOptString3) && linkedHashMapB.containsKey(strOptString2)) {
                ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString2);
                View view = linkedHashMapB.get(strOptString3);
                u.a(view);
                if (viewGroup != null && view != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                    int iOptInt2 = 0;
                    if (view instanceof ATTempContainer) {
                        o.d(b, "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(f11468n), Integer.valueOf(f11469o), Integer.valueOf(f11470p), Integer.valueOf(f11471q), Integer.valueOf(f11472r)));
                        ((ATTempContainer) view).setNotchPadding(f11468n, f11469o, f11470p, f11471q, f11472r);
                        Iterator<View> it = linkedHashMapB.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            View next = it.next();
                            if (next instanceof AnythinkBTContainer) {
                                u.a(view);
                                ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, jSONObjectOptJSONObject2);
                                break;
                            }
                        }
                    } else {
                        Rect rect = null;
                        if (jSONObjectOptJSONObject2 == null) {
                            if (view instanceof BTBaseView) {
                                rect = ((BTBaseView) view).getRect();
                                iOptInt2 = ((BTBaseView) view).getViewWidth();
                                iOptInt = ((BTBaseView) view).getViewHeight();
                            } else {
                                iOptInt = 0;
                            }
                        } else {
                            Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                            iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                            iOptInt = jSONObjectOptJSONObject2.optInt("height");
                            rect = rect2;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt2, iOptInt);
                        u.a(view);
                        viewGroup.addView(view, layoutParamsA);
                    }
                    a(obj, strOptString2);
                    a(obj, "onAppendView", strOptString2);
                    o.a(b, "appendSubView parentId = " + strOptString2 + " childId = " + strOptString3);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "instanceId is not exist");
            o.a(b, "appendSubView failed: instanceId is not exist");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendSubView failed: " + th.getMessage());
        }
    }

    public static void a(String str, String str2) {
        f11458d.put(str, str2);
    }

    private static void c(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11466l);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(b, e2.getMessage());
        }
    }

    public static void a(String str, Activity activity) {
        f11463i.put(str, activity);
    }

    public final synchronized LinkedHashMap<String, View> b(String str, String str2) {
        if (f11457c.containsKey(str + "_" + str2)) {
            return f11457c.get(str + "_" + str2);
        }
        LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
        f11457c.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    public static void a(String str, int i2) {
        f11462h.put(str, Integer.valueOf(i2));
    }

    public static void a(WebView webView, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11466l);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(b, e2.getMessage());
        }
    }

    public static void f(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            String strOptString = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                a(obj, strOptString);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public final void b(final Object obj, JSONObject jSONObject) {
        final Rect rect;
        final int i2;
        final int iOptInt;
        try {
            final String strOptString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(strOptString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            int iOptInt2 = jSONObjectOptJSONObject.optInt("delay", 0);
            final String strOptString2 = jSONObjectOptJSONObject.optString("fileURL");
            final String strOptString3 = jSONObjectOptJSONObject.optString(TbsReaderView.KEY_FILE_PATH);
            final String strOptString4 = jSONObjectOptJSONObject.optString(com.baidu.mobads.sdk.internal.a.f12785f);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(a, a, a, a);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect3 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                int iOptInt3 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                rect = rect3;
                i2 = iOptInt3;
            } else {
                rect = rect2;
                i2 = 0;
                iOptInt = 0;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.a.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    String rid;
                    WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                    if (windVaneWebView != null) {
                        rid = windVaneWebView.getRid();
                    } else {
                        rid = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> linkedHashMapB = c.this.b(strOptString, rid);
                    String strB = c.b();
                    c.f11458d.put(strB, rid);
                    AnythinkBTWebView anythinkBTWebView = new AnythinkBTWebView(n.a().g());
                    linkedHashMapB.put(strB, anythinkBTWebView);
                    anythinkBTWebView.setInstanceId(strB);
                    anythinkBTWebView.setUnitId(strOptString);
                    anythinkBTWebView.setFileURL(strOptString2);
                    anythinkBTWebView.setFilePath(strOptString3);
                    anythinkBTWebView.setHtml(strOptString4);
                    anythinkBTWebView.setRect(rect);
                    anythinkBTWebView.setWebViewRid(rid);
                    anythinkBTWebView.setCreateWebView(windVaneWebView);
                    if (i2 > 0 || iOptInt > 0) {
                        anythinkBTWebView.setLayout(i2, iOptInt);
                    }
                    anythinkBTWebView.preload();
                    c.a(obj, strB);
                    o.a(c.b, "createWebview instanceId = ".concat(String.valueOf(strB)));
                }
            }, iOptInt2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createWebview failed：" + th.getMessage());
        }
    }

    public final void c(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("unitId");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String rid = "";
                com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (cVarB != null && !TextUtils.isEmpty(strOptString)) {
                    cVarB.l(strOptString);
                    rid = cVarB.Z();
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("show_time", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("show_mute", 0);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("show_close", 0);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("orientation", 1);
                int iOptInt5 = jSONObjectOptJSONObject.optInt("show_pgb", 0);
                AnythinkBTVideoView anythinkBTVideoView = new AnythinkBTVideoView(n.a().g());
                anythinkBTVideoView.setCampaign(cVarB);
                anythinkBTVideoView.setUnitId(strOptString);
                anythinkBTVideoView.setShowMute(iOptInt2);
                anythinkBTVideoView.setShowTime(iOptInt);
                anythinkBTVideoView.setShowClose(iOptInt3);
                anythinkBTVideoView.setOrientation(iOptInt4);
                anythinkBTVideoView.setProgressBarState(iOptInt5);
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    rid = windVaneWebView.getRid();
                    anythinkBTVideoView.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strB = b();
                f11458d.put(strB, rid);
                anythinkBTVideoView.setInstanceId(strB);
                linkedHashMapB.put(strB, anythinkBTVideoView);
                anythinkBTVideoView.preLoadData();
                if (cVarB == null) {
                    c(obj, "campaign is null");
                    o.a(b, "createPlayerView failed");
                } else {
                    a(obj, strB);
                    o.a(b, "createPlayerView instanceId = ".concat(String.valueOf(strB)));
                }
                com.anythink.expressad.video.bt.a.a.a();
                com.anythink.expressad.video.bt.a.a.a(strB, anythinkBTVideoView);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createPlayerView failed：" + th.getMessage());
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11465k);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            c(obj, e2.getMessage());
            o.a(b, e2.getMessage());
        }
    }

    private static void a(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11465k);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            c(obj, e2.getMessage());
            o.a(b, e2.getMessage());
        }
    }

    public static void b(Object obj, String str) {
        o.a(b, "reportUrls:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("type");
                String strOptString = jSONObject.optString("url");
                int iOptInt2 = jSONObject.optInt(AgooConstants.MESSAGE_REPORT);
                boolean z2 = true;
                if (iOptInt2 == 0) {
                    Context contextG = n.a().g();
                    if (iOptInt == 0) {
                        z2 = false;
                    }
                    com.anythink.expressad.a.a.a(contextG, (com.anythink.expressad.foundation.d.c) null, "", strOptString, z2);
                } else {
                    com.anythink.expressad.a.a.a(n.a().g(), null, "", strOptString, false, iOptInt != 0, iOptInt2);
                }
            }
            a(obj, "");
        } catch (Throwable th) {
            o.b(b, "reportUrls", th);
        }
    }

    public static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11465k);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            j.a();
            j.a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(webView, e2.getMessage());
            o.a(b, e2.getMessage());
        }
    }

    public final void a(final Object obj, JSONObject jSONObject) {
        final Rect rect;
        final int i2;
        final int iOptInt;
        try {
            final String strOptString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(strOptString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            int iOptInt2 = jSONObjectOptJSONObject.optInt("delay", 0);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(a, a, a, a);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect3 = new Rect(jSONObjectOptJSONObject2.optInt("left", a), jSONObjectOptJSONObject2.optInt("top", a), jSONObjectOptJSONObject2.optInt("right", a), jSONObjectOptJSONObject2.optInt("bottom", a));
                int iOptInt3 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                rect = rect3;
                i2 = iOptInt3;
            } else {
                rect = rect2;
                i2 = 0;
                iOptInt = 0;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    String rid;
                    WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                    if (windVaneWebView != null) {
                        rid = windVaneWebView.getRid();
                    } else {
                        rid = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> linkedHashMapB = c.this.b(strOptString, rid);
                    String strB = c.b();
                    c.f11458d.put(strB, rid);
                    AnythinkBTLayout anythinkBTLayout = new AnythinkBTLayout(n.a().g());
                    linkedHashMapB.put(strB, anythinkBTLayout);
                    anythinkBTLayout.setInstanceId(strB);
                    anythinkBTLayout.setUnitId(strOptString);
                    anythinkBTLayout.setWebView(windVaneWebView);
                    anythinkBTLayout.setRect(rect);
                    if (i2 > 0 || iOptInt > 0) {
                        anythinkBTLayout.setLayout(i2, iOptInt);
                    }
                    c.a(obj, strB);
                    o.a(c.b, "create view instanceId = ".concat(String.valueOf(strB)));
                }
            }, iOptInt2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "create view failed：" + th.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.LinearLayout$LayoutParams] */
    private static ViewGroup.LayoutParams a(ViewGroup.LayoutParams layoutParams, Rect rect, int i2, int i3) {
        if (rect == null) {
            rect = new Rect(a, a, a, a);
        }
        Context contextG = n.a().g();
        if (contextG == null) {
            return layoutParams;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int i4 = rect.left;
            if (i4 != -999) {
                layoutParams2.leftMargin = t.b(contextG, i4);
            }
            int i5 = rect.top;
            if (i5 != -999) {
                layoutParams2.topMargin = t.b(contextG, i5);
            }
            int i6 = rect.right;
            if (i6 != -999) {
                layoutParams2.rightMargin = t.b(contextG, i6);
            }
            int i7 = rect.bottom;
            if (i7 != -999) {
                layoutParams2.bottomMargin = t.b(contextG, i7);
            }
            if (i2 > 0) {
                layoutParams2.width = t.b(contextG, i2);
            }
            if (i3 > 0) {
                layoutParams2.height = t.b(contextG, i3);
            }
            return layoutParams2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            int i8 = rect.left;
            if (i8 != -999) {
                layoutParams3.leftMargin = t.b(contextG, i8);
            }
            int i9 = rect.top;
            if (i9 != -999) {
                layoutParams3.topMargin = t.b(contextG, i9);
            }
            int i10 = rect.right;
            if (i10 != -999) {
                layoutParams3.rightMargin = t.b(contextG, i10);
            }
            int i11 = rect.bottom;
            if (i11 != -999) {
                layoutParams3.bottomMargin = t.b(contextG, i11);
            }
            if (i2 > 0) {
                layoutParams3.width = t.b(contextG, i2);
            }
            if (i3 > 0) {
                layoutParams3.height = t.b(contextG, i3);
            }
            return layoutParams3;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
            int i12 = rect.left;
            if (i12 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = t.b(contextG, i12);
            }
            int i13 = rect.top;
            if (i13 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = t.b(contextG, i13);
            }
            int i14 = rect.right;
            if (i14 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = t.b(contextG, i14);
            }
            int i15 = rect.bottom;
            if (i15 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = t.b(contextG, i15);
            }
            if (i2 > 0) {
                ((LinearLayout.LayoutParams) layoutParams).width = t.b(contextG, i2);
            }
            if (i3 > 0) {
                ((LinearLayout.LayoutParams) layoutParams).height = t.b(contextG, i3);
            }
        }
        return layoutParams;
    }

    public static void a(Object obj) {
        try {
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    private static void a(String str, com.anythink.expressad.foundation.d.c cVar) {
        if (f.f10445k == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "reward");
    }

    public static void a(int i2, int i3, int i4, int i5, int i6) {
        o.a(b, "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)));
        f11467m = h.a(i2, i3, i4, i5, i6);
        f11468n = i2;
        f11469o = i3;
        f11470p = i4;
        f11471q = i5;
        f11472r = i6;
    }

    private static void a(String str, String str2, String str3) {
        try {
            LinkedHashMap<String, View> linkedHashMapB = a.a.b(str, str2);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).notifyEvent(str3);
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).notifyEvent(str3);
                } else if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).notifyEvent(str3);
                }
            }
        } catch (Throwable th) {
            o.a(b, th.getMessage());
        }
    }
}
