package com.anythink.expressad.atsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public final class MBWebViewChecker {
    private static volatile Boolean a;
    private static volatile Handler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f8295c;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
        } catch (Exception unused) {
            webView = null;
        }
        return webView != null;
    }

    public static boolean isWebViewAvailable(final Context context) {
        Boolean bool = Boolean.FALSE;
        f8295c = bool;
        if (bool == null || !f8295c.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (a == null) {
                try {
                    a = Boolean.valueOf(b(context));
                } catch (Exception unused) {
                    a = Boolean.FALSE;
                }
            }
            if (a == null) {
                a = Boolean.FALSE;
            }
            return a.booleanValue();
        }
        if (a == null && b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            b = handler;
            handler.post(new Runnable() { // from class: com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MBWebViewChecker.a == null) {
                        try {
                            Boolean unused2 = MBWebViewChecker.a = Boolean.valueOf(MBWebViewChecker.b(context));
                        } catch (Exception unused3) {
                            Boolean unused4 = MBWebViewChecker.a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (a == null) {
            return true;
        }
        return a.booleanValue();
    }
}
