package cn.bmob.v3.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public class BmobDbOpenHelper extends SQLiteOpenHelper {
    public static final String API = "api";
    private static final String DB_NAME = "bmob_provider.db";
    private static final int DB_VERSION = 1;
    public static final String FILE = "file";
    static final String GAME_TABLE_NAME = "bmob";
    public static final String IGNORE_VERSIONS = "ignoreversions";
    public static final String INSTALLATION = "installation";
    public static final String IO = "io";
    public static final String PUSH = "push";
    public static final String SESSION_TOKEN = "sessionToken";
    public static final String USER = "user";
    public static final String UY = "upyun";
    public static final String UY_VERSION = "upyunVer";
    private String CREATE_GAME_TABLE;

    public BmobDbOpenHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.CREATE_GAME_TABLE = "create table if not exists bmob(_id integer primary key, sessionToken TEXT, user TEXT, api TEXT, file TEXT, push TEXT, io TEXT, upyunVer TEXT, upyun TEXT, ignoreversions TEXT, installation TEXT)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.CREATE_GAME_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
