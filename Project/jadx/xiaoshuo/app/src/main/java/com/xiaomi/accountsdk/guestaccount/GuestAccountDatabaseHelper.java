package com.xiaomi.accountsdk.guestaccount;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.accountsdk.guestaccount.data.GuestAccount;
import com.xiaomi.accountsdk.guestaccount.data.GuestAccountType;
import com.xiaomi.accountsdk.utils.AccountLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class GuestAccountDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "guest_account.db";
    private static final int DATABASE_VERSION = 2;
    private static final String FIELD_PASS_TOKEN = "passToken";
    private static final String FIELD_SID = "sid";
    private static final String FIELD_USER_ID = "userId";
    private static final String TABLE_NAME_ACCOUNT_TABLE = "account";
    private static final String TAG = "GuestAccountDatabaseHe";
    private static final String FIELD_C_USER_ID = "cUserId";
    private static final String FIELD_USER_TYPE = "userType";
    private static final String GUEST_ACCOUNT_TABLE_CREATE = String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT,%s TEXT, %s INTEGER DEFAULT 0)", "account", "_id", "userId", FIELD_C_USER_ID, "passToken", FIELD_USER_TYPE);
    private static final String TABLE_NAME_SERVICE_TOKEN = "service_token";
    private static final String FIELD_SERVICE_TOKEN = "serviceToken";
    private static final String FIELD_SECURITY = "security";
    private static final String FIELD_SLH = "slh";
    private static final String FIELD_PH = "ph";
    private static final String SERVICE_TOKEN_TABLE_CREATE = String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT,  %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME_SERVICE_TOKEN, "_id", "userId", "sid", FIELD_SERVICE_TOKEN, FIELD_SECURITY, FIELD_SLH, FIELD_PH);
    private static volatile GuestAccountDatabaseHelper sInstance = null;

    public GuestAccountDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public static synchronized GuestAccountDatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new GuestAccountDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(GUEST_ACCOUNT_TABLE_CREATE);
        sQLiteDatabase.execSQL(SERVICE_TOKEN_TABLE_CREATE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AccountLogger.log(TAG, "downgrade ignore");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        AccountLogger.log(TAG, "upgrade from version " + i + " to version" + i2);
        if (i2 == 2 && i == 1) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("ALTER TABLE account ADD COLUMN cUserId TEXT");
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.xiaomi.accountsdk.guestaccount.data.GuestAccount readGuestAccount(java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.accountsdk.guestaccount.GuestAccountDatabaseHelper.readGuestAccount(java.lang.String):com.xiaomi.accountsdk.guestaccount.data.GuestAccount");
    }

    public void removeAll() {
        getWritableDatabase().delete("account", null, null);
        getWritableDatabase().delete(TABLE_NAME_SERVICE_TOKEN, null, null);
    }

    public void removeServiceToken(String str) {
        updateServiceToken(new GuestAccount.Builder().sid(str).serviceToken("").security("").slh("").ph("").build());
    }

    public synchronized void updatePassToken(GuestAccount guestAccount) {
        if (guestAccount == null) {
            throw new IllegalArgumentException("ga == null");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", guestAccount.userId);
        contentValues.put(FIELD_C_USER_ID, guestAccount.cUserId);
        contentValues.put("passToken", guestAccount.passToken);
        GuestAccountType guestAccountType = guestAccount.type;
        contentValues.put(FIELD_USER_TYPE, Integer.valueOf(guestAccountType != null ? guestAccountType.serverValue : -1));
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase.update("account", contentValues, null, null) > 0) {
            AccountLogger.log(TAG, "1 entry updated in guest_account/account database");
        } else {
            writableDatabase.insert("account", null, contentValues);
            AccountLogger.log(TAG, "1 entry inserted in guest_account/account database");
        }
    }

    public synchronized void updateServiceToken(GuestAccount guestAccount) {
        if (guestAccount == null) {
            throw new IllegalArgumentException("ga == null");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("sid", guestAccount.sid);
        contentValues.put(FIELD_SERVICE_TOKEN, guestAccount.serviceToken);
        contentValues.put(FIELD_SECURITY, guestAccount.security);
        contentValues.put(FIELD_SLH, guestAccount.slh);
        contentValues.put(FIELD_PH, guestAccount.ph);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (writableDatabase.update(TABLE_NAME_SERVICE_TOKEN, contentValues, "sid=?", new String[]{guestAccount.sid}) > 0) {
            AccountLogger.log(TAG, "1 entry updated in guest_account/serviceToken database");
        } else {
            writableDatabase.insert(TABLE_NAME_SERVICE_TOKEN, null, contentValues);
            AccountLogger.log(TAG, "1 entry inserted in guest_account/serviceToken database");
        }
    }
}
