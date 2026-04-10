package com.amgcyo.cuttadon.utils.comic;

import android.text.TextUtils;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.tencent.mmkv.MMKV;

/* JADX INFO: compiled from: MmkvSpUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static d a;
    private static MMKV b;

    private d() {
        String strA = com.open.hule.library.c.b.a(h.t() + "fatCatAppkyZXtt8qISIDfN8");
        b = MMKV.mmkvWithID("mofish", 2, TextUtils.isEmpty(strA) ? "kyZXtt8qISIDfN8" : strA);
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public static Long b(String str) {
        return Long.valueOf(b.decodeLong(str, 0L));
    }

    public static String c(String str) {
        return b.decodeString(str, "");
    }

    public static void a(String str, Object obj) {
        if (obj instanceof String) {
            b.encode(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            b.encode(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Boolean) {
            b.encode(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Float) {
            b.encode(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Long) {
            b.encode(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            b.encode(str, ((Double) obj).doubleValue());
        } else if (obj instanceof byte[]) {
            b.encode(str, (byte[]) obj);
        } else if (obj != null) {
            b.encode(str, obj.toString());
        }
    }

    public static Integer a(String str) {
        return Integer.valueOf(b.decodeInt(str, 0));
    }

    public static Integer a(String str, int i2) {
        return Integer.valueOf(b.decodeInt(str, i2));
    }

    public static Long a(String str, long j2) {
        return Long.valueOf(b.decodeLong(str, j2));
    }

    public static Boolean a(String str, boolean z2) {
        return Boolean.valueOf(b.decodeBool(str, z2));
    }

    public static Float a(String str, float f2) {
        return Float.valueOf(b.decodeFloat(str, f2));
    }

    public static String a(String str, String str2) {
        return b.decodeString(str, str2);
    }
}
