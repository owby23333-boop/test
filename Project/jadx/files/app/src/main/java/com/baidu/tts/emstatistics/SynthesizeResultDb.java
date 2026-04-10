package com.baidu.tts.emstatistics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.umeng.message.proguard.ad;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class SynthesizeResultDb {
    private static final String DATABASE_NAME = "ttsdata";
    private static final int DATABASE_VERSION = 1;
    public static final String KEY_CMD_ID = "cmd_id";
    public static final String KEY_CMD_TYPE = "cmd_type";
    public static final String KEY_ERROR_CODE = "code";
    private static final String KEY_RECOGNITION_RESULT_CMD_ID = "cmd_id";
    private static final String KEY_RECOGNITION_RESULT_CMD_TYPE = "cmd_type";
    private static final String KEY_RECOGNITION_RESULT_ERROR_CODE = "error_code";
    private static final String KEY_RECOGNITION_RESULT_TIME = "time";
    private static final String KEY_RECOGNITION_RESULT_VOICE_TO_TEXT = "voice_to_text_result";
    public static final String KEY_RESULT = "result";
    public static final String KEY_ROWID = "_id";
    public static final String KEY_TIME = "time";
    private static final String TABLE_RESULT = "result";
    private static final String TABLE_RESULT_CREATE_SQL = "create table result (_id integer primary key autoincrement, time text, code integer, cmd_type integer, cmd_id integer, result text);";
    private static final String TAG = "SynthesizeResultDb";
    private static SynthesizeResultDb mSynthesizeResultDb;
    private Context mContext;
    private DatabaseHelper mDatabaseHelper;
    private ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();
    private Lock mWriteLock = this.mReadWriteLock.writeLock();
    private Lock mReadLock = this.mReadWriteLock.readLock();

    class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, SynthesizeResultDb.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(SynthesizeResultDb.TABLE_RESULT_CREATE_SQL);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS result");
            onCreate(sQLiteDatabase);
        }
    }

    private SynthesizeResultDb(Context context) {
        this.mContext = context;
        this.mDatabaseHelper = new DatabaseHelper(this.mContext);
    }

    public static SynthesizeResultDb getInstance(Context context) {
        if (mSynthesizeResultDb == null) {
            synchronized (SynthesizeResultDb.class) {
                if (mSynthesizeResultDb == null) {
                    mSynthesizeResultDb = new SynthesizeResultDb(context);
                }
            }
        }
        return mSynthesizeResultDb;
    }

    private SQLiteDatabase getReadableDatabase() {
        return this.mDatabaseHelper.getReadableDatabase();
    }

    private SQLiteDatabase getWritableDb() {
        return this.mDatabaseHelper.getWritableDatabase();
    }

    public void addSynthesizeResult(long j2, int i2, int i3, int i4, String str) {
        this.mWriteLock.lock();
        SQLiteDatabase writableDb = getWritableDb();
        try {
            try {
                try {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("time", Long.valueOf(j2));
                        contentValues.put("code", Integer.valueOf(i2));
                        contentValues.put("cmd_type", Integer.valueOf(i3));
                        contentValues.put("cmd_id", Integer.valueOf(i4));
                        contentValues.put("result", str);
                        writableDb.insert("result", null, contentValues);
                    } catch (Exception e2) {
                        LoggerProxy.d(TAG, "exception:" + e2.toString());
                    }
                } catch (IllegalStateException e3) {
                    LoggerProxy.d(TAG, "exception:" + e3.toString());
                }
            } catch (SQLiteException e4) {
                LoggerProxy.d(TAG, "exception:" + e4.toString());
            }
        } finally {
            writableDb.close();
            this.mWriteLock.unlock();
        }
    }

    public void deleteSynthesizeResult(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mWriteLock.lock();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        try {
            String str = "";
            for (int i2 = 0; i2 < list.size(); i2++) {
                try {
                    try {
                        try {
                            str = str + list.get(i2) + ",";
                        } catch (IllegalStateException e2) {
                            LoggerProxy.d(TAG, "exception:" + e2.toString());
                        }
                    } catch (Exception e3) {
                        LoggerProxy.d(TAG, "exception:" + e3.toString());
                    }
                } catch (SQLiteException e4) {
                    LoggerProxy.d(TAG, "exception:" + e4.toString());
                }
            }
            if (str.length() > 0) {
                readableDatabase.delete("result", "_id in (" + str.substring(0, str.length() - 1) + ad.f20406s, null);
            }
        } finally {
            readableDatabase.close();
            this.mWriteLock.unlock();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(7:73|5|80|6|7|(6:71|8|9|76|10|11)|(6:70|12|(1:14)|15|85|37))|3|68) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0137, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0138, code lost:
    
        r3 = r5;
        r2 = r6;
        r18 = r10;
        r19 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0155, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0156, code lost:
    
        r3 = r5;
        r2 = r6;
        r18 = r10;
        r19 = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.util.ArrayList> queryResult() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.emstatistics.SynthesizeResultDb.queryResult():java.util.Map");
    }

    public int queryResultCount() {
        this.mReadLock.lock();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        int count = 0;
        Cursor cursorQuery = null;
        try {
            if (readableDatabase != null) {
                try {
                    try {
                        try {
                            cursorQuery = readableDatabase.query("result", new String[]{"_id", "time", "code", "cmd_type", "cmd_id", "result"}, null, null, null, null, null);
                            count = cursorQuery.getCount();
                        } catch (IllegalStateException e2) {
                            LoggerProxy.d(TAG, "exception:" + e2.toString());
                        }
                    } catch (Exception e3) {
                        LoggerProxy.d(TAG, "exception:" + e3.toString());
                    }
                } catch (SQLiteException e4) {
                    LoggerProxy.d(TAG, "exception:" + e4.toString());
                }
            }
            return count;
        } finally {
            cursorQuery.close();
            readableDatabase.close();
            this.mReadLock.unlock();
        }
    }
}
