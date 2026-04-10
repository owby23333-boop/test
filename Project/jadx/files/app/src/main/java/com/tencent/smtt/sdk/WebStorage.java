package com.tencent.smtt.sdk;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WebStorage {
    private static WebStorage a;

    @Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j2);
    }

    private static synchronized WebStorage a() {
        if (a == null) {
            a = new WebStorage();
        }
        return a;
    }

    public static WebStorage getInstance() {
        return a();
    }

    public void deleteAllData() {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebStorage.getInstance().deleteAllData();
        } else {
            wVarA.c().n();
        }
    }

    public void deleteOrigin(String str) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        } else {
            wVarA.c().e(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        } else {
            wVarA.c().a(valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        } else {
            wVarA.c().b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        } else {
            wVarA.c().a(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j2) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j2);
        } else {
            wVarA.c().a(str, j2);
        }
    }
}
