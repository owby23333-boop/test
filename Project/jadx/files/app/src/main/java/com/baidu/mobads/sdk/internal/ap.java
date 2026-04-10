package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ap {
    private static final String a = w.f13191p;
    private static final String b = "pauseDlByPk";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12861c = "resumeDownload";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12862d = "getDownloadStatus";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ap f12863f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private aq f12864e;

    private ap(Context context) {
        this.f12864e = aq.a(context, a);
    }

    public static ap a(Context context) {
        if (f12863f == null) {
            synchronized (ap.class) {
                if (f12863f == null) {
                    f12863f = new ap(context);
                }
            }
        }
        return f12863f;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12864e.a(null, b, str);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object objB = this.f12864e.b(null, f12861c, context, jSONObject, str, str2);
            if (objB instanceof Boolean) {
                return ((Boolean) objB).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (br.a(context, str)) {
            return 103;
        }
        Object objB = this.f12864e.b(null, f12862d, str);
        if (objB instanceof Integer) {
            return ((Integer) objB).intValue();
        }
        return -1;
    }
}
