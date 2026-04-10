package com.amgcyo.cuttadon.utils.otherutils;

import android.text.TextUtils;
import com.tencent.mmkv.MMKV;

/* JADX INFO: compiled from: MmkvUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e0 {
    private static e0 a;
    private static MMKV b;

    private e0(String str) {
        String strA = com.open.hule.library.c.b.a(h.t() + g.W() + "~HEuG2jKe{nX,3rL6");
        String str2 = str + " 加密key：" + (TextUtils.isEmpty(strA) ? "~HEuG2jKe{nX,3rL6" : strA);
        b = MMKV.mmkvWithID(str, 2);
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

    public static Integer b(String str) {
        return Integer.valueOf(b.decodeInt(str, 0));
    }

    public static e0 c(String str) {
        if (a == null) {
            synchronized (e0.class) {
                if (a == null) {
                    a = new e0(str);
                }
            }
        }
        return a;
    }

    public static Boolean a(String str) {
        return Boolean.valueOf(b.decodeBool(str, false));
    }
}
