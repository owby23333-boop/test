package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class CookieSyncManager {
    private static android.webkit.CookieSyncManager a = null;
    private static CookieSyncManager b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f18834c = false;

    private CookieSyncManager(Context context) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            return;
        }
        wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        f18834c = true;
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        a = android.webkit.CookieSyncManager.createInstance(context);
        if (b == null || !f18834c) {
            b = new CookieSyncManager(context.getApplicationContext());
        }
        return b;
    }

    public static synchronized CookieSyncManager getInstance() {
        if (b == null) {
            throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
        }
        return b;
    }

    public void startSync() {
        w wVarA = w.a();
        if (wVarA != null && wVarA.b()) {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
            return;
        }
        a.startSync();
        try {
            Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
            declaredField.setAccessible(true);
            ((Thread) declaredField.get(a)).setUncaughtExceptionHandler(new h());
        } catch (Exception unused) {
        }
    }

    public void stopSync() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            a.stopSync();
        } else {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            a.sync();
        } else {
            wVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
