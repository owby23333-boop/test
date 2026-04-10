package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.client.model.ModelFileInfo;
import com.baidu.tts.database.TransactionTask;
import com.baidu.tts.tools.SqlTool;

/* JADX INFO: loaded from: classes2.dex */
public class ModelFileTable {
    public static final String TABLE_NAME = "modelFile";

    public enum Field {
        ID("id", "integer primary key"),
        LENGTH("length", "bigint"),
        MD5("md5", "varchar(32)"),
        NAME("name", "varchar(256) not null default unnamed"),
        ABS_PATH("absPath", "varchar");

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

    public static int deleteFileItem(SQLiteDatabase sQLiteDatabase, String str) {
        return sQLiteDatabase.delete(TABLE_NAME, "id=?", new String[]{str});
    }

    public static void insertModelFileBags(SQLiteDatabase sQLiteDatabase, final ModelFileBags modelFileBags) {
        new TransactionTask(sQLiteDatabase, new TransactionTask.OnTransactionListener() { // from class: com.baidu.tts.database.ModelFileTable.1
            @Override // com.baidu.tts.database.TransactionTask.OnTransactionListener
            public boolean execute(SQLiteDatabase sQLiteDatabase2) {
                try {
                    SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase2.compileStatement("insert into modelFile (id, length, md5, name, absPath) values (?, ?, ?, ?, ?)");
                    for (ModelFileInfo modelFileInfo : modelFileBags.getModelFileInfos()) {
                        String serverid = modelFileInfo.getServerid();
                        String length = modelFileInfo.getLength();
                        String md5 = modelFileInfo.getMd5();
                        String name = modelFileInfo.getName();
                        String absPath = modelFileInfo.getAbsPath();
                        sQLiteStatementCompileStatement.bindString(1, serverid);
                        sQLiteStatementCompileStatement.bindString(2, length);
                        sQLiteStatementCompileStatement.bindString(3, md5);
                        sQLiteStatementCompileStatement.bindString(4, name);
                        sQLiteStatementCompileStatement.bindString(5, absPath);
                        sQLiteStatementCompileStatement.executeInsert();
                    }
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        }).executeTransaction();
    }

    public static String sqlCreateTable() {
        return SqlTool.sqlCreateTable(TABLE_NAME, Field.values());
    }

    public static String sqlDropTable() {
        return SqlTool.sqlDropTable(TABLE_NAME);
    }
}
