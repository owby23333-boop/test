package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: renamed from: com.kuaishou.weapon.p0.do, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
public class Cdo {
    public static final String a = "plc001_t_re";
    public static final String b = "wlpauct2";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16709c = "plc001_pd_ptip_pi";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f16710d = "wiipaot";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16711e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f16712f = "a1_p_s_p_s";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f16713g = "a1_p_s_p_s_c_b";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Cdo f16714j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SharedPreferences f16715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SharedPreferences.Editor f16716i;

    private Cdo(Context context) {
        try {
            this.f16715h = context.getSharedPreferences(bh.f16579r, 4);
            this.f16716i = this.f16715h.edit();
        } catch (Throwable unused) {
        }
    }

    public static Cdo a() {
        return f16714j;
    }

    public static synchronized Cdo a(Context context) {
        try {
            if (f16714j == null) {
                f16714j = new Cdo(context);
            }
        } catch (Exception unused) {
            return null;
        }
        return f16714j;
    }

    public int a(String str, int i2) {
        try {
            return this.f16715h.getInt(str, i2);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public long a(String str) {
        return this.f16715h.getLong(str, 0L);
    }

    public String a(String str, String str2) {
        return this.f16715h.getString(str, str2);
    }

    public void a(String str, int i2, boolean z2) {
        try {
            this.f16716i.putInt(str, i2);
            if (z2) {
                this.f16716i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, long j2, boolean z2) {
        try {
            this.f16716i.putLong(str, j2);
            if (z2) {
                this.f16716i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool, boolean z2) {
        try {
            if (this.f16716i != null) {
                this.f16716i.putBoolean(str, bool.booleanValue());
                if (z2) {
                    this.f16716i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str, String str2) {
        try {
            this.f16716i.putString(str, str2);
            this.f16716i.apply();
        } catch (Exception unused) {
        }
    }

    public boolean b(String str) {
        return this.f16715h.getBoolean(str, false);
    }
}
