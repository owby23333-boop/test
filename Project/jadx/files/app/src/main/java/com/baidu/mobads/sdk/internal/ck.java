package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ck implements Thread.UncaughtExceptionHandler {
    public static String a = "";
    private static final String b = "remote";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13024c = "proxy";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13025d = "third-mtj";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13026e = "third-novel";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f13027f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile ck f13028g = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f13029j = "key_crash_source";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f13030k = "key_crash_trace";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f13031l = "key_crash_ad";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f13032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f13033i;

    interface a {
        void a(String str);
    }

    private ck(Context context) {
        this.f13032h = context.getApplicationContext();
        f13027f = Thread.getDefaultUncaughtExceptionHandler();
    }

    private List<String> d() {
        IXAdContainerFactory iXAdContainerFactoryC;
        ArrayList arrayList = new ArrayList();
        try {
            z zVarA = z.a();
            if (zVarA != null && (iXAdContainerFactoryC = zVarA.c()) != null) {
                Object remoteParam = iXAdContainerFactoryC.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.f13032h.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor editorF = f();
        editorF.clear();
        editorF.apply();
    }

    public void c() {
        this.f13033i = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String strA = a(th);
            if (strA != null) {
                a(strA, Log.getStackTraceString(th));
                if (this.f13033i != null) {
                    this.f13033i.a(strA);
                }
            }
            if (f13027f != null) {
                f13027f.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof ck) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static ck a(Context context) {
        if (f13028g == null) {
            synchronized (ck.class) {
                if (f13028g == null) {
                    f13028g = new ck(context);
                }
            }
        }
        return f13028g;
    }

    public void a() {
        ba.a().a((h) new cl(this));
    }

    public void a(a aVar) {
        this.f13033i = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> listD = d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    break;
                }
                if (className.startsWith(w.aq) || className.startsWith(w.ar) || className.startsWith(w.as)) {
                    return b;
                }
                if (className.startsWith(w.at) || className.startsWith(w.au) || className.startsWith(w.av)) {
                    return "proxy";
                }
                if (className.startsWith(w.aw)) {
                    return f13025d;
                }
                if (!className.startsWith(w.ax) && !className.startsWith(w.ay)) {
                    if (a(className, listD)) {
                        return b;
                    }
                } else if (cj.f13022g.booleanValue()) {
                    return f13026e;
                }
            }
        }
        return null;
    }

    private boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorF = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + " ";
        editorF.putString(f13029j, str);
        editorF.putString(f13030k, str3 + str2);
        editorF.putString(f13031l, a);
        editorF.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return e().getString(str, "");
    }
}
