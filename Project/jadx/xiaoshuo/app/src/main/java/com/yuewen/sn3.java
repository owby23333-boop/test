package com.yuewen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public abstract class sn3 {
    public static boolean a(Cursor cursor, int i) {
        return cursor == null || cursor.getCount() == 0 || cursor.isNull(i);
    }

    public static int b(Cursor cursor, int i) {
        return c(cursor, i, 0);
    }

    public static int c(Cursor cursor, int i, int i2) {
        return a(cursor, i) ? i2 : cursor.getInt(i);
    }

    public static long d(Cursor cursor, int i) {
        return e(cursor, i, 0L);
    }

    public static long e(Cursor cursor, int i, long j) {
        return a(cursor, i) ? j : cursor.getLong(i);
    }

    public static short f(Cursor cursor, int i) {
        return g(cursor, i, (short) 0);
    }

    public static short g(Cursor cursor, int i, short s) {
        return a(cursor, i) ? s : cursor.getShort(i);
    }

    public static String h(Cursor cursor, int i) {
        return i(cursor, i, "");
    }

    public static String i(Cursor cursor, int i, String str) {
        return a(cursor, i) ? str : cursor.getString(i);
    }

    public static List<String> j(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(String.format("PRAGMA table_info('%s')", str), null);
        LinkedList linkedList = new LinkedList();
        while (cursorRawQuery.moveToNext()) {
            try {
                linkedList.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("name")));
            } catch (Throwable unused) {
            }
        }
        cursorRawQuery.close();
        return linkedList;
    }

    public static List<String> k(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        LinkedList linkedList = new LinkedList();
        while (cursorRawQuery.moveToNext()) {
            try {
                linkedList.add(cursorRawQuery.getString(0));
            } catch (Throwable unused) {
            }
        }
        cursorRawQuery.close();
        return linkedList;
    }
}
