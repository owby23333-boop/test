package com.tencent.smtt.sdk;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class GeolocationPermissions {
    private static GeolocationPermissions a;

    private static synchronized GeolocationPermissions a() {
        if (a == null) {
            a = new GeolocationPermissions();
        }
        return a;
    }

    public static GeolocationPermissions getInstance() {
        return a();
    }

    public void allow(String str) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        } else {
            wVarA.c().g(str);
        }
    }

    public void clear(String str) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        } else {
            wVarA.c().f(str);
        }
    }

    public void clearAll() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        } else {
            wVarA.c().o();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        } else {
            wVarA.c().c(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        } else {
            wVarA.c().b(valueCallback);
        }
    }
}
