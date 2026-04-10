package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tf {
    static final g[] dl;
    private static final sd[] m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ti f302a;
    private String e;
    private final z gc;
    public static final int[] z = {1};
    static final HashMap<String, sd> g = new HashMap<>();

    static {
        z(new lk());
        z(new zz(true));
        z(new u());
        z(new vo());
        sd[] sdVarArr = {new ja(), new nb(null, false, null), new wn("", new JSONObject())};
        m = sdVarArr;
        for (int i = 0; i < 3; i++) {
            z(sdVarArr[i]);
        }
        dl = new g[]{new g(), new g(), new g()};
    }

    private String z(String str, boolean z2) {
        return "SELECT * FROM page WHERE session_id" + (z2 ? "='" : "!='") + str + "' ORDER BY " + (z2 ? "session_id," : "") + "duration DESC LIMIT 500";
    }

    private String g(String str, boolean z2) {
        return "DELETE FROM page WHERE session_id" + (z2 ? "='" : "!='") + str + "'";
    }

    private String z(sd sdVar, String str, boolean z2, int i, int i2) {
        return "SELECT * FROM " + sdVar.a() + " WHERE session_id" + (z2 ? "='" : "!='") + str + "' AND event_type='" + i2 + "' ORDER BY _id LIMIT " + i;
    }

    private String z(String str, int i, String str2, boolean z2, long j) {
        return "DELETE FROM " + str + " WHERE session_id" + (z2 ? "='" : "!='") + str2 + "' AND event_type='" + i + "' AND _id<=" + j;
    }

    private String z(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    public tf(ti tiVar) {
        this.gc = new z(tiVar.g(), "bd_embed_tea_agent.db", null, 30);
        this.f302a = tiVar;
    }

    private static void z(sd sdVar) {
        g.put(sdVar.a(), sdVar);
    }

    static class g {
        int dl;
        int g;
        String z;

        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void g() {
            for (g gVar : tf.dl) {
                gVar.z = "";
                gVar.g = 0;
                gVar.dl = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(sd sdVar) {
            String strFo = sdVar.fo();
            if (strFo == null || strFo.length() <= this.g) {
                return;
            }
            this.z = sdVar.gz();
            this.g = strFo.length();
        }

        public String toString() {
            return new StringBuilder(this.dl).append("-").append(this.z).append("-").append(this.g).toString();
        }
    }

    private boolean z(String str) {
        cb.z("needLaunch, " + this.e + ", " + str);
        if (TextUtils.equals(str, this.e)) {
            return false;
        }
        this.e = str;
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:106|4|5|129|6|125|7|119|8|(9:9|10|(6:107|12|(7:(1:15)|123|16|17|115|18|19)(10:22|102|23|24|(2:26|27)|30|31|(2:33|34)|35|36)|37|117|38)(1:131)|74|121|79|(2:109|81)|86|87)|43|(1:47)|113|51|(6:53|(3:55|111|56)|58|(2:104|60)|65|87)|57|58|(0)|65|87) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.ArrayList<com.bytedance.embedapplog.vo> z(org.json.JSONObject r31) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.tf.z(org.json.JSONObject):java.util.ArrayList");
    }

    private void z(JSONObject jSONObject, boolean z2, vo voVar, SQLiteDatabase sQLiteDatabase) {
        for (int i : z) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int iZ = z(0, sQLiteDatabase, voVar.f299a, z2, i, jSONArrayArr, jArr);
            if (z(jArr)) {
                int i2 = iZ;
                while (true) {
                    voVar.z(jSONObject, null, null, null, jSONArrayArr, jArr, i);
                    z(voVar, z2, sQLiteDatabase, true);
                    int iZ2 = i2;
                    while (iZ2 < m.length) {
                        iZ2 = z(iZ2, sQLiteDatabase, voVar.f299a, z2, i, jSONArrayArr, jArr);
                        if (z(jArr)) {
                            break;
                        }
                    }
                    i2 = iZ2;
                }
            }
        }
    }

    private JSONObject z(zz zzVar, JSONObject jSONObject) {
        if (TextUtils.equals(zzVar.i, this.f302a.gc().dl()) && zzVar.wp == this.f302a.gc().g()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            o.g(jSONObject2, jSONObject);
            jSONObject2.put("app_version", zzVar.i);
            jSONObject2.put("version_code", zzVar.wp);
            return jSONObject2;
        } catch (JSONException e) {
            cb.g(e);
            return jSONObject;
        }
    }

    private void z(JSONObject jSONObject, zz zzVar, vo voVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<vo> arrayList) {
        SQLiteDatabase sQLiteDatabase2;
        JSONArray[] jSONArrayArr2;
        long[] jArr2;
        tf tfVar;
        JSONObject jSONObject2;
        vo voVar2;
        int iZ;
        cb.z("packCurrentData, " + zzVar.f299a);
        boolean z2 = z(zzVar.f299a);
        int iZ2 = z(0, sQLiteDatabase, zzVar.f299a, true, 0, jSONArrayArr, jArr);
        if (z2 || z(jArr)) {
            voVar.z(jSONObject, z2 ? zzVar : null, null, null, jSONArrayArr, jArr, 0);
            if (iZ2 >= m.length) {
                vo voVar3 = (vo) voVar.clone();
                voVar3.uy();
                arrayList.add(voVar3);
                sQLiteDatabase2 = sQLiteDatabase;
                jSONArrayArr2 = jSONArrayArr;
                iZ = iZ2;
                jArr2 = jArr;
                tfVar = this;
                jSONObject2 = jSONObject;
                voVar2 = voVar;
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                jSONArrayArr2 = jSONArrayArr;
                jArr2 = jArr;
                tfVar = this;
                jSONObject2 = jSONObject;
                voVar2 = voVar;
                tfVar.z(voVar2, true, sQLiteDatabase2, true);
                iZ = iZ2;
            }
        } else {
            sQLiteDatabase2 = sQLiteDatabase;
            jSONArrayArr2 = jSONArrayArr;
            iZ = iZ2;
            jArr2 = jArr;
            tfVar = this;
            jSONObject2 = jSONObject;
            voVar2 = voVar;
        }
        while (iZ < m.length) {
            iZ = tfVar.z(iZ, sQLiteDatabase2, zzVar.f299a, true, 0, jSONArrayArr2, jArr2);
            if (tfVar.z(jArr2)) {
                voVar2.z(jSONObject2, tfVar.z(zzVar.f299a) ? zzVar : null, null, null, jSONArrayArr2, jArr2, 0);
                tfVar.z(voVar2, true, sQLiteDatabase2, true);
                iZ = iZ;
            }
        }
    }

    private void z(JSONObject jSONObject, zz zzVar, vo voVar, lk lkVar, u uVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        boolean z2;
        boolean z3;
        cb.z("packHistoryData, " + zzVar.f299a);
        JSONArray jSONArrayZ = z(zzVar, true, uVar, lkVar, sQLiteDatabase);
        zzVar.v = jSONArrayZ.length() == 0;
        int iZ = z(0, sQLiteDatabase, zzVar.f299a, true, 0, jSONArrayArr, jArr);
        if (zzVar.v) {
            voVar.z(jSONObject, z(zzVar.f299a) ? zzVar : null, null, null, jSONArrayArr, jArr, 0);
            z2 = true;
        } else {
            z2 = true;
            voVar.z(jSONObject, null, uVar, jSONArrayZ, jSONArrayArr, jArr, 0);
        }
        vo voVar2 = voVar;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        while (true) {
            z(voVar2, z2, sQLiteDatabase2, z2);
            int iZ2 = iZ;
            while (iZ2 < m.length) {
                z3 = z2;
                iZ2 = z(iZ2, sQLiteDatabase, zzVar.f299a, true, 0, jSONArrayArr, jArr);
                if (z(jArr)) {
                    break;
                } else {
                    z2 = z3;
                }
            }
            return;
            voVar.z(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
            voVar2 = voVar;
            sQLiteDatabase2 = sQLiteDatabase;
            iZ = iZ2;
            z2 = z3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(org.json.JSONObject r17, com.bytedance.embedapplog.zz r18, com.bytedance.embedapplog.u r19, com.bytedance.embedapplog.lk r20, com.bytedance.embedapplog.vo r21, android.database.sqlite.SQLiteDatabase r22, java.lang.String r23, org.json.JSONArray[] r24, long[] r25) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.tf.z(org.json.JSONObject, com.bytedance.embedapplog.zz, com.bytedance.embedapplog.u, com.bytedance.embedapplog.lk, com.bytedance.embedapplog.vo, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
    }

    private boolean z(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void z(vo voVar, boolean z2, SQLiteDatabase sQLiteDatabase, boolean z3) {
        boolean z4;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.gc.getWritableDatabase();
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    cb.g(th);
                    if (z4) {
                        o.z(sQLiteDatabase);
                        return;
                    }
                    return;
                } finally {
                    if (z4) {
                        o.z(sQLiteDatabase);
                    }
                }
            }
        }
        if (z3 && sQLiteDatabase.insert("pack", null, voVar.g((ContentValues) null)) < 0) {
            if (voVar.js != null) {
                z((String) null);
            }
            if (z4) {
                return;
            } else {
                return;
            }
        }
        if (voVar.ls > 0) {
            sQLiteDatabase.execSQL(z(NotificationCompat.CATEGORY_EVENT, voVar.uy, voVar.f299a, z2, voVar.ls));
        }
        if (voVar.fv > 0) {
            sQLiteDatabase.execSQL(z("eventv3", voVar.uy, voVar.f299a, z2, voVar.fv));
        }
        if (voVar.q > 0) {
            sQLiteDatabase.execSQL(z("event_misc", voVar.uy, voVar.f299a, z2, voVar.q));
        }
        if (z4) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (z4) {
            o.z(sQLiteDatabase);
        }
    }

    private int z(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z2, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
        g.g();
        int i3 = 0;
        while (i3 < i) {
            jSONArrayArr[i3] = null;
            jArr[i3] = 0;
            i3++;
        }
        int i4 = i3;
        int i5 = 200;
        while (i5 > 0 && i4 < m.length) {
            z(sQLiteDatabase, str, i5, i4, z2, jSONArrayArr, jArr, i2);
            int length = jSONArrayArr[i4].length();
            i5 -= length;
            dl[i4].dl = length;
            if (i5 > 0) {
                i4++;
            }
        }
        for (int i6 = i4 + 1; i6 < jSONArrayArr.length; i6++) {
            jSONArrayArr[i6] = null;
            jArr[i6] = 0;
        }
        return i4;
    }

    private void z(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z2, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
        sd sdVar = m[i2];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(z(sdVar, str, z2, i, i3), null);
            for (int i4 = 0; cursorRawQuery.moveToNext() && i4 <= 200; i4++) {
                try {
                    sdVar.z(cursorRawQuery);
                    dl[i2].z(sdVar);
                    if (cb.g) {
                        cb.z("queryEvent, ".concat(String.valueOf(sdVar)), null);
                    }
                    jSONArray.put(sdVar.m());
                    if (sdVar.z > j) {
                        j = sdVar.z;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    try {
                        cb.g(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } finally {
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        jSONArrayArr[i2] = jSONArray;
        jArr[i2] = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00da A[PHI: r12 r15 r17 r18
  0x00da: PHI (r12v2 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v6 android.database.Cursor) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]
  0x00da: PHI (r15v2 long) = (r15v3 long), (r15v5 long) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]
  0x00da: PHI (r17v3 java.lang.String) = (r17v4 java.lang.String), (r17v7 java.lang.String) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]
  0x00da: PHI (r18v2 java.lang.String) = (r18v3 java.lang.String), (r18v5 java.lang.String) binds: [B:46:0x00d8, B:36:0x00c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray z(com.bytedance.embedapplog.zz r21, boolean r22, com.bytedance.embedapplog.u r23, com.bytedance.embedapplog.lk r24, android.database.sqlite.SQLiteDatabase r25) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.tf.z(com.bytedance.embedapplog.zz, boolean, com.bytedance.embedapplog.u, com.bytedance.embedapplog.lk, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[DONT_GENERATE, PHI: r3
  0x003b: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:15:0x0039, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.bytedance.embedapplog.vo> z() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap<java.lang.String, com.bytedance.embedapplog.sd> r1 = com.bytedance.embedapplog.tf.g
            java.lang.String r2 = "pack"
            java.lang.Object r1 = r1.get(r2)
            com.bytedance.embedapplog.vo r1 = (com.bytedance.embedapplog.vo) r1
            r2 = 0
            com.bytedance.embedapplog.tf$z r3 = r5.gc     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "SELECT * FROM pack ORDER BY _id DESC LIMIT 8"
            android.database.Cursor r3 = r3.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> L34
        L1c:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto L2f
            com.bytedance.embedapplog.sd r1 = r1.clone()     // Catch: java.lang.Throwable -> L32
            com.bytedance.embedapplog.vo r1 = (com.bytedance.embedapplog.vo) r1     // Catch: java.lang.Throwable -> L32
            r1.z(r3)     // Catch: java.lang.Throwable -> L32
            r0.add(r1)     // Catch: java.lang.Throwable -> L32
            goto L1c
        L2f:
            if (r3 == 0) goto L3e
            goto L3b
        L32:
            r1 = move-exception
            goto L36
        L34:
            r1 = move-exception
            r3 = r2
        L36:
            com.bytedance.embedapplog.cb.g(r1)     // Catch: java.lang.Throwable -> L4c
            if (r3 == 0) goto L3e
        L3b:
            r3.close()
        L3e:
            java.lang.String r1 = "queryPack, "
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r1 = r1.concat(r3)
            com.bytedance.embedapplog.cb.z(r1, r2)
            return r0
        L4c:
            r0 = move-exception
            if (r3 == 0) goto L52
            r3.close()
        L52:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.tf.z():java.util.ArrayList");
    }

    public void z(ArrayList<vo> arrayList, ArrayList<vo> arrayList2, ArrayList<vo> arrayList3) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        cb.z("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<vo> it = arrayList2.iterator();
        while (it.hasNext()) {
            vo next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.g) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            writableDatabase = this.gc.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            try {
                for (vo voVar : arrayList) {
                    if (arrayList3.contains(voVar)) {
                        z(voVar, true, writableDatabase, false);
                    } else {
                        writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(voVar.z)});
                    }
                }
            } catch (Throwable th2) {
                cb.g(th2);
            }
            for (vo voVar2 : arrayList2) {
                if (voVar2.js != null) {
                    z((String) null);
                }
                if (!arrayList3.contains(voVar2)) {
                    long j = voVar2.z;
                    int i = voVar2.i + 1;
                    voVar2.i = i;
                    writableDatabase.execSQL(z(j, i));
                }
            }
            writableDatabase.setTransactionSuccessful();
            o.z(writableDatabase);
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = writableDatabase;
            try {
                cb.g(th);
            } finally {
                o.z(sQLiteDatabase);
            }
        }
    }

    public void z(ArrayList<sd> arrayList) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.gc.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            ContentValues contentValuesG = null;
            for (sd sdVar : arrayList) {
                String strA = sdVar.a();
                contentValuesG = sdVar.g(contentValuesG);
                sdVar.z = writableDatabase.insert(strA, null, contentValuesG);
                if (NotificationCompat.CATEGORY_EVENT.equals(sdVar.a())) {
                    arrayList3.add(sdVar);
                } else if ("eventv3".equals(sdVar.a())) {
                    arrayList3.add(sdVar);
                } else if (sdVar instanceof zz) {
                    arrayList2.add((zz) sdVar);
                }
            }
            writableDatabase.setTransactionSuccessful();
            o.z(writableDatabase);
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                cb.g(th);
            } finally {
                o.z(sQLiteDatabase);
            }
        }
    }

    static class z extends SQLiteOpenHelper {
        z(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(new com.bytedance.sdk.openadsdk.api.plugin.z(context), str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<sd> it = tf.g.values().iterator();
                while (it.hasNext()) {
                    String strDl = it.next().dl();
                    if (strDl != null) {
                        sQLiteDatabase.execSQL(strDl);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    cb.g(th);
                } finally {
                    o.z(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            cb.a("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<sd> it = tf.g.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().a());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } catch (Throwable th) {
                }
            }
            o.z(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
