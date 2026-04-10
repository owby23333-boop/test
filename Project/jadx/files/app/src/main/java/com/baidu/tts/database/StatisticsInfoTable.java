package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.tools.SqlTool;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticsInfoTable {
    public static final String TABLE_NAME = "StatisticsInfo";

    public static void InsertData(SQLiteDatabase sQLiteDatabase, String str) {
    }

    public static String selectStatisticsInfo() {
        return "select * from StatisticsInfo limit 0,100";
    }

    public static String sqlCreateTable() {
        return "CREATE TABLE StatisticsInfo(id INTEGER PRIMARY KEY AUTOINCREMENT,uuid varchar(256),startInfo varchar(256),endInfo varchar(256))";
    }

    public static String sqlDropTable() {
        return SqlTool.sqlDropTable(TABLE_NAME);
    }

    public static void updata(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("update StatisticsInfo set " + str2 + "=? where uuid=?", new String[]{str3, str});
    }
}
