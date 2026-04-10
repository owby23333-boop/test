package com.baidu.tts.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.anythink.core.api.ATCustomRuleKeys;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelInfo;
import com.baidu.tts.database.TransactionTask;
import com.baidu.tts.tools.SqlTool;

/* JADX INFO: loaded from: classes2.dex */
public class SpeechModelTable {
    public static final String TABLE_NAME = "speechModel";

    public enum Field {
        ID("id", "integer primary key"),
        TEXT_DATA_ID("text_data_id", "integer"),
        SPEECH_DATA_ID("speech_data_id", "integer"),
        NAME("name", "varchar(256) not null default unnamed"),
        VERSION_MIN("version_min", "integer"),
        VERSION_MAX("version_max", "integer"),
        LANGUAGE("language", "varchar(20)"),
        GENDER(ATCustomRuleKeys.GENDER, "varchar(20)"),
        SPEAKER("speaker", "varchar(256)"),
        DOMAIN("domain", "varchar(50)"),
        QUALITY("quality", "varchar(50)");

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
        return sQLiteDatabase.delete(TABLE_NAME, "id=?", new String[]{str});
    }

    public static void insertModelBags(SQLiteDatabase sQLiteDatabase, final ModelBags modelBags) {
        new TransactionTask(sQLiteDatabase, new TransactionTask.OnTransactionListener() { // from class: com.baidu.tts.database.SpeechModelTable.1
            @Override // com.baidu.tts.database.TransactionTask.OnTransactionListener
            public boolean execute(SQLiteDatabase sQLiteDatabase2) {
                try {
                    SQLiteStatement sQLiteStatementCompileStatement = sQLiteDatabase2.compileStatement("insert into speechModel (name, version_min, version_max, language, gender, speaker, domain, quality, text_data_id, speech_data_id, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    for (ModelInfo modelInfo : modelBags.getModelInfos()) {
                        String name = modelInfo.getName();
                        String versionMin = modelInfo.getVersionMin();
                        String versionMax = modelInfo.getVersionMax();
                        String language = modelInfo.getLanguage();
                        String gender = modelInfo.getGender();
                        String speaker = modelInfo.getSpeaker();
                        String domain = modelInfo.getDomain();
                        String quality = modelInfo.getQuality();
                        String textDataId = modelInfo.getTextDataId();
                        String speechDataId = modelInfo.getSpeechDataId();
                        String serverId = modelInfo.getServerId();
                        sQLiteStatementCompileStatement.bindString(1, name);
                        sQLiteStatementCompileStatement.bindString(2, versionMin);
                        sQLiteStatementCompileStatement.bindString(3, versionMax);
                        sQLiteStatementCompileStatement.bindString(4, language);
                        sQLiteStatementCompileStatement.bindString(5, gender);
                        sQLiteStatementCompileStatement.bindString(6, speaker);
                        sQLiteStatementCompileStatement.bindString(7, domain);
                        sQLiteStatementCompileStatement.bindString(8, quality);
                        sQLiteStatementCompileStatement.bindString(9, textDataId);
                        sQLiteStatementCompileStatement.bindString(10, speechDataId);
                        sQLiteStatementCompileStatement.bindString(11, serverId);
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
