package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static final String a = "re_po_rt";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static h f16732e;
    private SharedPreferences b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences.Editor f16733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f16734d;

    public h(Context context) {
        try {
            this.f16734d = context;
            this.b = context.getSharedPreferences("re_po_rt", 4);
            this.f16733c = this.b.edit();
        } catch (Throwable unused) {
        }
    }

    public h(Context context, String str) {
        try {
            this.f16734d = context;
            this.b = context.getSharedPreferences(str, 4);
            this.f16733c = this.b.edit();
        } catch (Throwable unused) {
        }
    }

    public static h a() {
        return f16732e;
    }

    public static synchronized h a(Context context, String str) {
        if (f16732e == null) {
            synchronized (h.class) {
                if (f16732e == null) {
                    f16732e = new h(context, str);
                }
            }
        }
        return f16732e;
    }

    public long a(String str, long j2) {
        return this.b.getLong(str, j2);
    }

    public String a(String str) {
        return this.b.getString(str, "");
    }

    public void a(Context context) {
        this.f16734d = context;
    }

    public void a(String str, int i2) {
        try {
            this.f16733c.putInt(str, i2);
            this.f16733c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, int i2, boolean z2) {
        try {
            this.f16733c.putInt(str, i2);
            if (z2) {
                this.f16733c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool) {
        this.f16733c.putBoolean(str, bool.booleanValue());
        this.f16733c.apply();
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f16733c.putString(str, str2);
            this.f16733c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, boolean z2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f16733c.putString(str, str2);
            if (z2) {
                this.f16733c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public int b(String str) {
        try {
            return this.b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int b(String str, int i2) {
        try {
            return this.b.getInt(str, i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public Context b() {
        return this.f16734d;
    }

    public String b(String str, String str2) {
        return this.b.getString(str, str2);
    }

    public String b(String str, String str2, boolean z2) {
        String strB = b(str, "");
        return !TextUtils.isEmpty(strB) ? z2 ? c.b(strB, 2) : strB : str2;
    }

    public void b(String str, long j2) {
        this.f16733c.putLong(str, j2);
        this.f16733c.apply();
    }

    public int c(String str) {
        try {
            return this.b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int c(String str, int i2) {
        try {
            return this.b.getInt(str, i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public void c() {
        try {
            this.f16733c.apply();
        } catch (Throwable unused) {
        }
    }

    public void c(String str, String str2) {
        try {
            this.f16733c.putString(str, str2);
            this.f16733c.apply();
        } catch (Exception unused) {
        }
    }

    public void c(String str, String str2, boolean z2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (z2) {
                str2 = c.b(str2.getBytes(), 2);
            }
            this.f16733c.putString(str, str2);
            this.f16733c.apply();
        } catch (Throwable unused) {
        }
    }

    public long d(String str) {
        return this.b.getLong(str, 0L);
    }

    public void d(String str, int i2) {
        this.f16733c.putInt(str, i2);
        this.f16733c.apply();
    }

    public boolean e(String str) {
        return this.b.getBoolean(str, false);
    }
}
