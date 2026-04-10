package com.tencent.smtt.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewDatabase {
    private static WebViewDatabase a;
    private Context b;

    protected WebViewDatabase(Context context) {
        this.b = context;
    }

    private static synchronized WebViewDatabase a(Context context) {
        if (a == null) {
            a = new WebViewDatabase(context);
        }
        return a;
    }

    public static WebViewDatabase getInstance(Context context) {
        return a(context);
    }

    public void clearFormData() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
        } else {
            wVarA.c().g(this.b);
        }
    }

    public void clearHttpAuthUsernamePassword() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
        } else {
            wVarA.c().e(this.b);
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
        } else {
            wVarA.c().c(this.b);
        }
    }

    public boolean hasFormData() {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasFormData() : wVarA.c().f(this.b);
    }

    public boolean hasHttpAuthUsernamePassword() {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword() : wVarA.c().d(this.b);
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword() : wVarA.c().b(this.b);
    }
}
