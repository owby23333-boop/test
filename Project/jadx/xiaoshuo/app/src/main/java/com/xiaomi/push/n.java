package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n f8162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f879a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, Map<String, String>> f880a = new HashMap();

    private n(Context context) {
        this.f878a = context;
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f880a == null) {
            this.f880a = new HashMap();
        }
        Map<String, String> map = this.f880a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f880a.put(str, map);
    }

    public static n a(Context context) {
        if (f8162a == null) {
            synchronized (n.class) {
                if (f8162a == null) {
                    f8162a = new n(context);
                }
            }
        }
        return f8162a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m692a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f879a.post(new o(this, str, str2, str3));
    }

    private synchronized String a(String str, String str2) {
        if (this.f880a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f880a.get(str);
                    if (map == null) {
                        return "";
                    }
                    return map.get(str2);
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    public synchronized String a(String str, String str2, String str3) {
        String strA = a(str, str2);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        return this.f878a.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
