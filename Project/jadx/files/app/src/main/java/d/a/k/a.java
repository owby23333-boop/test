package d.a.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.http.NetworkSdkSetting;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile boolean a = false;
    private static CookieManager b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f20716c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static C0562a f20717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static SharedPreferences f20718e;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d.a.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    static class C0562a {
        String a;
        String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f20719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f20720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f20721e;

        C0562a(String str) {
            this.a = str;
            String string = a.f20718e.getString("networksdk_cookie_monitor", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (!TextUtils.isEmpty(this.a) && this.a.equals(jSONObject.getString("cookieName"))) {
                    this.f20721e = jSONObject.getLong("time");
                    if (System.currentTimeMillis() - this.f20721e < 86400000) {
                        this.b = jSONObject.getString("cookieText");
                        this.f20719c = jSONObject.getString("setCookie");
                        this.f20720d = jSONObject.getString("domain");
                    } else {
                        this.f20721e = 0L;
                        a.f20718e.edit().remove("networksdk_cookie_monitor").apply();
                    }
                }
            } catch (JSONException e2) {
                ALog.e("anet.CookieManager", "cookie json parse error.", null, e2, new Object[0]);
            }
        }

        void a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cookieName", this.a);
                jSONObject.put("cookieText", this.b);
                jSONObject.put("setCookie", this.f20719c);
                this.f20721e = System.currentTimeMillis();
                jSONObject.put("time", this.f20721e);
                jSONObject.put("domain", this.f20720d);
                a.f20718e.edit().putString("networksdk_cookie_monitor", jSONObject.toString()).apply();
            } catch (Exception e2) {
                ALog.e("anet.CookieManager", "cookie json save error.", null, e2, new Object[0]);
            }
        }
    }

    private static boolean d() {
        if (!a && NetworkSdkSetting.getContext() != null) {
            a(NetworkSdkSetting.getContext());
        }
        return a;
    }

    private static void e() {
        ThreadPoolExecutorFactory.submitCookieMonitor(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f() {
        SharedPreferences sharedPreferences = f20718e;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("networksdk_target_cookie_name", null);
    }

    public static synchronized void b(String str, String str2) {
        if (d.a.j.b.g()) {
            if (d() && f20716c) {
                try {
                    b.setCookie(str, str2);
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        b.flush();
                    }
                } catch (Throwable th) {
                    ALog.e("anet.CookieManager", "set cookie failed.", null, th, "url", str, "cookies", str2);
                }
            }
        }
    }

    public static void c(String str) {
        SharedPreferences sharedPreferences;
        if (str == null || (sharedPreferences = f20718e) == null) {
            return;
        }
        sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
    }

    public static synchronized void a(Context context) {
        if (d.a.j.b.g()) {
            if (a) {
                return;
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(context);
                }
                b = CookieManager.getInstance();
                b.setAcceptCookie(true);
                if (Build.VERSION.SDK_INT < 21) {
                    b.removeExpiredCookie();
                }
                f20718e = PreferenceManager.getDefaultSharedPreferences(context);
                e();
                ALog.e("anet.CookieManager", "CookieManager setup.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th) {
                f20716c = false;
                ALog.e("anet.CookieManager", "Cookie Manager setup failed!!!", null, th, new Object[0]);
            }
            a = true;
        }
    }

    public static synchronized String b(String str) {
        String cookie = null;
        if (!d.a.j.b.g()) {
            return null;
        }
        if (!d() || !f20716c) {
            return null;
        }
        try {
            cookie = b.getCookie(str);
        } catch (Throwable th) {
            ALog.e("anet.CookieManager", "get cookie failed. url=" + str, null, th, new Object[0]);
        }
        a(str, cookie);
        return cookie;
    }

    public static void a(String str, Map<String, List<String>> map) {
        if (!d.a.j.b.g() || str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && (key.equalsIgnoreCase(HttpConstant.SET_COOKIE) || key.equalsIgnoreCase(HttpConstant.SET_COOKIE2))) {
                    for (String str2 : entry.getValue()) {
                        b(str, str2);
                        a(str2);
                    }
                }
            }
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "set cookie failed", null, e2, "url", str, "\nheaders", map);
        }
    }

    private static void a(String str) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new c(str));
    }

    private static void a(String str, String str2) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new d(str, str2));
    }
}
