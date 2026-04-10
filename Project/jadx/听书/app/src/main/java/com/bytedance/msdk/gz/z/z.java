package com.bytedance.msdk.gz.z;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class z extends SQLiteOpenHelper {
    public static String z = "z";

    public z(Context context) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.z(context), "mediation_behavior.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            z(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    private void z(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gromore_prime_rit_adn_perform (id INTEGER PRIMARY KEY AUTOINCREMENT, adn_name TEXT NOT NULL , prime_rit TEXT NOT NULL , adn_rit TEXT NOT NULL ,ad_action TEXT NOT NULL ,time_stamp LONG DEFAULT 0)");
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gromore_prime_rit_adn_perform ;");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            com.bytedance.msdk.z.gc.dl.z(z, "onUpgrade....Database version upgrade.....old:" + i + ",new:" + i2);
            if (i > i2) {
                g(sQLiteDatabase);
                z(sQLiteDatabase);
                com.bytedance.msdk.z.gc.dl.z(z, "onUpgrade...Reverse installation Database reset - create table.....");
                return;
            }
            z(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    public void z(ContentValues contentValues) {
        if (contentValues != null) {
            String asString = contentValues.getAsString(MediationConstant.EXTRA_ADN_NAME);
            String asString2 = contentValues.getAsString(MediationConstant.KEY_GM_PRIME_RIT);
            String asString3 = contentValues.getAsString("adn_rit");
            String asString4 = contentValues.getAsString("ad_action");
            long jLongValue = contentValues.getAsLong("time_stamp").longValue();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(MediationConstant.EXTRA_ADN_NAME, asString);
            contentValues2.put(MediationConstant.KEY_GM_PRIME_RIT, asString2);
            contentValues2.put("adn_rit", asString3);
            contentValues2.put("ad_action", asString4);
            contentValues2.put("time_stamp", Long.valueOf(jLongValue));
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        writableDatabase.insert("gromore_prime_rit_adn_perform", null, contentValues2);
                        writableDatabase.close();
                    }
                } catch (IllegalStateException unused) {
                }
            }
        }
    }

    public Cursor z(String str, String[] strArr) {
        return getReadableDatabase().query("gromore_prime_rit_adn_perform", null, str, strArr, null, null, null);
    }

    public void g(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("gromore_prime_rit_adn_perform", str, strArr);
        writableDatabase.close();
    }
}
