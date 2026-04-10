package com.anythink.expressad.atsignalcommon.c;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f8275c = 1;
    private String a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WindVaneWebView f8278f;

    /* JADX INFO: renamed from: com.anythink.expressad.atsignalcommon.c.a$a, reason: collision with other inner class name */
    private static class C0178a {
        static a a = new a(0);

        private C0178a() {
        }
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0178a.a;
    }

    private void b(Object obj) {
        a(obj, new JSONObject());
    }

    private a() {
        this.a = "ShakeCacheManager";
    }

    public final void a(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cache", this.f8277e);
            a(obj, jSONObject);
        } catch (JSONException e2) {
            a(obj, e2.getMessage(), new JSONObject());
        }
    }

    public final void a(Object obj, WindVaneWebView windVaneWebView, String str, String str2) {
        if ((!TextUtils.isEmpty(this.f8277e) && this.f8277e.equals(str)) || (TextUtils.isEmpty(this.f8277e) && TextUtils.isEmpty(str))) {
            this.f8277e = str2;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.f8276d = new JSONObject(str2).optString("sid");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f8278f = windVaneWebView;
            a(obj, new JSONObject());
            return;
        }
        String str3 = this.f8277e;
        if (windVaneWebView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("currentCache", str3);
                a(obj, "cache had changed", jSONObject);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void a(Object obj, WindVaneWebView windVaneWebView, String str) {
        if (!TextUtils.isEmpty(this.f8277e) && this.f8277e.equals(str)) {
            this.f8277e = "";
            this.f8278f = null;
            a(obj, windVaneWebView);
            a(obj, new JSONObject());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("currentCache", this.f8277e);
            a(obj, "cache is exception", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a(Object obj, WindVaneWebView windVaneWebView, String str, String str2, String str3) {
        if ((str + str2 + str3).equals(this.f8276d)) {
            a(obj, windVaneWebView);
        }
    }

    private static void a(Object obj, WindVaneWebView windVaneWebView) {
        if (windVaneWebView != null) {
            j.a().a(obj, "releaseShake", "");
        }
    }

    private void a(Object obj, WebView webView, String str, String str2) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("currentCache", str);
                a(obj, str2, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", b);
            jSONObject2.put("message", "");
            jSONObject2.put("data", jSONObject);
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(obj, e2.getMessage(), new JSONObject());
            o.a(this.a, e2.getMessage());
        }
    }

    private void a(Object obj, String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", f8275c);
            jSONObject2.put("message", str);
            jSONObject2.put("data", jSONObject);
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(this.a, e2.getMessage());
        }
    }
}
