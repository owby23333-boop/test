package com.bytedance.sdk.openadsdk.core.v;

import android.content.ContentValues;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static final g z = new g();

    public void insert(z zVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dev1", Long.valueOf(zVar.fo()));
        contentValues.put("dev2", Long.valueOf(zVar.uy()));
        contentValues.put("dev3", Long.valueOf(zVar.kb()));
        contentValues.put("dev4", Long.valueOf(zVar.wp()));
        contentValues.put("dev5", Integer.valueOf(zVar.i()));
        contentValues.put("dev6", Long.valueOf(zVar.gz()));
        contentValues.put("dev7", Long.valueOf(zVar.z()));
        contentValues.put("dev8", Long.valueOf(zVar.g()));
        com.bytedance.sdk.openadsdk.core.multipro.z.z.insert(zw.getContext(), "sdk_launch", contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd A[DONT_GENERATE, PHI: r1 r3
  0x00bd: PHI (r1v2 java.util.ArrayList) = (r1v3 java.util.ArrayList), (r1v5 java.util.ArrayList) binds: [B:25:0x00bb, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
  0x00bd: PHI (r3v3 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v5 android.database.Cursor) binds: [B:25:0x00bb, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.bytedance.sdk.openadsdk.core.v.z> z(long r19) {
        /*
            r18 = this;
            r0 = 518400000(0x1ee62800, double:2.56123631E-315)
            long r0 = r19 - r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.zw.getContext()     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r5 = "sdk_launch"
            r6 = 0
            java.lang.String r7 = "dev1 > ?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            r1 = 0
            r8[r1] = r0     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            r9 = 0
            r10 = 0
            java.lang.String r11 = "dev1 DESC"
            android.database.Cursor r3 = com.bytedance.sdk.openadsdk.core.multipro.z.z.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            if (r3 == 0) goto Lb0
        L28:
            boolean r0 = r3.moveToNext()     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            if (r0 == 0) goto Lb0
            java.lang.String r0 = "dev1"
            int r0 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            long r0 = r3.getLong(r0)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r4 = "dev2"
            int r4 = r3.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            long r4 = r3.getLong(r4)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r6 = "dev3"
            int r6 = r3.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            long r6 = r3.getLong(r6)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r8 = "dev4"
            int r8 = r3.getColumnIndex(r8)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            long r8 = r3.getLong(r8)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r10 = "dev5"
            int r10 = r3.getColumnIndex(r10)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            long r10 = r3.getLong(r10)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r12 = "dev6"
            int r12 = r3.getColumnIndex(r12)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            long r12 = r3.getLong(r12)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            java.lang.String r14 = "dev7"
            int r14 = r3.getColumnIndex(r14)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            long r14 = r3.getLong(r14)     // Catch: java.lang.Throwable -> Lb4 java.lang.Exception -> Lb6
            r19 = r2
            java.lang.String r2 = "dev8"
            int r2 = r3.getColumnIndex(r2)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r16 = r14
            long r14 = r3.getLong(r2)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            com.bytedance.sdk.openadsdk.core.v.z r2 = new com.bytedance.sdk.openadsdk.core.v.z     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.<init>()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.a(r0)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.gc(r4)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.m(r6)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.e(r8)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            int r0 = (int) r10     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.g(r0)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.dl(r12)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r0 = r16
            r2.z(r0)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r2.g(r14)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lb4
            r1 = r19
            r1.add(r2)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lb4
            r2 = r1
            goto L28
        Laa:
            r0 = move-exception
            goto Lb8
        Lac:
            r0 = move-exception
            r1 = r19
            goto Lb8
        Lb0:
            r1 = r2
            if (r3 == 0) goto Lc0
            goto Lbd
        Lb4:
            r0 = move-exception
            goto Lc1
        Lb6:
            r0 = move-exception
            r1 = r2
        Lb8:
            com.bytedance.sdk.component.utils.wp.z(r0)     // Catch: java.lang.Throwable -> Lb4
            if (r3 == 0) goto Lc0
        Lbd:
            r3.close()
        Lc0:
            return r1
        Lc1:
            if (r3 == 0) goto Lc6
            r3.close()
        Lc6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.v.g.z(long):java.util.List");
    }

    public void z() {
        com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), "sdk_launch", "dev1 < ?", new String[]{String.valueOf(dl.gc().fo() - 2592000000L)});
    }
}
