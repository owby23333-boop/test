package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.IProcessName;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    public static int a;
    public static String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f18129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f18130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f18131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static IProcessName f18132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static AtomicInteger f18133g = new AtomicInteger(-1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f18134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Context f18135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ActivityManager f18136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ConnectivityManager f18137k;

    private a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (f18135i == null) {
            f18135i = context.getApplicationContext();
        }
    }

    public static a a(Context context) {
        if (f18134h == null) {
            synchronized (a.class) {
                if (f18134h == null) {
                    f18134h = new a(context);
                }
            }
        }
        return f18134h;
    }

    public static boolean c() {
        return f18133g.intValue() == 0;
    }

    public ConnectivityManager b() {
        if (this.f18137k == null) {
            this.f18137k = (ConnectivityManager) f18135i.getSystemService("connectivity");
        }
        return this.f18137k;
    }

    public ActivityManager a() {
        if (this.f18136j == null) {
            this.f18136j = (ActivityManager) f18135i.getSystemService("activity");
        }
        return this.f18136j;
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(b)) {
            str2 = str + ".TaobaoIntentService";
        } else {
            str2 = b;
        }
        ALog.d("AdapterGlobalClientInfo", "getAgooCustomServiceName", "serviceName", str2);
        return str2;
    }
}
