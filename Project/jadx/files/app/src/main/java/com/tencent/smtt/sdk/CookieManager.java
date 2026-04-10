package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CookieManager {
    public static String LOGTAG = "CookieManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static CookieManager f18827c;
    CopyOnWriteArrayList<b> a;
    a b = a.MODE_NONE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18828d = false;

    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    class b {
        int a;
        String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f18831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ValueCallback<Boolean> f18832d;

        b() {
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (f18827c == null) {
            synchronized (CookieManager.class) {
                if (f18827c == null) {
                    f18827c = new CookieManager();
                }
            }
        }
        return f18827c;
    }

    public static int getROMCookieDBVersion(Context context) {
        return context.getSharedPreferences("cookiedb_info", Build.VERSION.SDK_INT >= 11 ? 4 : 0).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("cookiedb_info", Build.VERSION.SDK_INT >= 11 ? 4 : 0).edit();
        editorEdit.putInt("db_version", i2);
        editorEdit.commit();
    }

    synchronized void a() {
        if (this.a != null && this.a.size() != 0) {
            w wVarA = w.a();
            if (wVarA == null || !wVarA.b()) {
                for (b bVar : this.a) {
                    int i2 = bVar.a;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            android.webkit.CookieManager.getInstance().setCookie(bVar.b, bVar.f18831c);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        com.tencent.smtt.utils.j.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, bVar.b, bVar.f18831c, bVar.f18832d);
                    }
                }
            } else {
                for (b bVar2 : this.a) {
                    int i3 = bVar2.a;
                    if (i3 == 1) {
                        setCookie(bVar2.b, bVar2.f18831c, bVar2.f18832d);
                    } else if (i3 == 2) {
                        setCookie(bVar2.b, bVar2.f18831c);
                    }
                }
            }
            this.a.clear();
        }
    }

    public boolean acceptCookie() {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.CookieManager.getInstance().acceptCookie() : wVarA.c().d();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            Object objInvokeStaticMethod = wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (objInvokeStaticMethod == null) {
                return true;
            }
            return ((Boolean) objInvokeStaticMethod).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        Object objA = com.tencent.smtt.utils.j.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class}, webView.getView());
        if (objA == null) {
            return false;
        }
        return ((Boolean) objA).booleanValue();
    }

    public void flush() {
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.j.a(android.webkit.CookieManager.getInstance(), "flush", (Class<?>[]) new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            return wVarA.c().a(str);
        }
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean hasCookies() {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.CookieManager.getInstance().hasCookies() : wVarA.c().h();
    }

    @Deprecated
    public void removeAllCookie() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            wVarA.c().e();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.j.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    @Deprecated
    public void removeExpiredCookie() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    @Deprecated
    public void removeSessionCookie() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.j.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", (Class<?>[]) new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z2) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z2) {
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z2));
        } else if (Build.VERSION.SDK_INT < 21) {
        } else {
            com.tencent.smtt.utils.j.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", (Class<?>[]) new Class[]{android.webkit.WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z2));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            if (!wVarA.d()) {
                b bVar = new b();
                bVar.a = 1;
                bVar.b = str;
                bVar.f18831c = str2;
                bVar.f18832d = valueCallback;
                if (this.a == null) {
                    this.a = new CopyOnWriteArrayList<>();
                }
                this.a.add(bVar);
            }
            if (Build.VERSION.SDK_INT < 21) {
            } else {
                com.tencent.smtt.utils.j.a(android.webkit.CookieManager.getInstance(), "setCookie", (Class<?>[]) new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
            }
        } else {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z2) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            if (!w.a().d()) {
                b bVar = new b();
                bVar.a = 2;
                bVar.b = str;
                bVar.f18831c = str2;
                bVar.f18832d = null;
                if (this.a == null) {
                    this.a = new CopyOnWriteArrayList<>();
                }
                this.a.add(bVar);
            }
            android.webkit.CookieManager.getInstance().setCookie(str, str2);
        } else {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        }
    }

    public void setCookies(Map<String, String[]> map) {
        w wVarA = w.a();
        if ((wVarA == null || !wVarA.b()) ? false : wVarA.c().a(map)) {
            return;
        }
        for (String str : map.keySet()) {
            for (String str2 : map.get(str)) {
                setCookie(str, str2);
            }
        }
    }
}
