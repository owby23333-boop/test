package com.baidu.tts.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.anythink.core.api.ATCustomRuleKeys;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.modelmanager.ModelMediator;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.SqlTool;
import com.baidu.tts.tools.StringTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class DbManager {
    private ModelDbHelper mModelDbHelper;
    private ModelMediator mModelMediator;
    private ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();
    private Lock mWriteLock = this.mReadWriteLock.writeLock();
    private Lock mReadLock = this.mReadWriteLock.readLock();

    public DbManager(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
        this.mModelDbHelper = new ModelDbHelper(this.mModelMediator.getContext());
    }

    private SQLiteDatabase getReadableDb() {
        return this.mModelDbHelper.getReadableDatabase();
    }

    private SQLiteDatabase getWritableDb() {
        return this.mModelDbHelper.getWritableDatabase();
    }

    public int deleteModelFileInfos(Set<String> set) {
        this.mWriteLock.lock();
        try {
            SQLiteDatabase writableDb = getWritableDb();
            String[] strArrFromSetToArray = DataTool.fromSetToArray(set);
            try {
                return writableDb.delete(ModelFileTable.TABLE_NAME, SqlTool.buildInCondition("id", strArrFromSetToArray), strArrFromSetToArray);
            } finally {
                writableDb.close();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public int deleteModelFileItem(String str) {
        int iDeleteFileItem;
        this.mWriteLock.lock();
        try {
            SQLiteDatabase writableDb = getWritableDb();
            try {
                try {
                    iDeleteFileItem = ModelFileTable.deleteFileItem(writableDb, str);
                } finally {
                    writableDb.close();
                }
            } catch (Exception unused) {
                iDeleteFileItem = -1;
                writableDb.close();
            }
            return iDeleteFileItem;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public int deleteModelItem(String str) {
        int iDeleteModelItem;
        this.mWriteLock.lock();
        try {
            SQLiteDatabase writableDb = getWritableDb();
            try {
                try {
                    iDeleteModelItem = SpeechModelTable.deleteModelItem(writableDb, str);
                } finally {
                    writableDb.close();
                }
            } catch (Exception unused) {
                iDeleteModelItem = -1;
                writableDb.close();
            }
            return iDeleteModelItem;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public String getModelFileAbsPath(String str, String str2) {
        Map<String, String> mapSelectInMap = selectInMap("select b.absPath from speechModel a left join modelFile b on a." + str + "=b.id where a.id=?", new String[]{str2});
        if (mapSelectInMap != null) {
            return mapSelectInMap.get(KeyEnum.ABS_PATH.getFullName());
        }
        return null;
    }

    public void insertModelBags(ModelBags modelBags) {
        this.mWriteLock.lock();
        try {
            SpeechModelTable.insertModelBags(getWritableDb(), modelBags);
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void insertModelFileBags(ModelFileBags modelFileBags) {
        this.mWriteLock.lock();
        try {
            ModelFileTable.insertModelFileBags(getWritableDb(), modelFileBags);
        } finally {
            this.mWriteLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046 A[Catch: all -> 0x004a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x004a, blocks: (B:3:0x0005, B:9:0x0020, B:10:0x0023, B:20:0x003b, B:24:0x0046, B:15:0x002f, B:16:0x0032, B:17:0x0035, B:19:0x0038, B:5:0x0017), top: B:30:0x0005, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isFileInfoExist(java.lang.String r5) {
        /*
            r4 = this;
            java.util.concurrent.locks.Lock r0 = r4.mReadLock
            r0.lock()
            java.lang.String r0 = "select id from modelFile where id=?"
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L4a
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L4a
            android.database.sqlite.SQLiteDatabase r5 = r4.getReadableDb()     // Catch: java.lang.Throwable -> L4a
            android.database.Cursor r0 = r5.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L44
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L36
            if (r2 != 0) goto L1e
            goto L44
        L1e:
            if (r0 == 0) goto L23
            r0.close()     // Catch: java.lang.Throwable -> L4a
        L23:
            r5.close()     // Catch: java.lang.Throwable -> L4a
            java.util.concurrent.locks.Lock r5 = r4.mReadLock
            r5.unlock()
            return r1
        L2c:
            r1 = move-exception
            if (r0 == 0) goto L32
            r0.close()     // Catch: java.lang.Throwable -> L4a
        L32:
            r5.close()     // Catch: java.lang.Throwable -> L4a
            throw r1     // Catch: java.lang.Throwable -> L4a
        L36:
            if (r0 == 0) goto L3b
            r0.close()     // Catch: java.lang.Throwable -> L4a
        L3b:
            r5.close()     // Catch: java.lang.Throwable -> L4a
            java.util.concurrent.locks.Lock r5 = r4.mReadLock
            r5.unlock()
            return r3
        L44:
            if (r0 == 0) goto L3b
            r0.close()     // Catch: java.lang.Throwable -> L4a
            goto L3b
        L4a:
            r5 = move-exception
            java.util.concurrent.locks.Lock r0 = r4.mReadLock
            r0.unlock()
            goto L52
        L51:
            throw r5
        L52:
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.database.DbManager.isFileInfoExist(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046 A[Catch: all -> 0x004a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x004a, blocks: (B:3:0x0005, B:9:0x0020, B:10:0x0023, B:20:0x003b, B:24:0x0046, B:15:0x002f, B:16:0x0032, B:17:0x0035, B:19:0x0038, B:5:0x0017), top: B:30:0x0005, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isModelInfoExist(java.lang.String r5) {
        /*
            r4 = this;
            java.util.concurrent.locks.Lock r0 = r4.mReadLock
            r0.lock()
            java.lang.String r0 = "select id from speechModel where id=?"
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L4a
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L4a
            android.database.sqlite.SQLiteDatabase r5 = r4.getReadableDb()     // Catch: java.lang.Throwable -> L4a
            android.database.Cursor r0 = r5.rawQuery(r0, r2)     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L44
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L36
            if (r2 != 0) goto L1e
            goto L44
        L1e:
            if (r0 == 0) goto L23
            r0.close()     // Catch: java.lang.Throwable -> L4a
        L23:
            r5.close()     // Catch: java.lang.Throwable -> L4a
            java.util.concurrent.locks.Lock r5 = r4.mReadLock
            r5.unlock()
            return r1
        L2c:
            r1 = move-exception
            if (r0 == 0) goto L32
            r0.close()     // Catch: java.lang.Throwable -> L4a
        L32:
            r5.close()     // Catch: java.lang.Throwable -> L4a
            throw r1     // Catch: java.lang.Throwable -> L4a
        L36:
            if (r0 == 0) goto L3b
            r0.close()     // Catch: java.lang.Throwable -> L4a
        L3b:
            r5.close()     // Catch: java.lang.Throwable -> L4a
            java.util.concurrent.locks.Lock r5 = r4.mReadLock
            r5.unlock()
            return r3
        L44:
            if (r0 == 0) goto L3b
            r0.close()     // Catch: java.lang.Throwable -> L4a
            goto L3b
        L4a:
            r5 = move-exception
            java.util.concurrent.locks.Lock r0 = r4.mReadLock
            r0.unlock()
            goto L52
        L51:
            throw r5
        L52:
            goto L51
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.database.DbManager.isModelInfoExist(java.lang.String):boolean");
    }

    public void replaceFsFileState(String str, int i2) {
        this.mWriteLock.lock();
        try {
            String[] strArr = {str, String.valueOf(i2)};
            SQLiteDatabase writableDb = getWritableDb();
            try {
                writableDb.execSQL("replace into fsFileInfo (absPath,state) values (?, ?)", strArr);
            } finally {
                writableDb.close();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public Map<String, String> selectFsFileState(String str) {
        return selectInMap("select * from fsFileInfo where absPath=?", new String[]{str});
    }

    public List<Map<String, String>> selectInList(String str, String[] strArr) {
        ArrayList arrayList;
        this.mReadLock.lock();
        SQLiteDatabase readableDb = null;
        try {
            try {
                try {
                    arrayList = new ArrayList();
                } catch (Exception e2) {
                    e = e2;
                    arrayList = null;
                }
                try {
                    readableDb = getReadableDb();
                    Cursor cursorRawQuery = readableDb.rawQuery(str, strArr);
                    if (cursorRawQuery != null) {
                        if (cursorRawQuery.moveToFirst()) {
                            String[] columnNames = cursorRawQuery.getColumnNames();
                            do {
                                HashMap map = new HashMap();
                                int length = columnNames.length;
                                for (int i2 = 0; i2 < length; i2++) {
                                    map.put(columnNames[i2], cursorRawQuery.getString(cursorRawQuery.getColumnIndex(columnNames[i2])));
                                }
                                arrayList.add(map);
                            } while (cursorRawQuery.moveToNext());
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (readableDb != null) {
                    }
                    return arrayList;
                }
                return arrayList;
            } finally {
                if (0 != 0) {
                    readableDb.close();
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[Catch: all -> 0x005a, DONT_GENERATE, PHI: r0
  0x0041: PHI (r0v3 java.util.HashMap) = (r0v5 java.util.HashMap), (r0v6 java.util.HashMap) binds: [B:25:0x004b, B:18:0x003f] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x005a, blocks: (B:3:0x0006, B:19:0x0041, B:30:0x0056, B:31:0x0059, B:4:0x000a, B:6:0x0010, B:8:0x0016, B:9:0x001b, B:11:0x0023, B:24:0x0048, B:17:0x003c), top: B:40:0x0006, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> selectInMap(java.lang.String r7, java.lang.String[] r8) {
        /*
            r6 = this;
            java.util.concurrent.locks.Lock r0 = r6.mReadLock
            r0.lock()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r6.getReadableDb()     // Catch: java.lang.Throwable -> L5a
            android.database.Cursor r7 = r1.rawQuery(r7, r8)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r7 == 0) goto L3f
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r8 == 0) goto L3a
            java.util.HashMap r8 = new java.util.HashMap     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r8.<init>()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String[] r0 = r7.getColumnNames()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L45
            int r2 = r0.length     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L45
            r3 = 0
        L21:
            if (r3 >= r2) goto L35
            r4 = r0[r3]     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L45
            r5 = r0[r3]     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L45
            int r5 = r7.getColumnIndex(r5)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L45
            java.lang.String r5 = r7.getString(r5)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L45
            r8.put(r4, r5)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L45
            int r3 = r3 + 1
            goto L21
        L35:
            r0 = r8
            goto L3a
        L37:
            r7 = move-exception
            r0 = r8
            goto L48
        L3a:
            if (r7 == 0) goto L3f
            r7.close()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
        L3f:
            if (r1 == 0) goto L4e
        L41:
            r1.close()     // Catch: java.lang.Throwable -> L5a
            goto L4e
        L45:
            r7 = move-exception
            goto L54
        L47:
            r7 = move-exception
        L48:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L4e
            goto L41
        L4e:
            java.util.concurrent.locks.Lock r7 = r6.mReadLock
            r7.unlock()
            return r0
        L54:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.lang.Throwable -> L5a
        L59:
            throw r7     // Catch: java.lang.Throwable -> L5a
        L5a:
            r7 = move-exception
            java.util.concurrent.locks.Lock r8 = r6.mReadLock
            r8.unlock()
            goto L62
        L61:
            throw r7
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.database.DbManager.selectInMap(java.lang.String, java.lang.String[]):java.util.Map");
    }

    public List<Map<String, String>> selectModelBags(Conditions conditions) {
        String str;
        String[] strArr;
        String version = conditions.getVersion();
        if (StringTool.isEmpty(version)) {
            str = null;
            strArr = null;
        } else {
            strArr = new String[]{version, version};
            str = "version_min <= ? and version_max >= ?";
        }
        String[] domainArray = conditions.getDomainArray();
        String[] languageArray = conditions.getLanguageArray();
        String[] qualityArray = conditions.getQualityArray();
        String[] genderArray = conditions.getGenderArray();
        String[] speakerArray = conditions.getSpeakerArray();
        String[] modelIdsArray = conditions.getModelIdsArray();
        String strBuildConditions = SqlTool.buildConditions("and", str, SqlTool.buildInCondition("domain", domainArray), SqlTool.buildInCondition("language", languageArray), SqlTool.buildInCondition("quality", qualityArray), SqlTool.buildInCondition(ATCustomRuleKeys.GENDER, genderArray), SqlTool.buildInCondition("speaker", speakerArray), SqlTool.buildInCondition("id", modelIdsArray));
        if (StringTool.isEmpty(strBuildConditions)) {
            return null;
        }
        return selectInList("select * from speechModel where " + strBuildConditions, DataTool.connect(strArr, domainArray, languageArray, qualityArray, genderArray, speakerArray, modelIdsArray));
    }

    public Map<String, String> selectModelFileIds(String str) {
        return selectInMap("select text_data_id, speech_data_id from speechModel where id=?", new String[]{str});
    }

    public Map<String, String> selectModelFileInfo(String str) {
        return selectInMap("select * from modelFile where id=?", new String[]{str});
    }

    public List<Map<String, String>> selectModelFileInfos(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        String[] strArrFromSetToArray = DataTool.fromSetToArray(set);
        return selectInList("select * from modelFile where " + SqlTool.buildInCondition("id", strArrFromSetToArray), strArrFromSetToArray);
    }

    public Map<String, String> selectModelInfo(String str) {
        return selectInMap("select * from speechModel where id=?", new String[]{str});
    }
}
