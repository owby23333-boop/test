package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    private class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i2) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f19831c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f19831c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f19832d, ""), (JSONArray) obj);
            return true;
        }
    }

    private class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i2) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f19831c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f19831c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f19832d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    private class a implements Serializable {
        int a;
        String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f19824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f19825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f19827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f19828g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f19829h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                a aVar = new a();
                aVar.f19824c = jSONObject.optString("id");
                aVar.f19828g = UMUtils.getAppVersionName(this.mContext);
                aVar.f19829h = UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.f19826e = jSONObject.optInt("__t");
                aVar.f19827f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f19825d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
        } catch (Exception unused) {
            sQLiteDatabaseA = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabaseA = null;
        }
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.b);
                        contentValues.put("__e", aVar.f19824c);
                        contentValues.put("__t", Integer.valueOf(aVar.f19826e));
                        contentValues.put(a.InterfaceC0549a.f19840f, aVar.f19827f);
                        contentValues.put("__av", aVar.f19828g);
                        contentValues.put("__vc", aVar.f19829h);
                        contentValues.put("__s", aVar.f19825d);
                        sQLiteDatabaseA.insert(a.InterfaceC0549a.a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Exception unused4) {
                if (sQLiteDatabaseA != null) {
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            throw th;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) throws Throwable {
        if (dbIsExists(str)) {
            List<a> eventByProcess = readEventByProcess(str);
            if (!eventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f19836h, eventByProcess)) {
                deleteEventDatas(str, null, eventByProcess);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0 A[Catch: Exception -> 0x00b3, PHI: r2
  0x00b0: PHI (r2v6 android.database.sqlite.SQLiteDatabase) = (r2v5 android.database.sqlite.SQLiteDatabase), (r2v9 android.database.sqlite.SQLiteDatabase) binds: [B:27:0x00ae, B:14:0x0093] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {Exception -> 0x00b3, blocks: (B:26:0x00ab, B:28:0x00b0, B:13:0x0090), top: B:45:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c5 A[Catch: Exception -> 0x00c8, TRY_LEAVE, TryCatch #3 {Exception -> 0x00c8, blocks: (B:33:0x00c0, B:35:0x00c5), top: B:43:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0063 A[PHI: r0
  0x0063: PHI (r0v4 android.database.sqlite.SQLiteDatabase) = (r0v3 android.database.sqlite.SQLiteDatabase), (r0v7 android.database.sqlite.SQLiteDatabase) binds: [B:27:0x0061, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteEventDatas(java.lang.String r5, java.lang.String r6, java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L7
            return
        L7:
            r6 = 0
            android.content.Context r0 = r4.mContext     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            android.database.sqlite.SQLiteDatabase r0 = r0.a(r5)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L60
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r1 = r7.size()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r7 == 0) goto L3f
            if (r1 <= 0) goto L3f
            r6 = 0
        L1e:
            if (r6 >= r1) goto L44
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2.<init>()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r3 = "delete from __et_p where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.Object r3 = r7.get(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            com.umeng.analytics.process.UMProcessDBHelper$a r3 = (com.umeng.analytics.process.UMProcessDBHelper.a) r3     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r3 = r3.a     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2.append(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r6 = r6 + 1
            goto L1e
        L3f:
            java.lang.String r7 = "__et_p"
            r0.delete(r7, r6, r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
        L44:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r0 == 0) goto L66
            goto L63
        L4a:
            r6 = move-exception
            goto L51
        L4c:
            goto L61
        L4e:
            r7 = move-exception
            r0 = r6
            r6 = r7
        L51:
            if (r0 == 0) goto L56
            r0.endTransaction()
        L56:
            android.content.Context r7 = r4.mContext
            com.umeng.analytics.process.c r7 = com.umeng.analytics.process.c.a(r7)
            r7.b(r5)
            throw r6
        L60:
            r0 = r6
        L61:
            if (r0 == 0) goto L66
        L63:
            r0.endTransaction()
        L66:
            android.content.Context r6 = r4.mContext
            com.umeng.analytics.process.c r6 = com.umeng.analytics.process.c.a(r6)
            r6.b(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteEventDatas(java.lang.String, java.lang.String, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[PHI: r1
  0x004b: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = (r1v4 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:16:0x0049, B:8:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r7.mContext     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
        L14:
            boolean r2 = r8.hasNext()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r2 == 0) goto L32
            java.lang.Object r2 = r8.next()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r6 = 0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r5[r6] = r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            goto L14
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r1 == 0) goto L4e
            goto L4b
        L38:
            r8 = move-exception
            if (r1 == 0) goto L3e
            r1.endTransaction()
        L3e:
            android.content.Context r1 = r7.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a(r1)
            r1.b(r0)
            throw r8
        L48:
            if (r1 == 0) goto L4e
        L4b:
            r1.endTransaction()
        L4e:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.c.a(r8)
            r8.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) throws Throwable {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) throws Throwable {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) throws Throwable {
        Cursor cursorQuery;
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.f19836h);
            try {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    cursorQuery = sQLiteDatabaseA.query(a.InterfaceC0549a.a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            try {
                                if (cursorQuery.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("__av"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor = cursorQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f19836h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f19836h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                    } catch (Exception unused2) {
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f19836h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabaseA != null) {
                                    sQLiteDatabaseA.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.f19836h);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            jSONObject = null;
                        }
                    }
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (sQLiteDatabaseA != null) {
                        sQLiteDatabaseA.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f19836h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = cursor;
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = null;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
            sQLiteDatabaseA = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
