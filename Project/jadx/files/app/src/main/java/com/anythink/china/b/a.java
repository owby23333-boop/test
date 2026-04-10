package com.anythink.china.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.p;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static String a = "";
    private static String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f6354c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f6355d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f6356e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f6357f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f6358g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f6359h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f6360i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f6361j = false;

    public static void a(final Context context) {
        String strB = p.b(context, g.f6799o, "oaid", "");
        f6354c = strB;
        if (TextUtils.isEmpty(strB) && !n.a().c("oaid") && TextUtils.isEmpty(f6354c)) {
            com.anythink.china.a.b.a(context, new com.anythink.china.a.a() { // from class: com.anythink.china.b.a.1
                @Override // com.anythink.china.a.a
                public final void a() {
                }

                @Override // com.anythink.china.a.a
                public final void a(String str, boolean z2) {
                    if (a.a(str)) {
                        return;
                    }
                    String unused = a.f6354c = str;
                    p.a(context, g.f6799o, "oaid", str);
                }
            });
        }
        a = n.a().c("mac") ? "" : Build.VERSION.SDK_INT < 23 ? d.a(context) : d.a();
        b = d(context);
        f6355d = b.a();
        String[] strArrC = b.c(context);
        if (strArrC != null && strArrC.length == 2) {
            f6356e = strArrC[0];
            f6357f = strArrC[1];
        }
        f6358g = b.b();
        f6359h = b.c();
        f6360i = b.d();
    }

    public static String c(final Context context) {
        if (n.a().c("oaid")) {
            return "";
        }
        if (!TextUtils.isEmpty(f6354c)) {
            return f6354c;
        }
        String strB = p.b(context, g.f6799o, "oaid", "");
        f6354c = strB;
        if (!TextUtils.isEmpty(strB)) {
            return f6354c;
        }
        final Object obj = new Object();
        final boolean[] zArr = {false};
        com.anythink.china.a.b.a(context, new com.anythink.china.a.a() { // from class: com.anythink.china.b.a.2
            @Override // com.anythink.china.a.a
            public final void a(String str, boolean z2) {
                if (!a.a(str)) {
                    String unused = a.f6354c = str;
                    p.a(context, g.f6799o, "oaid", str);
                }
                try {
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                } catch (Throwable unused2) {
                }
                zArr[0] = true;
            }

            @Override // com.anythink.china.a.a
            public final void a() {
                zArr[0] = true;
                try {
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                } catch (Throwable unused) {
                }
            }
        });
        if (!zArr[0]) {
            try {
                synchronized (obj) {
                    obj.wait(1500L);
                }
            } catch (Exception unused) {
            }
        }
        String str = f6354c;
        return str != null ? str : "";
    }

    public static synchronized String d(Context context) {
        if (n.a().c("imei")) {
            return "";
        }
        if (!f6361j && TextUtils.isEmpty(b) && com.anythink.china.common.d.a(context, "android.permission.READ_PHONE_STATE")) {
            b = c.a(context);
            f6361j = true;
        }
        return b;
    }

    public static String e() {
        return b.a(n.a().g());
    }

    public static String f() {
        return f6356e;
    }

    public static String g() {
        return f6357f;
    }

    public static String h() {
        return f6358g;
    }

    public static String i() {
        return f6359h;
    }

    public static String j() {
        return f6360i;
    }

    public static String b(Context context) {
        d(context);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String strC = c(context);
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static String b() {
        return n.a().c("oaid") ? "" : f6354c;
    }

    public static String d() {
        return f6355d;
    }

    private static boolean c(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String c() {
        return n.a().c("wifi_name") ? "" : b.b(n.a().g());
    }

    public static String a() {
        return n.a().c("mac") ? "" : a;
    }

    static /* synthetic */ boolean a(String str) {
        return Pattern.matches("^[0-]+$", str);
    }
}
