package com.baidu.tts.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.modelmanager.ModelMediator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticsDbManager {
    private static final String TAG = "StatisticsDbManager";
    private ModelMediator mModelMediator;
    private StatisticsDbHelper mStatisticsDbHelper;
    private ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();
    private Lock mWriteLock = this.mReadWriteLock.writeLock();
    private Lock mReadLock = this.mReadWriteLock.readLock();

    public StatisticsDbManager(ModelMediator modelMediator) {
        this.mModelMediator = modelMediator;
        this.mStatisticsDbHelper = new StatisticsDbHelper(this.mModelMediator.getContext());
    }

    private SQLiteDatabase getReadableDatabase() {
        return this.mStatisticsDbHelper.getReadableDatabase();
    }

    private SQLiteDatabase getWritableDb() {
        return this.mStatisticsDbHelper.getWritableDatabase();
    }

    public int delteData(int i2, int i3) {
        this.mWriteLock.lock();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        try {
            int iDelete = readableDatabase.delete(StatisticsInfoTable.TABLE_NAME, "id between ? and ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
            LoggerProxy.d(TAG, "delete database=" + iDelete + "=" + i2 + "=" + i3);
            return iDelete;
        } finally {
            readableDatabase.close();
            this.mWriteLock.unlock();
        }
    }

    public long insertData(String str) {
        this.mWriteLock.lock();
        SQLiteDatabase writableDb = getWritableDb();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("uuid", str);
            return writableDb.insert(StatisticsInfoTable.TABLE_NAME, null, contentValues);
        } finally {
            writableDb.close();
            this.mWriteLock.unlock();
        }
    }

    public Map<String, ArrayList> selectData() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.mReadLock.lock();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursorRawQuery = readableDatabase.rawQuery("select * from StatisticsInfo limit 0,100", null);
        while (cursorRawQuery.moveToNext()) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("id"));
                    jSONObject.put("uuid", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("uuid")));
                    jSONObject.put("startInfo", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("startInfo")));
                    jSONObject.put("endInfo", cursorRawQuery.getString(cursorRawQuery.getColumnIndex("endInfo")));
                    arrayList2.add(Integer.valueOf(i2));
                    arrayList.add(jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } finally {
                cursorRawQuery.close();
                readableDatabase.close();
                this.mReadLock.unlock();
            }
        }
        map.put("listId", arrayList2);
        map.put("list", arrayList);
        return map;
    }

    public int update(String str, String str2, String str3) {
        this.mWriteLock.lock();
        SQLiteDatabase writableDb = getWritableDb();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(str2, str3);
            int iUpdate = writableDb.update(StatisticsInfoTable.TABLE_NAME, contentValues, "uuid=?", new String[]{str});
            if (iUpdate == 0) {
                writableDb.insert(StatisticsInfoTable.TABLE_NAME, null, contentValues);
            }
            return iUpdate;
        } finally {
            writableDb.close();
            this.mWriteLock.unlock();
        }
    }
}
