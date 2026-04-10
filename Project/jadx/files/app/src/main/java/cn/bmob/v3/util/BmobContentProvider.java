package cn.bmob.v3.util;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Binder;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.bean.Init;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class BmobContentProvider extends ContentProvider {
    private static String AUTHORITY;
    private static Uri GAME_CONTENT_URI;
    private static Context mContext;
    private static SQLiteDatabase mDb;
    private static UriMatcher mUriMatcher;
    private static String table;

    public static ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", (Integer) 1);
        return contentValues;
    }

    public static Cursor getCursor() {
        Binder.getCallingPid();
        return Bmob.getApplicationContext().getContentResolver().query(GAME_CONTENT_URI, new String[]{BmobDbOpenHelper.SESSION_TOKEN, BmobDbOpenHelper.USER, "api", BmobDbOpenHelper.FILE, "push", BmobDbOpenHelper.IO, "upyun", BmobDbOpenHelper.UY_VERSION, BmobDbOpenHelper.IGNORE_VERSIONS, BmobDbOpenHelper.INSTALLATION}, null, null, null);
    }

    public static String getFile() {
        Cursor cursor = getCursor();
        return cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(BmobDbOpenHelper.FILE)) : BmobURL.getDefault().getFileUrl();
    }

    public static String getIO() {
        Cursor cursor = getCursor();
        return cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(BmobDbOpenHelper.IO)) : BmobURL.getDefault().getRealTimeDataUrl();
    }

    public static String getIgnoreVersions() {
        Cursor cursor = getCursor();
        return cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(BmobDbOpenHelper.IGNORE_VERSIONS)) : "";
    }

    public static String getInstallation() {
        Cursor cursor = getCursor();
        return cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(BmobDbOpenHelper.INSTALLATION)) : "";
    }

    public static String getSessionToken() {
        Cursor cursor = getCursor();
        if (cursor == null) {
            return null;
        }
        return cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(BmobDbOpenHelper.SESSION_TOKEN)) : "";
    }

    public static String getUpyun() {
        Cursor cursor = getCursor();
        return cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex("upyun")) : "";
    }

    public static int getUpyunVersion() {
        Cursor cursor = getCursor();
        if (cursor.moveToFirst()) {
            return cursor.getInt(cursor.getColumnIndex(BmobDbOpenHelper.UY_VERSION));
        }
        return -1;
    }

    public static String getUser() {
        String string;
        Cursor cursor = getCursor();
        if (cursor != null && cursor.moveToFirst() && (string = cursor.getString(cursor.getColumnIndex(BmobDbOpenHelper.USER))) != null && !"".equals(string)) {
            if (string.startsWith("{")) {
                return string;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64Coder.decode(string));
            try {
                CompatibleInputStream compatibleInputStream = new CompatibleInputStream(byteArrayInputStream);
                Object object = compatibleInputStream.readObject();
                compatibleInputStream.close();
                byteArrayInputStream.close();
                return GsonUtil.toJson(object);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void initProvider(Context context) {
        mContext = context;
        table = BmobConstants.TAG;
        AUTHORITY = mContext.getPackageName() + ".BmobContentProvider";
        GAME_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/bmob");
        mUriMatcher = new UriMatcher(-1);
        mUriMatcher.addURI(AUTHORITY, BmobConstants.TAG, 0);
        mDb = new BmobDbOpenHelper(mContext).getWritableDatabase();
    }

    public static void removeLocalUser() {
        ContentValues contentValues = getContentValues();
        contentValues.put(BmobDbOpenHelper.USER, "");
        updateProvider(contentValues);
    }

    public static void updateIgnoreVersions(String str) {
        ContentValues contentValues = getContentValues();
        contentValues.put(BmobDbOpenHelper.IGNORE_VERSIONS, str);
        updateProvider(contentValues);
    }

    public static void updateInit(Init init) {
        ContentValues contentValues = getContentValues();
        contentValues.put("api", init.getApi());
        contentValues.put(BmobDbOpenHelper.FILE, init.getFile());
        contentValues.put("push", init.getPush());
        contentValues.put(BmobDbOpenHelper.IO, init.getIo());
        updateProvider(contentValues);
    }

    public static void updateInstallation(String str) {
        ContentValues contentValues = getContentValues();
        contentValues.put(BmobDbOpenHelper.INSTALLATION, str);
        updateProvider(contentValues);
    }

    public static void updateProvider(ContentValues contentValues) {
        if (getCursor().getCount() > 0) {
            Bmob.getApplicationContext().getContentResolver().update(GAME_CONTENT_URI, contentValues, "_id = ?", new String[]{"1"});
        } else {
            Bmob.getApplicationContext().getContentResolver().insert(GAME_CONTENT_URI, contentValues);
        }
    }

    public static void updateSessionToken(String str) {
        ContentValues contentValues = getContentValues();
        contentValues.put(BmobDbOpenHelper.SESSION_TOKEN, str);
        updateProvider(contentValues);
    }

    public static void updateUpyun(String str, int i2) {
        ContentValues contentValues = getContentValues();
        contentValues.put("upyun", str);
        contentValues.put(BmobDbOpenHelper.UY_VERSION, Integer.valueOf(i2));
        updateProvider(contentValues);
    }

    public static <T> void updateUser(String str, Class<T> cls) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(GsonUtil.toObject(str, cls));
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            String str2 = new String(Base64Coder.encode(byteArray));
            ContentValues contentValues = getContentValues();
            contentValues.put(BmobDbOpenHelper.USER, str2);
            updateProvider(contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        mDb.delete(table, str, strArr);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        mDb.insert(table, null, contentValues);
        mContext.getContentResolver().notifyChange(uri, null);
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase sQLiteDatabase = mDb;
        if (sQLiteDatabase == null) {
            return null;
        }
        return sQLiteDatabase.query(BmobConstants.TAG, strArr, str, strArr2, null, str2, null);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        mDb.update(table, contentValues, str, strArr);
        return 0;
    }
}
