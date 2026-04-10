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

/* JADX INFO: loaded from: classes4.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    private int getDataSource() {
        return 0;
    }

    private class InsertEventCallback implements FileLockCallback {
        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.d, ""), (JSONArray) obj);
            return true;
        }
    }

    private UMProcessDBHelper() {
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
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

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e) {
            e.printStackTrace();
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

    public void insertEvents(String str, JSONArray jSONArray) throws Throwable {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) throws Throwable {
        if (dbIsExists(str)) {
            List<a> eventByProcess = readEventByProcess(str);
            if (!eventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.h, eventByProcess)) {
                deleteEventDatas(str, null, eventByProcess);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[PHI: r1
  0x004a: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = (r1v4 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:15:0x0048, B:8:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
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
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r6 = 0
            r5[r6] = r2     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            goto L14
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L48
            if (r1 == 0) goto L4d
            goto L4a
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
            if (r1 == 0) goto L4d
        L4a:
            r1.endTransaction()
        L4d:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.c.a(r8)
            r8.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void deleteEventDatas(String str, String str2, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
            try {
                sQLiteDatabaseA.beginTransaction();
                int size = list.size();
                if (list == null || size <= 0) {
                    sQLiteDatabaseA.delete(a.InterfaceC0492a.f2270a, null, null);
                } else {
                    for (int i = 0; i < size; i++) {
                        sQLiteDatabaseA.execSQL("delete from __et_p where rowid=" + list.get(i).f2268a);
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (Exception unused) {
                sQLiteDatabase = sQLiteDatabaseA;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            sQLiteDatabaseA = null;
            th = th3;
        }
        c.a(this.mContext).b(str);
    }

    private boolean insertEvents_(String str, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.b);
                        contentValues.put("__e", aVar.c);
                        contentValues.put("__t", Integer.valueOf(aVar.e));
                        contentValues.put(a.InterfaceC0492a.f, aVar.f);
                        contentValues.put("__av", aVar.g);
                        contentValues.put("__vc", aVar.h);
                        contentValues.put("__s", aVar.d);
                        sQLiteDatabaseA.insert(a.InterfaceC0492a.f2270a, null, contentValues);
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
                sQLiteDatabase = sQLiteDatabaseA;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = sQLiteDatabaseA;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            throw th;
        }
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.c = jSONObject.optString("id");
                aVar.g = UMUtils.getAppVersionName(this.mContext);
                aVar.h = UMUtils.getAppVersionCode(this.mContext);
                aVar.b = jSONObject.optString("__i");
                aVar.e = jSONObject.optInt("__t");
                aVar.f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public JSONObject readVersionInfoFromColumId(Integer num) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            try {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    Cursor cursorQuery = sQLiteDatabaseA.query(a.InterfaceC0492a.f2270a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
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
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = cursorQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                jSONObject = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                    throw th;
                                }
                            }
                            if (sQLiteDatabaseA != null) {
                                sQLiteDatabaseA.endTransaction();
                            }
                            c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                            throw th;
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
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabaseA = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae A[Catch: Exception -> 0x00b1, PHI: r2
  0x00ae: PHI (r2v6 android.database.sqlite.SQLiteDatabase) = (r2v5 android.database.sqlite.SQLiteDatabase), (r2v9 android.database.sqlite.SQLiteDatabase) binds: [B:27:0x00ac, B:14:0x0093] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #7 {Exception -> 0x00b1, blocks: (B:26:0x00a9, B:28:0x00ae, B:13:0x0090), top: B:46:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4 A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #4 {Exception -> 0x00c7, blocks: (B:34:0x00bf, B:36:0x00c4), top: B:43:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.umeng.analytics.process.UMProcessDBHelper$1] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2268a;
        String b;
        String c;
        String d;
        int e;
        String f;
        String g;
        String h;

        private a() {
        }
    }

    private class ProcessToMainCallback implements FileLockCallback {
        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.d, ""));
            return true;
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

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }
}
