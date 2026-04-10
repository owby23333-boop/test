package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.baidu.tts.tools.SqlTool;

/* JADX INFO: loaded from: classes2.dex */
public class FsFileInfoTable {
    public static final String TABLE_NAME = "fsFileInfo";

    public enum Field {
        ABS_PATH("absPath", "varchar primary key"),
        STATE(CallMraidJS.b, "integer");

        private final String mColumnName;
        private final String mDataType;

        Field(String str, String str2) {
            this.mColumnName = str;
            this.mDataType = str2;
        }

        public String getColumnName() {
            return this.mColumnName;
        }

        public String getDataType() {
            return this.mDataType;
        }
    }

    public static int deleteModelItem(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete(TABLE_NAME, "absPath=?", new String[]{str});
    }

    public static String sqlCreateTable() {
        return SqlTool.sqlCreateTable(TABLE_NAME, Field.values());
    }

    public static String sqlDropTable() {
        return SqlTool.sqlDropTable(TABLE_NAME);
    }
}
