package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.os.SystemProperties;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;

/* JADX INFO: loaded from: classes.dex */
final class f1 implements a1 {
    private static final o0<Boolean> a = new a();

    static final class a extends o0<Boolean> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object... objArr) {
            return Boolean.valueOf("1".equals(f1.b("persist.sys.identifierid.supported", "0")));
        }
    }

    f1(Context context) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0057 A[EXC_TOP_SPLITTER, PHI: r2 r9
  0x0057: PHI (r2v3 java.lang.String) = (r2v9 java.lang.String), (r2v5 java.lang.String) binds: [B:33:0x006a, B:23:0x0055] A[DONT_GENERATE, DONT_INLINE]
  0x0057: PHI (r9v7 android.database.Cursor) = (r9v6 android.database.Cursor), (r9v9 android.database.Cursor) binds: [B:33:0x006a, B:23:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(@androidx.annotation.NonNull android.content.Context r9, int r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "OaidVivo#query close cursor exception."
            java.lang.String r1 = "Oaid#"
            r2 = 0
            if (r10 == 0) goto L29
            r3 = 1
            if (r10 == r3) goto L17
            r3 = 2
            if (r10 == r3) goto Lf
            r4 = r2
            goto L30
        Lf:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            goto L1e
        L17:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
        L1e:
            r10.append(r3)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            goto L2b
        L29:
            java.lang.String r10 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
        L2b:
            android.net.Uri r10 = android.net.Uri.parse(r10)
            r4 = r10
        L30:
            if (r4 == 0) goto L85
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            if (r9 == 0) goto L55
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L74
            if (r10 == 0) goto L55
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L74
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L74
            r2 = r10
            goto L55
        L53:
            r10 = move-exception
            goto L62
        L55:
            if (r9 == 0) goto L85
        L57:
            r9.close()     // Catch: java.lang.Exception -> L5b
            goto L85
        L5b:
            r9 = move-exception
            goto L6d
        L5d:
            r9 = move-exception
            goto L77
        L5f:
            r9 = move-exception
            r10 = r9
            r9 = r2
        L62:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L74
            java.lang.String r11 = "OaidVivo#query"
            bykvm_19do.bykvm_19do.bykvm_19do.t0.b(r1, r11, r10)     // Catch: java.lang.Throwable -> L74
            if (r9 == 0) goto L85
            goto L57
        L6d:
            r9.printStackTrace()
            bykvm_19do.bykvm_19do.bykvm_19do.t0.b(r1, r0, r9)
            goto L85
        L74:
            r10 = move-exception
            r2 = r9
            r9 = r10
        L77:
            if (r2 == 0) goto L84
            r2.close()     // Catch: java.lang.Exception -> L7d
            goto L84
        L7d:
            r10 = move-exception
            r10.printStackTrace()
            bykvm_19do.bykvm_19do.bykvm_19do.t0.b(r1, r0, r10)
        L84:
            throw r9
        L85:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.f1.a(android.content.Context, int, java.lang.String):java.lang.String");
    }

    static boolean a() {
        return a.b(new Object[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        a1.a aVar = new a1.a();
        aVar.a = a(context, 0, null);
        t0.b("Oaid#", "OaidVivo#oaid " + aVar.a);
        return aVar;
    }
}
