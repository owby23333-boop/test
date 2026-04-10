package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: compiled from: UPushKV.java */
/* JADX INFO: loaded from: classes3.dex */
public class af {
    private final String a;

    public af(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "_";
        }
        this.a = str;
    }

    private String b(String str) {
        return this.a + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0033 A[EXC_TOP_SPLITTER, PHI: r0 r11
  0x0033: PHI (r0v3 android.database.Cursor) = (r0v0 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:19:0x003d, B:12:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0033: PHI (r11v1 java.lang.String) = (r11v0 java.lang.String), (r11v3 java.lang.String) binds: [B:19:0x003d, B:12:0x0031] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.message.proguard.r.b()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r2 = 0
            r7[r2] = r10     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            android.net.Uri r4 = com.umeng.message.proguard.ab.f20365c     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r5 = 0
            r6 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            if (r0 != 0) goto L20
            if (r0 == 0) goto L1f
            r0.close()     // Catch: java.lang.Throwable -> L1f
        L1f:
            return r11
        L20:
            boolean r10 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            if (r10 == 0) goto L31
            java.lang.String r10 = "v"
            int r10 = r0.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            java.lang.String r10 = r0.getString(r10)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            r11 = r10
        L31:
            if (r0 == 0) goto L40
        L33:
            r0.close()     // Catch: java.lang.Throwable -> L40
            goto L40
        L37:
            r10 = move-exception
            goto L41
        L39:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L37
            if (r0 == 0) goto L40
            goto L33
        L40:
            return r11
        L41:
            if (r0 == 0) goto L46
            r0.close()     // Catch: java.lang.Throwable -> L46
        L46:
            goto L48
        L47:
            throw r10
        L48:
            goto L47
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.af.c(java.lang.String, java.lang.String):java.lang.String");
    }

    private void d(String str, String str2) {
        try {
            Context contextB = r.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("k", str);
            contentValues.put("v", str2);
            contextB.getContentResolver().insert(ab.f20365c, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, int i2) {
        d(b(str), String.valueOf(i2));
    }

    public void a(String str, long j2) {
        d(b(str), String.valueOf(j2));
    }

    public Set<String> b(String str, Set<String> set) {
        try {
            String strC = c(b(str), "");
            HashSet hashSet = new HashSet();
            JSONArray jSONArray = new JSONArray(strC);
            int length = jSONArray.length();
            if (length > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    hashSet.add(jSONArray.optString(i2));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return set;
        }
    }

    public void a(String str, float f2) {
        d(b(str), String.valueOf(f2));
    }

    public void a(String str, String str2) {
        d(b(str), String.valueOf(str2));
    }

    public void a(String str, boolean z2) {
        d(b(str), String.valueOf(z2));
    }

    public void a(String str, Set<String> set) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (set != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            d(b(str), jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public int b(String str, int i2) {
        try {
            return Integer.parseInt(c(b(str), String.valueOf(i2)));
        } catch (Exception unused) {
            return i2;
        }
    }

    public long b(String str, long j2) {
        try {
            return Long.parseLong(c(b(str), String.valueOf(j2)));
        } catch (Exception unused) {
            return j2;
        }
    }

    public void a(String str) {
        c(b(str));
    }

    private void c(String str) {
        try {
            r.b().getContentResolver().delete(ab.f20365c, null, new String[]{str});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public float b(String str, float f2) {
        try {
            return Float.parseFloat(c(b(str), String.valueOf(f2)));
        } catch (Exception unused) {
            return f2;
        }
    }

    public boolean b(String str, boolean z2) {
        try {
            return Boolean.parseBoolean(c(b(str), String.valueOf(z2)));
        } catch (Exception unused) {
            return z2;
        }
    }

    public String b(String str, String str2) {
        return c(b(str), String.valueOf(str2));
    }
}
